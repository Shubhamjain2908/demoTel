# demoTel
 A Demo Application which has a database table (Student) has 4 columns (Name, Age, Marks, City).and it shows Top 5 Students in each age groups (10-20, 20-30, 30-60) in each city.

 
# Installation
 Prerequisites:

 - mysql, maven, jdk 8 

# Build

- tweek any properties in the resources/application.properties files. Add database credentials.
- Create a single table name "student.sql"

# Run as
 - mvn clean compile install

# Instructions to run as spring boot project

- Import project in eclipse as existing maven project
- Run as maven project with command "mvn clean compile install"
- Modify application.properties to refer your configuration
- Locate executable JAR file  inside /target folder
- Run command "Java -jar XXX-0.0.1-SNAPSHOT.jar (This will launch inbuilt tomcat container and execute the application)
