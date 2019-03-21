FROM tomcat:8.5.31-jre8

ENV CATALINA_HOME /usr/local/tomcat
ADD target/helloworld-0.0.1-SNAPSHOT.war $CATALINA_HOME/webapps

CMD ["catalina.sh","run"]
