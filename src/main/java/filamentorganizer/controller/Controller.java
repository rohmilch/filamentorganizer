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
		initProjects();
		initListener();
		fillAndRefreshTables();
	}

	private void initProjects() {
		ObservableList<Project> lItems = mTableViewProjects.getItems();
		TableColumn<Project, String> mNameShelfColumn = new TableColumn<Project, String>("Name");
		mTableViewProjects.getColumns().addAll(mNameShelfColumn);
		mNameShelfColumn.setCellValueFactory(new PropertyValueFactory<Project, String>("name"));
	}

	private void initShelf() {
		ObservableList<FilamentSpool> lItems = mTableViewShelf.getItems();
		TableColumn<FilamentSpool, String> mNameShelfColumn = new TableColumn<FilamentSpool, String>("Name");
		TableColumn<FilamentSpool, String> mLengthShelfColumn = new TableColumn<FilamentSpool, String>("Length");
		TableColumn<FilamentSpool, String> mWeightShelfColumn = new TableColumn<FilamentSpool, String>("Weight");
		TableColumn<FilamentSpool, String> mColourShelfColumn = new TableColumn<FilamentSpool, String>("Colour");
		TableColumn<FilamentSpool, String> mMaterialShelfColumn = new TableColumn<FilamentSpool, String>("Material");
		TableColumn<FilamentSpool, String> mNoozleTempShelfColumn = new TableColumn<FilamentSpool, String>(
				"Noozle Temp");
		TableColumn<FilamentSpool, String> mBedTempShelfColumn = new TableColumn<FilamentSpool, String>("Bed Temp");

		mTableViewShelf.getColumns().addAll(mNameShelfColumn, mLengthShelfColumn, mWeightShelfColumn,
				mColourShelfColumn, mMaterialShelfColumn, mNoozleTempShelfColumn, mBedTempShelfColumn);
		mNameShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("name"));
		mLengthShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("length"));
		mWeightShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("weight"));
		mColourShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("colour"));
		mMaterialShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("material"));
		mNoozleTempShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("IdealNoozleTemp"));
		mBedTempShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("IdealBedTemp"));
	}

	private void fillAndRefreshTables() {
		mTableViewShelf.getItems().clear();
		mTableViewProjects.getItems().clear();
		List<FilamentSpool> lDatabanklistFilament = DatabaseConnection.getFilamentListFromDatabase();
		if (lDatabanklistFilament != null) {
			mTableViewShelf.getItems().addAll(lDatabanklistFilament);
		}
		List<Project> lDatabanklistProject = DatabaseConnection.getProjectListFromDatabase();
		if (lDatabanklistProject != null) {
			mTableViewProjects.getItems().addAll(lDatabanklistProject);
		}
		mTableViewShelf.getSelectionModel().selectFirst();
		mTableViewProjects.getSelectionModel().selectFirst();

	}

	public void initListener() {
		mAddFilamentButton.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event pEvent) {
				ControllerForPopupAddFilament popupController = new ControllerForPopupAddFilament();
				showPopup(Constants.FXML_POPUP_ADD_FILAMENT);
				FilamentSpool lResult = popupController.getResult();
				DatabaseConnection.addFilamentToDatabase(lResult);
				fillAndRefreshTables();
			}

		});

		mAddProjectButton.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event pEvent) {
				ControllerForAddingProject popupController = new ControllerForAddingProject();
				showPopup(Constants.FXML_POPUP_ADD_PROJECT);
				Project lResult = popupController.getResult();
				DatabaseConnection.addProjectToDatabase(lResult);
				fillAndRefreshTables();
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
				fillAndRefreshTables();
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
