package filamentorganizer.gui;

import javax.swing.JFrame;

public class FrontPage  {
	
    public JFrame frame;

    public FrontPage() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
