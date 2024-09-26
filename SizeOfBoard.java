package sgbevisualproject.group020_visualproject_demo;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class SizeOfBoard extends TheHexGame {

    protected RadioButton[] radioButtons(){
        RadioButton[] radioButtons = new RadioButton[3];
        radioButtons[0] = new RadioButton("5x5");
        radioButtons[1] = new RadioButton("7x7");
        radioButtons[2] = new RadioButton("11x11");
        radioButtons[0].setUserData(5);
        radioButtons[1].setUserData(7);
        radioButtons[2].setUserData(11);
        for (int i = 0; i < 3; i++) {
            radioButtons[i].setLayoutX(850);
            radioButtons[i].setLayoutY(60 + i * 20);
        }

        ToggleGroup radioButtonsGroup= new ToggleGroup();
        radioButtons[0].setToggleGroup(radioButtonsGroup);
        radioButtons[1].setToggleGroup(radioButtonsGroup);
        radioButtons[2].setToggleGroup(radioButtonsGroup);

        return radioButtons;
    }

    protected int size = 0;

    protected int theSizeOfGameBoard(RadioButton[] radioButtons){
        radioButtons[0].setOnAction(e -> {
            if(radioButtons[0].isSelected()) size = 5;
        });
        radioButtons[1].setOnAction(e -> {
            if(radioButtons[1].isSelected())size = 11;
        });
        radioButtons[2].setOnAction(e -> {
            if(radioButtons[2].isSelected())size = 17;
        });

        return size;
    }
}
