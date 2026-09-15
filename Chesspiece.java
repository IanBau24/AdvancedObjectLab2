

// in order to use the chesspiece method call it from another class in a nonstatic context
public class Chesspiece {
    // leave the constatncs as static so they can be referenced inside of the method
    private static final int MAX_ROW = 8;
    private static final int MIN_ROW = 1;


    public static boolean withinChessboard(char col, int row){
        // col has char comparisson, row uses the constants
		if ((col<='h' && col>='a') && (row>=MIN_ROW && row<=MAX_ROW)){
			return true;
		}
		return false;
    }
}
