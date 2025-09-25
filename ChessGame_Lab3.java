import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ChessGame_Lab3 {

    private static Set<String> remainingPieces = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessPiece[] givenPieces = new ChessPiece[6];
        int counter = 0;

        // Initialize available pieces
        remainingPieces.add("pawn"); remainingPieces.add("rook");
        remainingPieces.add("knight"); remainingPieces.add("bishop");
        remainingPieces.add("queen"); remainingPieces.add("king");

        
        while (counter < 6) {
            System.out.println("Enter piece name (Pawn, Rook, Knight, Bishop, Queen, King):");
            String name = scanner.nextLine().trim();

            // Use your checkPiece method
            if (!checkPiece(name)) continue;

            // Color input
            Colors color = null;
            while (true) {
                System.out.println("Enter color (WHITE, BLACK):");
                try {
                    color = Colors.valueOf(scanner.nextLine().trim().toUpperCase());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid color. Enter WHITE or BLACK.");
                }
            }

            // Position input
            Columns currentX = null;
            int currentY = 0;
            while (true) {
                System.out.println("Enter column (A-H):");
                char colChar = scanner.next().trim().toUpperCase().charAt(0);

                System.out.println("Enter row (1-8):");
                try {
                    currentY = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Invalid row input. Must be a number 1-8.");
                    scanner.nextLine();
                    continue;
                }

                currentX = Columns.fromChar(colChar);
                if (Chessboard.bounds(currentX, currentY)) {
                break;
                }
                System.out.println("Invalid position. Column A-H, row 1-8.");
            }

            // Create piece and add to array
            ChessPiece piece = definePiece(name, color, currentX, currentY);
            if (piece != null) {
                givenPieces[counter++] = piece;
            } else {
                System.out.println("Invalid piece name, try again.");
            }
        }

        
        Columns targetX = null;
        int targetY = 0;
        while (true) {
            System.out.println("Enter target column (A-H):");
            char colChar = scanner.next().trim().toUpperCase().charAt(0);

            System.out.println("Enter target row (1-8):");
            try {
                targetY = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid row input. Must be a number 1-8.");
                scanner.nextLine(); 
                continue;
            }

            targetX = Columns.fromChar(colChar);
            if (Chessboard.bounds(targetX, targetY)) break;
            System.out.println("Invalid target position. Column A-H, row 1-8.");
        }

        
        for (ChessPiece piece : givenPieces) {
            if (piece != null) {
                if (piece.validMove(targetX, targetY)) {
                    System.out.println(piece.getName() + " at " + piece.getCurrentX() + ", " +
                            piece.getCurrentY() + " can move to " + targetX + ", " + targetY);
                } else {
                    System.out.println(piece.getName() + " at " + piece.getCurrentX() + ", " +
                            piece.getCurrentY() + " can NOT move to " + targetX + ", " + targetY);
                }
            }
        }

        scanner.close();
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
