package concesionario.dominio;

public abstract class Persona {
    private int idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String correoElectronico;

    // Constructor, getters y setters


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }



    public Persona(int idCliente, String nombre, String apellido, String telefono, String direccion, String correoElectronico) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
    }

    // metodos y lógica
    abstract void comprarVehiculo(Vehiculo vehiculo,GestorBD gestorBD);

    private boolean compraRealizada = false;


    boolean haRealizadoCompra() {
        return compraRealizada;
    }

    void marcarCompraRealizada() {
        compraRealizada = true;
    }

}
