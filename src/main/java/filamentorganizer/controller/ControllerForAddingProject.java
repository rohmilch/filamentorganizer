package filamentorganizer.controller;

import java.net.URL;
import java.util.ResourceBundle;

import filamentorganizer.data.DatabaseConnection;
import filamentorganizer.logik.Project;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerForAddingProject extends AbstractController implements Initializable {

	@FXML
	private Button mOKButton;
	@FXML
	private Button mCancelButton;

	@FXML
	private TextField PUNewProjNameWert;
	@FXML
	private TextField PUNewProjNoteWert;

	public void initialize(URL url, ResourceBundle rb) {
		initListener();

	}

	private void initListener() {
		mOKButton.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event pEvent) {
				if (!(PUNewProjNameWert.getText().isEmpty())) {
					Project lProject = new Project();
					lProject.setNameProject(PUNewProjNameWert.getText());
					lProject.setNameProject(PUNewProjNoteWert.getText());
					DatabaseConnection.addProjectToDatabase(lProject);
					getStage().close();
				} else {
//							 popup für Fehlerhinweis
//							Stage dialog = new Stage();
//							dialog.initOwner(getStage());
//							dialog.initModality(Modality.APPLICATION_MODAL);
//							dialog.showAndWait();
				}
			}
		});

		mCancelButton.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event pEvent) {
				getStage().close();
			}

		});

	}
}
