package filamentorganizer.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import filamentorganizer.data.DatabaseConnection;
import filamentorganizer.general.Constants;
import filamentorganizer.logik.FilamentSpool;
import filamentorganizer.logik.Print;
import filamentorganizer.logik.Project;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller extends AbstractController implements Initializable {

	@FXML
	private TableView<FilamentSpool> mTableViewShelf;

	private TableColumn<FilamentSpool, String> mNameShelfColumn;
	private TableColumn<FilamentSpool, String> mLengthShelfColumn;
	private TableColumn<FilamentSpool, String> mWeightShelfColumn;
	private TableColumn<FilamentSpool, String> mColourShelfColumn;
	private TableColumn<FilamentSpool, String> mMaterialShelfColumn;
	private TableColumn<FilamentSpool, String> mNoozleTempShelfColumn;
	private TableColumn<FilamentSpool, String> mBedTempShelfColumn;
	@FXML
	private TableView<Project> mTableViewProjects;

	@FXML
	private Button mAddFilamentButton;
	@FXML
	private Button mAddProjectButton;
	@FXML
	private Button mAddUseButton;

//	private Shelf mShelf;

	public Controller() {
		// muss leer bleiben
	}

	public void initialize(URL pArg0, ResourceBundle pArg1) {

//wird automatisch gerufen
		initShelf();
//		initProjects();
		initListener();
	}

	private void initProjects() {
		ObservableList<Project> lItems = mTableViewProjects.getItems();

	}

	private void initShelf() {
		ObservableList<FilamentSpool> lItems = mTableViewShelf.getItems();
		mNameShelfColumn = new TableColumn<FilamentSpool, String>("Name");
		mLengthShelfColumn = new TableColumn<FilamentSpool, String>("Length");
		mWeightShelfColumn = new TableColumn<FilamentSpool, String>("Weight");
		mColourShelfColumn = new TableColumn<FilamentSpool, String>("Colour");
		mMaterialShelfColumn = new TableColumn<FilamentSpool, String>("Material");
		mNoozleTempShelfColumn = new TableColumn<FilamentSpool, String>("Noozle Temp");
		mBedTempShelfColumn = new TableColumn<FilamentSpool, String>("Bed Temp");

		mTableViewShelf.getColumns().addAll(mNameShelfColumn, mLengthShelfColumn, mWeightShelfColumn,
				mColourShelfColumn, mMaterialShelfColumn, mNoozleTempShelfColumn, mBedTempShelfColumn);
		mNameShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("name"));
		mLengthShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("length"));
		mWeightShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("weight"));
		mColourShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("colour"));
		mMaterialShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("material"));
		mNoozleTempShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("IdealNoozleTemp"));
		mBedTempShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("IdealBedTemp"));
		fillShelfFromDatabase();
	}

	private void fillShelfFromDatabase() {
		mTableViewShelf.getItems().clear();
		List<FilamentSpool> lDatabanklistFilament = DatabaseConnection.getFilamentListFromDatabase();
		if (lDatabanklistFilament != null) {
			mTableViewShelf.getItems().addAll(lDatabanklistFilament);
		}
		mTableViewShelf.getSelectionModel().selectFirst();

	}

	private void fillProjectFromDatabase() {
		mTableViewProjects.getItems().clear();
		List<Project> lProjectListFromDatabase = DatabaseConnection.getProjectListFromDatabase();
		if (lProjectListFromDatabase != null) {
			mTableViewProjects.getItems().addAll(lProjectListFromDatabase);
		}
	}

	public void initListener() {
		mAddFilamentButton.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event pEvent) {
				ControllerForPopupAddFilament popupController = new ControllerForPopupAddFilament();
				showPopup(Constants.FXML_POPUP_ADD_FILAMENT);
				FilamentSpool lResult = popupController.getResult();
				DatabaseConnection.addFilamentToDatabase(lResult);
				fillShelfFromDatabase();
			}

		});

		mAddProjectButton.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event pEvent) {

				System.out.println("click");
				// TODO Auto-generated method stub

			}
		});
		mAddUseButton.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event pEvent) {
				FilamentSpool lSelectionFilament = mTableViewShelf.getSelectionModel().getSelectedItem();
				ControllerForAddingUsage popupController = new ControllerForAddingUsage();

				showPopup(Constants.FXML_POPUP_ADD_USAGE);
				Print lResult = popupController.getResult(lSelectionFilament);
//checkbox ob Print wirklich in DB soll oder wenn Projekt leer bleibt?
				int lNewWeight = lSelectionFilament.getWeight() - lResult.getWeight();
				int lNewLength = lSelectionFilament.getLength() - lResult.getLength();
				lSelectionFilament.setWeigth(lNewWeight);
				lSelectionFilament.setLength(lNewLength);
				DatabaseConnection.addPrintToDatabaseAndUpdateFilament(lResult, lSelectionFilament);
				fillShelfFromDatabase();
			}
		});

	}

	private void showPopup(String mNameOfFXML) {
		FXMLLoader loader = new FXMLLoader(mMainApp.getClass().getResource(mNameOfFXML));
		Parent lPopUp;
		try {
			lPopUp = loader.load();
			Scene scene = new Scene(lPopUp);
			Stage popupStage = new Stage();
			popupStage.initOwner(mMainApp.getPrimaryStage());
			popupStage.initModality(Modality.WINDOW_MODAL);
			popupStage.setScene(scene);
			popupStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
