### Documentation

###  Comprendre les concepts fondamentaux

1) Qu'est-ce que l'AOP 🧩 ?

 L’AOP (Aspect-Oriented Programming) permet d’écrire du code qui s’exécute avant, après ou autour d’une méthode, sans avoir à modifier directement cette méthode.

🎯 Cela est particulièrement utile pour gérer des préoccupations transverses comme :

* les logs 
* la sécurité
* les transactions 

Spring Boot prend en charge l'AOP via Spring AOP, qui utilise des annotations et des proxys dynamiques.

2) Qu’est-ce qu’un Aspect 🔍 ?

Un aspect est un module qui regroupe un comportement transversal, c’est-à-dire un comportement qui s’applique à plusieurs endroits dans le code, mais qui n’est pas lié au cœur métier.

3) Qu’est-ce qu’un Proxy 🧱 ?

Un proxy est un objet intermédiaire entre le code appelant (le client 🧑‍💻) et l’objet cible réel (le service métier 🎯). Il intercepte les appels de méthodes pour y insérer des logiques transverses.

###  Fonctionnalités


* Audit automatique — Suivi automatique des événements de création et de modification sur vos entités.

* Log du temps d’exécution — Journalise le temps d’exécution des méthodes.

* Mécanisme de Retry via annotation — Relance automatique des opérations échouées avec des paramètres personnalisables.


###  Comment utiliser check-common-lib (setup)

📦 Installation Maven
Ajoutez la dépendance suivante à votre pom.xml :

<dependency>
<groupId>com.aop</groupId>
<artifactId>check-common-lib</artifactId>
<version>1.0.0</version>
</dependency>

⚙️ Configuration
Ajoutez la configuration suivante dans votre fichier application.yml :

check-common:
audit-enabled: true              
log-execution-time: true          
retry:                           
enabled: true
default-max-attempts: 3
default-delay-ms: 500
