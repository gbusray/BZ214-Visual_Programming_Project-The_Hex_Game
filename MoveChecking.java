package sgbevisualproject.group020_visualproject_demo;

import javafx.scene.control.Alert;
import javafx.scene.paint.Color;

public class  MoveChecking extends TheGameBoard{
    protected boolean moveCheck(Hexagon hexagon){ //written by Saliha İşgören
        boolean moveCheck =  false;
        if (overlap(hexagon))
            showWrongMove("Move conflicting!");
        else
            moveCheck = true;
        return moveCheck;
    }

    protected static void showWrongMove(String wrongMoveMessage) { //written by Saliha İşgören
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("WrongMessage");
        alert.setHeaderText(null);
        alert.setContentText(wrongMoveMessage);
        alert.showAndWait();
    }

    protected boolean overlap(Hexagon hexagon){ //written by Ece Cingöz
        if (hexagon.getFill() != Color.WHITE)
            return true; //it overlaps
        // else
        return false;
    }


}

