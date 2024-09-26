package sgbevisualproject.group020_visualproject_demo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;

public class Hexagon extends Polygon {
    HexTypedLists_TypeChanger changer = new HexTypedLists_TypeChanger();

    public Hexagon(double x, double y, double radius) {
        final double angle = Math.PI / 3;
        for (int i = 0; i < 6; i++) {
            getPoints().add(x + radius * Math.cos(i * angle));
            getPoints().add(y + radius * Math.sin(i * angle));
        }
        setFill(Color.WHITE);
        setStroke(Color.BLACK);
    }

    public int getRow(ArrayList<Hexagon> hexagon, int index) {
        Hexagon[][] hexMatrixForRow = changer.arrayToMatrix(hexagon);
        int theRow = 0;
        for(int row = 0; row < changer.sizeOfGameBoard; row++)
            for(int col = 0; col < changer.sizeOfGameBoard; col++)
                if(hexMatrixForRow[col][row] == hexagon.get(index))
                    theRow = row;
        return theRow;
    }

    public int getCol(ArrayList<Hexagon> hexagon, int index) {
        Hexagon[][] hexMatrixForCol = changer.arrayToMatrix(hexagon);
        int theCol = 0;
        for(int row = 0; row < changer.sizeOfGameBoard; row++)
            for(int col = 0; col < changer.sizeOfGameBoard; col++)
                if(hexMatrixForCol[col][row] == hexagon.get(index))
                    theCol = col;
        return theCol;
    }


}
