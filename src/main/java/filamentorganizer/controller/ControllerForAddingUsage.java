package filamentorganizer.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import filamentorganizer.data.DatabaseConnection;
import filamentorganizer.general.ConstantsAndGeneralMethods;
import filamentorganizer.logik.FilamentSpool;
import filamentorganizer.logik.Print;
import filamentorganizer.logik.Project;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.IntegerStringConverter;

public class ControllerForAddingUsage extends AbstractController implements Initializable {

	@FXML
	private Button mOKButton;
	@FXML
	private Button mCancelButton;
	@FXML
	private Label PUNewPrintLaengeName;
	@FXML
	private Label PUNewPrintGewichtName;
	@FXML
	private TextField PUNewPrintDauerWert;
	@FXML
	private TextField PUNewPrintNameWert;
	@FXML
	private ComboBox<FilamentSpool> PUNewPrintFilamentWert;
	@FXML
	private ComboBox<Project> PUNewPrintProjektWert;
	@FXML
	private TextField PUNewPrintLaengeGewichtWert;
	@FXML
	private TextField PUNewPrintNotizWert;
	@FXML
	private Slider PUAddUsageToggleL0G1;
//	@FXML
//	private TextField PUNewPrintDatumWert;

	public void initialize(URL url, ResourceBundle rb) {
		List<FilamentSpool> lFilamentListFromDatabase = DatabaseConnection.getFilamentListFromDatabase();
		PUNewPrintFilamentWert.setItems(FXCollections.observableArrayList(lFilamentListFromDatabase));
		PUNewPrintProjektWert
				.setItems(FXCollections.observableArrayList(DatabaseConnection.getProjectListFromDatabase()));
		initListener();
		formatToOnlyNumericTextFields();
	}

	private void formatToOnlyNumericTextFields() {
		PUNewPrintLaengeGewichtWert.setTextFormatter(new TextFormatter(new IntegerStringConverter()));
		PUNewPrintDauerWert.setTextFormatter(new TextFormatter(new IntegerStringConverter()));
	}

	private void initListener() {
//Listener erstellen um auzugrauen wenn anderes durch slider gewählt
		mOKButton.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event pEvent) {
				if (!(PUNewPrintNameWert.getText().isEmpty() && PUNewPrintLaengeGewichtWert.getText().isEmpty())
						&& PUNewPrintFilamentWert.getSelectionModel().getSelectedIndex() != -1) {
					Print lNewPrint = new Print();
					FilamentSpool lSelectedFilament = PUNewPrintFilamentWert.getSelectionModel().getSelectedItem();
					lNewPrint.setFilament(lSelectedFilament);
					Project lSelectedProjekt = PUNewPrintProjektWert.getSelectionModel().getSelectedItem();
					lNewPrint.setProject(lSelectedProjekt);

					lNewPrint.setNamePrint(PUNewPrintNameWert.getText());
					lNewPrint.setNote(PUNewPrintNotizWert.getText());

					if (PUNewPrintDauerWert.getText() != null && !PUNewPrintDauerWert.getText().isEmpty()) {
						lNewPrint.setDuration(Integer.parseInt(PUNewPrintDauerWert.getText()));
					}
					int lWeigthOrLength = Integer.parseInt(PUNewPrintLaengeGewichtWert.getText());
					fillLengthWeigthAndPriceOfPrint(lNewPrint, lWeigthOrLength, PUAddUsageToggleL0G1.getValue());

					lNewPrint.setDate(System.currentTimeMillis());
					DatabaseConnection.addPrintToDatabaseAndUpdateFilamentAndProject(lNewPrint);
					getStage().close();
				} else {
//					 popup für Fehlerhinweis
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

	private void fillLengthWeigthAndPriceOfPrint(Print lNewPrint, double pLengthWeigth, double pToggleValue) {

		FilamentSpool lSelectedFilament = lNewPrint.getFilament();
		double lCurrentWeight = lSelectedFilament.getCurrentWeight();
		double lCurrentLength = lSelectedFilament.getCurrentLength();
		double lDensityFilament = lSelectedFilament.getMaterial().getDensity();

		double lPrintLength;
		double lPrintWeigth;
		if (pToggleValue == 0) {
			// then toggle to length
			lPrintLength = pLengthWeigth;
			lPrintWeigth = ConstantsAndGeneralMethods.calculateWeigthByLength(lNewPrint.getLength(),
					lSelectedFilament.getDiameter(), lDensityFilament);

		} else {
			/// then toggle to weigth
			lPrintWeigth = pLengthWeigth;
			lPrintLength = ConstantsAndGeneralMethods.calculateLengthByWeight(lNewPrint.getWeight(),
					lSelectedFilament.getDiameter(), lDensityFilament);
		}

		lNewPrint.setLength(lPrintLength);
		lNewPrint.setWeight(lPrintWeigth);

		double lPricePerOneGramm = lSelectedFilament.getPrice() / lSelectedFilament.getOriginalWeight();
		double lPrintPrice = lPricePerOneGramm * lPrintWeigth;
		lNewPrint.setPrice(lPrintPrice);

		lCurrentWeight = lCurrentWeight - lPrintWeigth;
		lCurrentLength = lCurrentLength - lPrintLength;
		lNewPrint.getFilament().setCurrentLength(lCurrentLength);
		lNewPrint.getFilament().setCurrentWeight(lCurrentWeight);

	}

}
