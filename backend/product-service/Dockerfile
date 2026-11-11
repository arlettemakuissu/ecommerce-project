# Étape 1 : Utiliser une image OpenJDK pour builder/exécuter l'application
FROM eclipse-temurin:17-jdk-alpine

# Définir le dossier de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR généré dans le conteneur
COPY target/*.jar app.jar

# Exposer le port de l'application
EXPOSE 8081

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]