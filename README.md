# Spring Boot Security 
Implements JWT based authentication and authorization in Spring Boot application.

Uses the [jjwts](https://github.com/jwtk/jjwt) library for implementation

## Usage

Use [Postman](https://www.getpostman.com
) for sending beautiful requests easily. (For Testing purposes only)

Hit the endpoint **http://localhost:8080/api/auth/signin**, with **POST** and the following *Request Body*
```JSON
{
    "username" : "your_username",
    "password" : "your_password"
}
```

It will return a *Response* with the following json object on success
```JSON
{
    "token" : "Unique_JWT_Token",
    "tokenType" : "Bearer"
}
```
On failure i.e. incorrect username password it will return 
```JSON
{
    "timestamp": "2019-10-01T19:29:57.233+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Bad credentials",
    "path": "/api/auth/signin"
}
```

Use the value in token in every Request you send for accessing resources in the header with the key **"Authorization"**.

**Example**
```JSON
    "Authorization" : "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
```
Now access protected resources like GET **http://localhost:8080/api/auth/hello**. On success will generate the output.
```JSON
Hello
```
If access token is invalid for any reason, (expired, invalid signature, etc) then following response is given
```JSON
{
    "timestamp": "2019-10-01T19:33:29.399+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Full authentication is required to access this resource",
    "path": "/api/auth/hello"
}
``` 

Major referred document (Includes why and what is used):- https://www.callicoder.com/spring-boot-spring-security-jwt-mysql-react-app-part-2/

What's what :- https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/

Watch YouTube videos too, for better understanding.

Search terms :-  *Spring Boot JWT Authentication* , *Spring Boot JWT* , *Spring Boot Security token based*

## References :-
1. https://github.com/jwtk/jjwt
2. https://jwt.io/
3. https://medium.com/better-programming/secure-a-spring-boot-rest-api-with-json-web-token-reference-to-angular-integration-e57a25806c50
4. https://www.javadevjournal.com/spring/securing-a-restful-web-service-with-spring-security/
5. https://stackoverflow.com/questions/48386407/json-web-token-jwt-authorization-vs-authentication
6. https://auth0.com/docs/jwt
7. https://stackoverflow.com/questions/39909419/what-are-the-main-differences-between-jwt-and-oauth-authentication
