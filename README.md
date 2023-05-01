
# jwt-auth-impl
Implementation of Rest Api secured with JWT token authorization with user authentication from Postgres database with Spring Data JPA.

### User authentication
Users are stored in postgres database with their roles as a separate table. Setup of users can be done with
```txt
cz/jakvitov/jwtauthimpl/persistence/SetupDatabaseTestUsers.java
```
JWT is obtained by calling an /auth api (as listed below).


## Endpoints

#### Authenticate and get JWT token

```http
  POST /auth
```

#### Greeting for user - required user authority

```http
  GET /user/greet
```

#### Greeting for admin - required admin/user authority

```http
  GET /admin/greet
```



## Running Tests

To run tests, run the following command

```bash
  gradlew :test
```


## Authors

- [@jakvitov](https://www.github.com/jakvitov)



## Licence


[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
