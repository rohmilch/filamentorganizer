package filamentorganizer.controller;

import filamentorganizer.startandgui.MainApp;
import javafx.stage.Stage;

public abstract class AbstractController {

	private MainApp mMainApp;

	private Stage mStage;

	public void setMainApp(MainApp pMainApp) {
		this.mMainApp = pMainApp;
	}

	public MainApp getMainApp() {
		return mMainApp;
	}

	public void setStage(Stage pStage) {
		this.mStage = pStage;
	}

	public Stage getStage() {
		return mStage;
	}

}