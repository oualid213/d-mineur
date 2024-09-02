public class GameInformation {
    private int mineNumber;
    private int highestNumberOfMine;
    private int temps;
    private int score;
    private int highestScore;


    GameInformation(int mineNumber){
        this.mineNumber = mineNumber;
        this.highestNumberOfMine = mineNumber;
        this.temps = 0 ;
        this.score = 0;
        this.highestScore = 0;
    }


    public void decreaseMineNumber(int numberToSubtract) {
        if (this.mineNumber > 0){
            this.mineNumber = this.mineNumber - numberToSubtract;
        }
    }
    public boolean maxNumberOfMine(){
        return  mineNumber == highestNumberOfMine;
    }


    public int getMineNumber(){
        return this.mineNumber;
    }

}
