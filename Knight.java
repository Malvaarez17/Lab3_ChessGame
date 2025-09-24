public class Knight extends ChessPiece {
    public Knight() {
        super();
    }
    public Knight(Colors color, Columns currentX, int currentY) {
        super("Knight", color, currentX, currentY);
    }
    public boolean validMove(Columns targetX, int targetY) {
        if (!Chessboard.bounds(targetX, targetY)) {
            return false;
        }
        if (Chessboard.bounds(targetX, targetY)) {
            if (currentY == targetY + 2 || currentY == targetY - 2 || currentX.getIndex() == targetX.getIndex() + 2 || currentX.getIndex() == targetX.getIndex() - 2) {
                if (currentY == targetY + 1 || currentY == targetY - 1 || currentX.getIndex() == targetX.getIndex() + 1 || currentX.getIndex() == targetX.getIndex() - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
