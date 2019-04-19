# Remind me Stuff

## Docker Compose
- Spinning up
```
docker-compose up
```

## Kafka
Useful links:
- docker-compose config: https://medium.com/@saabeilin/kafka-hands-on-part-i-development-environment-fc1b70955152
- kafka command line: https://www.cloudera.com/documentation/kafka/latest/topics/kafka_command_line.html

### Create Topic
```
docker-compose exec zookeeper-1 /usr/bin/kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic remind-me
```

### List Topics
```
docker-compose exec zookeeper-1 /usr/bin/kafka-topics --list --zookeeper localhost:2181
```

### Console Consume
```
docker-compose exec kafka-1 /usr/bin/kafka-console-consumer --bootstrap-server kafka:9092 --topic remind-me
```

### Console Producer
```
docker-compose exec kafka-1 /usr/bin/kafka-console-producer --broker-list localhost:9092 --topic remind-me
```