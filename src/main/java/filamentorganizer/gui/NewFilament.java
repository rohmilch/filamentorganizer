package filamentorganizer.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import filamentorganizer.logik.Material;

public class NewFilament extends JDialog {

	private final JPanel mcontentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewFilament dialog = new NewFilament();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NewFilament() {
		setTitle("Neues Filament hinzufügen");
		setBounds(100, 100, 628, 477);
		getContentPane().setLayout(new BorderLayout());
		mcontentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mcontentPanel, BorderLayout.CENTER);
		mcontentPanel.setLayout(null);
		{
			JFormattedTextField formattedTextField = new JFormattedTextField();
			formattedTextField.setBounds(139, 74, 98, 26);
			mcontentPanel.add(formattedTextField);
		}
		{
			JLabel lblNewLabel = new JLabel("Ein neues Filament in den Regalbestand aufnehmen:");
			lblNewLabel.setBounds(130, 24, 349, 16);
			mcontentPanel.add(lblNewLabel);
		}

		JLabel lblNeuFilaName = new JLabel("Name");
		lblNeuFilaName.setBounds(31, 79, 61, 16);
		mcontentPanel.add(lblNeuFilaName);

		JLabel lblNeuFilaHersteller = new JLabel("Hersteller");
		lblNeuFilaHersteller.setBounds(316, 112, 61, 16);
		mcontentPanel.add(lblNeuFilaHersteller);

		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(424, 107, 98, 26);
		mcontentPanel.add(formattedTextField);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(424, 73, 98, 27);
		comboBox.setModel(new DefaultComboBoxModel(Material.values()));
		mcontentPanel.add(comboBox);

		JLabel lblNeuFilaMaterial = new JLabel("Material");
		lblNeuFilaMaterial.setBounds(316, 77, 61, 16);
		mcontentPanel.add(lblNeuFilaMaterial);

		JLabel lblNeuFilaPreis = new JLabel("Preis");
		lblNeuFilaPreis.setBounds(31, 338, 61, 16);
		mcontentPanel.add(lblNeuFilaPreis);

		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(139, 333, 98, 26);
		mcontentPanel.add(formattedTextField_1);

		JLabel lblNeuFilaGewicht = new JLabel("Gewicht");
		lblNeuFilaGewicht.setBounds(31, 178, 61, 16);
		mcontentPanel.add(lblNeuFilaGewicht);

		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(139, 173, 98, 26);
		mcontentPanel.add(formattedTextField_2);

		JLabel lblNeuFilaDurchmesser = new JLabel("Durchmesser");
		lblNeuFilaDurchmesser.setBounds(316, 178, 83, 16);
		mcontentPanel.add(lblNeuFilaDurchmesser);

		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setBounds(424, 173, 98, 26);
		mcontentPanel.add(formattedTextField_3);

		JLabel lblNeuFilaFarbe = new JLabel("Farbe");
		lblNeuFilaFarbe.setBounds(31, 112, 61, 16);
		mcontentPanel.add(lblNeuFilaFarbe);

		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setBounds(139, 107, 98, 26);
		mcontentPanel.add(formattedTextField_4);

		JLabel lblNeuFilaNozzleTemp = new JLabel("Nozzle Temp.");
		lblNeuFilaNozzleTemp.setBounds(31, 279, 98, 16);
		mcontentPanel.add(lblNeuFilaNozzleTemp);

		JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		formattedTextField_5.setBounds(139, 274, 98, 21);
		mcontentPanel.add(formattedTextField_5);

		JLabel lblFilaNeuBettTemp = new JLabel("Bett Temp.");
		lblFilaNeuBettTemp.setBounds(316, 279, 98, 16);
		mcontentPanel.add(lblFilaNeuBettTemp);

		JFormattedTextField formattedTextField_6 = new JFormattedTextField();
		formattedTextField_6.setBounds(424, 274, 98, 21);
		mcontentPanel.add(formattedTextField_6);

		JLabel lblNewFilaDichte = new JLabel("Dichte");
		lblNewFilaDichte.setBounds(31, 211, 61, 16);
		mcontentPanel.add(lblNewFilaDichte);

		JFormattedTextField formattedTextField_7 = new JFormattedTextField();
		formattedTextField_7.setBounds(139, 206, 98, 26);
		mcontentPanel.add(formattedTextField_7);

		JLabel lblNewFilaLaenge = new JLabel("Länge");
		lblNewFilaLaenge.setBounds(316, 211, 61, 16);
		mcontentPanel.add(lblNewFilaLaenge);

		JFormattedTextField formattedTextField_8 = new JFormattedTextField();
		formattedTextField_8.setBounds(424, 206, 98, 26);
		mcontentPanel.add(formattedTextField_8);

		JLabel lblShop = new JLabel("Shop");
		lblShop.setBounds(316, 338, 61, 16);
		mcontentPanel.add(lblShop);

		JFormattedTextField formattedTextField_9 = new JFormattedTextField();
		formattedTextField_9.setBounds(376, 333, 158, 26);
		mcontentPanel.add(formattedTextField_9);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
