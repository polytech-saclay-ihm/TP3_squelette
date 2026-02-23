package application.controller;

import application.event.PercentageValueListener;
import application.model.Model;

public class Controller implements ControllerInterface {
	private final Model model;

	public Controller(Model model) {
		this.model = model;
	}

	@Override
	public double getValue() {
		/**
		 * TODO 4. Complétez la classe Controller pour qu'elle fasse
		 * le lien entre le modèle et les vues.
		 */
		return 0.0d;
	}

	@Override
	public void setValue(double value) {
		/**
		 * TODO 4. Complétez la classe Controller pour qu'elle fasse
		 * le lien entre le modèle et les vues.
		 */
	}

	@Override
	public void addPercentageValueListener(PercentageValueListener percentageValueListener) {
		/**
		 * TODO 4. Complétez la classe Controller pour qu'elle fasse
		 * le lien entre le modèle et les vues.
		 */
	}

	@Override
	public void removePercentageValueListener(PercentageValueListener percentageValueListener) {
		/**
		 * TODO 4. Complétez la classe Controller pour qu'elle fasse
		 * le lien entre le modèle et les vues.
		 */
	}
}
