ViajaMás
ViajaMás es una API REST desarrollada con Spring Boot, diseñada para la gestión eficiente de vuelos. El proyecto sigue los principios SOLID para garantizar un código mantenible y escalable.

Características
Gestión de vuelos: Crear, leer y actualizar vuelos.
Gestión de aerolíneas: Manejo de diferentes aerolíneas.
Gestión de aviones: Registro y administración de aviones.
Gestión de aeropuertos: Manejo de aeropuertos y sus ubicaciones.
Gestión de usuarios y roles: Autenticación y autorización integradas utilizando Spring Security.
Requisitos
Java 11 o superior
Maven 3.6.3 o superior
Spring Boot 2.5.4 o superior
MySQL 8.0 o superior
Instalación
Clonar el repositorio:

bash
Copiar código
git clone https://github.com/tu-usuario/ViajaMas.git
cd ViajaMas
Configurar la base de datos en src/main/resources/application.properties:

properties
Copiar código
spring.datasource.url=jdbc:mysql://localhost:3306/bdviajamas
spring.datasource.username=tu-usuario
spring.datasource.password=tu-contraseña
spring.jpa.hibernate.ddl-auto=update
Compilar y ejecutar la aplicación:

bash
Copiar código
mvn clean install
mvn spring-boot:run
Endpoints
Vuelos
GET /vuelos: Obtiene todos los vuelos.
GET /vuelos/{id}: Obtiene un vuelo por ID.
POST /vuelos: Crea un nuevo vuelo.
PUT /vuelos/{id}: Actualiza un vuelo existente.
Aerolíneas
GET /aerolineas: Obtiene todas las aerolíneas.
GET /aerolineas/{id}: Obtiene una aerolínea por ID.
POST /aerolineas: Crea una nueva aerolínea.
PUT /aerolineas/{id}: Actualiza una aerolínea existente.
Aviones
GET /aviones: Obtiene todos los aviones.
GET /aviones/{id}: Obtiene un avión por ID.
POST /aviones: Crea un nuevo avión.
PUT /aviones/{id}: Actualiza un avión existente.
Aeropuertos
GET /aeropuertos: Obtiene todos los aeropuertos.
GET /aeropuertos/{id}: Obtiene un aeropuerto por ID.
POST /aeropuertos: Crea un nuevo aeropuerto.
PUT /aeropuertos/{id}: Actualiza un aeropuerto existente.
Principios SOLID
Single Responsibility Principle: Cada clase tiene una única responsabilidad.
Open/Closed Principle: Las clases están abiertas para extensión, pero cerradas para modificación.
Liskov Substitution Principle: Las clases derivadas deben ser sustituibles por sus clases base.
Interface Segregation Principle: Las interfaces deben ser específicas del cliente y no generales.
Dependency Inversion Principle: Depender de abstracciones y no de concreciones.
Contribuciones
Las contribuciones son bienvenidas. Por favor, sigue los pasos a continuación para contribuir:

Haz un fork del proyecto.
Crea una nueva rama (git checkout -b feature/nueva-caracteristica).
Realiza tus cambios y haz commit (git commit -am 'Añadir nueva característica').
Sube tus cambios (git push origin feature/nueva-caracteristica).
Abre un Pull Request.

Link Angular:
https://github.com/Enzolg03/ViajaMas-Angular
