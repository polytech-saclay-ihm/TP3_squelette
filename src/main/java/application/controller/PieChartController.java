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
			if (view.inPieChart(event)) {
				clickedInPieChart = true;
				/**
				 * TODO 5. La controleur doit mettre à jour le modèle lorsque l'utilisateur interagit avec la vue.
				 */
			}
			
		});

		view.pieChart.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
			if (clickedInPieChart) {
			/**
			 * TODO 5. La controleur doit mettre à jour le modèle lorsque l'utilisateur interagit avec la vue.
			 */
			}
		});

		view.pieChart.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
			if (clickedInPieChart) {
				clickedInPieChart = false;
			}
		});
	}
}
