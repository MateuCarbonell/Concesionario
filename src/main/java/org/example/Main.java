package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GestorBD gestorBD = new GestorBD();
        // Crear un vehículo para agregar a la base de datos
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Corolla", 2022, 25000.0, "Nuevo");
        Vehiculo vehiculo2 = new Vehiculo(2, "Mitsubishi", "EVO", 2023, 35000.0, "Usado");

        try{
            gestorBD.agregarVehiculo(vehiculo2);
        }catch(Exception e){
            e.printStackTrace();
        }



    }
}