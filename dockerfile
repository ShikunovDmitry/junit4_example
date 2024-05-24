# Использовать базовый образ Maven для сборки
FROM maven:3.8.4-openjdk-11-slim AS build

# Установить рабочую директорию
WORKDIR /app

# Скопировать файл зависимостей и исходный код
COPY pom.xml .
COPY src ./src

# Сборка проекта
RUN mvn clean package

# Использовать базовый образ OpenJDK для выполнения
FROM maven:3.8.4-openjdk-11-slim

# Установить рабочую директорию
WORKDIR /app

# Скопировать скомпилированный jar-файл из стадии сборки
COPY --from=build /app/target/lesson5-1.2-SNAPSHOT.jar app.jar

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]
