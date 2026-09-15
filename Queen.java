public class Queen {
    private String pieceName; // left it as public to call it since directions didnt specify setter and getter for this
    String color;
    char col;
    int row;

    Queen(String pieceName, String color, char col, int row){
        this.pieceName = pieceName;
        this.color = color;
        this.col = col;
        this.row = row;
    }

    public String getPieceName(){
        return this.pieceName;
    }

    public char getColumn(){
        return this.col;
    }

    public int getRow(){
        return this.row;
    }

	public boolean verifyTarget(char newCol, int newRow){
        int x_diff = Math.abs(col - newCol);
        int y_diff = Math.abs(row - newRow);

        // check that the wueen only moved in one column or that it moved diagonally
        return (col == newCol || row == newRow || x_diff == y_diff);
    }
}
