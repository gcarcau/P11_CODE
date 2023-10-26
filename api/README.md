# Api

Ce projet a été généré avec [SpringBoot](https://spring.io/projects/spring-boot) version 3.1.15.

## Serveur de développement

Exécutez le projet à l'aide de votre IDE préféré, puis rendez-vous sur `http://localhost:3000/`.

## Norme de programmation

Utilisez les répertoires `models`,`repository`,`controller`,`services` pour ajouter des features.

`models` : Modèles des classes java
`repository` : Les repository accèdent à la BDD
`controller` : Les controllers consomment les services
`services` : Les services consomment les reposiroty

## Build

Exécutez `mvn build` pour construire le projet. Les artéfacts de builds seront stocké dans `target/`.

## Exécution des tests unitaires

Exécutez `mvn test` pour exécuter les test unitaire avec [JUnit 5](https://junit.org/junit5/).

## Exécution des tests end-to-end

Exécutez `mvn clean verify -P end-to-end-test` pour démarrer les end-to-end tests.

## Aide approfondie

Documentation de référence (en anglais):
Pour vous renseigner sur les documentations de références veuillez vous rendre dans les liens ci-après :

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#data.sql.jpa-and-spring-data)

Guides : 
Les guides ci-dessous sont illustrés et démontres certains cas pour vous aider (toujours en anglais):

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

