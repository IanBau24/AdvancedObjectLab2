import java.util.Scanner;
/**
 * main class. Parses a text file extracting the attributes of each chess piece per line
 * creates an array to hold newly created chess pieces
 * takes in input from the user, input is a target position to move the pieces
 * traverses the array and uses valid methods to check if each type of piece can move to target possition (assuming board is empty)
 * prints out message for each piece in the array dictating if the move is valid, does NOT move pieces to target position
 * 
 * @author Ian Bautista Ambriz, Ismael Renova, Ricardo Carranza
 * @version 1.0.0
 * @since 2026-09-01
 * 
 * Change Log:
 * 2026-09-14 - Set up the runner class and finalized the chessboard class
 *declared enumerated chess piece variables
 *wrote
 *wrote readUser method to initiate the user input loop
 * 2026-09-15 - Added the chess piece classes, cleaned up structure, added documentation, and tested the program's functionality
 *wrote verifyTarget methods for each class
 */
public class Runner {
    enum PieceType{
        KING,
        QUEEN,
        ROOK,
        BISHOP,
        KNIGHT,
        PAWN
    }
    
    enum locationX{
        a,b,c,d,e,f,g,h
    }

    // helper method to check if the position is the same
    public static boolean samePosition(char col, int row, char newCol, int newRow){
        return (col == newCol && row == newRow);
    }


