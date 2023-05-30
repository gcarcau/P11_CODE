# P11_CODE

Application web de réservation de lits. 

## Introduction

Le présent projet est une preuve de concept pour le projet Preuve de concept (l'allocation de lits d'hôpital pour les urgences)


### Installation

Voici les étapes à suivre pour avoir un environnement de développement et de test opérationnel :


```
Explications de l'installation
```



## Executer les tests

```
Explication des tests
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
* Angular
* Java
* Spring

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

Branche "release" :

Lorsqu'une version stable du code est prête à être publiée, une branche "release" est créée à partir de la branche "develop".
Des tests finaux, des préparatifs pour la publication (comme la génération de documentation) et des corrections de bugs mineurs peuvent être effectués sur cette branche.
Une fois que la branche "release" est prête, elle est fusionnée à la fois dans la branche "main" et "develop".
De plus, un tag peut être créé pour marquer la version publiée.

Branche "hotfix" :

Si des problèmes critiques sont découverts dans la branche "main" nécessitant une correction immédiate, une branche "hotfix" est créée à partir de la branche "main".
Le correctif est appliqué sur cette branche, et une fois terminé, il est fusionné à la fois dans la branche "main" et "develop".
Cette approche permet de corriger rapidement les problèmes critiques sans perturber le flux de développement normal.