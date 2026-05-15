package application.controller;

import application.model.Model;
import application.view.SliderView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class SliderController {
	private Model model;
	private SliderView view;

    public SliderController(Model model, SliderView sliderView) {
        // Initialisation des attributs du controleur.
        this.model = model;
        this.view = sliderView;

        // Initialisation des gestionnaires d'événements.
		view.slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				/**
			 * TODO 5. La controleur doit mettre à jour le modèle lorsque l'utilisateur interagit avec la vue.
			 */
			}
		});
	}
}
