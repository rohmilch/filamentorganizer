package filamentorganizer.binder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import filamentorganizer.gui.View;
import filamentorganizer.logik.Shelf;

public class Controller {

	private View mView;
	private Shelf mShelf;

	public Controller(View pView, Shelf pModel) {
		super();
		mView = pView;
		mShelf = pModel;
		initListener();

		String headers[] = { "Name", "Length", "Weight", "Colour", "Material", "Ideale Druck-Temp." };
		mShelf.setColumnIdentifiers(headers);
		mView.getMtableSpoolShelf().setModel(mShelf);
	}

	public void initListener() {
		mView.getBtnAdddNewSpool().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent pE) {
				System.out.println(pE.getActionCommand());
				if (pE.getActionCommand().equals(mView.getBtnAdddNewSpool().getText())) {
					String lName = mView.getMtextName().getText();
					double lDiameter = Double.parseDouble(mView.getMtextDiameter().getText());
					int lLength = Integer.parseInt(mView.getMtextLength().getText());
					int lWeigth = Integer.parseInt(mView.getMtextWeigth().getText());
					int lNoozleTemp = Integer.parseInt(mView.getMtextNoozleTemp().getText());
					int lBedTemp = Integer.parseInt(mView.getMtextBedTemp().getText());
					int lPrice = Integer.parseInt(mView.getMtextPrice().getText());
					String lColour = mView.getMtextColour().getText();
					String lManufacturer = mView.getMtextManufacturer().getText();

					String lMaterial = mView.getComboBoxMaterial().getSelectedItem().toString();
					mShelf.addNewSpoolToShelf(lLength, lWeigth, lColour, lName, lManufacturer, lMaterial, lDiameter,
							lPrice, lNoozleTemp, lBedTemp);

					mShelf.addRow(new Object[] { lName, String.valueOf(lLength) + " m", String.valueOf(lWeigth) + " g",
							lColour, lMaterial, lNoozleTemp + " °C / " + lBedTemp + " °C" });

				}

			}
		});

	}

}
