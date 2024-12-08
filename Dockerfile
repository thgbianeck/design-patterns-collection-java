FROM maven:3.8.7-openjdk-18-slim

WORKDIR /app

VOLUME /root/.m2

CMD ["tail", "-f", "/dev/null"]
