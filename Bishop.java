public class Bishop{
    private String pieceName="Bishop";
    private String color;
    private char col;
    private int row;

    Bishop(String pieceName, String color, char col, int row){
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
    
    public boolean verifyTarget(char new_posx, int new_posy){
  			int x_diff = Math.abs(this.col - new_posx);
  			int y_diff = Math.abs(this.row - new_posy);
  			// bishop logic checks if the piece moved the same distance along the x and y positons, or a diagonal
  			if (x_diff == y_diff){
  				return true;
  			}
            return false;
    }

    
}
