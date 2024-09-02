public class LoseWinHandler {


    private boolean gameStat;
    private boolean gameWon;

    LoseWinHandler(boolean gameStat){
        this.gameStat = gameStat;
        this.gameWon = false;
    }

    public void setGameStat(boolean gameStat) {
        this.gameStat = gameStat;
    }
    public boolean getGameStat(){
        return this.gameStat;
    }


    public void setGameWon(boolean gameWon){
        this.gameWon = gameWon;
    }
    public boolean endOfGame(){
        return !gameStat  || gameWon;
    }


}
