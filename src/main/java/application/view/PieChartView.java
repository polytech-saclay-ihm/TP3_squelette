package application.view;

import application.model.Model;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class PieChartView extends BaseView {
    @FXML
    public Canvas pieChart;

	private GraphicsContext graphicsContext;

    @FXML
    public void initialize() {
        this.graphicsContext = pieChart.getGraphicsContext2D();
    }

	public void update(double value) {
		/**
		 * TODO 6a. Faites en sorte que les différentes vues aient
		 * chacune une méthode permettant de la mettre à jour.
		 */
	}

    /*
    Etant donné une valeur de pourcentage,dessine le camembert correspondant sur le canvas.
    
    *@param value : la valeur du pourcentage à dessiner, entre 0 et 1.
    */
	public void drawPieChart(double value) {
		// On détermine le centre de la figure
		double centerX = pieChart.getWidth() / 2;
		double centerY = pieChart.getHeight() / 2;

		// On détermine le rayon du cercle
		double radius = Math.min(pieChart.getWidth(), pieChart.getHeight()) / 2;

		// On calcule l'angle correspondant au pourcentage
		double angle = value * 2 * Math.PI;

		// On crée deux cercles imbriqués, dont l'un est coupé en fonction du
		// pourcentage
		graphicsContext.setFill(Color.GRAY);
		graphicsContext.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
		graphicsContext.setFill(Color.LIGHTBLUE);
		graphicsContext.fillArc(centerX - radius, centerY - radius, radius * 2, radius * 2, 0,
				(double) Math.toDegrees(angle), ArcType.ROUND);
	}

    /*
     * Vérifie si un événement de souris se trouve dans le camembert.
     *
     * @param event L'événement de souris à vérifier
     */
	public boolean inPieChart(MouseEvent event) {
		double mouseX = event.getX();
		double mouseY = event.getY();
		double centerX = pieChart.getWidth() / 2;
		double centerY = pieChart.getHeight() / 2;
		double radius = Math.min(pieChart.getWidth() - 4, pieChart.getHeight() - 4) / 2;

		double distanceCenterMouse = Math.sqrt(Math.pow((centerX - mouseX), 2) + Math.pow((centerY - mouseY), 2));

		if (distanceCenterMouse <= radius) {
			return true;
		} else {
			return false;
		}
	}

    /*
     * Calcule le pourcentage correspondant à la position d'un événement de souris sur le camembert.
     *
     * @param event L'événement de souris à convertir
     * @return La valeur de pourcentage correspondante
     */
	public double pointToPercentage(MouseEvent event) {
		double centerX = pieChart.getWidth() / 2;
		double centerY = pieChart.getHeight() / 2;
		double mouseX = event.getX();
		double mouseY = event.getY();

		// On calcule les points de l'angle formé
		double[] pointA = new double[] { mouseX - centerX, mouseY - centerY };
		double[] pointB = new double[] { 0, 0 };
		double[] pointC = new double[] { 10, 0 };

		// On calcule les distances entre ces points
		double distanceAB = Math.sqrt(Math.pow((pointA[0] - pointB[0]), 2) + Math.pow((pointA[1] - pointB[1]), 2));
		double distanceBC = Math.sqrt(Math.pow((pointB[0] - pointC[0]), 2) + Math.pow((pointB[1] - pointC[1]), 2));
		double distanceCA = Math.sqrt(Math.pow((pointC[0] - pointA[0]), 2) + Math.pow((pointC[1] - pointA[1]), 2));

		// On calcule l'angle ABC
		// Théorème d'Al-Kaski :
		// distanceCA * distanceCA = distanceAB * distanceAB + distanceBC * distanceBC -
		// 2d * distanceAB * distanceBC * Math.Cos(angleABC);
		// 0 = distanceAB * distanceAB + distanceBC * distanceBC - 2d * distanceAB *
		// distanceBC * Math.Cos(angleABC) - distanceCA * distanceCA;
		// 2d * distanceAB * distanceBC * Math.Cos(angleABC) = distanceAB * distanceAB +
		// distanceBC * distanceBC - distanceCA * distanceCA;
		// Math.Cos(angleABC) = (distanceAB * distanceAB + distanceBC * distanceBC -
		// distanceCA * distanceCA) / (2d * distanceAB * distanceBC);
		double angleABC = Math.acos((distanceAB * distanceAB + distanceBC * distanceBC - distanceCA * distanceCA)
				/ (2 * distanceAB * distanceBC));

		if (pointA[1] >= 0) {
			angleABC = 2 * Math.PI - angleABC;
			return angleABC / (2 * Math.PI);
		} else {
			return angleABC / (2 * Math.PI);
		}
	}
}
