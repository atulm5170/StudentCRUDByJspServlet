FROM tomcat:10.1-jdk21

RUN rm -rf /usr/local/tomcat/webapps/ROOT

COPY target/StudentCRUD.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080