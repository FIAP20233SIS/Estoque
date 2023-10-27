FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN

WORKDIR /tmp/
COPY . .

RUN mvn clean install

FROM openjdk:8-jre-alpine
COPY --from=MAVEN_TOOL_CHAIN /tmp/estoque/target/estoque.war $CATALINA_HOME/webapps/estoque.war
WORKDIR $CATALINA_HOME/webapps/
ENTRYPOINT [ "java","-jar", "estoque.war"  ]
EXPOSE 80