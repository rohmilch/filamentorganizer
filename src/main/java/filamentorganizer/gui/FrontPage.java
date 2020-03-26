package filamentorganizer.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JTextField;

public class FrontPage  {
	
    private JFrame mWindow;

    public FrontPage() {
        initialize();
    }

    private void initialize() {
    	mWindow = new JFrame();
    	mWindow.setBounds(100, 100, 450, 300);
    	mWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton btnAddNewFilament = new JButton("Add new filament");
        mWindow.getContentPane().add(btnAddNewFilament, BorderLayout.WEST);
        
        JList listAllFilaments = new JList();
        mWindow.getContentPane().add(listAllFilaments, BorderLayout.CENTER);
    }

	public JFrame getWindow() {
		return mWindow;
	}
}
