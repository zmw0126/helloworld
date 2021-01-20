FROM tomcat:8.5.31-jre8

EXPOSE 9098
ENV CATALINA_HOME /usr/local/tomcat
ADD target/helloworld-0.0.1-SNAPSHOT.war /

CMD ["java","-jar","/helloworld-0.0.1-SNAPSHOT.war"]
