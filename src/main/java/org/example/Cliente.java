package org.example;

public class Cliente extends Persona {
    public Cliente(int idCliente, String nombre, String apellido, String telefono, String direccion, String correoElectronico,boolean compraRealizada) {
        super(idCliente, nombre, apellido, telefono, direccion, correoElectronico,compraRealizada);

    }

    // Implementación del método para realizar una compra de vehículo
    @Override
    void comprarVehiculo(Vehiculo vehiculo) {
        if (!haRealizadoCompra()) {
            System.out.println("Realizando compra del vehículo: " + vehiculo);
            marcarCompraRealizada();
        } else {
            System.out.println("El cliente " + this.getNombre() + " ya ha realizado una compra previamente.");
        }
    }
}
