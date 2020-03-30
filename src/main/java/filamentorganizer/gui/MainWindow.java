package filamentorganizer.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.Mframe.setVisible(true);
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

		JMenuBar MenuBar = new JMenuBar();
		Mframe.setJMenuBar(MenuBar);

		JMenu MenuDatei = new JMenu("Datei");
		MenuBar.add(MenuDatei);

		JMenuItem MenuItemNeuFilament = new JMenuItem("Neues Filament...");
		MenuDatei.add(MenuItemNeuFilament);

		JMenuItem MenuItemNeuProjekt = new JMenuItem("Neues Projekt...");
		MenuDatei.add(MenuItemNeuProjekt);

		JMenuItem MenuItemNeuPrint = new JMenuItem("Neuer Print...");
		MenuDatei.add(MenuItemNeuPrint);

		JMenu MenuBearbeiten = new JMenu("Bearbeiten");
		MenuBar.add(MenuBearbeiten);

		JMenuItem MenuItemEinstellungen = new JMenuItem("Einstellungen");
		MenuBar.add(MenuItemEinstellungen);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		Mframe.getContentPane().add(tabbedPane, "cell 0 0,grow");

		JPanel panel = new JPanel();
		tabbedPane.addTab("Regal", null, panel, null);
		panel.setLayout(null);

		RegalTable = new JTable();
		RegalTable.setBounds(41, 48, 1012, 378);
		panel.add(RegalTable);

		JButton ButtonNeuFilament = new JButton("Neues Filament...");
		ButtonNeuFilament.setBounds(94, 450, 160, 29);
		panel.add(ButtonNeuFilament);

		JButton ButtonNeuPrint = new JButton("Neuer Print...");
		ButtonNeuPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ButtonNeuPrint.setBounds(303, 450, 160, 29);
		panel.add(ButtonNeuPrint);

		JTabbedPane TabPrints = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Prints", null, TabPrints, null);

		JTabbedPane TabProjekte = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Projekte", null, TabProjekte, null);

	}
}
