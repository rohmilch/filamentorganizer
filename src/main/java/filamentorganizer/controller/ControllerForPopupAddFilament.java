package filamentorganizer.controller;

import java.net.URL;
import java.util.ResourceBundle;

import filamentorganizer.logik.FilamentSpool;
import filamentorganizer.logik.Material;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class ControllerForPopupAddFilament extends AbstractController implements Initializable {

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

	public FilamentSpool getResult() {
		FilamentSpool lBspFilament = new FilamentSpool(100, 100, "gruen", "Button", "Beispiel", Material.PLA, 1.75, 20,
				200, 200);
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
