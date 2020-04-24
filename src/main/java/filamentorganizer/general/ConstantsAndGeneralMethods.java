package filamentorganizer.general;

public class ConstantsAndGeneralMethods {

	public static final String DATABASE_URL = "jdbc:sqlite:test.db";
	public static final String FXML_MAIN = "/MainWindow.fxml";
	public static final String FXML_POPUP_ADD_FILAMENT = "/PopupAddFilament.fxml";
	public static final String FXML_POPUP_ADD_PRINT = "/PopupAddPrint.fxml";
	public static final String FXML_POPUP_ADD_PROJECT = "/PopupAddProject.fxml";

	public static double calculateLengthByWeight(double lWeigth, double lDiameter, double pDensity) {
		double lLengthMeter = (4 * lWeigth) / (Math.PI * pDensity * (Math.pow(lDiameter, 2)));
		return lLengthMeter;
	}

	public static double calculateWeigthByLength(double pLength, double pDiameter, double pDensity) {
		double lWeigthcalculated = (pLength * Math.PI * Math.pow(pDiameter, 2) * pDensity) / (4);
		return lWeigthcalculated;
	}
}
