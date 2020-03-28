package filamentorganizer.logik;

import java.util.List;

import javax.swing.table.DefaultTableModel;

public class Shelf extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7249118366193008868L;
	private List<FilamentSpool> mListOfSpools;
	

	public Shelf(List<FilamentSpool> pListOfSpools) {
		mListOfSpools = pListOfSpools;
	}

	public void addNewSpoolToShelf(int pLength, int pTotalWeigth, String pColour, String pName, String pManufacturer, String pMaterial,
			double pDiameter, double pPrice, int pIdealNoozleTemp, int pIdealBedTemp) {
		
		FilamentSpool lNewSpool = FilamentSpool.createASpool(pLength, pTotalWeigth, pColour, pName, pManufacturer, pMaterial, pDiameter, pPrice, pIdealNoozleTemp, pIdealBedTemp);
		getListOfSpools().add(lNewSpool);		
	}
	
	public List<FilamentSpool> getListOfSpools() {
		return mListOfSpools;
	}
 
	public void setListOfSpuls(List<FilamentSpool> pListOfSpools) {
		mListOfSpools = pListOfSpools;
	}
	
	
	
}
