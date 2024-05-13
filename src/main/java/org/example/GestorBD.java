package org.example;
import java.sql.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

public class GestorBD {
    private DataSource dataSource;
    // Constructor
    public GestorBD(){
        this.dataSource=createDataSource();

    }
    public static DataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/concesionario");
        config.setUsername("root");
        config.setPassword("root");

        return new HikariDataSource(config);
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        String query = "INSERT INTO Vehiculos (marca, modelo, año, precio, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, vehiculo.getMarca());
            statement.setString(2, vehiculo.getModelo());
            statement.setInt(3, vehiculo.getAño());
            statement.setDouble(4, vehiculo.getPrecio());
            statement.setString(5, vehiculo.getEstado());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

