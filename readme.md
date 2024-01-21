# Microservicios con Spring

Este proyecto, basado en Spring Framework 3.2.1, utiliza tecnologías como Lombok, Feign, Eureka Server, Config Server y Spring Gateway. Está estructurado como un proyecto Maven con cinco microservicios.

## Diagrama del Proyecto

![diargrama-microservicios](https://github.com/mzrtcode/spring-microservices-test/assets/71569136/2406e8f1-ec7e-4612-a959-c36a12688346)

## Estructura del Proyecto 🏗️

- **microservice.gateway**: Puerta de enlace para la comunicación entre microservicios.
- **microservice-eureka**: Servidor Eureka para registro y descubrimiento de servicios.
- **microservice-config**: Microservicio de configuración centralizada.
- **microservice-student**: Gestión de estudiantes.
- **microservice-course**: Gestión de cursos.

## Tecnologías Utilizadas 🚀

- **Lombok (v1.18.30)**: Simplifica la creación de código.
- **Feign**: Facilita la comunicación entre microservicios.
- **Eureka Server**: Registro y descubrimiento de servicios.
- **Config Server**: Configuración centralizada para mantener coherencia.
- **Spring Gateway**: Puerta de enlace para enrutar solicitudes entre microservicios.

## Configuración de Maven 🧰

El archivo `pom.xml` está configurado con:

- **Spring Boot v3.2.1**
- **Codificación del Proyecto**: UTF-8.
- **Compilador Java**: 17.
