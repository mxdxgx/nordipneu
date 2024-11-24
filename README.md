# NordiPneu

NordiPneu est un projet basé sur Java conçu pour gérer les pneus d'une entreprise de vente de pneus.

## Stack

Le projet utilise les éléments de stack suivants :

- **Java** : Version 17
- **Maven** : Pour la gestion de projet et l'automatisation de la construction
- **JUnit** : Version 5.8.2 pour les tests
- **Lombok** : Version 1.18.24 pour réduire le code boilerplate
- **JaCoCo** : Version 0.8.12 pour la couverture de code

## Installation

Pour installer NordiPneu, suivez ces étapes :

1. Clonez le dépôt :
    ```bash
    git clone https://github.com/mxdxgx/nordipneu.git
    ```
2. Naviguez vers le répertoire du projet :
    ```bash
    cd nordipneu
    ```
3. Construisez le projet en utilisant Maven :
    ```bash
    mvn clean install
    ```

## Utilisation

Pour exécuter NordiPneu, utilisez la commande suivante :

```bash
mvn exec:java -Dexec.mainClass=org.example.App
"
