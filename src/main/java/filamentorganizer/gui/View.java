package filamentorganizer.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import javax.swing.JEditorPane;
import javax.swing.JSlider;
import javax.swing.JScrollPane;

public class View  {
	
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
    	mContentPane.setLayout(null);
    	
    	JPanel panel = new JPanel();
    	panel.setBounds(248, 45, 651, 719);
    	mContentPane.add(panel);
    	
    	JScrollPane scrollPane = new JScrollPane();
    	panel.add(scrollPane);
    	
    	mtableSpoolShelf = new JTable();
    	scrollPane.setViewportView(mtableSpoolShelf);
    	
    	mBtnAddNewSpool = new JButton("Add New Spool");
    	mBtnAddNewSpool.setBounds(27, 340, 121, 23);
    	mContentPane.add(mBtnAddNewSpool);
    	
    	mComboBoxMaterial = new JComboBox();
    	mComboBoxMaterial.setBounds(83, 45, 106, 20);
    	mContentPane.add(mComboBoxMaterial);
    	
    	JLabel lblMaterial = new JLabel("Material");
    	lblMaterial.setBounds(27, 45, 46, 14);
    	mContentPane.add(lblMaterial);
    	
    	JLabel lblLength = new JLabel("Length (in m)");
    	lblLength.setBounds(27, 94, 46, 14);
    	mContentPane.add(lblLength);
    	
    	JLabel lblWeigth = new JLabel("Weigth (in g)");
    	lblWeigth.setBounds(27, 119, 46, 14);
    	mContentPane.add(lblWeigth);
    	
    	JLabel lblName = new JLabel("Name");
    	lblName.setBounds(27, 20, 46, 14);
    	mContentPane.add(lblName);
    	
    	JLabel lblManufacturer = new JLabel("Manufacturer");
    	lblManufacturer.setBounds(27, 191, 46, 14);
    	mContentPane.add(lblManufacturer);
    	
    	JLabel lblDiameter = new JLabel("Diameter");
    	lblDiameter.setBounds(27, 244, 46, 14);
    	mContentPane.add(lblDiameter);
    	
    	JLabel lblPrice = new JLabel("Price");
    	lblPrice.setBounds(27, 269, 46, 14);
    	mContentPane.add(lblPrice);
    	
    	JLabel lblIdealNoozleTemp = new JLabel("Ideal Noozle Temp");
    	lblIdealNoozleTemp.setBounds(27, 294, 46, 14);
    	mContentPane.add(lblIdealNoozleTemp);
    	
    	JLabel lblIdealBedTemp = new JLabel("Ideal Bed Temp");
    	lblIdealBedTemp.setBounds(27, 319, 46, 14);
    	mContentPane.add(lblIdealBedTemp);
    	
    	JComboBox comboBoxManufacturer = new JComboBox();
    	comboBoxManufacturer.setBounds(83, 188, 106, 20);
    	mContentPane.add(comboBoxManufacturer);
    	
    	mtextName = new JTextField();
    	mtextName.setBounds(83, 14, 106, 20);
    	mContentPane.add(mtextName);
    	mtextName.setColumns(10);
    	
    	mtextLength = new JTextField();
    	mtextLength.setColumns(10);
    	mtextLength.setBounds(83, 91, 106, 20);
    	mContentPane.add(mtextLength);
    	
    	mtextWeigth = new JTextField();
    	mtextWeigth.setColumns(10);
    	mtextWeigth.setBounds(83, 116, 106, 20);
    	mContentPane.add(mtextWeigth);
    	
    	mtextDiameter = new JTextField();
    	mtextDiameter.setColumns(10);
    	mtextDiameter.setBounds(83, 241, 106, 20);
    	mContentPane.add(mtextDiameter);
    	
    	mtextPrice = new JTextField();
    	mtextPrice.setColumns(10);
    	mtextPrice.setBounds(83, 271, 106, 20);
    	mContentPane.add(mtextPrice);
    	
    	mtextNoozleTemp = new JTextField();
    	mtextNoozleTemp.setColumns(10);
    	mtextNoozleTemp.setBounds(83, 293, 106, 20);
    	mContentPane.add(mtextNoozleTemp);
    	
    	mtextBedTemp = new JTextField();
    	mtextBedTemp.setColumns(10);
    	mtextBedTemp.setBounds(83, 309, 106, 20);
    	mContentPane.add(mtextBedTemp);
    	mWindow.setLocationRelativeTo(null);
    	
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
