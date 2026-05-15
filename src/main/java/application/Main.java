package application;

import application.model.Model;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
        //On crée le modèle (MVC)
        Model modele = new Model(0.4);

        App app = new App(modele);

        primaryStage.setTitle("Model - View - Controller");
		primaryStage.setScene(new Scene(app.root, 300, 250));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
