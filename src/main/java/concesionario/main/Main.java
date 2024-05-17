package concesionario.main;
import concesionario.dominio.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creacion objetos prueba
        List<Vehiculo> inventario = new ArrayList<>();
        Concesionario concesionario = new Concesionario(inventario);
        GestorBD gestorBD = new GestorBD();
        Scanner scanner = new Scanner(System.in);
        String nombreArchivo = "inventario.txt"; // Writer
        String nombreArchivo2 = "inventarioImport"; // Reader


        int opcion;

        do {
            System.out.println("***** MENÚ *****");
            System.out.println("1. CRUD de Vehículos (Gestor BD)");
            System.out.println("2. Métodos del Concesionario");
            System.out.println("3. Mostrar información");
            System.out.println("0. Salir");
            System.out.print("Ingresa la opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuCRUDVehiculos(gestorBD, scanner);
                    break;
                case 2:
                    menuMetodosConcesionario(concesionario, nombreArchivo, nombreArchivo2);
                    break;
                case 3:
                    menuMostrarInformacion(concesionario);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingresa una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void menuCRUDVehiculos(GestorBD gestorBD, Scanner scanner) {
        int opcion;
        Cliente nuevoCliente = null; // para que el case 6 no de error.
        do {
            System.out.println("\n***** CRUD DE VEHÍCULOS *****");
            System.out.println("1. Agregar vehículo");
            System.out.println("2. Obtener vehículo por ID");
            System.out.println("3. Actualizar vehículo");
            System.out.println("4. Eliminar vehículo por ID");
            System.out.println("5. Agregar cliente");
            System.out.println("6. Registrar venta");
            System.out.println("0. Volver al menú principal");
            System.out.print("Ingresa una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Vehiculo nuevoVehiculo = crearVehiculo(scanner);
                    gestorBD.agregarVehiculo(nuevoVehiculo);
                    break;
                case 2:
                    System.out.println("Ingresa el ID del vehículo:");
                    int idVehiculo = scanner.nextInt();
                    Vehiculo vehiculoBuscado = gestorBD.obtenerVehiculoPorId(idVehiculo);
                    if (vehiculoBuscado != null) {
                        System.out.println("Vehículo encontrado: " + vehiculoBuscado);
                    } else {
                        System.out.println("No se encontró ningún vehículo con el ID proporcionado.");
                    }
                    break;
                case 3:
                    System.out.println("Ingresa el ID del vehículo a actualizar:");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    Vehiculo vehiculoActualizar = crearVehiculo(scanner);
                    gestorBD.actualizarVehiculo(idActualizar, vehiculoActualizar);
                    break;
                case 4:
                    System.out.println("Ingresa el ID del vehículo a eliminar:");
                    int idEliminar = scanner.nextInt();
                    gestorBD.eliminarVehiculoPorId(idEliminar);
                    break;
                case 5:
                    nuevoCliente = crearCliente(scanner);
                    gestorBD.agregarCliente(nuevoCliente);
                    break;

                case 6:
                    // Si o si , se creará la venta con el ultimo case 5 que se haya hecho.
                    System.out.println("Ingresa el ID del vehículo a vender:");
                    int idVehiculoVenta = scanner.nextInt();
                    Vehiculo vehiculoVenta = gestorBD.obtenerVehiculoPorId(idVehiculoVenta);
                    if (vehiculoVenta != null && nuevoCliente != null) {
                        gestorBD.registrarVenta(vehiculoVenta, nuevoCliente);
                        System.out.println("Venta registrada correctamente.");
                    } else {
                        System.out.println("No se pudo registrar la venta. Verifique el ID del vehículo proporcionado.");
                    }
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingresa una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void menuMetodosConcesionario( Concesionario concesionario, String nombreArchivo, String nombreArchivo2) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n***** MÉTODOS DEL CONCESIONARIO *****");
            System.out.println("1. Agregar vehículo");
            System.out.println("2. Eliminar vehículo");
            System.out.println("3. Buscar vehículos por marca");
            System.out.println("4. Calcular precio del inventario");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Guardar inventario en archivo");
            System.out.println("7. Cargar inventario desde archivo");
            System.out.println("0. Volver al menú principal");
            System.out.print("Ingresa una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Vehiculo nuevoVehiculo = crearVehiculo(scanner);
                    try {
                        concesionario.agregarVehiculo(nuevoVehiculo);
                        System.out.println("Vehículo agregado correctamente.");
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Ingresa el ID del vehículo a eliminar:");
                    int idEliminar = scanner.nextInt();
                    Vehiculo vehiculoEliminar = null;
                    for (Vehiculo vehiculo : concesionario.getInventario()) {
                        if (vehiculo.getIdVehiculo() == idEliminar) {
                            vehiculoEliminar = vehiculo;
                            break;
                        }
                    }
                    if (vehiculoEliminar != null) {
                        try {
                            concesionario.eliminarVehiculo(vehiculoEliminar);
                            System.out.println("Vehículo eliminado correctamente.");
                        } catch (IllegalArgumentException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("No se encontró el vehículo con esa ID.");
                    }
                    break;
                case 3:
                    System.out.println("Ingresa la marca a buscar:");
                    String marcaBuscar = scanner.next();
                    List<Vehiculo> vehiculosPorMarca = concesionario.buscarVehiculosPorMarca(marcaBuscar);
                    if (!vehiculosPorMarca.isEmpty()) {
                        System.out.println("Vehículos encontrados:");
                        for (Vehiculo vehiculo : vehiculosPorMarca) {
                            System.out.println(vehiculo);
                        }
                    } else {
                        System.out.println("No se encontraron vehículos de la marca especificada.");
                    }
                    break;
                case 4:
                    double precio= concesionario.calcularPrecioInventario();
                    System.out.println("El precio del inventario del concesionario es: " + precio);
                    break;
                case 5:
                    concesionario.mostrarInventario();
                    break;
                case 6:
                    concesionario.guardarInventarioEnArchivo(nombreArchivo);
                    break;
                case 7:
                    concesionario.cargarInventarioDesdeArchivo(nombreArchivo2);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, Ingresa una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void menuMostrarInformacion(Concesionario concesionario) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n***** MOSTRAR INFORMACIÓN *****");
            System.out.println("1. Mostrar información de un vehiculo");
            System.out.println("0. Volver al menú principal");
            System.out.print("Ingresa una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("De que vehículo de la lista quieres sacar información? Introduce la ID: ");
                    int id = scanner.nextInt();
                    boolean encontrado = false;
                    for(Vehiculo vehiculo : concesionario.getInventario()){
                        if (id == vehiculo.getIdVehiculo()){
                            System.out.println(vehiculo.toString());
                            encontrado = true;
                            break;
                        }
                    }
                    if(!encontrado){
                        System.out.println("El vehículo con la ID especificada no se encuentra en el inventario.");
                    }
                    break;

                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingresa una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }

    // Método para crear un vehículo ingresando datos por consola
    public static Vehiculo crearVehiculo(Scanner scanner) {
        System.out.println("Ingrese los detalles del vehículo:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Año: ");
        int año = scanner.nextInt();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        return new Vehiculo(id, marca, modelo, año, precio, estado);
    }

    // Método para crear un cliente ingresando datos por consola
    public static Cliente crearCliente(Scanner scanner) {
        System.out.println("Ingresa los detalles del cliente:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correo = scanner.nextLine();

        return new Cliente(id, nombre, apellido, dni, direccion, correo);
    }

}





