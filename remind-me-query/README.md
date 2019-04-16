# remind-me-query

## Curl
```sh
curl localhost:8091/query/reminder
```

## Cassandra

### Creating new instance
```
docker run --name cassandra-remind-me-1 -p 7000-7001:7000-7001 -p 7199:7199 -p 9042:9042 -p 9160:9160 -v /data/cassandra:/var/lib/cassandra -d cassandra
```

### Connecting and Running Commands
- connect to container
```
docker run -it --link cassandra-remind-me-1:cassandra --rm cassandra cqlsh cassandra
```

- keyspace
```
CREATE KEYSPACE remind_me WITH REPLICATION={'class':'SimpleStrategy', 'replication_factor': 1};
USE remind_me;
```

- table
```
CREATE TABLE reminder(id uuid PRIMARY KEY, type text, remindTo text);
INSERT INTO reminder(id, type, remindTo) VALUES (15d6768f-30e8-44bc-a035-8eade91b314d, 'TEXT', 'Drink water');
SELECT * FROM reminder;
```