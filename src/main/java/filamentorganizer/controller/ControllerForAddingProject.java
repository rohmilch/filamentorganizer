package filamentorganizer.controller;

import java.net.URL;
import java.util.ResourceBundle;

import filamentorganizer.logik.FilamentSpool;
import filamentorganizer.logik.Print;
import filamentorganizer.logik.Project;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class ControllerForAddingProject extends AbstractController implements Initializable {

	private Stage stage = null;

	public void initialize(URL url, ResourceBundle rb) {

	}

	public Project getResult() {
		Project lProject = new Project();
		lProject.setName("TestProjectName");
		Print lBspPrint = new Print(1, 1, "TestNote", lProject, "TestName", new FilamentSpool());
		lProject.getListOfPrints().add(lBspPrint);
		return lProject;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	private void closeStage() {
		if (stage != null) {
			stage.close();
		}
	}
}
