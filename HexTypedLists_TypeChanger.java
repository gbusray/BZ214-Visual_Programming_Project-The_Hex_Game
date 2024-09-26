package sgbevisualproject.group020_visualproject_demo;

import java.util.ArrayList;

public class HexTypedLists_TypeChanger extends TheHexGame {

    /*
    //Bu method game board'daki bir değişiklik sonucu doğru çalışamaz hale gelmiştir.
    //Kullanılmadığından yorum satırına çevirip bıraktık sonra lazım olursa diye.

    public ArrayList<Hexagon> matrixToArray(Hexagon[][] hexagons){
        ArrayList<Hexagon> hexagonArrayList = new ArrayList<>();
        for (int row = 0; row < this.sizeOfGameBoard; row++) {
            for (int col = 0; col < this.sizeOfGameBoard; col++) {
                hexagonArrayList.set( 3*col + row, hexagons[col][row]);
            }
        }
        return hexagonArrayList;
    }
     */

    protected Hexagon[][] arrayToMatrix(ArrayList<Hexagon> hexagons)
    {
        Hexagon[][] hexagonsMatrix = new Hexagon[maxCol][maxRow];

        for (int i = 0; i < hexagons.size(); i++) {
            for (int row = 0; row < maxRow; row++) {
                for (int col = 0; col < maxCol; col++) {
                    hexagonsMatrix[col][row] = hexagons.get(i);
                }
            }
        }
        return  hexagonsMatrix;
    }
}
