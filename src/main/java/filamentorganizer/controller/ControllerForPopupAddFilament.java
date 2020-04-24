package filamentorganizer.controller;

import java.net.URL;
import java.util.ResourceBundle;

import filamentorganizer.data.DatabaseConnection;
import filamentorganizer.general.ConstantsAndGeneralMethods;
import filamentorganizer.logik.FilamentSpool;
import filamentorganizer.logik.Material;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class ControllerForPopupAddFilament extends AbstractController implements Initializable {

	@FXML
	private Button mOKButton;
	@FXML
	private Button mCancelButton;
	@FXML
	private TextField PUNewFilaFarbeWert;
	@FXML
	private TextField PUNewFilaGewichtWert;
	@FXML
	private TextField PUNewFilaNameWert;
	@FXML
	private TextField PUNewFilaNozTempWert;
	@FXML
	private TextField PUNewFilaPreisWert;
	@FXML
	private ComboBox<Material> PUNewFilaMaterialWert;
	@FXML
	private TextField PUNewFilaHerstellerWert;
	@FXML
	private TextField PUNewFilaDurchmWert;
	@FXML
	private TextField PUNewFilaBedTempWert;
//	@FXML
//	private TextField PUNewFilaShopWert;

	public void initialize(URL url, ResourceBundle rb) {
		PUNewFilaMaterialWert.setItems(FXCollections.observableArrayList(Material.getValues()));
		initButtonListener();
		formatToOnlyNumericTextFields();
		PUNewFilaDurchmWert.setText("1.75");
		PUNewFilaMaterialWert.getSelectionModel().select(Material.PLA);
	}

	private void formatToOnlyNumericTextFields() {
		PUNewFilaGewichtWert.setTextFormatter(new TextFormatter(new IntegerStringConverter()));
		PUNewFilaNozTempWert.setTextFormatter(new TextFormatter(new IntegerStringConverter()));
		PUNewFilaPreisWert.setTextFormatter(new TextFormatter(new DoubleStringConverter()));
		PUNewFilaDurchmWert.setTextFormatter(new TextFormatter(new DoubleStringConverter()));
		PUNewFilaBedTempWert.setTextFormatter(new TextFormatter(new IntegerStringConverter()));

	}

	private void initButtonListener() {
		mOKButton.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event pEvent) {
				if (!(PUNewFilaNameWert.getText().isEmpty() && PUNewFilaFarbeWert.getText().isEmpty()
						&& PUNewFilaGewichtWert.getText().isEmpty() && PUNewFilaPreisWert.getText().isEmpty())) {
					FilamentSpool lNewSpool = new FilamentSpool();
					lNewSpool.setName(PUNewFilaNameWert.getText());
					lNewSpool.setColour(PUNewFilaFarbeWert.getText());
					lNewSpool.setManufacturer(PUNewFilaHerstellerWert.getText());
					lNewSpool.setIdealNoozleTemp(Integer.parseInt(PUNewFilaNozTempWert.getText()));
					lNewSpool.setIdealBedTemp(Integer.parseInt(PUNewFilaBedTempWert.getText()));
					double lWeigth = Integer.parseInt(PUNewFilaGewichtWert.getText());
					lNewSpool.setOriginalWeight(lWeigth);
					lNewSpool.setCurrentWeight(lWeigth);
					lNewSpool.setPrice(Double.parseDouble(PUNewFilaPreisWert.getText()));
					double lDiameter = Double.parseDouble(PUNewFilaDurchmWert.getText());
					lNewSpool.setDiameter(lDiameter);
					Material lMaterial = (Material) PUNewFilaMaterialWert.getSelectionModel().getSelectedItem();

					double lLengthMeter = ConstantsAndGeneralMethods.calculateLengthByWeight(lWeigth, lDiameter, lMaterial.getDensity());

					lNewSpool.setOriginalLength(lLengthMeter);
					lNewSpool.setCurrentLength(lLengthMeter);
					lNewSpool.setMaterial(lMaterial);
//				lNewSpool.set--(Integer.parseInt(PUNewFilaDichteWert.getText()));
					DatabaseConnection.addFilamentToDatabase(lNewSpool);
					getStage().close();
				} else {
					// popup für Fehlerhinweis
//					Stage dialog = new Stage();
//					dialog.initOwner(getStage());
//					dialog.initModality(Modality.APPLICATION_MODAL);
//					dialog.showAndWait();
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
