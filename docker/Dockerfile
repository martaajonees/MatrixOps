# Imagen base con Java 21
FROM eclipse-temurin:21-jdk

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar los archivos del proyecto al contenedor
COPY . .

# Instalar Maven
RUN apt-get update && apt-get install -y maven

# Compilar el proyecto con Maven y generar el archivo JAR
RUN mvn clean install -DskipTests

# Exponer el puerto por defecto de Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "target/App-0.0.1-SNAPSHOT.jar"]
