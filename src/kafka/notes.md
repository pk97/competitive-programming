
Apache Kafka is a distributed streaming system for managing real-time data flows, offering high throughput and low latency.
It operates as a cluster across multiple machines in data centres and organizes data into topics. Troubleshooting Kafka is crucial for maintaining system stability, data integrity, and optimal performance.
Addressing issues like message loss, consumer lag, and ZooKeeper dependency enhances data streaming system stability, performance, and reliability.
- https://medium.com/javarevisited/kafka-partitions-and-consumer-groups-in-6-mins-9e0e336c6c00
- https://medium.com/nerd-for-tech/a-basic-introduction-to-kafka-a7d10a7776e6

  - If two consumers have subscribed to the same topic and are present in the same consumer group,
  then these two consumers would be assigned a different set of partitions and 
  none of these two consumers would receive the same messages.

- Basics 
   - Kafka ensures high Throughout, but has low storage. It gaurrenty in-order read  to consumers,
      with high availabliity and fault tolerance.
  - Eg. 1 M drivers of Uber are producing data of their current location then you cannot directly save
    1m records to db since it's throughput is low. But kafka can handle it. Now each consumer on it's own speed
    will poll broker and fetch X events. process it and save it in DB.
  - Topic is a way to categorize different events. Eg.  hotel updates, driver location updates, vehicle updates
  - Parition are used to increase the Throughput further. if a topic has 10  partitiions, then it can have at max 10 
    consumers for parallel processing in a consumer group.
  - When you want to scale kafka, add more partitions to topic to increase consumers.
  - When you want risk-service, notification service to listen to same event but process them independently, then use consumer groups.
  - Zookeeper is a software used to manage disctributed brokers, to find leader, data replication etc.
  - Challenges
    - Consumer rebalancing
      - a consumer goes down, a new comes up, partitions will be destributed again leading to down time.
      - kafka broker not receiving heartbeat of consumer within sssion timeout.
      - Consumer taking more than max.pollTime to process the batch of events, then broker thinks consumer is stuck.
    - Poison Pill problem with kafka
    - Cost of increasing partitions
    - Expected down time on increasing partitions

  The CooperativeStickyAssignor is similar to StickyAssignor but allows consumers unaffected by rebalancing to process messages, 
  hence playing a part in minimizing lag.
