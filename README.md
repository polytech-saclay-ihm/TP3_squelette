Programmation Java @ Et3 \
Polytech Paris-Saclay | 2025-26

___

# TP3

Le but de ce TP est de mettre en pratique le pattern [*Modèle - Vue - Contrôleur*](https://developer.mozilla.org/fr/docs/Glossary/MVC). Pour cela, vous construirez une application simple qui permet d'éditer une unique valeur de pourcentage à travers quatre vues :
 - *ConsoleView* affiche un message dans la console à chaque fois que le modèle change.
 - *LabelView* affiche dans un [*Label*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html) l'état actuel du modèle.
 - *PieChartView* affiche un graphique correspondant à l'état actuel du modèle. Cette vue permet également à l'utilisateur de manuellement transformer ce graphique, s'il réalise un clic ou un drag sur celui-ci.
 - *SliderView* actualise la position du curseur d'un slider en accord avec l'état actuel du modèle. Cette vue permet également à l'utilisateur de manipuler directement ce curseur pour mettre à jour le modèle.

<br><div align="center"><img src="images/mvc_app.jpg" width="300"></img></div><br>


## Rappel du pattern MVC :

Le but de ce pattern est d'organiser le code en 3 classes principales distinctes.

- Le modèle contient les données de l'application, et est indépendant de la vue et du modèle.
- La vue gère l'affichage de l'application. Elle peut demander au modèle des informations pour savoir quoi afficher, et peut recevoir du modèle des événements indiquant qu'il a été changé et qu'il faut mettre la vue à jour.
- Le contrôleur contient la majeure partie de la logique de l'application. Il spécifie le comportement de l'application face aux actions de l'utilisateur (il a donc connaissance de la vue), et modifie le modèle et/ou la vue en conséquence.

Cette organisation présente plusieurs intérêts :
- Séparer clairement les responsabilités d'affichage, de données et d'interaction.
- Facilement rajouter des nouvelles vues sur un même modèle.

## Etapes

1. **Mise en place du projet :** Clonez ce projet et configurez votre IDE de la même manière que le TP1, en suivant les instructions sur https://github.com/polytech-saclay-ihm/HowToUseJavaFxWithIDE. Essayez de démarrer l'application pour vérifier qu'une fenêtre apparait.

2. **Compréhension de l'architecture :** Réalisez un diagramme de cette application, illustrant les liens entre les différentes classes et interfaces en vous aidant de la description ci-dessous :

Quelques indications à propos de la structure du projet :
  - un modèle : *Model.java*.
  - quatre vues
    - Une vue sous forme de texte dans la console (*ConsoleView.java*)
    - Une vue sous forme de texte dans l'interface graphique (*LabelView.java* et *percentageLabel.fxml*)
    - Une vue sous forme de slider (*SliderView.java* et *percentageSlider.fxml*)
    - Une vue sous forme de camembert (*PieChartView.java* et *percentagePieChart.fxml*)
  - quatre contrôleurs *ConsoleController.java*, *LabelController.java*, *PieChartController.java*, *SliderController.java* (un par vue)

**ATTENTION :** A l'exception de celle dans la console, chaque vue est faite d'un fichier fxml et du controleur fxml associé. Le contrôleur JavaFX d'un fichier fxml et le contrôleur dans un pattern MVC portent le même nom mais ne désignent pas la même chose. Le contrôleur JavaFX permet de faire le lien entre un fichier fxml et du code Java, alors que le contrôleur MVC décrit la logique de l'application en réponse à des actions de l'utilisateur qui modifient le modèle. Le contrôleur JavaFX correspond donc plutôt du point de vue du pattern MVC à la vue.

3. **Affichage des quatre vues :** Ajoutez les quatre vues *ConsoleView*, *LabelView*, *PieChartView*, *SliderView* à la classe principale (*App.java*).

4. **Dépendance entre Vues, Modèle et Contrôleurs :** Etablissez les liens nécessaires entre chaque composant MVC dans *App.java* (récupérez les vues MVC, connectez les au modèle, et créez les controleurs que vous connectez aux vues et au modèle).

5. **Implémentation du contrôleur :** Implémentez dans le constructeur des contrôleurs *SliderController* et *PieChartController* les événements pour mettre à jour le modèle en réaction quand l'utilisateur manipule les vues.

> PieChartView possède des méthodes pour manipuler le camembert.
> 
Pourquoi n'y a-t-il pas besoin de modifier *ConsoleController* et *LabelController* ?

6. **Les vues peuvent se mettre à jour :**

a. Implémentez la méthode `public void update(double value);` dans chaque vue qui indique comment la vue peut se mettre à jour avec une nouvelle valeur de pourcentage.

b. Modifiez le modèle pour qu'il notifie les percentageValueListeners d'un changement de pourcentage.

c. Identifiez quelle interface les vues doivent implémenter pour pouvoir s'abonner aux changements de pourcentage du modèle, et implémentez les.

d. Lorsqu'un modèle est rajouté à la vue, abonnez la aux changements de pourcentage du modèle.


7. **Affichage correct au lancement de l'application :** A présent, modifiez le pourcentage initial du modèle lorsqu'il est créé dans *Main.java*. Que remarquez-vous en lançant l'application ? Comment corriger ce problème ?