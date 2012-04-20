/**
 * 
 */
package org.SWTORparser.Gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;  
import javafx.scene.Parent;  
import javafx.scene.Scene;  
import javafx.stage.Stage;  

/**
 * @author Jason Gray
 * 
 */
public class Main extends Application {
	/**
	 * Main function for running this application.
	 * 
	 * @param arguments
	 *            Command-line arguments: none expected.
	 */
	public static void main(String[] arguments) {
		Application.launch(arguments);
	}

	/**
	 * Overridden Application.start(Stage) method.
	 * 
	 * @param stage
	 *            Primary stage.
	 * @throws Exception
	 *             JavaFX application exception.
	 */
	@Override
	public void start(final Stage stage) throws Exception {
		final Parent fxmlRoot = FXMLLoader.load(getClass().getResource(
				"mainGUI.fxml"));
		stage.setScene(new Scene(fxmlRoot));
		stage.show();
	}
}