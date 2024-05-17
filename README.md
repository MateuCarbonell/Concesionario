# Proyecto Concesionario de Vehículos

Este proyecto es un sistema de gestión para un concesionario de vehículos, que permite gestionar un inventario de vehículos, clientes y ventas.

## Tablas de la base de datos

- `vehiculos`
- `clientes`
- `ventas`

## Clases y métodos

### Abstracción

- **Clase Persona:** En esta clase, se crea un método abstracto llamado `comprarVehiculo`. Su objetivo es registrar automáticamente una venta en la tabla Ventas de la base de datos cuando un cliente compra un coche.

### Interfaz

- **Interfaz `solicitarInformacion()`:** Se utiliza para mostrar información de vehículos y ventas.

### Clase Concesionario

- **Atributos:**
  - `inventario`: Lista que recoge objetos de tipo Vehículo.

- **Métodos:**
  - `agregarVehiculo(Vehiculo vehiculo)`: En este método, se hace uso de las excepciones pedidas en clase. Simplemente recorre la lista y, si ya hay un vehículo que tiene la misma ID que se está intentando introducir,  lanza una excepción; de lo contrario, lo añade a la lista.
  - `eliminarVehiculo(Vehiculo vehiculo)`: Elimina un vehículo del inventario que coincida con la ID introducida por el usuario.
  - `buscarVehiculosPorMarca(String marca)`: busca en la lista la marca de todos los vehículos y la compara con la marca introducida por el usuario (con equalsIgnoreCase(marca) para no tener en cuenta mayúsculas, minúsculas, etc.) y devuelve una nueva lista con todos los vehículos que coincidan con la marca introducida.
  - `calcularPrecioInventario()`: Simplemente suma, con un bucle for y getPrecio()
  - `mostrarInventario()`: Muestra todos los vehículos del inventario.
  - `guardarInventarioEnArchivo(String nombreArchivo)`: Utiliza BufferedWriter para escribir en el archivo todos los vehículos (recorriendo la lista, separando con comas y añadiendo un salto de línea al final). En este método se hace uso de excepciones.
  - `cargarInventarioDesdeArchivo(String nombreArchivo)`: Utiliza BufferedReader, crea una lista y separa con la “,”, va guardando en variables todos los datos del archivo (usando el índice de String[] partes), hace las conversiones de tipo que sean necesarias y luego crea un nuevo objeto que se añadirá a la lista de vehículos. En este método se hace uso de excepciones.

### Clase GestorBD
#### Todas los métodos hacen uso de excepciones.
- **Métodos:**
  - `agregarVehiculo(Vehiculo vehiculo)`: Agrega un vehículo a la base de datos.
  - `obtenerVehiculoPorId(int id)`: Obtiene un vehículo por su ID (proporcionada por el usuario).
  - `actualizarVehiculo(int id, Vehiculo vehiculo)`: Actualiza un vehículo en la base de datos por su ID (proporcionada por el usuario).
  - `eliminarVehiculoPorId(int id)`: Elimina un vehículo de la base de datos por su ID (proporcionada por el usuario).
  - `registrarVenta(Vehiculo vehiculo, Cliente cliente)`: Registra una venta en la base de datos. (Destacar, que sí o sí, la venta será con el último usuario que se ha creado [case 5] y el ID que tu proporciones).
  - `agregarCliente(Cliente cliente)`: Agrega un cliente a la base de datos.

## Clase MAIN
#### A destacar:
- Contiene un menú con submenús para interactuar con el sistema.
- Se hace uso de scanner en todos los Case para que haya interacción directa con el usuario.
- ***IMPORTANTE*** || Se tienen dos métodos creados al final del Main (crearVehiculo(Scanner scanner) y crearCliente(Scanner scanner)), los cuales se usan muchas veces durante el código para reutilizar código. Por ejemplo, en el submenú del CRUD en el método añadirVehiculo y en el submenu del Concesionario en el método añadirVehiculo, se llama al método crearVehiculo(Scanner scanner) dos veces.

## Test Driven Development

- Se incluyen dos simples tests para las clases Concesionario y GestorBD.
  - Concesionario: Donde se testea el método agregarVehiculo (comprobando que el vehículo insertado en la lista existe efectivamente).
  - GestorBD: donde se testea el método agregarVehiculo() (comprobando con getters) y el método eliminarVehiculoPorId() (verificando que se borra).

