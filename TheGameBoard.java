package sgbevisualproject.group020_visualproject_demo;


import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;

public class TheGameBoard extends TheHexGame {
    int playersTurn = 0;

    protected ArrayList<Hexagon> theGameBoard(int sizeOfTheGameBoard, Label[] labels, Label labelPlayer) {
        MoveChecking moveChecking = new MoveChecking();
        Move move = new Move();
        EndGame endGame = new EndGame();

        ArrayList<Hexagon> hexagonsArray = new ArrayList<>();
        final double hexSize = 30; // Altıgen boyutu
        final double startX = 50; // Başlangıçtaki X koordinatı
        final double startY = 50; // Başlangıçtaki Y koordinatı
        double x = 0;
        double y = 0;

        // Create the game board
        for (int row = 0; row < sizeOfTheGameBoard; row++) {
            for (int col = 0; col < sizeOfTheGameBoard; col++) {
                x = startX + col * hexSize * Math.sqrt(3);
                y = startY + row * hexSize * 3 / 2;
                if (row != 0)
                    x += row* hexSize * Math.sqrt(3) * 0.5;
                Hexagon hexagon = new Hexagon(x, y, hexSize);
                hexagon.getTransforms().add(new Rotate(90,x,y));
                hexagonsArray.add(hexagon);

                //gameLoop for
                var ref = new Object() {
                    int index = 0;
                };
                try {
                    hexagon.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                        if(moveChecking.moveCheck(hexagon)) {
                            int player = (playersTurn + 1) % 2; // Determine the current player
                            move.move(hexagon, labelPlayer, hexagon.getCol(hexagonsArray, ref.index), hexagon.getRow(hexagonsArray, ref.index));
                            playersHexMatrix[hexagon.getRow(hexagonsArray, ref.index)][hexagon.getCol(hexagonsArray, ref.index)] = player + 1; // Update playersHexMatrix
                            playersTurn = player; // Switch to the next playerplayersTurn++;
                            mouseEvent.consume();
                            // Check for win condition after each move
                            if (endGame.checkWin(player, playersHexMatrix)) {
                                endGame.showWinner(player, labels);
                                System.out.println(player + "wins!");
                            }
                        }
                    });
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return hexagonsArray;
    }

}