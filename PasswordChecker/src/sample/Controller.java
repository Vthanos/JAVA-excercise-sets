package sample;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class Controller {
    public static int invalidTries=1;


    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public Button btn5;
    public Button btn6;
    public Button btn7;
    public Button btn8;
    public Button btn9;
    public Button btn0;
    public Button clearbtn;
    public Button enterbtn;
    public TextField text1;


    public void initialize(){
        ArrayList <String> nums=new ArrayList();
        for(int i = 0; i<10; i++){
            nums.add(String.valueOf(i));
        }

        Collections.shuffle(nums);
        System.out.println(nums);
        btn1.setText(nums.get(1));
        btn2.setText(nums.get(2));
        btn3.setText(nums.get(3));
        btn4.setText(nums.get(4));
        btn5.setText(nums.get(5));
        btn6.setText(nums.get(6));
        btn7.setText(nums.get(7));
        btn8.setText(nums.get(8));
        btn9.setText(nums.get(9));
        btn0.setText(nums.get(0));
    }

    public void type1(ActionEvent actionEvent) {

        text1.appendText(btn1.getText());

    }

    public void type2(ActionEvent actionEvent) {
        text1.appendText(btn2.getText());
    }

    public void type3(ActionEvent actionEvent) {
        text1.appendText(btn3.getText());
    }

    public void type4(ActionEvent actionEvent) {
        text1.appendText(btn4.getText());
    }

    public void type5(ActionEvent actionEvent) {
        text1.appendText(btn5.getText());
    }

    public void type6(ActionEvent actionEvent) {
        text1.appendText(btn6.getText());
    }

    public void type7(ActionEvent actionEvent) {
        text1.appendText(btn7.getText());
    }

    public void type8(ActionEvent actionEvent) {
        text1.appendText(btn8.getText());
    }

    public void type9(ActionEvent actionEvent) {
        text1.appendText(btn9.getText());
    }

    public void type0(ActionEvent actionEvent) {
        text1.appendText(btn0.getText());
    }


// clear method
    public void clear(ActionEvent actionEvent) {
            text1.clear();
    }

    public void enter(ActionEvent actionEvent) {
        try {


            BufferedReader in = new BufferedReader(new FileReader("src/sample/password.txt"));
            String line;
            if((line = in.readLine()) == null)
            {
                throw new IOException();
            }
            in.close();
            if (line.equals(text1.getText())){
                JOptionPane.showMessageDialog(null,"Correct Password");
            }

            else if(invalidTries==3){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setContentText("Counted three mistakes");
                alert.showAndWait();
                Platform.exit();
                System.exit(0);
            }
            else{
                invalidTries++;

                JOptionPane.showMessageDialog(null,"Wrong password "+(invalidTries-1)+"/3 Tries");
            }


        }catch (FileNotFoundException fne ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("File Not Found");
            alert.showAndWait();
        }
        catch (IOException ioe){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("The Specified File does not contain a Password ");
            alert.showAndWait();
        }

    }

}
