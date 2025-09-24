public class King extends Queen {
    public King() {
        super();
    }
    public King(Colors color, Columns currentX, int currentY) {
        super(color, currentX, currentY);
        this.name = "King"; 
    }
    public boolean validMove(Columns targetX, int targetY) {
        int dx = Math.abs(targetX.getIndex() - currentX.getIndex());
        int dy = Math.abs(targetY - currentY);
        if (Chessboard.bounds(targetX, targetY)) {
            if (dx <= 1 && dy <= 1 && !(dx == 0 && dy == 0)) {
                return true;
            }
        }
        return false;
    }
}
