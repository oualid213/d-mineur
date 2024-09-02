import java.nio.charset.CoderResult;
import java.util.Random;

public class GridBuilder {


    private Coordinate coordinate;
    private Grid grid;



    GridBuilder(Coordinate coordinate, int mineNumber, int treasureNumber){
        this.coordinate = coordinate;
        this.grid = new Grid(coordinate);
        buildGrid( mineNumber,  treasureNumber);
    }

    //construction d'une grille sans rien

    GridBuilder(Coordinate coordinate){
        this.coordinate = coordinate;
        this.grid = new Grid(coordinate);
        initializeGrid();
    }


    private void buildGrid(int mineNumber, int treasureNumber){
        initializeGrid();
        minePlacer(mineNumber);
        treasurePlacer(treasureNumber);
        cellStuckToTheMines();
    }

    private void initializeGrid(){
        for (int i = 0 ; i< this.coordinate.getRow() ; i++){
            for (int j = 0 ; j< coordinate.getCol() ; j++){
                this.grid.setCell(new Coordinate(i,j),'o');
            }
        }
    }

    private void minePlacer(int mineNumber){
        Coordinate coordinate;

        Random rd = new Random();


        for (int i = 0 ; i < mineNumber ; i++){
            do {
                coordinate = new Coordinate(rd.nextInt(this.coordinate.getRow()),rd.nextInt(this.coordinate.getCol()));
            }while(grid.getCell(coordinate).getCellContent() != 'o');
            grid.getCell(coordinate).setCellContent('*');
        }
    }

    private void treasurePlacer(int treasureNumber){
        Coordinate coordinate;
        Random rd = new Random();


        for (int i = 0 ; i < treasureNumber ; i++){
            do {
                 coordinate = new Coordinate(rd.nextInt(this.coordinate.getRow()),rd.nextInt(this.coordinate.getCol()));
            }while(grid.getCell(coordinate).getCellContent() != 'o');
            grid.getCell(coordinate).setTreasureCell(true);
        }
    }
    public void showGrid() {
        System.out.println("   1 2 3 4 5 6 7 8 9 A B C");
        System.out.println("   =======================");

        for (int i = 0; i < this.coordinate.getRow(); ++i) {
            char rowLabel = (char) ('A' + i);
            System.out.print(rowLabel + "| ");

            for (int j = 0; j < this.coordinate.getRow(); ++j) {
                System.out.print(this.grid.getCell(new Coordinate(i,j)).getCellContent() + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }

    public char getCell(Coordinate coordinate){
      return   grid.getCell(coordinate).getCellContent();
    }
    public void setCell(Coordinate coordinate, char character){
        grid.getCell(coordinate).setCellContent(character);
    }

    private void cellStuckToTheMines() {
        for (int i = 0; i < coordinate.getRow(); i++) {
            for (int j = 0; j < coordinate.getCol(); j++) {
                int numberOfMines = 0;
                if (grid.getCell(new Coordinate(i, j)).getCellContent() != '*') {
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            int neighborX = i + k;
                            int neighborY = j + l;
                            if (isValideCell( neighborX, neighborY)) {
                                if (grid.getCell(new Coordinate(neighborX, neighborY)).getCellContent() == '*') {
                                    numberOfMines++;
                                }
                            }
                        }
                    }
                    if(numberOfMines>0){
                        grid.getCell(new Coordinate(i, j)).setCellContent((char) ('0' + numberOfMines));
                    }
                }
            }
        }
    }

//    public boolean allCellsHaveBeenDiscovered(){
//
//    }


    public boolean isValideCell(int neighborX,int neighborY){
        return neighborX >= 0 && neighborX < coordinate.getRow() && neighborY >= 0 && neighborY < coordinate.getCol();
    }



}
