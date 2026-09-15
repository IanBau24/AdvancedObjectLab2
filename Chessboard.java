
public class Chessboard {
    // leave the constatncs as static so they can be referenced inside of the method
    private static final int MAX_ROW = 8;
    private static final int MIN_ROW = 1;
    private static final char MIN_COL = 'a';
    private static final char MAX_COL = 'h';


    public static boolean withinChessboard(char col, int row){
        // col has char comparisson, row uses the constants
		return ((col<=MAX_COL && col>=MIN_COL) && (row>=MIN_ROW && row<=MAX_ROW));
    }
}
