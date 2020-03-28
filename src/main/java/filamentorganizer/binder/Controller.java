package filamentorganizer.binder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import filamentorganizer.gui.View;
import filamentorganizer.logik.FilamentSpool;
import filamentorganizer.logik.Material;
import filamentorganizer.logik.Shelf;

public class Controller {

	private View mView;
	private Shelf mShelf;

	public Controller(View pView, Shelf pModel) {
		super();
		mView = pView;
		mShelf = pModel;
		initListener();

		String headers[] = { "Name", "Length", "Weight", "Colour", "Material" };
		mShelf.setColumnIdentifiers(headers);
		mView.getMtableSpoolShelf().setModel(mShelf);
	}

	public void initListener() {
		mView.getBtnAdddNewSpool().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent pE) {
				System.out.println(pE.getActionCommand());
				if (pE.getActionCommand().equals(mView.getBtnAdddNewSpool().getText())) {
					String lName = mView.getMtextName().getText();
					int lDiameter = Integer.parseInt(mView.getMtextDiameter().getText());
					int lLength = Integer.parseInt(mView.getMtextLength().getText());
					int lWeigth = Integer.parseInt(mView.getMtextWeigth().getText());
					int lNoozleTemp = Integer.parseInt(mView.getMtextNoozleTemp().getText());
					int lBedTemp = Integer.parseInt(mView.getMtextBedTemp().getText());
					int lPrice = Integer.parseInt(mView.getMtextPrice().getText());
//			String lColour = mView.getMtextrice().getText();
					mShelf.addNewSpoolToShelf(lLength, lWeigth, "black", lName, "a", Material.PLA, lDiameter, lPrice,
							lNoozleTemp, lBedTemp);
					
						mShelf.addRow(new Object[] {lName, String.valueOf(lLength), String.valueOf(lWeigth), "black", Material.PLA.getText()   });
						
				}

			}
		});

	}


}