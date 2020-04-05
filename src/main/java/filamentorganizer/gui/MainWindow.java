package filamentorganizer.gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class MainWindow {

	private JFrame Mframe;
	private JTable RegalTable;
	private JMenuBar MenuBar;
	private JMenu MenuDatei;
	private JMenuItem MenuItemNeuFilament;
	private JMenuItem MenuItemNeuProjekt;
	private JMenuItem MenuItemNeuPrint;
	private JMenu MenuBearbeiten;
	private JMenuItem MenuItemEinstellungen;
	private JTabbedPane TabbedPane;
	private JPanel Panel;
	private JButton ButtonNeuFilament;
	private JButton ButtonNeuPrint;
	private JTabbedPane TabPrints;
	private JTabbedPane TabProjekte;

	public JFrame getMframe() {
		return Mframe;
	}

	public JTable getRegalTable() {
		return RegalTable;
	}

	public JMenuBar getMenuBar() {
		return MenuBar;
	}

	public JMenu getMenuDatei() {
		return MenuDatei;
	}

	public JMenuItem getMenuItemNeuFilament() {
		return MenuItemNeuFilament;
	}

	public JMenuItem getMenuItemNeuProjekt() {
		return MenuItemNeuProjekt;
	}

	public JMenuItem getMenuItemNeuPrint() {
		return MenuItemNeuPrint;
	}

	public JMenu getMenuBearbeiten() {
		return MenuBearbeiten;
	}

	public JMenuItem getMenuItemEinstellungen() {
		return MenuItemEinstellungen;
	}

	public JTabbedPane getTabbedPane() {
		return TabbedPane;
	}

	public JPanel getPanel() {
		return Panel;
	}

	public JButton getButtonNeuFilament() {
		return ButtonNeuFilament;
	}

	public JButton getButtonNeuPrint() {
		return ButtonNeuPrint;
	}

	public JTabbedPane getTabPrints() {
		return TabPrints;
	}

	public JTabbedPane getTabProjekte() {
		return TabProjekte;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.getMframe().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Mframe = new JFrame();
		Mframe.setBounds(100, 100, 1148, 740);
		Mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/** MUSTER */

		MenuBar = new JMenuBar();
		Mframe.setJMenuBar(MenuBar);

		MenuDatei = new JMenu("Datei");
		MenuBar.add(MenuDatei);

		MenuItemNeuFilament = new JMenuItem("Neues Filament...");
		MenuDatei.add(MenuItemNeuFilament);

		MenuItemNeuProjekt = new JMenuItem("Neues Projekt...");
		MenuDatei.add(MenuItemNeuProjekt);

		MenuItemNeuPrint = new JMenuItem("Neuer Print...");
		MenuDatei.add(MenuItemNeuPrint);

		MenuBearbeiten = new JMenu("Bearbeiten");
		MenuBar.add(MenuBearbeiten);

		MenuItemEinstellungen = new JMenuItem("Einstellungen");
		MenuBar.add(MenuItemEinstellungen);

		TabbedPane = new JTabbedPane(JTabbedPane.TOP);
		Mframe.getContentPane().add(TabbedPane, "cell 0 0,grow");

		Panel = new JPanel();
		TabbedPane.addTab("Regal", null, Panel, null);
		Panel.setLayout(null);

		RegalTable = new JTable();
		RegalTable.setBounds(41, 48, 1012, 378);
		Panel.add(RegalTable);

		ButtonNeuFilament = new JButton("Neues Filament...");
		ButtonNeuFilament.setBounds(94, 450, 160, 29);
		Panel.add(ButtonNeuFilament);

		ButtonNeuPrint = new JButton("Neuer Print...");
//		ButtonNeuPrint.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		ButtonNeuPrint.setBounds(303, 450, 160, 29);
		Panel.add(ButtonNeuPrint);

		TabPrints = new JTabbedPane(JTabbedPane.TOP);
		TabbedPane.addTab("Prints", null, TabPrints, null);

		TabProjekte = new JTabbedPane(JTabbedPane.TOP);
		TabbedPane.addTab("Projekte", null, TabProjekte, null);

	}
}
