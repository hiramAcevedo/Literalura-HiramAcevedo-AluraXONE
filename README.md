# 📚 LiterAlura - Catálogo de Libros 🌟

Desafío del programa ONE Next Education X Alura consumiendo una API de libros, guardándolos en una base de datos para mostrarlos al usuario a demanda. Construido en Java y Spring Boot por Hiram Acevedo.

## 🚀 Características

- 🔍 Busca libros utilizando la API de Gutendex
- 💾 Guarda libros en una base de datos PostgreSQL
- 📖 Lista libros y autores registrados
- 🌍 Filtra libros por idioma
- 👴 Busca autores vivos en un año específico
- 🖥️ Interfaz de línea de comandos interactiva

## 🧠 Lógica del Programa

1. 🌐 Conecta con la API de Gutendex para buscar libros
2. 🔄 Convierte la respuesta JSON en objetos Java
3. 📥 Guarda los libros en la base de datos, evitando duplicados
4. 📊 Permite al usuario interactuar a través de un menú en consola
5. 🔍 Realiza consultas a la base de datos según las solicitudes del usuario

## 🛠️ Tecnologías Utilizadas

- Java 17
- Spring Boot 3.x
- Maven
- PostgreSQL
- Jackson para manejo de JSON
- JPA / Hibernate para persistencia de datos

## 📋 Requisitos Previos

- JDK 17 o superior
- Maven
- PostgreSQL
- Una conexión a Internet para acceder a la API de Gutendex

## 🚀 Cómo Ejecutar

1. Clona este repositorio:
   ```
   git clone https://tu-repositorio.git
   ```

2. Navega al directorio del proyecto:
   ```
   cd literalura
   ```

3. Configura la base de datos en `application.properties`

4. Compila el proyecto:
   ```
   mvn clean install
   ```

5. Ejecuta la aplicación:
   ```
   java -jar target/literalura-0.0.1-SNAPSHOT.jar
   ```

## 💡 Uso

1. Al iniciar, verás un menú con opciones numeradas.
2. Selecciona una opción ingresando el número correspondiente.
3. Sigue las instrucciones en pantalla para cada operación.
4. Para salir, selecciona la opción de salida (generalmente 0).

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue primero para discutir qué te gustaría cambiar.

## 📜 Licencia

[MIT](https://choosealicense.com/licenses/mit/)

---

Hecho con ❤️ y ☕ por Hiram Acevedo