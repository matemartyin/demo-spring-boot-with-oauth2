# Spring Boot with OAuth2
This is a demo Spring Boot application which uses OAuth2 for user authentication.

Current providers:
- Google
- Github

### You can try out the app on Heroku
https://spring-boot-with-oauth-demo.herokuapp.com

### Run the app on your local machine
To run the application you must create an OAuth App on Github and set up a project in the Google API Console to obtain OAuth 2.0 credentials.
Once you've got the client IDs and client secrets, you can run the app with Maven:

`mvn spring-boot:run -Dspring-boot.run.arguments=--GITHUB_CLIENT_ID=<your-client-id>,--GITHUB_CLIENT_SECRET=<your-client-id>,--GOOGLE_CLIENT_ID=<your-client-id>,--GOOGLE_CLIENT_SECRET=<your-client-id>`
