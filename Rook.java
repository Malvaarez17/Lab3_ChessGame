public class Rook extends ChessPiece {

    public Rook() {
        super();
    }
    public Rook(Colors color, Columns currentX, int currentY) {
        super("Rook", color, currentX, currentY);
    }
    public boolean validMove(Columns targetX, int targetY) {
        if (!Chessboard.bounds(targetX, targetY)) {
            return false;
        }
        if (currentX.getIndex() == targetX.getIndex() || currentY == targetY) {
            return true;
        }
        
        return false;
    }
}
