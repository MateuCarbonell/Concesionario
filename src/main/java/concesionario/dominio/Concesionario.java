package concesionario.dominio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Concesionario {
    private  List<Vehiculo> inventario;


    // Constructor
    public Concesionario(List<Vehiculo> inventario) {
        this.inventario = inventario;

    }

    public List<Vehiculo> getInventario() {
        return inventario;
    }

    public void agregarVehiculo(Vehiculo vehiculo){
          for (Vehiculo v : inventario) {
              if (v.getIdVehiculo() == vehiculo.getIdVehiculo()) {
                throw new IllegalArgumentException("El vehículo con ID " + vehiculo.getIdVehiculo() + " ya está en el inventario.");
              }
        }
        inventario.add(vehiculo);
    }
    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (!inventario.contains(vehiculo)) {
            throw new IllegalArgumentException("El vehículo con ID " + vehiculo.getIdVehiculo() + " no existe en el inventario.");
        }
        inventario.remove(vehiculo);
    }

    public List<Vehiculo> buscarVehiculosPorMarca(String marca){
        List<Vehiculo> nuevaLista = new ArrayList<>();
        for(Vehiculo vehiculo: inventario){
            if(vehiculo.getMarca().equalsIgnoreCase(marca)){
                nuevaLista.add(vehiculo);
            }
        }
        return nuevaLista;
    }

    public double calcularPrecioInventario(){
        double precio = 0;
        for(Vehiculo vehiculo: inventario){
            precio += vehiculo.getPrecio();
        }
        return precio;
    }
    public void mostrarInventario(){
        System.out.println("Mostrando inventario");
        for(Vehiculo vehiculo : inventario){
            System.out.println("Marca: " + vehiculo.getMarca() + " Modelo: " + vehiculo.getModelo() + " Precio: " + vehiculo.getPrecio());
        }
    }
    // Método para guardar todo el inventario en un archivo
    public void guardarInventarioEnArchivo(String nombreArchivo){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Vehiculo vehiculo : inventario) {
                writer.write(vehiculo.getIdVehiculo() + "," + vehiculo.getMarca() + "," + vehiculo.getModelo() + "," + vehiculo.getAño() + "," + vehiculo.getPrecio() + ","
                        + vehiculo.getEstado() + "\n");
            }
            System.out.println("Inventario guardado correctamente en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar el inventario en el archivo: " + e.getMessage());
        }
    }



    // Método para cargar el archivo y convertirlo en objetos, para posteriormente añadirlos al inventario
    public void cargarInventarioDesdeArchivo(String nombreArchivo){
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes utilizando la coma
                String[] partes = linea.split(",");
                int idVehiculo = Integer.parseInt(partes[0].trim()); // Convertir la cadena del id a entero
                String marca = partes[1].trim(); // recoge marca
                String modelo = partes[2].trim(); // recoge modelo
                int año = Integer.parseInt(partes[3].trim()); // Convertir la cadena del año a entero
                double precio = Double.parseDouble(partes[4].trim()); // Convertir la cadena del precio a double
                String estado = partes[5].trim(); // recoge estado
                // Crear un nuevo objeto Vehiculo y agregarlo al inventario
                Vehiculo vehiculo = new Vehiculo(idVehiculo, marca, modelo, año, precio, estado);
                inventario.add(vehiculo);
            }
            System.out.println("Inventario cargado correctamente desde el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al cargar el inventario desde el archivo: " + e.getMessage());
        }
    }


}




