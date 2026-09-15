import java.util.Scanner;

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

    public static void readUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name, color, column, and row of the piece separated by commas only (PAWN,WHITE,E,1.");
        System.out.println("For the column enter as a single character ex: 'a' or 'b'");

        // split the user input into an array using commas, so each parameter is an item in the array
        String[] input = scan.nextLine().split(",");

        if(input.length == 4){
            PieceType piece = PieceType.valueOf(input[1].trim().toUpperCase());
            String color = input[1].trim().toUpperCase();
            String posXStr = input[2].trim().toLowerCase(); // save as string enum will convert to char
            locationX posX = locationX.valueOf(posXStr); // get the value of the char and save it to posX
            int posY = Integer.parseInt(input[3]); // cast straight into int

            switch (piece.ordinal()) {
                case 0:
                    King = new King()
                    break;
                case 1:
                    // do this
                    break;
                case 2:
                    // do this
                    break;
                case 3:
                    // do this
                    break;
                case 4:
                    // do this
                    break;
                case 5:
                    // do this
                    break;
                case 6:
                    // do this
                    break;
                default:
                    System.out.print("How did we get here?");
            }
        }
        else{
            System.out.println("Invalid input please try again");
        }
    }


    public static void main(String[] args) {
        System.out.println("Hello this is where we will run our code");
        Pawn p1 = new Pawn("pawn", "white", 'a', 1);
        System.out.println("Pawn: " + p1.color);
    }
}
