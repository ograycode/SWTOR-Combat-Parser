/**
 * 
 */
package org.SWTORparser.Gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * @author Jason Gray
 *
 */
public class MainController implements Initializable  {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private void buttonLogLocation(final ActionEvent event){
		System.out.println("Hello World");
	}

}
