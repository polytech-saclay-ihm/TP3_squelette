package application.model;

import application.event.PercentageValueListener;
import java.util.ArrayList;

public class Model {
	private double percentageValue;
	public ArrayList<PercentageValueListener> percentageValueListeners;

	public Model(double initialValue) {
		percentageValueListeners = new ArrayList<>();
		setValue(initialValue);
	}


	/**
	 * Permet d'obtenir la valeur actuelle du pourcentage.
	 * 
	 * @return La valeur actuelle du pourcentage
	 */
	public double getValue() {
		return percentageValue;
	}

	/**
	 * Permet de modifier la valeur actuelle du pourcentage.
	 * 
	 * @param value La nouvelle valeur du pourcentage
	 */
	public void setValue(double value) {
		if (valueIsOK(value)) {
			percentageValue = value;
			/**
			 * TODO 6b.Faites en sorte que les différentes vues reçoivent
			 * un événement de type PercentageValueChangedEvent si l'état
			 * interne du modèle est modifié.
			 */
		} else {
			throw (new IllegalArgumentException(
					"La valeur entrée en paramètre n'est pas un pourcentage compris entre 0 et 1 (value = " + value
							+ ")."));
		}
	}

	/**
	 * Teste si une valeur est un pourcentage compris entre 0 et 1.
	 * 
	 * @param value La valeur a tester
	 * @return "true" si la valeur est comprise entre 0 et 1, "false" sinon
	 */
	public boolean valueIsOK(double value) {
		return ((0.0F <= value) && (value <= 1.0F));
	}
}
