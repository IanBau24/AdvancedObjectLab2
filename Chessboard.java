/**
 * Used for checking if a position is within the chessboard and holds bounds as attributes
 * 
 * @author Ian Bautista Ambriz, Ismael Renova, Ricardo Carranza
 * @version 1.0.0
 * @since 2026-09-14
 * 
 * Change Log:
 * 2026-09-14 - Set up class using the attributes indicated, wrote static withinChessboard method 
 */
public class Chessboard {
    // leave the constants as static so they can be referenced inside of the method
    private static final int MAX_ROW = 8;
    private static final int MIN_ROW = 1;
    private static final char MIN_COL = 'a';
    private static final char MAX_COL = 'h';

	// Returns true if a given position is valid. False otherwise.
    public static boolean withinChessboard(char col, int row){
        // col has char comparisson, row uses the constants
		return ((col<=MAX_COL && col>=MIN_COL) && (row>=MIN_ROW && row<=MAX_ROW));
    }
}
