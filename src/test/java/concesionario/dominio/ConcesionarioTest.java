package concesionario.dominio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ConcesionarioTest {

    @Test
    void agregarVehiculo() {

        List<Vehiculo> inventario = new ArrayList<>();
        Concesionario concesionario = new Concesionario(inventario);
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Corolla", 2022, 25000.0, "Nuevo");


        concesionario.agregarVehiculo(vehiculo);


        assertEquals(1, concesionario.getInventario().size());
        assertTrue(concesionario.getInventario().contains(vehiculo));
    }
}
