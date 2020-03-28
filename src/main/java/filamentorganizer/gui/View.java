package filamentorganizer.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import filamentorganizer.logik.Material;

public class View {

	private JFrame mWindow;
	private JPanel mContentPane;
	private JTable mtableSpoolShelf;
	private JTextField mtextName;
	private JTextField mtextLength;
	private JTextField mtextWeigth;
	private JTextField mtextDiameter;
	private JTextField mtextPrice;
	private JTextField mtextNoozleTemp;
	private JTextField mtextBedTemp;
	private JButton mBtnAddNewSpool;
	private JComboBox mComboBoxMaterial;
	private JTextField mtextManufacturer;
	private JLabel mLabelYourShelf;
	private JLabel mLabelColour;
	private JTextField mtextColour;

	public View() {
		initialize();
	}

	private void initialize() {
		mWindow = new JFrame();
		mWindow.setBounds(100, 100, 1000, 1000);
		mWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mContentPane = new JPanel();
		mContentPane.setBackground(new Color(0, 128, 128));
		mContentPane.setBorder(new LineBorder(new Color(0, 139, 139), 2));
		mWindow.setContentPane(mContentPane);
		GridBagLayout gbl_ContentPane = new GridBagLayout();
		gbl_ContentPane.columnWidths = new int[] { 46, 65, 106, 618, 0, 0, 0, 0, 0 };
		gbl_ContentPane.rowHeights = new int[] { 14, 14, 14, 20, 33, 20, 0, 20, 20, 20, 22, 15, 0, 4, 14, 424, 0 };
		gbl_ContentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_ContentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		mContentPane.setLayout(gbl_ContentPane);

		mLabelYourShelf = new JLabel("Your Shelf:");
		mLabelYourShelf.setFont(new Font("Tahoma", Font.PLAIN, 37));
		GridBagConstraints gbc_LabelYourShelf = new GridBagConstraints();
		gbc_LabelYourShelf.insets = new Insets(0, 0, 5, 5);
		gbc_LabelYourShelf.gridx = 3;
		gbc_LabelYourShelf.gridy = 0;
		mContentPane.add(mLabelYourShelf, gbc_LabelYourShelf);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane.gridheight = 14;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 1;
		mContentPane.add(scrollPane, gbc_scrollPane);
		scrollPane.setEnabled(false);

		mtableSpoolShelf = new JTable();
		mtableSpoolShelf.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(mtableSpoolShelf);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel.gridheight = 15;
		gbc_panel.gridx = 7;
		gbc_panel.gridy = 1;
		mContentPane.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(1, 1, 0, 0));

		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 3;
		mContentPane.add(lblName, gbc_lblName);

		mtextName = new JTextField();
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.anchor = GridBagConstraints.NORTH;
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.gridx = 2;
		gbc_textName.gridy = 3;
		mContentPane.add(mtextName, gbc_textName);
		mtextName.setColumns(10);

		JLabel lblMaterial = new JLabel("Material");
		GridBagConstraints gbc_lblMaterial = new GridBagConstraints();
		gbc_lblMaterial.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMaterial.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaterial.gridx = 1;
		gbc_lblMaterial.gridy = 4;
		mContentPane.add(lblMaterial, gbc_lblMaterial);

		mComboBoxMaterial = new JComboBox();
		mComboBoxMaterial.setModel(new DefaultComboBoxModel(Material.values()));

		GridBagConstraints gbc_ComboBoxMaterial = new GridBagConstraints();
		gbc_ComboBoxMaterial.fill = GridBagConstraints.HORIZONTAL;
		gbc_ComboBoxMaterial.insets = new Insets(0, 0, 5, 5);
		gbc_ComboBoxMaterial.gridx = 2;
		gbc_ComboBoxMaterial.gridy = 4;
		mContentPane.add(mComboBoxMaterial, gbc_ComboBoxMaterial);

		mLabelColour = new JLabel("Colour");
		GridBagConstraints gbc_LabelColour = new GridBagConstraints();
		gbc_LabelColour.anchor = GridBagConstraints.WEST;
		gbc_LabelColour.insets = new Insets(0, 0, 5, 5);
		gbc_LabelColour.gridx = 1;
		gbc_LabelColour.gridy = 5;
		mContentPane.add(mLabelColour, gbc_LabelColour);

