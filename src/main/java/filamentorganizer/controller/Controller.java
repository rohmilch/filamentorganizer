package filamentorganizer.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import filamentorganizer.data.DatabaseConnection;
import filamentorganizer.general.ConstantsAndGeneralMethods;
import filamentorganizer.logik.Displayable;
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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller extends AbstractController implements Initializable {

	@FXML
	private TableView<FilamentSpool> mTableViewShelf;

	@FXML
	private Button mAddFilamentButton;
	@FXML
	private Button mAddProjectButton;
	@FXML
	private Button mAddUseButton;

	@FXML
	private TreeTableView<Displayable> mTreeTableProjects;

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

		TreeTableColumn<Displayable, Project> mProjectNameColumn = new TreeTableColumn<Displayable, Project>(
				"ProjektName");
		TreeTableColumn<Displayable, Print> mPrintNameColumn = new TreeTableColumn<Displayable, Print>("PrintName");
		TreeTableColumn<Displayable, Print> mNotizenColumn = new TreeTableColumn<Displayable, Print>("Notizen");
		TreeTableColumn<Displayable, Print> mDurationColumn = new TreeTableColumn<Displayable, Print>("Dauer");
		TreeTableColumn<Displayable, Print> mWeigthColumn = new TreeTableColumn<Displayable, Print>("Gewicht");
		TreeTableColumn<Displayable, Print> mLengthColumn = new TreeTableColumn<Displayable, Print>("Länge");
		TreeTableColumn<Displayable, Print> mPriceColumn = new TreeTableColumn<Displayable, Print>("Preis");
		TreeTableColumn<Displayable, Print> mDateColumn = new TreeTableColumn<Displayable, Print>("Datum");
		mTreeTableProjects.getColumns().addAll(mProjectNameColumn, mPrintNameColumn, mNotizenColumn, mDurationColumn,
				mWeigthColumn, mLengthColumn, mPriceColumn, mDateColumn);
		mPrintNameColumn.setCellValueFactory(new TreeItemPropertyValueFactory<Displayable, Print>("NamePrint"));
		mProjectNameColumn.setCellValueFactory(new TreeItemPropertyValueFactory<Displayable, Project>("NameProject"));
		mNotizenColumn.setCellValueFactory(new TreeItemPropertyValueFactory<Displayable, Print>("note"));
		mDurationColumn.setCellValueFactory(new TreeItemPropertyValueFactory<Displayable, Print>("duration"));
		mWeigthColumn.setCellValueFactory(new TreeItemPropertyValueFactory<Displayable, Print>("weight"));
		mLengthColumn.setCellValueFactory(new TreeItemPropertyValueFactory<Displayable, Print>("length"));
		mPriceColumn.setCellValueFactory(new TreeItemPropertyValueFactory<Displayable, Print>("price"));
		mDateColumn.setCellValueFactory(new TreeItemPropertyValueFactory<Displayable, Print>("dateFormatted"));

	}

	private void initShelf() {
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
		mLengthShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("currentLength"));
		mWeightShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("currentWeight"));
		mColourShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("colour"));
		mMaterialShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("material"));
		mNoozleTempShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("IdealNoozleTemp"));
		mBedTempShelfColumn.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("IdealBedTemp"));
	}

	private void fillAndRefreshTables() {
		mTableViewShelf.getItems().clear();
//		mTreeTableProjects.getItems().clear();
		List<FilamentSpool> lDatabanklistFilament = DatabaseConnection.getFilamentListFromDatabase();
		if (lDatabanklistFilament != null) {
			mTableViewShelf.getItems().addAll(lDatabanklistFilament);
		}
		List<Project> lDatabanklistProject = DatabaseConnection.getProjectListFromDatabase();
		if (lDatabanklistProject != null) {
//			mTreeTableProjects.getItems().addAll(lDatabanklistProject);
		}
		mTableViewShelf.getSelectionModel().selectFirst();
		mTreeTableProjects.getSelectionModel().selectFirst();

		createProjectTreeTable();
	}

	private void createProjectTreeTable() {
		TreeItem<Displayable> lRoot = new TreeItem<Displayable>();
		mTreeTableProjects.setRoot(lRoot);
		mTreeTableProjects.setShowRoot(false);

		List<Print> lPrintsFromDatabase = DatabaseConnection.getPrintListFromDatabase();
		List<Project> lProjectListFromDatabase = DatabaseConnection.getProjectListFromDatabase();

		for (Project lProject : lProjectListFromDatabase) {
			TreeItem<Displayable> lProjectNode = new TreeItem<Displayable>(lProject);
			lRoot.getChildren().add(lProjectNode);
			lProjectNode.setExpanded(true);
		}

		Project lProject2 = new Project();
		lProject2.setNameProject("Einzeldrucke");
		TreeItem<Displayable> lNonProjectNode = new TreeItem<Displayable>(lProject2);
		lRoot.getChildren().add(lNonProjectNode);
		lNonProjectNode.setExpanded(true);

		for (Print lPrint : lPrintsFromDatabase) {
			TreeItem<Displayable> lPrintNode = new TreeItem<Displayable>(lPrint);
			if (lPrint.getProject() != null) {
				ObservableList<TreeItem<Displayable>> lChildren = lRoot.getChildren();
				for (TreeItem<Displayable> lProject : lChildren) {
					Project lPro = (Project) lProject.getValue();
					if (lPro.getNameProject().equals(lPrint.getProject().getNameProject())) {
						lProject.getChildren().add(lPrintNode);
					}
				}
			} else {
				lNonProjectNode.getChildren().add(lPrintNode);
			}
		}
	}

	public void initListener() {
		mAddFilamentButton.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event pEvent) {
				ControllerForPopupAddFilament popupController = new ControllerForPopupAddFilament();
				showPopup(ConstantsAndGeneralMethods.FXML_POPUP_ADD_FILAMENT);
				fillAndRefreshTables();
			}

		});

		mAddProjectButton.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event pEvent) {
				ControllerForAddingProject popupController = new ControllerForAddingProject();
				showPopup(ConstantsAndGeneralMethods.FXML_POPUP_ADD_PROJECT);
				fillAndRefreshTables();
			}
		});
		mAddUseButton.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event pEvent) {
				ControllerForAddingUsage popupController = new ControllerForAddingUsage();
				showPopup(ConstantsAndGeneralMethods.FXML_POPUP_ADD_PRINT);
				fillAndRefreshTables();
			}
		});

	}

	private void showPopup(String mNameOfFXML) {
		FXMLLoader loader = new FXMLLoader(getMainApp().getClass().getResource(mNameOfFXML));
		Parent lPopUp;
		try {
			lPopUp = loader.load();
			Scene scene = new Scene(lPopUp);
			AbstractController lController = loader.getController();
			Stage popupStage = new Stage();
			lController.setStage(popupStage);
			popupStage.initOwner(getMainApp().getPrimaryStage());
			popupStage.initModality(Modality.WINDOW_MODAL);
			popupStage.setScene(scene);
			popupStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
