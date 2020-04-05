package filamentorganizer.binder;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import filamentorganizer.logik.FilamentSpool;
import filamentorganizer.logik.Material;
import filamentorganizer.logik.Shelf;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {

	@FXML
	private TableView<FilamentSpool> tableView;
	@FXML
	private TableColumn<FilamentSpool, String> NameCol;
	@FXML
	private TableColumn<FilamentSpool, String> LengthCol;
	@FXML
	private TableColumn<FilamentSpool, String> WeightCol;
	@FXML
	private TableColumn<FilamentSpool, String> ColourCol;
	@FXML
	private TableColumn<FilamentSpool, String> MaterialCol;
	@FXML
	private TableColumn<FilamentSpool, String> NoozleTempCol;
	private TableColumn<FilamentSpool, String> BedTempCol;

	private Shelf mShelf;

	public Controller() {

	}

	public void initialize(URL pArg0, ResourceBundle pArg1) {
		ObservableList<FilamentSpool> lItems = tableView.getItems();
		NameCol = new TableColumn<FilamentSpool, String>("Name");
		LengthCol = new TableColumn<FilamentSpool, String>("Length");
		WeightCol = new TableColumn<FilamentSpool, String>("Weight");
		ColourCol = new TableColumn<FilamentSpool, String>("Colour");
		MaterialCol = new TableColumn<FilamentSpool, String>("Material");
		NoozleTempCol = new TableColumn<FilamentSpool, String>("Noozle Temp");
		BedTempCol = new TableColumn<FilamentSpool, String>("Bed Temp");

		tableView.getColumns().addAll(NameCol, LengthCol, WeightCol, ColourCol, MaterialCol, NoozleTempCol, BedTempCol);
		NameCol.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("name"));
		LengthCol.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("length"));
		WeightCol.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("weight"));
		ColourCol.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("colour"));
		MaterialCol.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("material"));
		NoozleTempCol.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("IdealNoozleTemp"));
		BedTempCol.setCellValueFactory(new PropertyValueFactory<FilamentSpool, String>("IdealBedTemp"));

		lItems.addAll(parseFilamentList());

	}

	private List<FilamentSpool> parseFilamentList() {

		List<FilamentSpool> lBsp = new ArrayList<FilamentSpool>();
		FilamentSpool lBspFilament = new FilamentSpool(100, 100, "gruen", "Beispiel", "Beispiel", Material.PLA, 1.75,
				20, 200, 200);
		lBsp.add(lBspFilament);
		return lBsp;
	}

//	public void initListener() {
//		mView.getBtnAdddNewSpool().addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent pE) {
//				System.out.println(pE.getActionCommand());
//				if (pE.getActionCommand().equals(mView.getBtnAdddNewSpool().getText())) {
//					String lName = mView.getMtextName().getText();
//					double lDiameter = Double.parseDouble(mView.getMtextDiameter().getText());
//					int lLength = Integer.parseInt(mView.getMtextLength().getText());
//					int lWeigth = Integer.parseInt(mView.getMtextWeigth().getText());
//					int lNoozleTemp = Integer.parseInt(mView.getMtextNoozleTemp().getText());
//					int lBedTemp = Integer.parseInt(mView.getMtextBedTemp().getText());
//					int lPrice = Integer.parseInt(mView.getMtextPrice().getText());
//					String lColour = mView.getMtextColour().getText();
//					String lManufacturer = mView.getMtextManufacturer().getText();
//
//					String lMaterial = mView.getComboBoxMaterial().getSelectedItem().toString();
//					mShelf.addNewSpoolToShelf(lLength, lWeigth, lColour, lName, lManufacturer, lMaterial, lDiameter,
//							lPrice, lNoozleTemp, lBedTemp);
//
//					mShelf.addRow(new Object[] { lName, String.valueOf(lLength) + " m", String.valueOf(lWeigth) + " g",
//							lColour, lMaterial, lNoozleTemp + " �C / " + lBedTemp + " �C" });
//
//				}
//
//			}
//		});
//
//	}

}
