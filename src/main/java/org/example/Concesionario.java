package org.example;

import java.util.List;

public class Concesionario {
    private List<Vehiculo> inventario;

    // Constructor
    public Concesionario(List<Vehiculo> inventario) {
        this.inventario = inventario;
    }

    public void mostrarInventario(){
        System.out.println("Mostrando inventario");
        for(Vehiculo vehiculo : inventario){
            System.out.println("Marca: " + vehiculo.getMarca() + " Modelo: " + vehiculo.getModelo() + " Precio: " + vehiculo.getPrecio());
        }
    }
}