		mtextColour = new JTextField();
		mtextColour.setColumns(10);
		GridBagConstraints gbc_textColour = new GridBagConstraints();
		gbc_textColour.insets = new Insets(0, 0, 5, 5);
		gbc_textColour.fill = GridBagConstraints.HORIZONTAL;
		gbc_textColour.gridx = 2;
		gbc_textColour.gridy = 5;
		mContentPane.add(mtextColour, gbc_textColour);

		JLabel lblManufacturer = new JLabel("Manufacturer");
		GridBagConstraints gbc_lblManufacturer = new GridBagConstraints();
		gbc_lblManufacturer.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblManufacturer.insets = new Insets(0, 0, 5, 5);
		gbc_lblManufacturer.gridx = 1;
		gbc_lblManufacturer.gridy = 6;
		mContentPane.add(lblManufacturer, gbc_lblManufacturer);

		mtextManufacturer = new JTextField();
		mtextManufacturer.setColumns(10);
		GridBagConstraints gbc_textManufacturer = new GridBagConstraints();
		gbc_textManufacturer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textManufacturer.anchor = GridBagConstraints.NORTH;
		gbc_textManufacturer.insets = new Insets(0, 0, 5, 5);
		gbc_textManufacturer.gridx = 2;
		gbc_textManufacturer.gridy = 6;
		mContentPane.add(mtextManufacturer, gbc_textManufacturer);

		JLabel lblLength = new JLabel("Length (in m)");
		GridBagConstraints gbc_lblLength = new GridBagConstraints();
		gbc_lblLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLength.insets = new Insets(0, 0, 5, 5);
		gbc_lblLength.gridx = 1;
		gbc_lblLength.gridy = 7;
		mContentPane.add(lblLength, gbc_lblLength);

		mtextLength = new JTextField();
		mtextLength.setColumns(5);
		GridBagConstraints gbc_textLength = new GridBagConstraints();
		gbc_textLength.anchor = GridBagConstraints.NORTHWEST;
		gbc_textLength.insets = new Insets(0, 0, 5, 5);
		gbc_textLength.gridx = 2;
		gbc_textLength.gridy = 7;
		mContentPane.add(mtextLength, gbc_textLength);

		JLabel lblWeigth = new JLabel("Weigth (in g)");
		GridBagConstraints gbc_lblWeigth = new GridBagConstraints();
		gbc_lblWeigth.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblWeigth.insets = new Insets(0, 0, 5, 5);
		gbc_lblWeigth.gridx = 1;
		gbc_lblWeigth.gridy = 8;
		mContentPane.add(lblWeigth, gbc_lblWeigth);

		mtextWeigth = new JTextField();
		mtextWeigth.setColumns(5);
		GridBagConstraints gbc_textWeigth = new GridBagConstraints();
		gbc_textWeigth.anchor = GridBagConstraints.NORTHWEST;
		gbc_textWeigth.insets = new Insets(0, 0, 5, 5);
		gbc_textWeigth.gridx = 2;
		gbc_textWeigth.gridy = 8;
		mContentPane.add(mtextWeigth, gbc_textWeigth);

		JLabel lblDiameter = new JLabel("Diameter");
		GridBagConstraints gbc_lblDiameter = new GridBagConstraints();
		gbc_lblDiameter.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDiameter.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiameter.gridx = 1;
		gbc_lblDiameter.gridy = 9;
		mContentPane.add(lblDiameter, gbc_lblDiameter);

		mtextDiameter = new JTextField("1.75");
		mtextDiameter.setColumns(5);
		GridBagConstraints gbc_textDiameter = new GridBagConstraints();
		gbc_textDiameter.anchor = GridBagConstraints.NORTHWEST;
		gbc_textDiameter.insets = new Insets(0, 0, 5, 5);
		gbc_textDiameter.gridx = 2;
		gbc_textDiameter.gridy = 9;
		mContentPane.add(mtextDiameter, gbc_textDiameter);

		JLabel lblPrice = new JLabel("Price");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 1;
		gbc_lblPrice.gridy = 10;
		mContentPane.add(lblPrice, gbc_lblPrice);

