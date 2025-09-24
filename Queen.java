public class Queen extends Bishop {
    public Queen() {
        super();
    }
    public Queen(Colors color, Columns currentX, int currentY) {
        super(color, currentX, currentY);
        this.name = "Queen"; 
    }
    public boolean validMove(Columns targetX, int targetY) {
        if (!Chessboard.bounds(targetX, targetY)) {
            return false;
        }
        int deltaX = Math.abs(targetX.getIndex() - currentX.getIndex());
        int deltaY = Math.abs(targetY - currentY);
        if (currentX.getIndex() == targetX.getIndex() && currentY != targetY) {
            return true;
        }
        if (currentY == targetY && currentX.getIndex() != targetX.getIndex()) {
            return true;
        }
        if (deltaX == deltaY && deltaX > 0) {
            return true;
        }
        
        return false;
    }
}
