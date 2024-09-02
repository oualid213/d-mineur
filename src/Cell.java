public class Cell {
    private char cellContent;
    private boolean thereIsTreasure;

    Cell(char cellContent, Boolean thereIsTreasure){
        this.cellContent = cellContent;
        this.thereIsTreasure = thereIsTreasure;
    }

    public char getCellContent(){
        return cellContent;
    }

    public void setCellContent(char cellContent){
        this.cellContent = cellContent;
    }
    public void setTreasureCell(boolean thereIsTreasure){
        this.thereIsTreasure = thereIsTreasure;
    }
}
