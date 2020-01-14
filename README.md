**Bindings** — a collection of interfaces that identify the input and output channels declaratively

**Binder** — messaging-middleware implementation such as Kafka or RabbitMQ

**Channel** — represents the communication pipe between messaging-middleware and the application

**StreamListeners** — message-handling methods in beans that will be automatically invoked on a message from the channel after the MessageConverter does the serialization/deserialization between middleware-specific events and domain object types / POJOs

**Message Schemas** — used for serialization and deserialization of messages, these schemas can be statically read from a location or loaded dynamically, supporting the evolution of domain object types


Notes:

Processor (Interface) - Default. Provided by SCS. This has one source and one sink.

To define a custom channel, create an interface with input and output.

**Partitions** 

**Scaling up**

spring.cloud.stream.instanceCount — number of running applications
spring.cloud.stream.instanceIndex — index of the current application



**Health Indicator**
http://[host]:[port]/health.


