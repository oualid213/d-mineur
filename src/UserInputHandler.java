import java.util.HashMap;
import java.util.Map;

public class UserInputHandler {

    private GridBuilder hiddenGrid;
    private GridBuilder showenGrid;
    private GameInformation gameInformation;
    private LoseWinHandler loseWin;
    private Map<Integer, Runnable> actionMap;

    UserInputHandler(GridBuilder hiddenGrid, GridBuilder showenGrid, GameInformation gameInformation, LoseWinHandler loseWin){
        this.hiddenGrid = hiddenGrid;
        this.showenGrid = showenGrid;
        this.gameInformation = gameInformation;
        this.loseWin = loseWin;
    }
    public void menuUserChoice(int choice){
        menuActionDistribution();
        Runnable actionToPerform = actionMap.get(choice);
        if(actionToPerform !=null){
            actionToPerform.run();
        }else{
            System.out.println("HashMap choice error ! (UserInputHandler class) ");
        }
    }

    private void menuActionDistribution(){
        actionMap = new HashMap<>();

        actionMap.put(1, this:: flagManager);
        actionMap.put(2, this:: cellRevealer);
        actionMap.put(3, this:: scoreConsultation);
        actionMap.put(9, this:: quit);
    }

    private void quit() {
    }

    private void scoreConsultation() {
    }

    private void cellRevealer() {
        CellRevealer cellRevealer = new CellRevealer(hiddenGrid,showenGrid,loseWin);
        cellRevealer.runCellRevealer();

    }

    private void flagManager() {
        System.out.println("1- put flag ");
        System.out.println("2- remove flag");
        FlagManager flagManager = new FlagManager(this.hiddenGrid,this.showenGrid,'D',this.gameInformation);
        flagManager.flagActionChoice(new Input().readInt(1,2));
    }

    /*
    * pour que le joueur gagne une partie, il faut qu'il met tous les drapeaux et après continuer à découvrir les autres cases
    *   */


}
