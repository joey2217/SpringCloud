# Spring Cloud Kubernetes

> https://docs.gitcode.net/spring/guide/spring-cloud/spring-cloud-kubernetes.html#_1-why-do-you-need-spring-cloud-kubernetes
 

## SpringBootDocker

https://spring.io/guides/topicals/spring-boot-docker/


```sh
docker build -t myorg/myapp .
```


```Dockerfile
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar ${0} ${@}"]
```

```sh
docker run -p 9000:9000 myorg/myapp --server.port=9000
```