# P11_CODE

MedHead met en place une application web de réservation de lits. 

## Introduction

Le présent projet est une preuve de concept pour le projet Preuve de concept (l'allocation de lits d'hôpital pour les urgences)


### Installation

Voici les étapes à suivre pour avoir un environnement de développement et de test opérationnel :


```
Pour installer l'application web vous devez :
1. Installer un éditeur de code (VS Code par exemple) pour projet Angular
2. Installer Angular sur votre poste
3. Installer Eclipse ou tout autre éditeur de code java pour projet Maven / Spring Boot
4. Installez MySQL ou tout autre logiciel de gestion de BDD SQL sur votre poste
5. Téléchargez les fichiers sources "WebApp" pour la partie front-end, et "Api" pour la partie back-end.
```



## Executer les tests

```
Les tests mis en places sont les test unitaires.
Chaque test, test indépendament une fonctionnalité de l'application web
- Chargement de la liste des hôpitaux (back-end et front-end)
- Chargement des spécialisations (back-end et front-end)
- Chargement des demandes (back-end et front-end)
- Recherche d'un hôpital (back-end et front-end)
```


## Déploiement

Voici les étapes à suivre pour déployer en production :

```
Installer ces fichiers code sur un serveur WEB.
Acheter un nom de domaine
Lier le nom de domaine au serveur web
Accéder à l'application web
```

## Technologies :

* HTML5/CSS3
* [Boostrap](https://getbootstrap.com/)
* [Angular] (https://angular.io/docs)
* [Java] (https://www.java.com/fr/)
* [Spring Boot] (https://spring.io/projects/spring-boot)
* [JMeter] (https://jmeter.apache.org/)
* [SQL] (https://sql.sh/)

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
 
    
    Branche "main" (ou "master") :

    La branche "main" représente la branche principale et stable du projet.
    C'est là où les versions de production sont déployées.
    Elle contient le code qui a été testé et validé pour une utilisation en production.

    Branche "develop" :

    La branche "develop" est utilisée pour le développement continu du projet.
    C'est là où toutes les fonctionnalités en cours de développement sont fusionnées.
    Les nouvelles fonctionnalités sont développées sur des branches séparées et fusionnées dans "develop" une fois terminées.

    Branches de fonctionnalités (feature branches) :
 
    Pour chaque nouvelle fonctionnalité ou tâche, une nouvelle branche de fonctionnalité est créée à partir de la branche "develop".
    Ces branches portent généralement le préfixe "feature/" suivi d'un nom descriptif, par exemple "feature/nouvelle-fonctionnalite".
    Le développement de la fonctionnalité est effectué sur cette branche, et une fois terminée, elle est fusionnée dans la branche "develop".
    com

    Branche "release" :

    Lorsqu'une version stable du code est prête à être publiée, une branche "release" est créée à partir de la branche "develop".
    Des tests finaux, des préparatifs pour la publication (comme la génération de documentation) et des corrections de bugs mineurs peuvent être effectués sur cette branche.
    Une fois que la branche "release" est prête, elle est fusionnée à la fois dans la branche "main" et "develop".
    De plus, un tag peut être créé pour marquer la version publiée.

    Branche "hotfix" :

    Si des problèmes critiques sont découverts dans la branche "main" nécessitant une correction immédiate, une branche "hotfix" est créée à partir de la branche "main".
    Le correctif est appliqué sur cette branche, et une fois terminé, il est fusionné à la fois dans la branche "main" et "develop".
    Cette approche permet de corriger rapidement les problèmes critiques sans perturber le flux de développement normal.