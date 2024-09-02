public class Display {
    private GridBuilder gridBuilder;
    private GameInformation gameInformation;

    Display(GridBuilder gridBuilder, GameInformation gameInformation ){
        this.gridBuilder = gridBuilder;
        this.gameInformation = gameInformation;
    }


    public void showMenu() {
        System.out.println("SCORE: " + 0 + " HIGHEST: " + 0 );
        System.out.println("TIME: " + 0);
        System.out.println("Il reste " + gameInformation.getMineNumber() + " mines à découvrir !");

       gridBuilder.showGrid();

        System.out.println("1 – Placer / Supprimer un drapeau");
        System.out.println("2 – Découvrir une case");
        System.out.println("3 – Consulter les SCORES");
        System.out.println("9 - Quitter");
    }

    public void loseWinMessage(LoseWinHandler loseWinHandler){
        if (!loseWinHandler.getGameStat()){
            System.out.println("you lose !");
        }
    }

}
