
public class Pawn {
    public String pieceName; // left it as public to call it since directions didnt specify setter and getter for this
    String color;
    char col;
    int row;

    Pawn(String pieceName, String color, char col, int row){
        this.pieceName = pieceName;
        this.color = color;
        this.col = col;
        this.row = row;
    }
}
