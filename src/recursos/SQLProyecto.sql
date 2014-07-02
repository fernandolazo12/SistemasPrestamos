CREATE TABLE DetallePrestamo (
  idDetallePrestamo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  descripcion INTEGER UNSIGNED NULL,
  idDocente INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idDetallePrestamo)
);

CREATE TABLE DetalleInventario (
  idDetalleInventario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Equipo VARCHAR(45) NULL,
  Cantidad INTEGER UNSIGNED NULL,
  PRIMARY KEY(idDetalleInventario)
);

CREATE TABLE Docente (
  idDocente INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Descripcion VARCHAR(45) NULL,
  idPersona INTEGER UNSIGNED NOT NULL,
  idEAP INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idDocente)
);

CREATE TABLE EAP (
  idEAP INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Escuela VARCHAR(45) NULL,
  idFacultad INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idEAP)
);

CREATE TABLE Equipo (
  idEquipo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Nombre VARCHAR(20) NULL,
  Marca VARCHAR(20) NULL,
  Modelo VARCHAR(20) NULL,
  Nro_Serie INTEGER UNSIGNED NULL,
  Estado CHAR(1) NULL,
  idDetalleInventario INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idEquipo)
);

CREATE TABLE Facultad (
  idFacultad INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Facultad VARCHAR(45) NULL,
  PRIMARY KEY(idFacultad)
);

CREATE TABLE Persona (
  idPersona INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Nombre VARCHAR(20) NULL,
  Paterno VARCHAR(20) NULL,
  Materno VARCHAR(20) NULL,
  Sexo CHAR(1) NULL,
  DNI NUMERIC(8) NULL,
  Celular NUMERIC(9) NULL,
  Direccion VARCHAR(45) NULL,
  PRIMARY KEY(idPersona)
);

CREATE TABLE Prestamos (
  idPrestamos INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Tiempo VARCHAR(20) NULL,
  Fecha_Prestamos DATETIME NULL,
  Fecha_Entrega DATETIME NULL,
  Estado CHAR(1) NULL,
  idUsuario INTEGER UNSIGNED NOT NULL,
  idEquipo INTEGER UNSIGNED NOT NULL,
  idDetallePrestamo INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idPrestamos)
);

CREATE TABLE Reserva (
  idReserva INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Curso VARCHAR(45) NULL,
  Aula VARCHAR(20) NULL,
  Fecha DATETIME NULL,
  Horario DATETIME NULL,
  Estado CHAR(1) NULL,
  idDocente INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idReserva)
);

CREATE TABLE Reserva_Equipo (
  idReserva INTEGER UNSIGNED NOT NULL,
  idEquipo INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idReserva, idEquipo)
);

CREATE TABLE Usuario (
  idUsuario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Login VARCHAR(45) NULL,
  Clave VARCHAR(45) NULL,
  idPersona INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idUsuario)
);

