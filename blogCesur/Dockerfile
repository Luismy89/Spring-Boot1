# Etapa 1: Construcción de la aplicación
FROM eclipse-temurin:23-jdk AS builder

# Definir el directorio de trabajo
WORKDIR /app

# Copiar los archivos del proyecto
COPY . .

# Dar permisos de ejecución a mvnw
RUN chmod +x mvnw

# Construir la aplicación sin ejecutar pruebas
RUN ./mvnw clean package -DskipTests

# Etapa 2: Ejecución de la aplicación
FROM eclipse-temurin:23-jre

# Definir el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR desde la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Exponer el puerto en el que correrá la aplicación
EXPOSE 9000

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]