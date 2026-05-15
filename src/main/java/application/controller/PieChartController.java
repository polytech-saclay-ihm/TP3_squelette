package application.controller;

import application.model.Model;
import application.view.PieChartView;
import javafx.scene.input.MouseEvent;

public class PieChartController {
	private Model model;
	private PieChartView view;
	private boolean clickedInPieChart;

    public PieChartController(Model model, PieChartView pieChartView) {
        // Initialisation des attributs du controleur.
        this.model = model;
        this.view = pieChartView;
        this.clickedInPieChart = false;

        // Initialisation des gestionnaires d'événements.
		view.pieChart.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			/**
			 * TODO 5. La controleur doit mettre à jour le modèle lorsque l'utilisateur interagit avec la vue.
			 */
		});

		view.pieChart.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
			/**
			 * TODO 5. La controleur doit mettre à jour le modèle lorsque l'utilisateur interagit avec la vue.
			 */
		});

		view.pieChart.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
			/**
			 * TODO 5. La controleur doit mettre à jour le modèle lorsque l'utilisateur interagit avec la vue.
			 */
		});
	}
}
