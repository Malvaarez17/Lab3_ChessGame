public class Pawn extends ChessPiece {
    public Pawn() {
        super();
    }
    public Pawn(Colors color, Columns currentX, int currentY) {
        super("Pawn", color, currentX, currentY);
    }
    public boolean validMove(Columns targetX, int targetY) {
        if (!Chessboard.bounds(targetX, targetY)) {
            return false;
        }
        if (currentX.getIndex() == targetX.getIndex()) {
            if (color == Colors.BLACK) {
                if (targetY - currentY == -1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (targetY - currentY == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
