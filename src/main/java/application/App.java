package application;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import application.controller.ConsoleController;
import application.controller.LabelController;
import application.controller.PieChartController;
import application.controller.SliderController;
import application.model.Model;
import application.view.ConsoleView;
import application.view.LabelView;
import application.view.PieChartView;
import application.view.SliderView;

public class App {
	Model model;

	LabelView labelView;
	PieChartView pieChartView;
	SliderView sliderView;
	ConsoleView consoleView;

	LabelController labelController;
	SliderController sliderController;
	PieChartController pieChartController;
	ConsoleController consoleController;

	Node labelViewRoot;
	Node sliderViewRoot;
	Node pieChartViewRoot;

	Parent root;

	public App(Model model) throws Exception {
		// On crée le modèle
		this.model = model;

		// On crée les vues
		FXMLLoader loaderLabel = new FXMLLoader(getClass().getResource("percentageLabel.fxml"));
        FXMLLoader loaderSlider = new FXMLLoader(getClass().getResource("percentageSlider.fxml"));
        FXMLLoader loaderPieChart = new FXMLLoader(getClass().getResource("percentagePiechart.fxml"));

		labelViewRoot = loaderLabel.load();
		sliderViewRoot = loaderSlider.load();
		pieChartViewRoot = loaderPieChart.load();

		/*
		TODO 3a : Obtenez ou créez les vues à partir des loaders avec leur méthode getController.
		*/

		/*
		TODO 3b : Connecter les vues au modèles.
		*/

        /*
		TODO 3c : Créez les contrôleurs pour chaque vue et liez les au modèle.
		*/

		initialiserUI();
	}

	/**
	 * Initialise l'interface utilisateur (UI) de l'application.
	 */
	private void initialiserUI() {
		VBox root = new VBox();
		this.root = root;

		Label label = new Label("Percentage: ");
		labelViewRoot.setDisable(true);

		// On crée un sous-Pane pour le label et sa valeur (labelView)
		HBox northPanel = new HBox();
		northPanel.getChildren().addAll(label, labelViewRoot);

		// On définit l'espacement entre les différents éléments du Pane
		root.setSpacing(30);
		VBox.setMargin(root, new Insets(15, 15, 15, 15));
		root.setAlignment(Pos.CENTER);

		// On ajoute tous les éléments au Pane
		root.getChildren().addAll(northPanel, pieChartViewRoot, sliderViewRoot);

		// On rend la fenêtre visible
		root.setVisible(true);
	}
}
