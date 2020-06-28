FROM openjdk:14-alpine as builder
WORKDIR application

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests -DskipITs
RUN java -Djarmode=layertools -jar target/*.jar extract

FROM openjdk:14-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
VOLUME /tmp
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.PropertiesLauncher"]
#ENTRYPOINT ["java", "-cp","app:app/lib/*","-Dloader.path=workspace/conf","-Dloader.main=com.example.demo.DemoApplication","org.springframework.boot.loader.PropertiesLauncher"]
#ENTRYPOINT ["java", "-cp","app:app/lib/*", "org.springframework.boot.loader.JarLauncher"]