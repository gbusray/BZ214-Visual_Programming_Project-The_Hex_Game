package sgbevisualproject.group020_visualproject_demo;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Move extends TheGameBoard{
    MoveChecking moveChecking = new MoveChecking();
    int playerTurn = 0;

    protected void move (Hexagon hex, Label lblPlayer, int hexCol, int hexRow){
        if (playerTurn%2 == 0) {
            playerTurn++;
            hex.setFill(Color.RED);
            lblPlayer.setText("Player 2");
            lblPlayer.setStyle("-fx-background-color: #0000ff; -fx-padding: 5px; -fx-text-fill: White;");
            playersHexMatrix[hexCol][hexRow] = 1;
        } else if(playerTurn%2 != 0){
            playerTurn++;
            hex.setFill(Color.BLUE);
            lblPlayer.setText("Player 1");
            lblPlayer.setStyle("-fx-background-color: Red; -fx-padding: 5px; -fx-text-fill: White;");
            playersHexMatrix[hexCol][hexRow] = 2;
        }
    }
}

