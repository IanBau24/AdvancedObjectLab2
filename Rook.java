public class Rook{
    private String pieceName="Bishop";
    private String color;
    private char col;
    private int row;

    Rook(String pieceName, String color, char col, int row){
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
  			// check if it moved in a striaght line along one axis
        if (this.col == new_posx || this.row == new_posy){
            if (this.col != new_posx || this.row != new_posy){ // check that only one axis changed
                return true;
            }
        }
        return false;
    }

    
}
