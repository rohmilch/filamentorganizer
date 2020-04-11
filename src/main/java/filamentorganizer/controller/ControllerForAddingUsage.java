package filamentorganizer.controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import filamentorganizer.logik.FilamentSpool;
import filamentorganizer.logik.Print;
import filamentorganizer.logik.Project;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class ControllerForAddingUsage extends AbstractController implements Initializable {

	private Stage stage = null;

	public void initialize(URL url, ResourceBundle rb) {

	}

	public Print getResult(FilamentSpool pFilament) {
		Project lProject = new Project();
		lProject.setName("TestProjectName");
		Print lBspPrint = new Print(1, 1, "TestNote", lProject, "TestName", pFilament);
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//		long mills = 0;
//		java.util.Date lParse = formatter.parse("12-04-2012");
//		mills = lParse.getTime();

		lBspPrint.setDate(new Date());
		lProject.getListOfPrints().add(lBspPrint);
		return lBspPrint;
	}

}
