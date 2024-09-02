public class GameLoop {


    public void startGame(){
        GridBuilder showenGrid = new GridBuilder(new Coordinate(12,12));
        GridBuilder hiddenGrid = new GridBuilder(new Coordinate(12,12),10,30);
        GameInformation gameInformation = new GameInformation(5);
        Display display  = new Display(showenGrid,gameInformation);
        LoseWinHandler loseWin = new LoseWinHandler(true);
        UserInputHandler userInputHandler = new UserInputHandler(hiddenGrid,showenGrid,gameInformation,loseWin);
        do{
            hiddenGrid.showGrid();
            display.showMenu();
            userInputHandler.menuUserChoice(new Input().readInt(1,4));
            display.loseWinMessage(loseWin);
        }while(!loseWin.endOfGame());





    }
}
