package sgbevisualproject.group020_visualproject_demo;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.List;


public class EndGame extends TheHexGame{

    public boolean checkWin(int player, int[][] board) {
        boolean[][] visited = new boolean[sizeOfGameBoard][sizeOfGameBoard];

        // Iterate over starting edge hexes for the player
        for (int i = 0; i < sizeOfGameBoard; i++) {
            if (board[player == 1 ? 0 : sizeOfGameBoard - 1][i] == player) { // Check appropriate starting edge
                if (dfs(i, player == 1 ? 0 : sizeOfGameBoard - 1, player, visited, board)) {
                    return true; // Winning path found!
                }
            }
        }
        return false; // No winning path for this player
    }

    private boolean dfs(int row, int col, int player, boolean[][] visited, int[][] board) {
        if (row < 0 || col < 0 || row >= sizeOfGameBoard || col >= sizeOfGameBoard || visited[row][col] || board[row][col] != player) {
            return false; // Out of bounds, visited, or not owned by the player
        }

        visited[row][col] = true;

        // Check if we've reached the winning edge
        if ((player == 1 && col == sizeOfGameBoard - 1) || (player == 2 && row == sizeOfGameBoard - 1)) {
            return true; // Reached the opposite side - WIN!
        }

        // Recursively explore neighbors (you'll need to adapt neighbor calculation based on your board structure)
        for (int[] neighbor : getNeighbors(row, col)) {
            if (dfs(neighbor[0], neighbor[1], player, visited, board)) {
                return true;
            }
        }

        return false;
    }

    private List<int[]> getNeighbors(int row, int col) {
        List<int[]> neighbors = new ArrayList<>();
        addNeighborIfValid(neighbors, row - 1, col);     // Top left
        addNeighborIfValid(neighbors, row - 1, col + 1); // Top right
        addNeighborIfValid(neighbors, row, col - 1);     // Left
        addNeighborIfValid(neighbors, row, col + 1);     // Right
        addNeighborIfValid(neighbors, row + 1, col);     // Bottom left
        addNeighborIfValid(neighbors, row + 1, col + 1); // Bottom right
        return neighbors;
    }

    private void addNeighborIfValid(List<int[]> neighbors, int row, int col) {
        if (row >= 0 && col >= 0 && row < sizeOfGameBoard && col < sizeOfGameBoard) {
            neighbors.add(new int[] { row, col });
        }
    }

    public void showWinner(int playerNo, Label[] labels) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Hex Game's Winner is.... ");
        if(playerNo == 1){
            alert.setHeaderText("Winner is Player 1 - Red ");
            alert.showAndWait().ifPresent(event -> {
                labels[3].setStyle("-fx-background-color: Red; -fx-padding: 5px; -fx-text-fill: White;");
                labels[3].setText("Winner-Red");
            });
        }
        if (playerNo == 2) {
            alert.setHeaderText("Winner Player 2 - Blue ");
            alert.showAndWait().ifPresent(event -> {
                labels[3].setStyle("-fx-background-color: Blue; -fx-padding: 5px; -fx-text-fill: White;");
                labels[3].setText("Winner-Blue");
            });
        }
    }

}
