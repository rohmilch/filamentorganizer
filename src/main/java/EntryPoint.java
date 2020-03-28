import java.util.ArrayList;
import java.util.List;

import filamentorganizer.binder.Controller;
import filamentorganizer.gui.View;
import filamentorganizer.logik.FilamentSpool;
import filamentorganizer.logik.Shelf;

public class EntryPoint {

	 public static void main(String[] args) {
	        try {
	            View lWindow = new View();
	            Shelf lShelf = new Shelf(new ArrayList<FilamentSpool>());
	        	Controller lHandler = new Controller(lWindow, lShelf);
	        	
	        	lWindow.getWindow().setVisible(true);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
