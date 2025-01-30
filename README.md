# Kafka + Zookeeper + Java Example

ES:

Este repositorio contiene un ejemplo básico para entender cómo funcionan **Kafka** y **Zookeeper** utilizando **Java** para crear un productor y un consumidor de mensajes.

## Requisitos

- Docker
- Java SDK
- Apache Maven

## Instalación

1. Clona este repositorio:
    
    git clone https://github.com/pdelalamo/kafka-java-example.git
    cd kafka-java-example

2. Inicia Kafka y Zookeeper con Docker:
    docker-compose up

3. Crea el topic en Kafka:
    docker exec -it code-kafka-1 /bin/sh
    kafka-topics.sh --create --topic test-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

4. Compila el proyecto:
    mvn package

## Uso

1. Ejecuta el **productor** para enviar mensajes a Kafka:
    java -cp target/kafka-java-example-1.0-SNAPSHOT.jar com.example.kafka.ProducerExample

2. Ejecuta el **consumidor** para recibir mensajes desde Kafka:
    java -cp target/kafka-java-example-1.0-SNAPSHOT.jar com.example.kafka.ConsumerExample

EN:

# Kafka + Zookeeper + Java Example

This repository contains a basic example to understand how **Kafka** and **Zookeeper** work using **Java** to create a message producer and consumer.

## Requirements

- Docker
- Java SDK
- Apache Maven

## Installation

1. Clone this repository:
    
    git clone https://github.com/pdelalamo/kafka-java-example.git  
    cd kafka-java-example

2. Start Kafka and Zookeeper with Docker:  
    docker-compose up

3. Create the topic in Kafka:  
    docker exec -it code-kafka-1 /bin/sh  
    kafka-topics.sh --create --topic test-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

4. Build the project:  
    mvn package

## Usage

1. Run the **producer** to send messages to Kafka:  
    java -cp target/kafka-java-example-1.0-SNAPSHOT.jar com.example.kafka.ProducerExample

2. Run the **consumer** to receive messages from Kafka:  
    java -cp target/kafka-java-example-1.0-SNAPSHOT.jar com.example.kafka.ConsumerExample

Run the consumer to receive messages from Kafka: java -cp target/kafka-java-example-1.0-SNAPSHOT.jar com.example.kafka.ConsumerExample
