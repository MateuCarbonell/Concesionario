package concesionario.dominio;
import java.sql.*;
import java.sql.Date;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

public class GestorBD {
    private DataSource dataSource;

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
    // CREATE
    public void agregarVehiculo(Vehiculo vehiculo) {
        String query = "INSERT INTO Vehiculos (idVehiculo,marca, modelo, año, precio, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1,vehiculo.getIdVehiculo());
            st.setString(2, vehiculo.getMarca());
            st.setString(3, vehiculo.getModelo());
            st.setInt(4, vehiculo.getAño());
            st.setDouble(5, vehiculo.getPrecio());
            st.setString(6, vehiculo.getEstado());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // READ
    public Vehiculo obtenerVehiculoPorId(int id) {
        Vehiculo vehiculo = null;
        String query = "SELECT * FROM Vehiculos WHERE idVehiculo = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                vehiculo = new Vehiculo(
                        rs.getInt("idVehiculo"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("año"),
                        rs.getDouble("precio"),
                        rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculo;
    }

    // UPDATE

    public void actualizarVehiculo(int id, Vehiculo vehiculo) {
        String query = "UPDATE Vehiculos SET idVehiculo= ?, marca = ?, modelo = ?, año = ?, precio = ?, estado = ? WHERE idVehiculo = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, vehiculo.getIdVehiculo());
            st.setString(2, vehiculo.getMarca());
            st.setString(3, vehiculo.getModelo());
            st.setInt(4, vehiculo.getAño());
            st.setDouble(5, vehiculo.getPrecio());
            st.setString(6, vehiculo.getEstado());
            st.setInt(7, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // DELETE

    public void eliminarVehiculoPorId(int id) {
        String query = "DELETE FROM Vehiculos WHERE idVehiculo = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // METODO PARA REGISTRAR UNA VENTA

    public void registrarVenta(Vehiculo vehiculo, Cliente cliente) {
        String query = "INSERT INTO ventas (idVehiculo, idCliente, fechaVenta, precioVenta) VALUES (?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, vehiculo.getIdVehiculo());
            st.setInt(2, cliente.getIdCliente());
            st.setDate(3, new Date(System.currentTimeMillis()));// Suponiendo que la fecha se registra automáticamente como la fecha actual
            st.setDouble(4, vehiculo.getPrecio()); // Obtenemos el precio del vehículo
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CLIENTE

    public void agregarCliente(Cliente cliente){
        String query = "INSERT INTO clientes (idCliente, nombre, apellido, telefono, direccion, correoElectronico) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, cliente.getIdCliente());
            st.setString(2, cliente.getNombre());
            st.setString(3, cliente.getApellido());
            st.setString(4, cliente.getTelefono());
            st.setString(5, cliente.getDireccion());
            st.setString(6, cliente.getCorreoElectronico());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }








