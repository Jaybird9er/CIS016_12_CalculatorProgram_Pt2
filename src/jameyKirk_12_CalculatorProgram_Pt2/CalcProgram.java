// Author: Jamey Kirk
// Date: 12/2/2020
// Assignment: 12_CalculatorProgram
// Class: Java CIS 016

package jameyKirk_12_CalculatorProgram_Pt2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.lang.Math;

public class CalcProgram extends Application 
{
	boolean status;
	String firstNum = "";
	String secondNum = "";
	double dFirstNum;
	double dSecondNum;
	boolean firstPoint = false;
	boolean secondPoint = false;
	int operator;
	Label myLabel = new Label(Double.toString(0));

	public void calcAction(String btn)
	{
		// clear input and reset all numbers/number strings
		if(btn == "C")
		{
			myLabel.setText(Double.toString(0));
			firstNum = "";
			dFirstNum = 0;
			firstPoint = false;
			secondNum = "";
			dSecondNum = 0;
			secondPoint = false;
			status = false;
			return;
		}
		// get ^2 of 1st number
		else if(btn == "^2" && status == false)
		{
			dFirstNum *= dFirstNum;
			firstNum = Double.toString(dFirstNum);
			myLabel.setText(Double.toString(dFirstNum));
			// return statement needed to skip other if statements
			return;
		}
		// get ^2 of 2nd number
		else if(btn == "^2" && status == true)
		{
			dSecondNum *= dSecondNum;
			secondNum = Double.toString(dSecondNum);
			myLabel.setText(Double.toString(dSecondNum));
			return;
		}
		// get SQRT of 1st number
		else if(btn == "SQRT" && status == false)
		{
			dFirstNum = Math.pow(dFirstNum, 0.5);
			firstNum = Double.toString(dFirstNum);
			myLabel.setText(Double.toString(dFirstNum));
			// return statement needed to skip other if statements
			return;
		}
		// get SQRT of 2nd number
		else if(btn == "SQRT" && status == true)
		{
			dSecondNum = Math.pow(dSecondNum, 0.5);
			secondNum = Double.toString(dSecondNum);
			myLabel.setText(Double.toString(dSecondNum));
			return;
		}
		// operate on 2 values
		else if(btn == "+" || btn == "-" || btn == "x" || btn == "/" && status == false)
		{
			status = true;
			if(operator != '\0')
				return;
			else if(btn == "+")
				operator = 1;
			else if(btn == "-")
				operator = 2;
			else if(btn == "x")
				operator = 3;
			else if(btn == "/")
				operator = 4;
			return;
		}
		// calculate
		else if(btn == "=")
		{
			switch(operator)
			{
			case 1:
				dFirstNum += dSecondNum;
				myLabel.setText(Double.toString(dFirstNum));
				break;
			case 2:			
				dFirstNum -= dSecondNum;
				myLabel.setText(Double.toString(dFirstNum));
				break;
			case 3:
				dFirstNum *= dSecondNum;
				myLabel.setText(Double.toString(dFirstNum));
				break;
			case 4:
				dFirstNum /= dSecondNum;
				myLabel.setText(Double.toString(dFirstNum));
				break;
			default:
				break;
			}
			return;
		}
		// generate floats
		if(status == false)
		{
			// handle decimals ~ sort of
			if(btn == "." && firstPoint == false && firstNum == "")
			{
				firstPoint = true;
				firstNum = "0.";
				dFirstNum = 0.0;
				myLabel.setText(Double.toString(dFirstNum));
				return;
			}
			else if(btn == "." && firstPoint == true)
				return;
			// concatenates numbers
			firstNum += btn;
			dFirstNum = Double.parseDouble(firstNum);
			myLabel.setText(Double.toString(dFirstNum));
		}
		else
		{
			if(btn == "." && secondPoint == false)
			{
				secondPoint = true;
				secondNum = "0.";
				dSecondNum = 0.0;
				myLabel.setText(Double.toString(dSecondNum));
				return;
			}
			else if(btn == "." && secondPoint == true)
				return;
			secondNum += btn;
			dSecondNum = Double.parseDouble(secondNum);
			myLabel.setText(Double.toString(dSecondNum));
		} 
	}
	
