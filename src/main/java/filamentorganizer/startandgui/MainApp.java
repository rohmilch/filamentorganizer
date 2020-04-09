package filamentorganizer.startandgui;

import filamentorganizer.controller.Controller;
import filamentorganizer.general.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage mPrimaryStage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage pPrimaryStage) throws Exception {
		mPrimaryStage = pPrimaryStage;

		FXMLLoader lParent = new FXMLLoader(getClass().getResource(Constants.FXML_MAIN));
		Parent lLoadedMainWindow = lParent.load();
		Controller lController = lParent.getController();
		lController.setMainApp(this);

		// Für Beispiel Filament
//		FilamentSpool lBspFilament = new FilamentSpool(100, 100, "gruen", "Beispiel", "Beispiel", Material.PLA, 1.75,
//				20, 200, 200);
//		DatabaseConnection.createFilament(lBspFilament);
		pPrimaryStage.setTitle("FilamentOrga");
		Scene lScene = new Scene(lLoadedMainWindow, 640, 480);
		pPrimaryStage.setScene(lScene);
		pPrimaryStage.show();
	}

	public Stage getPrimaryStage() {
		return mPrimaryStage;
	}
}
