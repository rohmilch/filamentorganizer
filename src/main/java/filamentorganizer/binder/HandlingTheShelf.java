package filamentorganizer.binder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import filamentorganizer.gui.FrontPage;
import filamentorganizer.logik.Shelf;

public class HandlingTheShelf {
	
	FrontPage mFrontPage;
	Shelf mShelf;
	
	
	 public void populateShelf() {
		 JTable lTableSpoolShelf = mFrontPage.getMtableSpoolShelf();
//		 lTableSpoolShelf.setModel(dataModel);;
	 }

	 public void addNewSpool() {
		 mFrontPage.getBtnAdddNewSpool().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent pE) {
//				mShelf.addNewSpoolToShelf(pLength, pTotalWeigth, pColour, pName, pManufacturer, pMaterial, pDiameter, pPrice, pIdealNoozleTemp, pIdealBedTemp);
			}
		});
	 }
}
