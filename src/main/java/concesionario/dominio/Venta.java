package concesionario.dominio;

import java.util.Date;

public class Venta implements SolicitarInformacion {
    private int idVenta;
    private Vehiculo vehiculo;
    private Persona cliente;
    private Date fechaVenta;
    private double precioVenta;

    // Constructor, getters y setters

    public Venta(int idVenta, Vehiculo vehiculo, Persona cliente, Date fechaVenta, double precioVenta) {
        this.idVenta = idVenta;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "ID: " + idVenta +
                ", Vehículo: " + vehiculo.getMarca() + " " + vehiculo.getModelo() +
                ", Cliente: " + cliente.getNombre() + " " + cliente.getApellido() +
                ", Fecha de Venta: " + fechaVenta +
                ", Precio de Venta: $" + String.format("%.2f", precioVenta) +
                '}';
    }
    @Override
    public void solicitarInformacion(){
        System.out.println(this.toString());
    }


}

