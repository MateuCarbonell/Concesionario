CREATE TABLE Vehiculos (
    idVehiculo INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(100),
    modelo VARCHAR(100),
    año INT,
    precio DECIMAL(10, 2),
    estado VARCHAR(50)
);

CREATE TABLE Clientes (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    telefono VARCHAR(20),
    direccion VARCHAR(255),
    correoElectronico VARCHAR(100)
);

CREATE TABLE Ventas (
    idVenta INT AUTO_INCREMENT PRIMARY KEY,
    idVehiculo INT,
    idCliente INT,
    fechaVenta DATE,
    precioVenta DECIMAL(10, 2),
    FOREIGN KEY (idVehiculo) REFERENCES Vehiculos(idVehiculo),
    FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente)
);
