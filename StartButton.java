package sgbevisualproject.group020_visualproject_demo;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartButton extends TheHexGame {
    protected Button startButton(){
        Button btn = new Button("Start Button");
        btn.setOnAction(actionEvent -> {
            root.getChildren().add(new Text("Hex Game Begins!"));
        });
        btn.setFont(Font.font(15));
        btn.setLayoutY(220);
        btn.setLayoutX(850);
        return btn;
    }

    protected Text startMessage (){
        Text start = new Text("Hex Game Begins!");
        start.setLayoutY(262);
        start.setLayoutX(850);
        return start;
    }

}


