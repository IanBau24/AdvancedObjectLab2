
public class Pawn {
    private String pieceName="Pawn"; // left it as public to call it since directions didnt specify setter and getter for this
    private String color;
    private char col;
    private int row;

    Pawn(String pieceName, String color, char col, int row){
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
        // handle case where pawn is white and moves "up" the board, x position remains the same and y position should be one higher
        if(piece.color.equals("white")){
            if(this.col == new_posx && (this.row + 1) == new_posy){
                return true;
            }
            return false;
        }
        if(piece.color.equals("black")){
            if(this.col == new_posx && (this.row - 1) == new_posy){
                return true;
            }
            return false;
        }	
    }
}
