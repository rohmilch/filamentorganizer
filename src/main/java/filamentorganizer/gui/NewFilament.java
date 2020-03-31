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

	private final JPanel Mcontentpanel = new JPanel();

	private JLabel NeuFilaTextfeld;
	private JLabel NeuFilaLabelName;
	private JLabel NeuFilaLabelHersteller;
	private JFormattedTextField NeuFilaTextFieldHersteller;
	private JComboBox NeuFilaComboBoxMaterial;
	private JLabel NeuFilaLabelMaterial;
	private JLabel NeuFilaLabelPreis;
	private JFormattedTextField NeuFilaTextfeldPreis;
	private JLabel NeuFilaLabelGewicht;
	private JFormattedTextField NeuFilaTextfeldGewicht;
	private JLabel NeuFilaLabelDurchmesser;
	private JFormattedTextField NeuFilaTextfeldDurchmesser;
	private JLabel NeuFilaLabelFarbe;
	private JFormattedTextField NeuFilaTextfeldFarbe;
	private JLabel NeuFilaLabelNozzle;
	private JFormattedTextField NeuFilaTextfeldNozzle;
	private JLabel NeuFilaLabelBett;
	private JFormattedTextField NeuFilaTextfeldBett;
	private JLabel NeuFilaLabelDichte;
	private JFormattedTextField NeuFilaTextfeldDichte;
	private JLabel NeuFilaLabelLaenge;
	private JFormattedTextField NeuFilaTextfeldLaenge;
	private JLabel NeuFilaLabelShop;
	private JFormattedTextField NeuFilaTextfeldShop;
	private JButton NeuFilaButtonOK;
	private JButton NeuFilaButtonCancel;

	public JPanel getMcontentpanel() {
		return Mcontentpanel;
	}

	public JLabel getNeuFilaTextfeld() {
		return NeuFilaTextfeld;
	}

	public JLabel getNeuFilaLabelName() {
		return NeuFilaLabelName;
	}

	public JLabel getNeuFilaLabelHersteller() {
		return NeuFilaLabelHersteller;
	}

	public JFormattedTextField getNeuFilaTextFieldHersteller() {
		return NeuFilaTextFieldHersteller;
	}

	public JComboBox getNeuFilaComboBoxMaterial() {
		return NeuFilaComboBoxMaterial;
	}

	public JLabel getNeuFilaLabelMaterial() {
		return NeuFilaLabelMaterial;
	}

	public JLabel getNeuFilaLabelPreis() {
		return NeuFilaLabelPreis;
	}

	public JFormattedTextField getNeuFilaTextfeldPreis() {
		return NeuFilaTextfeldPreis;
	}

	public JLabel getNeuFilaLabelGewicht() {
		return NeuFilaLabelGewicht;
	}

	public JFormattedTextField getNeuFilaTextfeldGewicht() {
		return NeuFilaTextfeldGewicht;
	}

	public JLabel getNeuFilaLabelDurchmesser() {
		return NeuFilaLabelDurchmesser;
	}

	public JFormattedTextField getNeuFilaTextfeldDurchmesser() {
		return NeuFilaTextfeldDurchmesser;
	}

	public JLabel getNeuFilaLabelFarbe() {
		return NeuFilaLabelFarbe;
	}

	public JFormattedTextField getNeuFilaTextfeldFarbe() {
		return NeuFilaTextfeldFarbe;
	}

	public JLabel getNeuFilaLabelNozzle() {
		return NeuFilaLabelNozzle;
	}

	public JFormattedTextField getNeuFilaTextfeldNozzle() {
		return NeuFilaTextfeldNozzle;
	}

	public JLabel getNeuFilaLabelBett() {
		return NeuFilaLabelBett;
	}

	public JFormattedTextField getNeuFilaTextfeldBett() {
		return NeuFilaTextfeldBett;
	}

	public JLabel getNeuFilaLabelDichte() {
		return NeuFilaLabelDichte;
	}

	public JFormattedTextField getNeuFilaTextfeldDichte() {
		return NeuFilaTextfeldDichte;
	}

	public JLabel getNeuFilaLabelLaenge() {
		return NeuFilaLabelLaenge;
	}

	public JFormattedTextField getNeuFilaTextfeldLaenge() {
		return NeuFilaTextfeldLaenge;
	}

	public JLabel getNeuFilaLabelShop() {
		return NeuFilaLabelShop;
	}

	public JFormattedTextField getNeuFilaTextfeldShop() {
		return NeuFilaTextfeldShop;
	}

	public JButton getNeuFilaButtonOK() {
		return NeuFilaButtonOK;
	}

	public JButton getNeuFilaButtonCancel() {
		return NeuFilaButtonCancel;
	}

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
		Mcontentpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(Mcontentpanel, BorderLayout.CENTER);
		Mcontentpanel.setLayout(null);
		{
			JFormattedTextField NeuFilaTextfeldName = new JFormattedTextField();
			NeuFilaTextfeldName.setBounds(139, 74, 98, 26);
			Mcontentpanel.add(NeuFilaTextfeldName);
		}
		{
			NeuFilaTextfeld = new JLabel("Ein neues Filament in den Regalbestand aufnehmen:");
			NeuFilaTextfeld.setBounds(130, 24, 349, 16);
			Mcontentpanel.add(NeuFilaTextfeld);
		}

		NeuFilaLabelName = new JLabel("Name");
		NeuFilaLabelName.setBounds(31, 79, 61, 16);
		Mcontentpanel.add(NeuFilaLabelName);

		NeuFilaLabelHersteller = new JLabel("Hersteller");
		NeuFilaLabelHersteller.setBounds(316, 112, 61, 16);
		Mcontentpanel.add(NeuFilaLabelHersteller);

		NeuFilaTextFieldHersteller = new JFormattedTextField();
		NeuFilaTextFieldHersteller.setBounds(424, 107, 98, 26);
		Mcontentpanel.add(NeuFilaTextFieldHersteller);

		NeuFilaComboBoxMaterial = new JComboBox();
		NeuFilaComboBoxMaterial.setBounds(424, 73, 98, 27);
		NeuFilaComboBoxMaterial.setModel(new DefaultComboBoxModel(Material.values()));
		Mcontentpanel.add(NeuFilaComboBoxMaterial);

		NeuFilaLabelMaterial = new JLabel("Material");
		NeuFilaLabelMaterial.setBounds(316, 77, 61, 16);
		Mcontentpanel.add(NeuFilaLabelMaterial);

		NeuFilaLabelPreis = new JLabel("Preis");
		NeuFilaLabelPreis.setBounds(31, 338, 61, 16);
		Mcontentpanel.add(NeuFilaLabelPreis);

		NeuFilaTextfeldPreis = new JFormattedTextField();
		NeuFilaTextfeldPreis.setBounds(139, 333, 98, 26);
		Mcontentpanel.add(NeuFilaTextfeldPreis);

		NeuFilaLabelGewicht = new JLabel("Gewicht");
		NeuFilaLabelGewicht.setBounds(31, 178, 61, 16);
		Mcontentpanel.add(NeuFilaLabelGewicht);

		NeuFilaTextfeldGewicht = new JFormattedTextField();
		NeuFilaTextfeldGewicht.setBounds(139, 173, 98, 26);
		Mcontentpanel.add(NeuFilaTextfeldGewicht);

		NeuFilaLabelDurchmesser = new JLabel("Durchmesser");
		NeuFilaLabelDurchmesser.setBounds(316, 178, 83, 16);
		Mcontentpanel.add(NeuFilaLabelDurchmesser);

		NeuFilaTextfeldDurchmesser = new JFormattedTextField();
		NeuFilaTextfeldDurchmesser.setBounds(424, 173, 98, 26);
		Mcontentpanel.add(NeuFilaTextfeldDurchmesser);

		NeuFilaLabelFarbe = new JLabel("Farbe");
		NeuFilaLabelFarbe.setBounds(31, 112, 61, 16);
		Mcontentpanel.add(NeuFilaLabelFarbe);

		NeuFilaTextfeldFarbe = new JFormattedTextField();
		NeuFilaTextfeldFarbe.setBounds(139, 107, 98, 26);
		Mcontentpanel.add(NeuFilaTextfeldFarbe);

		NeuFilaLabelNozzle = new JLabel("Nozzle Temp.");
		NeuFilaLabelNozzle.setBounds(31, 279, 98, 16);
		Mcontentpanel.add(NeuFilaLabelNozzle);

		NeuFilaTextfeldNozzle = new JFormattedTextField();
		NeuFilaTextfeldNozzle.setBounds(139, 274, 98, 21);
		Mcontentpanel.add(NeuFilaTextfeldNozzle);

		NeuFilaLabelBett = new JLabel("Bett Temp.");
		NeuFilaLabelBett.setBounds(316, 279, 98, 16);
		Mcontentpanel.add(NeuFilaLabelBett);

		NeuFilaTextfeldBett = new JFormattedTextField();
		NeuFilaTextfeldBett.setBounds(424, 274, 98, 21);
		Mcontentpanel.add(NeuFilaTextfeldBett);

		NeuFilaLabelDichte = new JLabel("Dichte");
		NeuFilaLabelDichte.setBounds(31, 211, 61, 16);
		Mcontentpanel.add(NeuFilaLabelDichte);

		NeuFilaTextfeldDichte = new JFormattedTextField();
		NeuFilaTextfeldDichte.setBounds(139, 206, 98, 26);
		Mcontentpanel.add(NeuFilaTextfeldDichte);

		NeuFilaLabelLaenge = new JLabel("Länge");
		NeuFilaLabelLaenge.setBounds(316, 211, 61, 16);
		Mcontentpanel.add(NeuFilaLabelLaenge);

		NeuFilaTextfeldLaenge = new JFormattedTextField();
		NeuFilaTextfeldLaenge.setBounds(424, 206, 98, 26);
		Mcontentpanel.add(NeuFilaTextfeldLaenge);

		NeuFilaLabelShop = new JLabel("Shop");
		NeuFilaLabelShop.setBounds(316, 338, 61, 16);
		Mcontentpanel.add(NeuFilaLabelShop);

		NeuFilaTextfeldShop = new JFormattedTextField();
		NeuFilaTextfeldShop.setBounds(376, 333, 158, 26);
		Mcontentpanel.add(NeuFilaTextfeldShop);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				NeuFilaButtonOK = new JButton("OK");
				NeuFilaButtonOK.setActionCommand("OK");
				buttonPane.add(NeuFilaButtonOK);
				getRootPane().setDefaultButton(NeuFilaButtonOK);
			}
			{
				NeuFilaButtonCancel = new JButton("Cancel");
				NeuFilaButtonCancel.setActionCommand("Cancel");
				buttonPane.add(NeuFilaButtonCancel);
			}
		}
	}
}
