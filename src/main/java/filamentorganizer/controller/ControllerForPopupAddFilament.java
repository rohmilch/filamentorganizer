package filamentorganizer.controller;

import java.net.URL;
import java.util.ResourceBundle;

import filamentorganizer.data.DatabaseConnection;
import filamentorganizer.logik.FilamentSpool;
import filamentorganizer.logik.Material;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ControllerForPopupAddFilament extends AbstractController implements Initializable {

	@FXML
	private Button mOKButton;
	@FXML
	private Button mCancelButton;
	@FXML
	private TextField PUNewFilaFarbeWert;
	@FXML
	private TextField PUNewFilaGewichtWert;
//	@FXML
//	private TextField PUNewFilaDichteWert;
	@FXML
	private TextField PUNewFilaNameWert;
	@FXML
	private TextField PUNewFilaNozTempWert;
	@FXML
	private TextField PUNewFilaPreisWert;
	@FXML
	private ChoiceBox PUNewFilaMaterialWert;
	@FXML
	private TextField PUNewFilaHerstellerWert;
	@FXML
	private TextField PUNewFilaDurchmWert;
	@FXML
	private TextField PUNewFilaLaengWert;
	@FXML
	private TextField PUNewFilaBedTempWert;
//	@FXML
//	private TextField PUNewFilaShopWert;

	public void initialize(URL url, ResourceBundle rb) {
		PUNewFilaMaterialWert.setItems(FXCollections.observableArrayList(Material.getValues()));
		initButtonListener();
	}

	private void initButtonListener() {
		mOKButton.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event pEvent) {
				FilamentSpool lNewSpool = new FilamentSpool();
				lNewSpool.setName(PUNewFilaNameWert.getText());
				lNewSpool.setColour(PUNewFilaFarbeWert.getText());
				lNewSpool.setManufacturer(PUNewFilaHerstellerWert.getText());
				lNewSpool.setIdealNoozleTemp(Integer.parseInt(PUNewFilaNozTempWert.getText()));
				lNewSpool.setIdealBedTemp(Integer.parseInt(PUNewFilaBedTempWert.getText()));
				lNewSpool.setWeigth(Integer.parseInt(PUNewFilaGewichtWert.getText()));
				lNewSpool.setPrice(Integer.parseInt(PUNewFilaPreisWert.getText()));
				lNewSpool.setDiameter(Integer.parseInt(PUNewFilaDurchmWert.getText()));
				lNewSpool.setLength(Integer.parseInt(PUNewFilaLaengWert.getText()));
				lNewSpool.setMaterial((Material) PUNewFilaMaterialWert.getSelectionModel().getSelectedItem());
//				lNewSpool.set--(Integer.parseInt(PUNewFilaDichteWert.getText()));
				DatabaseConnection.addFilamentToDatabase(lNewSpool);
				getStage().close();
			}
		});
		mCancelButton.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event pEvent) {
				getStage().close();
			}
		});

	}

}
