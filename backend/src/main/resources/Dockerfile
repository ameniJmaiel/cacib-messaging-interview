FROM eclipse-temurin:17-jre-alpine
RUN mkdir /work
COPY target/*.war /work/myapp.war
CMD [ "java", "-jar", "/work/myapp.war"]