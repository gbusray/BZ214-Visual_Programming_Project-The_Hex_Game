package sgbevisualproject.group020_visualproject_demo;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Supplies {

    protected Button setSize(){
        Button btn = new Button("Set Size Of GameBoard");
        btn.setFont(Font.font(15));
        btn.setLayoutY(135);
        btn.setLayoutX(850);
        return btn;
    }

    protected Label[] labels(){
        Label[] labels = new Label[4];
        labels[0] = new Label();
        labels[1] = new Label();
        labels[2] = new Label("Player");
        labels[3] = new Label(""); //label Winner

        for (int i = 0; i < 4; i++) {
            labels[i].setLayoutX(850);
        }

        labels[0].setText("If you do not choose a size,");
        labels[0].setLayoutY(25);

        labels[1].setText("there is no game!");
        labels[1].setLayoutY(40);

        labels[2].setLayoutY(180);
        labels[2].setStyle("-fx-background-color: Black; -fx-text-fill: White ; -fx-padding: 5px");

        labels[3].setLayoutY(270);
        labels[3].setStyle("-fx-padding: 5px");

        return labels;
    }


}
