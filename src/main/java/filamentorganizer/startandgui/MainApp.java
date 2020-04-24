package filamentorganizer.startandgui;

import filamentorganizer.controller.Controller;
import filamentorganizer.general.ConstantsAndGeneralMethods;
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

		FXMLLoader lParent = new FXMLLoader(getClass().getResource(ConstantsAndGeneralMethods.FXML_MAIN));
		Parent lLoadedMainWindow = lParent.load();
		Controller lController = lParent.getController();
		lController.setMainApp(this);

		pPrimaryStage.setTitle("FilamentOrga");
		Scene lScene = new Scene(lLoadedMainWindow, 640, 480);
		pPrimaryStage.setScene(lScene);
		pPrimaryStage.show();
	}

	public Stage getPrimaryStage() {
		return mPrimaryStage;
	}
}
