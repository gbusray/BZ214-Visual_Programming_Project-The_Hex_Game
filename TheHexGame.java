package sgbevisualproject.group020_visualproject_demo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class TheHexGame extends Application {
    Pane root = new Pane();

    Supplies supplies = new Supplies(); //to increase readibility it keeps labels' details
    public int sizeOfGameBoard; //variable that keeps board size
    int maxCol = sizeOfGameBoard;
    int maxRow = sizeOfGameBoard;
    int[][] playersHexMatrix = new int[maxCol][maxRow]; // keeps players numbers according to moves

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(root, 1111, 650); // defining scene
        HexTypedLists_TypeChanger listTypeChanger = new HexTypedLists_TypeChanger(); //call the class that has the list's type changing methods

        // for make movecheck method in movechecking class truly at start we set all indexs "0"
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                playersHexMatrix[col][row] = 0;
            }
        }

        //calling the Start Button class & defining a Start Button
        StartButton startButtonClass = new StartButton();
        Button startButton = startButtonClass.startButton();
        Text startText = startButtonClass.startMessage(); //the text which informs player about game starts

        //calling the RadioButton class & defining a RadioButton list
        SizeOfBoard sizeOfBoardClass = new SizeOfBoard();
        RadioButton[] radioButtons = sizeOfBoardClass.radioButtons();
        sizeOfGameBoard = sizeOfBoardClass.theSizeOfGameBoard(radioButtons);
        Button setSizeButton = supplies.setSize();
        for (int i = 0; i < 3; i++) {
            root.getChildren().add(radioButtons[i]);
        }

        //defining labels
        Label[] labels = supplies.labels();
        Label labelPlayer = labels[2];

        // calling CreateTheGameBoard class and keeping the gameboard
        TheGameBoard theGameBoard = new TheGameBoard();
        ArrayList<Hexagon> hexagonsArray = new ArrayList<>();

        //setting the game board size & creating the gameBoard
        setSizeButton.setOnAction(actionEvent -> {
            if(radioButtons[0].isSelected())
                sizeOfGameBoard = 5;
            if(radioButtons[1].isSelected())
                sizeOfGameBoard= 7;
            if(radioButtons[2].isSelected())
                sizeOfGameBoard = 11;
            setSizeButton.setStyle("-fx-background-color: #6600cc   ; -fx-text-fill: White;");
            hexagonsArray.addAll(theGameBoard.theGameBoard(sizeOfGameBoard, labels, labelPlayer));
        });
        root.getChildren().add(setSizeButton);

        //start button's actions
        startButton.setOnAction(actionEvent -> {
            root.getChildren().add(startText);
            labelPlayer.setStyle("-fx-background-color: Red; -fx-padding: 5px; -fx-text-fill: White;");
            labelPlayer.setText("Player 1");
            startButton.setStyle("-fx-background-color: #00ff00");
            root.getChildren().addAll(hexagonsArray);
        });

        //adding start button to screen
        root.getChildren().add(startButton);

        // adding labels to screen
        labels[2] = labelPlayer;
        for(int i = 0; i < 4; i++){
            root.getChildren().add(labels[i]);
        }

        //setting the scene
        stage.setTitle("The Hex Game");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
