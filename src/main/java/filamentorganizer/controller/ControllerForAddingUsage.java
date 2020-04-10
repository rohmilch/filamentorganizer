package filamentorganizer.controller;

import java.net.URL;
import java.util.ResourceBundle;

import filamentorganizer.logik.FilamentSpool;
import filamentorganizer.logik.Print;
import filamentorganizer.logik.Project;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class ControllerForAddingUsage extends AbstractController implements Initializable {

//	@FXML
//	private TextField usernameTF;
//	@FXML
//	private PasswordField passwordPF;
//	@FXML
//	private Button connectBtn;
	private Stage stage = null;
//	private HashMap<String, Object> result = new HashMap<String, Object>();

	public void initialize(URL url, ResourceBundle rb) {
//		connectBtn.setOnAction((event) -> {
//			result.clear();
//			result.put("username", usernameTF.getText());
//			result.put("password", passwordPF.getText());
//			closeStage();
//		});

	}

	public Print getResult(FilamentSpool pFilament) {
		Print lBspFilament = new Print(1, 1, "TestNote", new Project(), "TestName", pFilament);
		return lBspFilament;
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