    public static void readUser(){
        Scanner scan = new Scanner(System.in);
        boolean newPieceCreation = true;

        // loop to iterate until user decides to break
        while (newPieceCreation) {
            System.out.println("Enter the name, color, column, and row of the piece separated by commas only (PAWN,WHITE,e,1)");
            System.out.println("enter the column as a single character such as 'e' or 'h'");

            String[] input = scan.nextLine().split(","); // break input into array of parameters

            if (input.length != 4) {
                System.out.println("Invalid input, expected 4 values. Please try again.");
                continue; // run loop again from the top
            }

            // try catch to catch all bad input
            try {
                PieceType piece = PieceType.valueOf(input[0].trim().toUpperCase()); // use enum to list the chesspiece types
                String color = input[1].trim().toUpperCase();

                // handle wrong color
                if (!color.equals("WHITE") && !color.equals("BLACK")) {
                    System.out.println("Color must be WHITE or BLACK. Please try again.");
                    continue; // break out and loop again
                }


                char posX = input[2].trim().toLowerCase().charAt(0);
                int posY = Integer.parseInt(input[3].trim());

                // use chessboard class to check positions within bounds
                if (!Chessboard.withinChessboard(posX, posY)) { // need to create object to call method
                    System.out.println("Column must be a-h and row must be 1-8. Please try again.");
                    continue;
                }

                // input should be valid by this point so we can create piece objects
                switch (piece) {
                    case KING:
                        // create piece
                        King k = new King(piece.name(), color, posX, posY);

                        // handle logic for choosing position
                        boolean sameOriginalPosition = true;
                        while (sameOriginalPosition) {

                            // loop checks if position is valid
                            char targetCol = 0;
                            int targetRow = 0;
                            boolean targetValid = false;

                            while (!targetValid) {
                                System.out.println("Enter target column and row, comma separated ex: a,1");
                                String[] targetInput = scan.nextLine().split(",");

                                //more parameters than needed
                                if (targetInput.length != 2) {
                                    System.out.println("Invalid input, expected 2 values. Please try again.");
                                    continue;
                                }

                                // try catch to catch wrong input
                                try {
                                    targetCol = targetInput[0].trim().toLowerCase().charAt(0);
                                    targetRow = Integer.parseInt(targetInput[1].trim());
                                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                                    System.out.println("Invalid column/row format. Please try again.");
                                    continue; // to go the top of the look
                                } 

                                // reuse same chessboard method to check bounds
                                if (!Chessboard.withinChessboard(targetCol, targetRow)) {
                                    System.out.println("Column must be a-h and row must be 1-8. Please try again.");
                                    continue;
                                }

                                // use same position method to check if piece moved at all
                                if(samePosition(k.getColumn, k.getRow(), targetCol, targetRow)){
                                    System.out.println("Target must be different from current position. Please try again.");
                                    continue;
                                }
                                targetValid = true; // passed all checks, exit inner loop
                            }

                            // given a valid position use verifyTarget method to see if the piece can move to that position
                            if (k.verifyTarget(targetCol, targetRow)) {
                                System.out.println("Piece " + k.getPieceName() + " in position " + k.getColumn() + k.getRow()
                                        + " can move to target position " + targetCol + targetRow);
                            } else {
                                System.out.println("Piece " + k.getPieceName() + " in position " + k.getColumn() + k.getRow()
                                        + " cannot move to target position " + targetCol + targetRow);
                            }

                            // ask user if they wanna move the same piece to another position
                            System.out.println("Verify another target using the same original position? (y/n)");
                            String again = scan.nextLine().trim().toLowerCase();
                            sameOriginalPosition = again.equals("y"); // keep loop condition as true
                            // otherwise the loop will break and the user will have to select another piece
                        }
                        break;
                    case QUEEN:
                        Queen q = new Queen(piece.name(), color, posX, posY);
                        
                        // handle logic for choosing position
                        sameOriginalPosition = true;
                        while (sameOriginalPosition) {

                            // loop checks if position is valid
                            char targetCol = 0;
                            int targetRow = 0;
                            boolean targetValid = false;

                            while (!targetValid) {
                                System.out.println("Enter target column and row, comma separated ex: a,1");
                                String[] targetInput = scan.nextLine().split(",");

                                //more parameters than needed
                                if (targetInput.length != 2) {
                                    System.out.println("Invalid input, expected 2 values. Please try again.");
                                    continue;
                                }

                                // try catch to catch wrong input
                                try {
                                    targetCol = targetInput[0].trim().toLowerCase().charAt(0);
                                    targetRow = Integer.parseInt(targetInput[1].trim());
                                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                                    System.out.println("Invalid column/row format. Please try again.");
                                    continue; // to go the top of the look
                                } 

                                // reuse same chessboard method to check bounds
                                if (!Chessboard.withinChessboard(targetCol, targetRow)) {
                                    System.out.println("Column must be a-h and row must be 1-8. Please try again.");
                                    continue;
                                }

                                // use same position method to check if piece moved at all
                                if(samePosition(q.getColumn, q.getRow(), targetCol, targetRow)){
                                    System.out.println("Target must be different from current position. Please try again.");
                                    continue;
                                }
                                targetValid = true; // passed all checks, exit inner loop
                            }

                            // given a valid position use verifyTarget method to see if the piece can move to that position
                            if (q.verifyTarget(targetCol, targetRow)) {
                                System.out.println("Piece " + q.getPieceName() + " in position " + q.getColumn() + q.getRow()
                                        + " can move to target position " + targetCol + targetRow);
                            } else {
                                System.out.println("Piece " + q.getPieceName() + " in position " + q.getColumn() + q.getRow()
                                        + " cannot move to target position " + targetCol + targetRow);
                            }

                            // ask user if they wanna move the same piece to another position
                            System.out.println("Verify another target using the same original position? (y/n)");
                            String again = scan.nextLine().trim().toLowerCase();
                            sameOriginalPosition = again.equals("y"); // keep loop condition as true
                            // otherwise the loop will break and the user will have to select another piece
                        }
                        break;
                    case ROOK:
                        Rook r = new Rook(piece.name(), color, posX, posY);
                        
                        sameOriginalPosition = true;
                        while (sameOriginalPosition) {

                            char targetCol = 0;
                            int targetRow = 0;
                            boolean targetValid = false;

                            while (!targetValid) {
                                System.out.println("Enter target column and row, comma separated ex: a,1");
                                String[] targetInput = scan.nextLine().split(",");
                                if (targetInput.length != 2) {
                                    System.out.println("Invalid input, expected 2 values. Please try again.");
                                    continue;
                                }
                                try {
                                    targetCol = targetInput[0].trim().toLowerCase().charAt(0);
                                    targetRow = Integer.parseInt(targetInput[1].trim());
                                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                                    System.out.println("Invalid column/row format. Please try again.");
                                    continue;
                                } 
                                if (!Chessboard.withinChessboard(targetCol, targetRow)) {
                                    System.out.println("Column must be a-h and row must be 1-8. Please try again.");
                                    continue;
                                }
                                if(samePosition(t.getColumn, r.getRow(), targetCol, targetRow)){
                                    System.out.println("Target must be different from current position. Please try again.");
                                    continue;
                                }
                                targetValid = true;
                            }
                            if (r.verifyTarget(targetCol, targetRow)) {
                                System.out.println("Piece " + r.getPieceName() + " in position " + r.getColumn() + r.getRow()
                                        + " can move to target position " + targetCol + targetRow);
                            } else {
                                System.out.println("Piece " + r.getPieceName() + " in position " + r.getColumn() + r.getRow()
                                        + " cannot move to target position " + targetCol + targetRow);
                            }

                            System.out.println("Verify another target using the same original position? (y/n)");
                            String again = scan.nextLine().trim().toLowerCase();
                            sameOriginalPosition = again.equals("y");
                        }
                        break;
                    case BISHOP:
                        Bishop b = new Bishop(piece.name(), color, posX, posY);
                        
                        sameOriginalPosition = true;
                        while (sameOriginalPosition) {

                            char targetCol = 0;
                            int targetRow = 0;
                            boolean targetValid = false;

                            while (!targetValid) {
                                System.out.println("Enter target column and row, comma separated ex: a,1");
                                String[] targetInput = scan.nextLine().split(",");
                                if (targetInput.length != 2) {
                                    System.out.println("Invalid input, expected 2 values. Please try again.");
                                    continue;
                                }
                                try {
                                    targetCol = targetInput[0].trim().toLowerCase().charAt(0);
                                    targetRow = Integer.parseInt(targetInput[1].trim());
                                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                                    System.out.println("Invalid column/row format. Please try again.");
                                    continue;
                                } 
                                if (!Chessboard.withinChessboard(targetCol, targetRow)) {
                                    System.out.println("Column must be a-h and row must be 1-8. Please try again.");
                                    continue;
                                }
                                if(samePosition(b.getColumn, b.getRow(), targetCol, targetRow)){
                                    System.out.println("Target must be different from current position. Please try again.");
                                    continue;
                                }
                                targetValid = true;
                            }
                            if (b.verifyTarget(targetCol, targetRow)) {
                                System.out.println("Piece " + b.getPieceName() + " in position " + b.getColumn() + b.getRow()
                                        + " can move to target position " + targetCol + targetRow);
                            } else {
                                System.out.println("Piece " + b.getPieceName() + " in position " + b.getColumn() + b.getRow()
                                        + " cannot move to target position " + targetCol + targetRow);
                            }

                            System.out.println("Verify another target using the same original position? (y/n)");
                            String again = scan.nextLine().trim().toLowerCase();
                            sameOriginalPosition = again.equals("y");
                        }
                        break;
                    case KNIGHT:
                        Knight kn = new Knight(piece.name(), color, posX, posY);
                        
                        sameOriginalPosition = true;
                        while (sameOriginalPosition) {

                            char targetCol = 0;
                            int targetRow = 0;
                            boolean targetValid = false;

                            while (!targetValid) {
                                System.out.println("Enter target column and row, comma separated ex: a,1");
                                String[] targetInput = scan.nextLine().split(",");
                                if (targetInput.length != 2) {
                                    System.out.println("Invalid input, expected 2 values. Please try again.");
                                    continue;
                                }
                                try {
                                    targetCol = targetInput[0].trim().toLowerCase().charAt(0);
                                    targetRow = Integer.parseInt(targetInput[1].trim());
                                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                                    System.out.println("Invalid column/row format. Please try again.");
                                    continue;
                                } 
                                if (!Chessboard.withinChessboard(targetCol, targetRow)) {
                                    System.out.println("Column must be a-h and row must be 1-8. Please try again.");
                                    continue;
                                }
                                if(samePosition(kn.getColumn, kn.getRow(), targetCol, targetRow)){
                                    System.out.println("Target must be different from current position. Please try again.");
                                    continue;
                                }
                                targetValid = true;
                            }
                            if (kn.verifyTarget(targetCol, targetRow)) {
                                System.out.println("Piece " + kn.getPieceName() + " in position " + kn.getColumn() + kn.getRow()
                                        + " can move to target position " + targetCol + targetRow);
                            } else {
                                System.out.println("Piece " + kn.getPieceName() + " in position " + kn.getColumn() + kn.getRow()
                                        + " cannot move to target position " + targetCol + targetRow);
                            }

                            System.out.println("Verify another target using the same original position? (y/n)");
                            String again = scan.nextLine().trim().toLowerCase();
                            sameOriginalPosition = again.equals("y");
                        }
                        break;
                    case PAWN:
                        Pawn p = new Pawn(piece.name(), color, posX, posY);
                        
                        sameOriginalPosition = true;
                        while (sameOriginalPosition) {

                            char targetCol = 0;
                            int targetRow = 0;
                            boolean targetValid = false;

                            while (!targetValid) {
                                System.out.println("Enter target column and row, comma separated ex: a,1");
                                String[] targetInput = scan.nextLine().split(",");
                                if (targetInput.length != 2) {
                                    System.out.println("Invalid input, expected 2 values. Please try again.");
                                    continue;
                                }
                                try {
                                    targetCol = targetInput[0].trim().toLowerCase().charAt(0);
                                    targetRow = Integer.parseInt(targetInput[1].trim());
                                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                                    System.out.println("Invalid column/row format. Please try again.");
                                    continue;
                                } 
                                if (!Chessboard.withinChessboard(targetCol, targetRow)) {
                                    System.out.println("Column must be a-h and row must be 1-8. Please try again.");
                                    continue;
                                }
                                if(samePosition(p.getColumn, p.getRow(), targetCol, targetRow)){
                                    System.out.println("Target must be different from current position. Please try again.");
                                    continue;
                                }
                                targetValid = true;
                            }
                            if (p.verifyTarget(targetCol, targetRow)) {
                                System.out.println("Piece " + p.getPieceName() + " in position " + p.getColumn() + p.getRow()
                                        + " can move to target position " + targetCol + targetRow);
                            } else {
                                System.out.println("Piece " + p.getPieceName() + " in position " + p.getColumn() + p.getRow()
                                        + " cannot move to target position " + targetCol + targetRow);
                            }

                            System.out.println("Verify another target using the same original position? (y/n)");
                            String again = scan.nextLine().trim().toLowerCase();
                            sameOriginalPosition = again.equals("y");
                        }
                        break;
                }

            newPieceCreation = false; // swtich off piece creation and break out of the loop

            System.out.println("Select a different piece? (y/n)");
            String choosePiece = scan.nextLine().trim().toLowerCase();
            if (choosePiece.equals("y")) {
                newPieceCreation = true; // turn loop condition on and prompt to select a piece again
            }
            } catch (IllegalArgumentException e) {
                // catches invalid values
                System.out.println("Invalid piece name or row number. Please try again.");
            } catch (StringIndexOutOfBoundsException e) {
                // catches empty values
                System.out.println("Column must be a single letter a-h. Please try again.");
            }
        }
    }


    public static void main(String[] args) {
        readUser();
    }
}
