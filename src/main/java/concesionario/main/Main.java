package concesionario.main;

import concesionario.dominio.Cliente;
import concesionario.dominio.GestorBD;
import concesionario.dominio.Vehiculo;
import concesionario.dominio.Concesionario;
import concesionario.dominio.Venta;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> inventario = new ArrayList<>();
        Concesionario concesionario = new Concesionario(inventario);
        GestorBD gestorBD = new GestorBD();

        // Creación de objetos para pruebas
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Corolla", 2022, 25000.0, "Nuevo");

        Cliente cliente1 = new Cliente(1, "Alejandro", "Islero", "132452", "Valencia", "alejandro@yahoo.eu");

        // Sección: CRUD de Vehículos
        // CREATE, READ, UPDATE, DELETE

        concesionario.agregarVehiculo(vehiculo);
        concesionario.mostrarInventario();

        Vehiculo vehiculoBuscado = gestorBD.obtenerVehiculoPorId(1);
        System.out.println("Vehículo encontrado: " + vehiculoBuscado);

        Vehiculo newVehiculo = new Vehiculo(1, "Audi", "RS7", 2021, 57500.0, "Nuevo");
        gestorBD.actualizarVehiculo(1, newVehiculo);

        gestorBD.eliminarVehiculoPorId(1);

        // Operaciones con Clientes
        gestorBD.agregarCliente(cliente1);

        // Operaciones con Vehículos
        gestorBD.agregarVehiculo(vehiculo);
        gestorBD.agregarVehiculo(newVehiculo);

        // Compra y creación de venta
        cliente1.comprarVehiculo(vehiculo, gestorBD);

        // SECCIÓN : BUFFEREDREADER Y BUFFEREDWRITER
        String nombreArchivo = "inventario.txt";
        String nombreArchivo2 = "inventarioImport";
        concesionario.guardarInventarioEnArchivo(nombreArchivo);
        concesionario.cargarInventarioDesdeArchivo(nombreArchivo2);
        concesionario.mostrarInventario();
    }
}
