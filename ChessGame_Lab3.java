import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ChessGame_Lab3 {

    private static Set<String> remainingPieces = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessPiece[] givenPieces = new ChessPiece[6];
        int counter = 0;

        // Initialize the set with all pieces
        remainingPieces.add("pawn");
        remainingPieces.add("rook");
        remainingPieces.add("knight");
        remainingPieces.add("bishop");
        remainingPieces.add("queen");
        remainingPieces.add("king");

        while (counter < 6) {
            System.out.println("Enter piece name (Pawn, Rook, Knight, Bishop, Queen, King):");
            String name = scanner.nextLine().trim();

            // Check if the piece has already been selected
            if (!checkPiece(name)) {
                continue;
            }

            Colors color = null;
        while (true) {
            System.out.println("Enter color (WHITE, BLACK):");
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                color = Colors.valueOf(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid color. Please enter WHITE or BLACK.");
            }
        }
            Columns currentX = null;
            int currentY = 0;

            // Loop until valid position
            while (true) {
                System.out.println("Enter column (A to H):");
                char colChar = scanner.nextLine().trim().charAt(0);
                System.out.println("Enter row (1 to 8):");
                currentY = scanner.nextInt();
                scanner.nextLine();
                currentX = Columns.fromChar(colChar);

                if (Chessboard.bounds(currentX, currentY)) {
                    break;
                } else {
                    System.out.println("Invalid position. Column a-h, row 1-8.");
                }

            // Create the piece using definePiece method
            ChessPiece piece = definePiece(name, color, currentX, currentY);

            givenPieces[counter] = piece;
            counter++;
        }

        // Prompt for target position
        Columns targetX = null;
        int targetY = 0;
        while (true) {
            System.out.println("Enter target column (A to H):");
            char colChar = scanner.nextLine().trim().charAt(0);
            System.out.println("Enter target row (1 to 8):");
            targetY = scanner.nextInt();
            scanner.nextLine();
            targetX = Columns.fromChar(colChar);
            if (Chessboard.bounds(targetX, targetY)) {
                break;
            } else {
                System.out.println("Invalid position. Column a-h, row 1-8.");
            }
        }

        // Check moves for each piece using normal for loop
        for (int i = 0; i < givenPieces.length; i++) {
            ChessPiece piece = givenPieces[i];
            if (piece.validMove(targetX, targetY)) {
                System.out.println(piece.getName() + " at " + piece.getCurrentX() + ", " + piece.getCurrentY() +
                        " can move to " + targetX + ", " + targetY);
            } else {
                System.out.println(piece.getName() + " at " + piece.getCurrentX() + ", " + piece.getCurrentY() +
                        " can NOT move to " + targetX + ", " + targetY);
            }
        }

        scanner.close();
    }
}

    // Method to create the correct ChessPiece object
    public static ChessPiece definePiece(String name, Colors color, Columns x, int y) {
        ChessPiece piece = null;
        switch (name.toLowerCase()) {
            case "pawn":
                piece = new Pawn(color, x, y);
                break;
            case "rook":
                piece = new Rook(color, x, y);
                break;
            case "knight":
                piece = new Knight(color, x, y);
                break;
            case "bishop":
                piece = new Bishop(color, x, y);
                break;
            case "queen":
                piece = new Queen(color, x, y);
                break;
            case "king":
                piece = new King(color, x, y);
                break;
            default:
                piece = null;
                System.out.println("Invalid piece type.");
        }
        return piece;
    }

    // Method to check if the piece has already been selected
    public static boolean checkPiece(String name) {
        name = name.toLowerCase();
        if (remainingPieces.contains(name)) {
            remainingPieces.remove(name);
            return true;
        } else {
            System.out.println("You already selected this piece, try again.");
            return false;
        }
    }



}
