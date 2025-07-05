FROM tomcat:10.1-jdk21
WORKDIR /usr/local/tomcat/webapps/
COPY target/quest-1.0-SNAPSHOT.war ./ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]