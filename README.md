# Spring Boot Keycloak Example

Simple Spring Boot application which uses Keycloak for authentication and authorization.

Just run `docker-compose up --build` to start two containers, one with Keycloak and one with the application itself.

You have to wait a while till Keycloak starts...

We have two URLs here, `localhost:8000` is public accessible and `localhost:8000/secured` is secured. You will be redirected to Keycloak to authenticate yourself before you're able to access it. You can register an account on demand. That's all.

Due to the fact that both, the client (your browser) and the back end application have to resolve the `keycloak-dev` host you have to add the host name `keycloak-dev` to your `/etc/hosts` on Linux or respective `%windir%\system32\drivers\etc\hosts` on Windows. There are a lot of much more complicated solutions, I like this one ;)
