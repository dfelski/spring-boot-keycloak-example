# Spring Boot Keycloak Example

Simple Spring Boot application which uses Keycloak for authentication and authorization.

Just run `docker-compose up --build` to start two containers, one with Keycloak and one with the application itself.

You have to wait a while till Keycloak starts...

We have two URLs here, `localhost:9000` is public accessible and `localhost:9000/secured` is secured. You will be redirected to Keycloak to authenticate yourself before you're able to access it. You can register an account on demand. That's all.
