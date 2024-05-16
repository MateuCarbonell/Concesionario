package concesionario.dominio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Objects;

public class GestorBDTest {

    @Test
    void agregarVehiculo() {
        // Arrange
        GestorBD gestorBD = new GestorBD();
        Vehiculo vehiculo = new Vehiculo(999, "Toyota", "Corolla", 2022, 25000.0, "Nuevo");

        // Act
        gestorBD.agregarVehiculo(vehiculo);

        // Assert
        Vehiculo vehiculoAgregado = gestorBD.obtenerVehiculoPorId(999);
        assertNotNull(vehiculoAgregado);
        assertEquals(vehiculo.getIdVehiculo(), vehiculoAgregado.getIdVehiculo());
        assertEquals(vehiculo.getMarca(), vehiculoAgregado.getMarca());
        assertEquals(vehiculo.getModelo(), vehiculoAgregado.getModelo());
        assertEquals(vehiculo.getAño(), vehiculoAgregado.getAño());
        assertEquals(vehiculo.getPrecio(), vehiculoAgregado.getPrecio());
        assertEquals(vehiculo.getEstado(), vehiculoAgregado.getEstado());
    }

    @Test
    void eliminarVehiculoPorId() {
        // Arrange
        GestorBD gestorBD = new GestorBD();
        Vehiculo vehiculo = new Vehiculo(10000, "Toyota", "Corolla", 2022, 25000.0, "Nuevo");
        gestorBD.agregarVehiculo(vehiculo);

        // Act
        gestorBD.eliminarVehiculoPorId(10000);

        // Assert
        assertNull(gestorBD.obtenerVehiculoPorId(10000));
    }
}

