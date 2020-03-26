import filamentorganizer.gui.FrontPage;

public class EntryPoint {

	 public static void main(String[] args) {
	        try {
	            FrontPage window = new FrontPage();
	            window.getWindow().setVisible(true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
