package application.view;


import application.model.Model;

public class BaseView {
    private Model model;

    public void setModel(Model model) {
        this.model = model;
        /**
         * TODO 6d. Faites en sorte que les vues s'abonnent au modèle pour recevoir des changements de pourcentage.
         */
    }

    public Model getModel() {
        return this.model;
    }

    /**
	 * Met à jour la vue en accord avec la valeur du pourcentage donnée en paramètre.
	 * 
	 * @param value La valeur du pourcentage à représenter dans la vue
	 */
    public void update(double value) {
    };

    /**
     * TODO 6c. Implémentez la bonne interface pour que les vues puissent recevoir des événements du modèle.
     */

}