	//String inputNum = new String();
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) throws Exception
	{
		
		double sum = 0;
		
		Pane pane = new Pane();
		
		// number pad
		// 0 button
		Button bt0 = new Button("0");
		bt0.setLayoutX(85);
		bt0.setLayoutY(260);
		bt0.setMinWidth(50);
		bt0.setOnAction(e -> calcAction("0"));
		pane.getChildren().add(bt0);

		// 1 button
		Button bt1 = new Button("1");
		bt1.setLayoutX(30);
		bt1.setLayoutY(225);
		bt1.setMinWidth(50);
		bt1.setOnAction(e -> calcAction("1"));
		pane.getChildren().add(bt1);
		
		// 2 button
		Button bt2 = new Button("2");
		bt2.setLayoutX(85);
		bt2.setLayoutY(225);
		bt2.setMinWidth(50);
		bt2.setOnAction(e -> calcAction("2"));
		pane.getChildren().add(bt2);
		
		// 3 button
		Button bt3 = new Button("3");
		bt3.setLayoutX(140);
		bt3.setLayoutY(225);
		bt3.setMinWidth(50);
		bt3.setOnAction(e -> calcAction("3"));
		pane.getChildren().add(bt3);

		// 4 button
		Button bt4 = new Button("4");
		bt4.setLayoutX(30);
		bt4.setLayoutY(190);
		bt4.setMinWidth(50);
		bt4.setOnAction(e -> calcAction("4"));
		pane.getChildren().add(bt4);
		
		// 5 button
		Button bt5 = new Button("5");
		bt5.setLayoutX(85);
		bt5.setLayoutY(190);
		bt5.setMinWidth(50);
		bt5.setOnAction(e -> calcAction("5"));
		pane.getChildren().add(bt5);
		
		// 6 button
		Button bt6 = new Button("6");
		bt6.setLayoutX(140);
		bt6.setLayoutY(190);
		bt6.setMinWidth(50);
		bt6.setOnAction(e -> calcAction("6"));
		pane.getChildren().add(bt6);
		
		// 7 button
		Button bt7 = new Button("7");
		bt7.setLayoutX(30);
		bt7.setLayoutY(155);
		bt7.setMinWidth(50);
		bt7.setOnAction(e -> calcAction("7"));
		pane.getChildren().add(bt7);
		
		// 8 button
		Button bt8 = new Button("8");
		bt8.setLayoutX(85);
		bt8.setLayoutY(155);
		bt8.setMinWidth(50);
		bt8.setOnAction(e -> calcAction("8"));
		pane.getChildren().add(bt8);
		
		// 9 button
		Button bt9 = new Button("9");
		bt9.setLayoutX(140);
		bt9.setLayoutY(155);
		bt9.setMinWidth(50);
		bt9.setOnAction(e -> calcAction("9"));
		pane.getChildren().add(bt9);

		// operators

		// / button 
		Button btDiv = new Button("/");
		btDiv.setLayoutX(195);
		btDiv.setLayoutY(155);
		btDiv.setMinWidth(50);
		btDiv.setOnAction(e -> calcAction("/"));
		pane.getChildren().add(btDiv);
		
		// x button (*)
		Button btMulti = new Button("x");
		btMulti.setLayoutX(195);
		btMulti.setLayoutY(190);
		btMulti.setMinWidth(50);
		btMulti.setOnAction(e -> calcAction("x"));
		pane.getChildren().add(btMulti);
				
		// - button
		Button btSubt = new Button("-");
		btSubt.setLayoutX(195);
		btSubt.setLayoutY(225);
		btSubt.setMinWidth(50);
		btSubt.setOnAction(e -> calcAction("-"));
		pane.getChildren().add(btSubt);

		// + button
		Button btAdd = new Button("+");
		btAdd.setLayoutX(195);
		btAdd.setLayoutY(260);
		btAdd.setMinWidth(50);
		btAdd.setOnAction(e -> calcAction("+"));
		pane.getChildren().add(btAdd);

		// = button
		Button btEq = new Button("=");
		btEq.setLayoutX(140);
		btEq.setLayoutY(260);
		btEq.setMinWidth(50);
		btEq.setOnAction(e -> calcAction("="));
		pane.getChildren().add(btEq);
		
		// extras
		// C button
		Button btClear = new Button("C");
		btClear.setLayoutX(195);
		btClear.setLayoutY(120);
		btClear.setMinWidth(50);
		btClear.setOnAction(e -> calcAction("C"));
		pane.getChildren().add(btClear);
		
		Button btSQ = new Button("^2");
		btSQ.setLayoutX(140);
		btSQ.setLayoutY(120);
		btSQ.setMinWidth(50);
		btSQ.setOnAction(e -> calcAction("^2"));
		pane.getChildren().add(btSQ);
		
		Button btSqrt = new Button("SQRT");
		btSqrt.setLayoutX(85);
		btSqrt.setLayoutY(120);
		btSqrt.setMinWidth(50);
		btSqrt.setOnAction(e -> calcAction("SQRT"));
		pane.getChildren().add(btSqrt);
		
		Button btDot = new Button(".");
		btDot.setLayoutX(30);
		btDot.setLayoutY(260);
		btDot.setMinWidth(50);
		btDot.setOnAction(e -> calcAction("."));
		pane.getChildren().add(btDot);
		
		myLabel.setFont(Font.font("Courier",FontWeight.BOLD,FontPosture.REGULAR,20));
		myLabel.setStyle("-fx-border-color: blue;");
		myLabel.setAlignment(Pos.BASELINE_RIGHT); // align text to the right side of the label.
		myLabel.setLayoutX(10);       // set the x location of the label
		myLabel.setLayoutY(10);       // set the y location of the label
		myLabel.setPrefSize(250, 20); // set the width and height of the label
		pane.getChildren().add(myLabel);

		
		Scene scene = new Scene(pane,280,300);
		primaryStage.setTitle("MyJavaFX"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	

	public static void main(String[] args)
	{
		launch(args);
	}
	
	
}
