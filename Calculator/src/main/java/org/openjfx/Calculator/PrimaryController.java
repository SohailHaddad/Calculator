/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */

package org.openjfx.Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {
	
    String str = "";
    @FXML // fx:id="text"
    private TextField text; // Value injected by FXMLLoader

    @FXML // fx:id="num1"
    private Button num1; // Value injected by FXMLLoader

    @FXML // fx:id="num6"
    private Button num6; // Value injected by FXMLLoader

    @FXML // fx:id="num2"
    private Button num2; // Value injected by FXMLLoader

    @FXML // fx:id="num3"
    private Button num3; // Value injected by FXMLLoader

    @FXML // fx:id="num7"
    private Button num7; // Value injected by FXMLLoader

    @FXML // fx:id="num8"
    private Button num8; // Value injected by FXMLLoader

    @FXML // fx:id="num5"
    private Button num5; // Value injected by FXMLLoader

    @FXML // fx:id="num9"
    private Button num9; // Value injected by FXMLLoader

    @FXML // fx:id="plus"
    private Button plus; // Value injected by FXMLLoader

    @FXML // fx:id="close"
    private Button close; // Value injected by FXMLLoader

    @FXML // fx:id="num0"
    private Button num0; // Value injected by FXMLLoader

    @FXML // fx:id="open"
    private Button open; // Value injected by FXMLLoader

    @FXML // fx:id="num4"
    private Button num4; // Value injected by FXMLLoader

    @FXML // fx:id="sub"
    private Button sub; // Value injected by FXMLLoader

    @FXML // fx:id="mul"
    private Button mul; // Value injected by FXMLLoader

    @FXML // fx:id="div"
    private Button div; // Value injected by FXMLLoader

    @FXML // fx:id="clear"
    private Button clear; // Value injected by FXMLLoader

    @FXML // fx:id="equal"
    private Button equal; // Value injected by FXMLLoader
    
    @FXML // fx:id="nekoda"
    private Button nekoda; // Value injected by FXMLLoader

    @FXML
    void clear(ActionEvent event) {
      str="";
      text.setText("");
    }

    @FXML
    void close(ActionEvent event) {
    	str+=')';
   	    text.setText(str);
    }

    @FXML
    void div(ActionEvent event) {
    	str+='/';
    	text.setText(str);
    }

    @FXML
    void equal(ActionEvent event) {
        double num = ArithmeticApp.startCalc(str);
        String txt = String.valueOf(num);
        text.setText(txt);
    }

    @FXML
    void mul(ActionEvent event) {
    	str+='*';
    	text.setText(str);
    }
    
    @FXML
    void nekoda(ActionEvent event) {
    	str+='.';
    	text.setText(str);
    }

    @FXML
    void num0(ActionEvent event) {
    	str+='0';
    	text.setText(str);
    }

    @FXML
    void num1(ActionEvent event) {
    	str+='1';
    	text.setText(str);
    }

    @FXML
    void num2(ActionEvent event) {
    	str+='2';
    	text.setText(str);
    }

    @FXML
    void num3(ActionEvent event) {
    	str+='3';
    	text.setText(str);
    }

    @FXML
    void num4(ActionEvent event) {
    	str+='4';
    	text.setText(str);
    }

    @FXML
    void num5(ActionEvent event) {
    	str+='5';
    	text.setText(str);
    }

    @FXML
    void num6(ActionEvent event) {
    	str+='6';
    	text.setText(str);
    }

    @FXML
    void num7(ActionEvent event) {
    	str+='7';
    	text.setText(str);
    }

    @FXML
    void num8(ActionEvent event) {
    	str+='8';
    	text.setText(str);
    }

    @FXML
    void num9(ActionEvent event) {
    	str+='9';
    	text.setText(str);
    }

    @FXML
    void open(ActionEvent event) {
    	str+='(';
    	text.setText(str);
    }

    @FXML
    void plus(ActionEvent event) {
    	str+='+';
    	text.setText(str);
    }

    @FXML
    void sub(ActionEvent event) {
    	str+='-';
    	text.setText(str);
    }

}
