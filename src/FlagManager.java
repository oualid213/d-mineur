import java.util.HashMap;
import java.util.Map;

public class FlagManager {
    private GridBuilder hiddenGrid;
    private GridBuilder showenGrid;
    private final char flagCharacter;
    private final char defaultCharacter;
    private GameInformation gameInformation;
    private Map<Integer, Runnable> actionMap;
    public FlagManager(GridBuilder hiddenGrid, GridBuilder showenGrid, char flagCharacter, GameInformation gameInformation) {
        this.hiddenGrid = hiddenGrid;
        this.showenGrid = showenGrid;
        this.flagCharacter = flagCharacter;
        this.defaultCharacter = 'o';
        this.gameInformation = gameInformation;
    }

    public void flagActionChoice(int choice){
        flagActions();
        Runnable actionToRun = actionMap.get(choice);
        if(actionToRun != null ){
            actionToRun.run();
        }else{
          System.out.println("map action error ! (FlagManager class)");
        }
    }

    private void flagActions(){

        actionMap = new HashMap<>();

        actionMap.put(1,this::addFlag);
        actionMap.put(2,this::removeFlag);
    }

    private void removeFlag() {
        if (!gameInformation.maxNumberOfMine()){
            Coordinate coordinate = new Input().IntegerCoordinate(new Input().readCoordinate());
            removeFlagInCell(coordinate);
        }else{
            System.out.println("You did not put your first flag !");
        }

    }

    private void addFlag() {
        Coordinate coordinate = new Input().IntegerCoordinate(new Input().readCoordinate());
        if(gameInformation.getMineNumber()>0){
            addFlagInCell(coordinate);
            gameInformation.decreaseMineNumber(1);
        }else{
            // a peaufiner
            System.out.println("you have put all your flags");

        }

    }



    private void addFlagInCell(Coordinate coordinate) {

        do {
            if (isValideCell(coordinate, true)) {
                showenGrid.setCell(coordinate, this.flagCharacter);
                break;
            } else {
                System.out.println("There is already a flag in this cell! Choose another one.");
                coordinate = new Input().IntegerCoordinate(new Input().readCoordinate());
            }
        } while (true);
    }

    private void removeFlagInCell(Coordinate coordinate){
            if (isValideCell(coordinate, false)) {
                showenGrid.setCell(coordinate, this.defaultCharacter);
            } else {
                System.out.println("There is no flag in this cell! Choose another one.");
            }
    }


    private boolean isValideCell(Coordinate coordinate, boolean addFunctionSelected) {
        if (addFunctionSelected){
            return showenGrid.getCell(coordinate) == defaultCharacter;
        }else{
            return showenGrid.getCell(coordinate) == flagCharacter;
        }
    }


}
