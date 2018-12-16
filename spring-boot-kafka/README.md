# Spring Boot with Kafka Producer Example

# Start Zookeeper
zookeeper-server-start.bat E:\SandBox\kafka_2.12-2.0.0\config\zookeeper.properties

# Start Kafka Server
kafka-server-start.bat E:\SandBox\kafka_2.12-2.0.0\config\server.properties

# Create Kafka Topic
kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic topictest

# Consume from the Kafka Topic via Console
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topictest --from-beginning

# Publish message via WebService
http://localhost:2017/kafka/publish/Muni
