package application.event;

public interface PercentageValueListener {
	/**
	 * Réagit à un changement de la valeur du pourcentage dans le modèle.
	 * 
	 * @param event l'évenement correspondant à ce changement
	 */
	public void onPercentageValueChanged(double newValue);
}
