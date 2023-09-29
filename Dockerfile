# Use uma imagem base do OpenJDK com Java 17
FROM openjdk:17

# Define variáveis de ambiente para limitar o uso de CPU e memória
ENV JAVA_OPTS="-Xmx512m -Xms512m" \
    CPUS=2

# Copie o arquivo JAR do seu projeto para o contêiner
COPY ./build/libs/rinha-1.0-SNAPSHOT.jar /app/rinha-1.0-SNAPSHOT.jar

COPY ./soma.rinha.json /app/soma.rinha.json

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Comando para executar o seu projeto Java
CMD ["java", "-jar", "rinha-1.0-SNAPSHOT.jar"]
