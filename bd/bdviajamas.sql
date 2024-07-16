create database bdviajamas;
use bdviajamas;

CREATE TABLE usuario (
	idusuario INT auto_increment NOT NULL,
	nomusuario varchar(100) NULL,
	email varchar(200) NULL,
	password varchar(300) NULL,
	nombres varchar(100) NULL,
	apellidos varchar(100) NULL,
	activo BOOL NULL,
	CONSTRAINT users_pk PRIMARY KEY (idusuario)
);


CREATE TABLE rol (
	idrol INT auto_increment NOT NULL,
	nomrol varchar(300) NULL,
	CONSTRAINT roles_pk PRIMARY KEY (idrol)
);


CREATE TABLE usuario_rol (
	idusuario INT NOT NULL,
	idrol INT NOT NULL,
	CONSTRAINT user_role_pk PRIMARY KEY (idusuario, idrol)
);

create table pais (
    idpais int auto_increment primary key,
    descripcion varchar(255)
);

create table jurisdiccion (
    idjurisdiccion int auto_increment primary key,
    descripcion varchar(255),
    idpais int,
    foreign key (idpais) references pais(idpais)
);
create table ciudad (
    idciudad int auto_increment primary key,
    descripcion varchar(255),
    idjurisdiccion int,
    foreign key (idjurisdiccion) references jurisdiccion(idjurisdiccion)
);

CREATE TABLE Avion (
    idavion INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(100) NOT NULL,
    capacidadpasajeros INT
);

CREATE TABLE aerolinea (
    idaerolinea INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    idpais INT,
    FOREIGN KEY (idpais) REFERENCES pais(idpais)
);

CREATE TABLE aeropuerto (
    idaeropuerto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    idciudad int,
    idjurisdiccion int,
    idpais int,
    FOREIGN KEY (idciudad) REFERENCES ciudad(idciudad),
    FOREIGN KEY (idjurisdiccion) REFERENCES jurisdiccion(idjurisdiccion),
    FOREIGN KEY (idpais) REFERENCES pais(idpais)
);

CREATE TABLE Vuelo(
    idvuelo INT AUTO_INCREMENT PRIMARY KEY,
    numerovuelo CHAR(20) NOT NULL,
    aerolinea INT,
    avion INT,
    aeropuerto_origen INT,
    aeropuerto_destino INT,
    fechasalida DATETIME,
    fechallegada DATETIME,
    duracion INT,
    FOREIGN KEY (aerolinea) REFERENCES aerolinea(idaerolinea),
    FOREIGN KEY (aeropuerto_origen) REFERENCES aeropuerto(idaeropuerto),
    FOREIGN KEY (aeropuerto_destino) REFERENCES aeropuerto(idaeropuerto),
    FOREIGN KEY (avion) REFERENCES avion(idavion)
);
