//MYSQL TABLE
CREATE TABLE EMPLOYEE(
    id INT NOT NULL auto_increment, 
    name VARCHAR(50) NOT NULL,
    joining_date DATE NOT NULL,
    salary DOUBLE NOT NULL,
    ssn VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

//ORACLE TABLE
CREATE TABLE EMPLOYEE(
    id INTEGER NOT NULL, 
    name VARCHAR2(50) NOT NULL,
    joining_date DATE NOT NULL,
    salary FLOAT NOT NULL,
    ssn VARCHAR2(30) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

//To install your Oracle jdbc driver, issue following command
mvn install:install-file -Dfile=C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar

//use in pom.xml
<!-- ORACLE database driver -->
		<dependency>
			<groupId>com.oracle</groupId>
			<artifactId>ojdbc6</artifactId>
			<version>11.2.0</version>
		</dependency>
		
		
//sample request
{
"id": 2,
"name": "Muni swamy",
"joiningDate": "3910-11-10",
"salary": 10000,
"ssn": "ssn00000001"
}