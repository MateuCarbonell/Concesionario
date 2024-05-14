package concesionario.dominio;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    void testComprarVehiculo() {
        // Crear un cliente
        Cliente cliente = new Cliente(1, "Nombre", "Apellido", "123456789", "Dirección", "correo@ejemplo.com");

        // Crear un gestor de base de datos (puede ser una implementación real o una en memoria para las pruebas)
        GestorBD gestorBD = new GestorBD(); // Esto depende de cómo implementes tu GestorBD

        // Crear un vehículo
        Vehiculo vehiculo = new Vehiculo(1, "Marca", "Modelo", 2022, 25000.0, "Nuevo");

        // Probar comprar un vehículo por primera vez
        cliente.comprarVehiculo(vehiculo, gestorBD);

        // Verificar que el cliente ha marcado la compra como realizada
        assertTrue(cliente.haRealizadoCompra());

        // Probar comprar un vehículo por segunda vez
        cliente.comprarVehiculo(vehiculo, gestorBD);

        // Verificar que el cliente no realiza una segunda compra
        assertFalse(cliente.haRealizadoCompra());
    }
}
