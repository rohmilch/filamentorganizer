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

import net.miginfocom.swing.MigLayout;

public class MainWindow {

	private JFrame mframe;
	private JTable mtable_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.mframe.setVisible(true);
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
		mframe = new JFrame();
		mframe.setBounds(100, 100, 1148, 740);
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		mframe.setJMenuBar(menuBar);

		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);

		JMenuItem mntmNeuFilament = new JMenuItem("Neues Filament...");
		mnDatei.add(mntmNeuFilament);

		JMenuItem mntmNeuProjekt = new JMenuItem("Neues Projekt...");
		mnDatei.add(mntmNeuProjekt);

		JMenuItem mntmNeuPrint = new JMenuItem("Neuer Print...");
		mnDatei.add(mntmNeuPrint);

		JMenu mnBearbeiten = new JMenu("Bearbeiten");
		menuBar.add(mnBearbeiten);

		JMenuItem mntmEinstellungen = new JMenuItem("Einstellungen");
		menuBar.add(mntmEinstellungen);
		mframe.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mframe.getContentPane().add(tabbedPane, "cell 0 0,grow");

		JPanel panel = new JPanel();
		tabbedPane.addTab("Regal", null, panel, null);
		panel.setLayout(null);

		mtable_1 = new JTable();
		mtable_1.setBounds(41, 48, 1012, 378);
		panel.add(mtable_1);

		JButton btnNeuFilament = new JButton("Neues Filament...");
		btnNeuFilament.setBounds(94, 450, 160, 29);
		panel.add(btnNeuFilament);

		JButton btnNeuPrint = new JButton("Neuer Print...");
		btnNeuPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNeuPrint.setBounds(303, 450, 160, 29);
		panel.add(btnNeuPrint);

		JTabbedPane tabPrints = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Prints", null, tabPrints, null);

		JTabbedPane tabProjekte = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Projekte", null, tabProjekte, null);

	}
}
