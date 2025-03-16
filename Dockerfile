FROM tomcat:10.1-jdk21
WORKDIR /usr/local/tomcat/webapps/
COPY target/com_javarush_buga_quest-1.0-SNAPSHOT.war ./ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]