# P11_CODE

MedHead met en place une application web de réservation de lits. `EMERGENCY EXPERT SYSTEMS`

## Introduction

Le présent projet est une preuve de concept pour le projet Preuve de concept (l'allocation de lits d'hôpital pour les urgences)


### Spécificités du POC

Les spécificatés du POC (Installation, Build, Tests) sont disponibles dans les READ.md qui leur sont associés.

* Pour l'API : [README.md](https://github.com/gcarcau/P11_CODE/blob/main/api/README.md)
* Pour la WebApp : [README.md](https://github.com/gcarcau/P11_CODE/blob/main/webapp/README.md)

## Technologies

* HTML5/CSS3
* [Boostrap](https://getbootstrap.com/)
* [Angular](https://angular.io/docs)
* [TypeScript](https://www.typescriptlang.org/)
* [Java](https://www.java.com/fr/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [JMeter](https://jmeter.apache.org/)
* [SQL](https://sql.sh/)

## Contribution

Guillaume CARCAU

## Auteurs

Guillaume CARCAU

## WorkFlow

Le WorkFlow utilisé pour se projet est un workflow reposant sur "GitFlow" qui consiste à avoir plusieurs branches de fonctionnalités :
    - Feature : Concerne les branches des features à développer
    - Developpement : Concerne la branche des features en développement
    - Release : Concerne les livraisons des features développés
    - HotFixes : Concerne les corrections de bugs des features développés
    - Main : Concerne la branche principale des fichiers livrés
 
Pour chaque nouvelle fonctionnalité :
* Merci de bien vouloir suivre la méthodologie [GitFlow](https://buildmedia.readthedocs.org/media/pdf/git-flow/latest/git-flow.pdf).


## Pipeline CI/CD

La pipeline CI/CD mise en place est disponible sous l'onglet [Github Actions](https://github.com/gcarcau/P11_CODE/actions)

Deux actions sont effectués lors de __CHAQUE__ push sur la __branche main__:
* Build : Cette pipeline vérifie le bon fonctionnement du build.
* Tests : Cette pipeline vérifie la bonne éxécution des tests (unitaires).
 
Informations complémentaires à GitHub Action :
* Merci de bien vouloir suivre la méthodologie [GitFlow](https://buildmedia.readthedocs.org/media/pdf/git-flow/latest/git-flow.pdf).
