# Office Management System
System to organize administration works of an office.

##### Pre-requisites
1. MongoDB Atlas
    * Signup / login to mongodb atlas. [Link to Mongo](https://account.mongodb.com/account/login "Mongodb Login/Signup")
    * Give your desired name for your own organisation :P
    * Add project name.
    * Create a cluster (make use of free-tier usages). This would take 1-3 minutes.
    * Click on connect from the clusters' sandbox.
    * Choose a way to connect to mongodb (through shell, application or compass)
2. MongoDB Compass/Shell
    * Download the mongodb compass/shell from the popup by clicking on "Connect" of cluster's sandbox.
    * Connect to db with the connection string from the clusters' sandbox.
    * Create a database.
    * Use your desired database.
    * Create collection (general term `table` is called as collection here as it is saving data as a json)
---

To connect mongodb to this application, make below changes.

In the application.yaml
```yaml
spring:
  data:
    mongodb:
      uri: mongodb+srv://root:<password>@<host>/<db-name>?retryWrites=true&w=majority # Get this connection string from your cluster
      database: office-management
```
In the pom.xml, add below dependencies
```xml
<!-- Spring mongodb starter -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```
```xml
<!-- Mongodb driver -->
<dependency>
    <groupId>org.mongodb</groupId>
    <artifactId>mongo-java-driver</artifactId>
    <version>version</version> # replace with its latest version
</dependency>
```

Run the spring boot application, office-management services will be up and running on port 7300

You can change the port by updating in application.yaml
```yaml
server:
  port: 7300
```
