# cursos

## Comenzando 🚀

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local y en Docker para propósitos de desarrollo y pruebas.

## Pre-requisitos

### Herramientas necesarias

-[Java SE Development Kit 11.0.11](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html) - El software que provee herramientas de desarrollo para la creación de programas en Java.

-[IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/download/#section=windows) - es un entorno de desarrollo integrado (IDE) para el desarrollo de programas informáticos.

-[Docker Desktop](https://docs.docker.com/desktop/windows/install/) - Docker empaqueta software en “contenedores” que incluyen en ellos todo lo necesario para que dicho software se ejecute.

-[Postman](https://www.postman.com/downloads/) - Postman es una aplicación que nos permite realizar pruebas API.

-[Git](https://gitforwindows.org/) - Git es un sistema de control de versiones distribuido.

## Instalación

Descargue de Git el repositorio.

```bash
git clone git@github.com:LuisLunaNivelics/cursos-ms.git
```
## Ejecución local
1. Ejecutar el proyecto desde el IDE.
2. Crear la BD curso.
3. Por medio de Postman se realiza la validación de conexión con el MS.
```python
http://localhost:8083/api/v1/cursos/listar
```

## Ejecución con Docker
1. Crear red de trabajo Docker.
```python
   docker network create -d bridge dev-local
```
2. Crear la BD curso.
3. Crear la imagen y ejecutar en Docker el microservicio.

## Pasos para crear imagen en docker
3.1 Agregar al archivo docker-compose.yml en la carpeta que va a contener todos los microservicios estos se agregan a nivel de db.
```python
version: "3"
services: 
  db:
    image: mysql
    restart: always
    container_name: nombre-contenedor-para-la-BD
    networks:
      - dev-local
    command: --default-authentication-plugin=mysql_native_password --transaction-isolation=READ-COMMITTED --binlog-format=ROW 
    ports:
      - 3306:3306
    environment:
      MYSQL_ROOT_PASSWORD: password-BD
      MYSQL_DATABASE: curso
    volumes:
      - ./data/mysql:/var/lib/mysql
  cursos-ms:
    image: cursos-ms
    restart: always
    container_name: cursos-ms
    networks:
      - dev-local
    ports:
      - "8083:8083"
    environment:
      MYSQL_HOST: "db"
    depends_on:
      - db
networks: 
  dev-local:
    external: true
``` 
3.2 Construir el proyecto para crear el archivo .jar ej: build/libs/cursos-ms-0.0.1-SNAPSHOT.jar.         
3.3 Agregar el archivo Dockerfile al microservicio y en la línea 2 se agrega la ruta del .jar generado.
```python
FROM openjdk:11-jre-slim
ADD build/libs/cursos-ms-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8083
ENTRYPOINT [ "java", "-jar", "app.jar"]
```
3.4 Abrimos la consola GitBash dentro de la ruta del microservicio y creamos la imagen con el siguiente comando.
```python
   docker build -f Dockerfile -t cursos-ms .
```
3.5 Abrimos la consola GitBash dentro de la carpeta donde tenemos el microservicio y ejecutamos el siguiente comando para generar el contenedor del servicio.
```python
   docker-compose up -d
```
4. depués de estos pasos nos dirigimos a Postman y validamos la conexión con el microservicio.
```python
http://localhost:8083/api/v1/cursos/listar
```
## License
[MIT](https://choosealicense.com/licenses/mit/)