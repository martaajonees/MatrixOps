# Imagen base con Java 21
FROM eclipse-temurin:21-jdk

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR al contenedor
COPY target/App-0.0.1-SNAPSHOT.jar matrix-calculator.jar

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "matrix-calculator.jar"]
