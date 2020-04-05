
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage pPrimaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
//		String javaVersion = System.getProperty("java.version");
//		String javafxVersion = System.getProperty("javafx.version");
//		MainWindow4 l = new MainWindow4("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
		pPrimaryStage.setTitle("Filament");
		Scene scene = new Scene(root, 640, 480);
		pPrimaryStage.setScene(scene);
		pPrimaryStage.show();
	}

}
