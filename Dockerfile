# Usar una imagen base de Tomcat
FROM tomcat:10.1.28-jdk17

# Establecer el directorio de trabajo
WORKDIR /usr/local/tomcat

# Copiar la aplicación web al directorio webapps de Tomcat
COPY ./ /usr/local/tomcat/webapps/

# Descargar y configurar MySQL
RUN apt-get update && \
    apt-get install -y mysql-server && \
    apt-get clean

# Configurar MySQL
RUN service mysql start && \
    mysql -e "CREATE DATABASE mydb;" && \
    mysql -e "CREATE USER 'user'@'%' IDENTIFIED BY 'password';" && \
    mysql -e "GRANT ALL PRIVILEGES ON mydb.* TO 'user'@'%';" && \
    mysql -e "FLUSH PRIVILEGES;"

# Descargar y configurar phpMyAdmin
RUN apt-get install -y phpmyadmin && \
    ln -s /usr/share/phpmyadmin /usr/local/tomcat/webapps/phpmyadmin

# Exponer los puertos necesarios
EXPOSE 8080 3306

# Comando para iniciar Tomcat y MySQL
CMD service mysql start && catalina.sh run
