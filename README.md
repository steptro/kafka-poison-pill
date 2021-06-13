# How to handle poison pills in Kafka
Example project for my blogpost about Kafka poison pills: https://stephantromer.dev/how-to-handle-poison-pills-in-kafka. 

## Libraries used
- Java 14
- Spring Boot 2.5.0
- Spring Kafka 2.7.1
- Gradle 6.8
- Docker with Kafka

## Projects
This repository contains two projects:

- `kafka-poison-pill`: This folder contains the code that simulates a poison pill.
- `kafka-poison-pill-error-handling`: This folder contains the code that shows how to configure an `ErrorHandlingDeserializer`.

The project also contains a `docker-compose.yml` file that you can use to setup Kafka locally in case you haven’t already configured Kafka yourself.

## Usage
After building and starting one of the applications, the poison pill can be triggered by running following command or pasting the url in your browser to trigger the poison pill: 
```
curl http://localhost:8080/produce-order
```

### Dead letter topic
In the `kafka-poison-pill-error-handling` project dead letter topics can be enabled by setting the property `spring.kafka.dlt.enable` to true.

