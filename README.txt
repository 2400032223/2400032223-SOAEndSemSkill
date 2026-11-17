TOURIST TOKEN VALIDATION - STARTER PROJECT

Requirements:
- JDK 17
- STS / Spring Tool Suite
- MySQL Server and MySQL Workbench
- Internet connection for Maven to download dependencies

1. Create the database in MySQL Workbench:
   CREATE DATABASE tourist_db;

2. Open src/main/resources/application.properties.
   Replace YOUR_MYSQL_PASSWORD with your MySQL root password.
   The sample valid token is MY_SECRET_TOKEN.

3. Import into STS:
   File > Import > Maven > Existing Maven Projects
   Select the extracted tourist-token-validation folder.
   Select pom.xml and click Finish.

4. Wait for Maven dependencies to download.
   Right-click the project > Run As > Spring Boot App.

5. Open Swagger UI:
   http://localhost:8080/swagger-ui/index.html

6. Test GET /api/tourists:
   - Add request header named: token
   - Valid value: MY_SECRET_TOKEN
   - Valid token returns 200 OK and the tourist list.
   - Missing/invalid token returns 500 Internal Server Error with:
     {"message":"Unauthorized: The token is invalid"}

7. Add sample records in MySQL Workbench:
   USE tourist_db;
   INSERT INTO tourists (name, email, destination)
   VALUES ('Ravi', 'ravi@example.com', 'Hyderabad'),
          ('Anu', 'anu@example.com', 'Goa');

Then execute GET /api/tourists again in Swagger UI.

NOTE:
- This is a beginner starter project. The Tourist table is created automatically by JPA.
- The entity currently has id, name, email, destination fields. If your lab question
  specifies different tourist fields, they can be adjusted.
- For this lab, invalid token intentionally returns HTTP 500 because that is what
  the stated question requests. In production APIs, 401 is normally appropriate.
