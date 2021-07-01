package sample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Scanner;

public class Chessboard extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();
        Scanner board = new Scanner(System.in);

          int size =8 ;

        System.out.println("default size of the board is 8, do you want to change it , type yes if so ");
        Scanner nonDeaf =  new Scanner(System.in);
        String nd = nonDeaf.nextLine();
        if (nd.equalsIgnoreCase("Yes")){
            do {
                System.out.println("Type the size of the board, sizes must be a multiplicand of 2");
                size = board.nextInt();

            }while ((size>=2)&&(size<=16)&&(size%2!=0));
        }


        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col ++) {
                StackPane square = new StackPane();
                String color ;
                if ((row + col) % 2 == 0) {
                    color = "white";
                } else {
                    color = "black";
                }
                square.setStyle("-fx-background-color: "+color+";");
                root.add(square, col, row);



            }
        }


        for (int i = 0; i < size; i++) {
            root.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            root.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
            

        }

        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}