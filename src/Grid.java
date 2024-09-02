import java.util.Scanner;

public class Grid {


   private Cell[][] grid ;
   private Coordinate matrixSize;


   Grid(Coordinate matrixSize){
       this.matrixSize = matrixSize;
       this.grid = new Cell[matrixSize.getRow()][matrixSize.getCol()] ;
       gridInitialization();
   }


   public Cell getCell(Coordinate coordinate){
       return grid[coordinate.getRow()][coordinate.getCol()];
   }

   public void setCell(Coordinate coordinate, char car){
         grid[coordinate.getRow()][coordinate.getCol()].setCellContent(car);
   }

   private void gridInitialization(){
        for(int i = 0; i<matrixSize.getRow(); i++){
            for (int j = 0; j< matrixSize.getCol(); j++){
                grid[i][j] = new Cell(' ',false);
            }
        }
    }

}
