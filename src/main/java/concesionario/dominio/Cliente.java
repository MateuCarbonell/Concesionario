package concesionario.dominio;

public class Cliente extends Persona {
    public Cliente(int idCliente, String nombre, String apellido, String telefono, String direccion, String correoElectronico) {
        super(idCliente, nombre, apellido, telefono, direccion, correoElectronico);

    }



    // Implementación del método para realizar una compra de vehículo
    @Override
    public void comprarVehiculo(Vehiculo vehiculo, GestorBD gestorBD) {
        if (!haRealizadoCompra()) {
            System.out.println("Realizando compra del vehículo: " + vehiculo);
            gestorBD.registrarVenta(vehiculo,this);
            marcarCompraRealizada();

        } else {
            System.out.println("El cliente " + this.getNombre() + " ya ha realizado una compra previamente.");
        }
    }
}
