public class Knight {
    private String pieceName;
    private String color;
    private char col;
    private int row;

    Knight(String pieceName, String color, char col, int row){
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

    public void setColumn(char col){
        this.col=col;
    }

    public void setRow(int row){
        this.row=row;
    }
    
    public boolean verifyTarget(char newCol, int newRow){
        int x_diff = Math.abs(col-newCol);
        int y_diff = Math.abs(row-newRow);
        // knight can move if the differences are of 1 and 3 in either x-axis or y-axis respectively
        // by adding their differences all possible 1 and 3 combinations are checked
        return (x_diff + y_diff==3) && (Math.abs(y_diff-x_diff)==1);
    }
}
