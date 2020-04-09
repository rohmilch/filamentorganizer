package filamentorganizer.controller;

import filamentorganizer.startandgui.MainApp;

public abstract class AbstractController {

	public MainApp mMainApp;

	public void setMainApp(MainApp pMainApp) {
		this.mMainApp = pMainApp;

	}

}