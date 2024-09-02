import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CellRevealer {

    private LoseWinHandler loseWin;
    private GridBuilder hiddenGrid;
    private GridBuilder showenGrid;
    private Map<Integer, Runnable> actionMap;
    private Coordinate coordinate;
    CellRevealer(GridBuilder hiddenGrid,GridBuilder showenGrid,  LoseWinHandler loseWin){
        this.loseWin = loseWin;
        this.hiddenGrid = hiddenGrid;
        this.showenGrid = showenGrid;
    }

    public void runCellRevealer(){
        this.coordinate = new Input().IntegerCoordinate(new Input().readCoordinate());

        if (userLose(coordinate)){
            uniqCellActionChoice(1);
        }else if(isEmptyCell(coordinate)){

            uniqCellActionChoice(2);
        }else{
            uniqCellActionChoice(3);
        }

    }


    private void uniqCellActionChoice(int choice){
        cellActionChoices();
        Runnable actionToRun = actionMap.get(choice);
        if (actionToRun != null){
            actionToRun.run();
        }else{
            System.out.println("map action error ! (CellRevealer class)");
        }
    }

    private void cellActionChoices(){
        actionMap = new HashMap<>();

        actionMap.put(1,this::gameLost);
        actionMap.put(2,this::emptyCell);
        actionMap.put(3,this::numberCell);
    }

    private void numberCell() {
        showenGrid.setCell(coordinate,hiddenGrid.getCell(coordinate));
    }


    private void emptyCell() {
        recursiveEmptyCellReveler(this.coordinate);
    }
    private void recursiveEmptyCellReveler(Coordinate coordinate) {

        if (hiddenGrid.getCell(coordinate) != 'o' || hiddenGrid.getCell(coordinate) == '*') {
            showenGrid.setCell(coordinate,hiddenGrid.getCell(coordinate));
            return;
        }

        hiddenGrid.setCell(coordinate, ' ');
        showenGrid.setCell(coordinate,' ');

        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                int neighborX = coordinate.getRow() + k;
                int neighborY = coordinate.getCol() + l;

                if (hiddenGrid.isValideCell(neighborX, neighborY)) {
                    recursiveEmptyCellReveler(new Coordinate(neighborX, neighborY));
                }
            }
        }
    }

    private void gameLost() {
        this.loseWin.setGameStat(false);
    }
    private boolean userLose(Coordinate coordinate){
        return hiddenGrid.getCell(coordinate) == '*';
    }
    private boolean isEmptyCell(Coordinate coordinate){
        return hiddenGrid.getCell(coordinate) == 'o';
    }

}
