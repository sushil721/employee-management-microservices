# employee-management-microservices
employee-management-microservices using react and all patterns


## Cloud config server repository link:
* [https://github.com/sushil721/cloud-config-server-repository.git](https://github.com/sushil721/cloud-config-server-repository.git)

## Rabbit MQ server install in Docker container:
* [https://hub.docker.com/_/rabbitmq]()
* install docker command:
    ```bash
    docker pull rabbitmq:latest
    ```
* Open Docker Desktop Application:
    ```bash
    docker run --rm -it -p 5672:5672 rabbitmq:latest
    ```

* After running application, do changes git message props of dept and emp properties file.
* [http://localhost:8082/actuator/busrefresh]()
* Just refresh bus it will giving us updated message for both services.

## Micrometrer and Zipkin server link:
* OpenZipkin Docker install command:
    ```bash
    docker pull openzipkin/zipkin
    ```
* Run Zipkin server in Docker container:
    ```bash
    docker run --rm -it --name zipkin -p 9411:9411 openzipkin/zipkin
    ```

* Zipkin server link:
  [http://localhost:9411/zipkin/]()

  ## Swagger URL:
  * http://localhost:8081/swagger-ui/index.html
  * http://localhost:8082/swagger-ui/index.html
  * http://localhost:8084/swagger-ui/index.html
