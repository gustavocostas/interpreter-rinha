FROM openjdk:17

ENV JAVA_OPTS="-Xmx512m -Xms512m" \
    CPUS=2

COPY ./build/libs/rinha-1.0-SNAPSHOT.jar /app/rinha-1.0-SNAPSHOT.jar

COPY ./soma.rinha.json /app/soma.rinha.json

WORKDIR /app

CMD ["java", "-jar", "rinha-1.0-SNAPSHOT.jar"]
