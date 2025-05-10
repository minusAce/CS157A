# CS157A Project

## Project Overview
This project is a web application designed for managing cases, evidence, and chain of custody for law enforcement personnel. It includes features for creating, updating, and viewing case information, evidence details, and chain of custody records. The application is built using Java Servlets, JSP, and MySQL.

## Instructions for Setting Up and Running the Project

1. **Install Required Software**:
   - [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (version 8 or higher)
   - [Apache Tomcat](https://tomcat.apache.org/) (version 9.0 or higher)
   - [MySQL Server](https://dev.mysql.com/downloads/mysql/)

2. **Clone the Repository**:
   - Clone this repository to your local machine.

3. **Set Up the Database**:
   - Navigate to the `sql/` directory.
   - Execute the `create_schema.sql` script to create the database schema.
   - Execute the `initialize_data.sql` script to populate the database with initial data.

4. **Compile the Java Code**:
   - Open a terminal and navigate to the project root directory.
   - Run the following command to compile the Java files:
     ```powershell
     javac -cp "C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\*;C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\mysql-connector-j-9.3.0.jar" -d WEB-INF\classes src\dao\*.java src\model\*.java src\servlets\*.java
     ```

5. **Package the Application**:
   - Create a WAR file by running the following command:
     ```powershell
     jar cvf CS157A.war *
     ```

6. **Deploy the Application**:
   - Move the `CS157A.war` file to the `webapps` directory of your Tomcat installation:
     ```powershell
     move CS157A.war "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps" -Force
     ```

7. **Start the Tomcat Server**:
   - Navigate to the `bin` directory of your Tomcat installation and start the server:
     ```powershell
     .\startup.bat
     ```
   - To stop the server, use:
     ```powershell
     .\shutdown.bat
     ```

8. **Access the Application**:
   - Open a web browser and navigate to: [http://localhost:8080/CS157A/](http://localhost:8080/CS157A/)

## Dependencies and Required Software
- Java Development Kit (JDK) 8 or higher
- Apache Tomcat 9.0 or higher
- MySQL Server
- MySQL Connector/J (version 9.3.0)

## Additional Configuration Steps
- Ensure that the MySQL server is running and accessible.
- Update the database connection settings in the Java DAO classes if necessary to match your MySQL configuration.
- Verify that the `mysql-connector-j-9.3.0.jar` file is located in the `lib` directory of your Tomcat installation.
