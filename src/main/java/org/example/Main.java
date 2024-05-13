package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GestorBD gestorBD = new GestorBD();
        // Crear un vehículo para agregar a la base de datos
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Corolla", 2022, 25000.0, "Nuevo");

        try{
            gestorBD.agregarVehiculo(vehiculo);
        }catch(Exception e){
            e.printStackTrace();
        }



    }
}