		mtextPrice = new JTextField();
		mtextPrice.setColumns(5);
		GridBagConstraints gbc_textPrice = new GridBagConstraints();
		gbc_textPrice.anchor = GridBagConstraints.SOUTHWEST;
		gbc_textPrice.insets = new Insets(0, 0, 5, 5);
		gbc_textPrice.gridx = 2;
		gbc_textPrice.gridy = 10;
		mContentPane.add(mtextPrice, gbc_textPrice);

		JLabel lblIdealNoozleTemp = new JLabel("Ideal Noozle Temp");
		GridBagConstraints gbc_lblIdealNoozleTemp = new GridBagConstraints();
		gbc_lblIdealNoozleTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIdealNoozleTemp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdealNoozleTemp.gridx = 1;
		gbc_lblIdealNoozleTemp.gridy = 11;
		mContentPane.add(lblIdealNoozleTemp, gbc_lblIdealNoozleTemp);

		mtextNoozleTemp = new JTextField();
		mtextNoozleTemp.setColumns(5);
		GridBagConstraints gbc_textNoozleTemp = new GridBagConstraints();
		gbc_textNoozleTemp.anchor = GridBagConstraints.NORTHWEST;
		gbc_textNoozleTemp.insets = new Insets(0, 0, 5, 5);
		gbc_textNoozleTemp.gridx = 2;
		gbc_textNoozleTemp.gridy = 11;
		mContentPane.add(mtextNoozleTemp, gbc_textNoozleTemp);

		JLabel lblIdealBedTemp = new JLabel("Ideal Bed Temp");
		GridBagConstraints gbc_lblIdealBedTemp = new GridBagConstraints();
		gbc_lblIdealBedTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIdealBedTemp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdealBedTemp.gridx = 1;
		gbc_lblIdealBedTemp.gridy = 12;
		mContentPane.add(lblIdealBedTemp, gbc_lblIdealBedTemp);

		mtextBedTemp = new JTextField();
		mtextBedTemp.setColumns(5);
		GridBagConstraints gbc_textBedTemp = new GridBagConstraints();
		gbc_textBedTemp.anchor = GridBagConstraints.NORTHWEST;
		gbc_textBedTemp.insets = new Insets(0, 0, 5, 5);
		gbc_textBedTemp.gridx = 2;
		gbc_textBedTemp.gridy = 12;
		mContentPane.add(mtextBedTemp, gbc_textBedTemp);

		mBtnAddNewSpool = new JButton("Add New Spool");
		GridBagConstraints gbc_BtnAddNewSpool = new GridBagConstraints();
		gbc_BtnAddNewSpool.anchor = GridBagConstraints.NORTH;
		gbc_BtnAddNewSpool.fill = GridBagConstraints.HORIZONTAL;
		gbc_BtnAddNewSpool.insets = new Insets(0, 0, 5, 5);
		gbc_BtnAddNewSpool.gridwidth = 2;
		gbc_BtnAddNewSpool.gridx = 1;
		gbc_BtnAddNewSpool.gridy = 14;
		mContentPane.add(mBtnAddNewSpool, gbc_BtnAddNewSpool);
		mWindow.setLocationRelativeTo(null);

	}

	public JTextField getMtextManufacturer() {
		return mtextManufacturer;
	}

	public JLabel getLabelYourShelf() {
		return mLabelYourShelf;
	}

	public JLabel getLabelColour() {
		return mLabelColour;
	}

	public JTextField getMtextColour() {
		return mtextColour;
	}

	public JFrame getWindow() {
		return mWindow;
	}

	public JPanel getContentPane() {
		return mContentPane;
	}

	public JTable getMtableSpoolShelf() {
		return mtableSpoolShelf;
	}

	public JTextField getMtextName() {
		return mtextName;
	}

	public JTextField getMtextLength() {
		return mtextLength;
	}

	public JTextField getMtextWeigth() {
		return mtextWeigth;
	}

	public JTextField getMtextDiameter() {
		return mtextDiameter;
	}

	public JTextField getMtextPrice() {
		return mtextPrice;
	}

	public JTextField getMtextNoozleTemp() {
		return mtextNoozleTemp;
	}

	public JTextField getMtextBedTemp() {
		return mtextBedTemp;
	}

	public JButton getBtnAdddNewSpool() {
		return mBtnAddNewSpool;
	}

	public JComboBox getComboBoxMaterial() {
		return mComboBoxMaterial;
	}
}
