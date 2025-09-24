
public class Bishop extends ChessPiece {
    public Bishop() {
        super();
    }
    public Bishop(Colors color, Columns currentX, int currentY) {
        super("Bishop", color, currentX, currentY);
    }
    public boolean validMove(Columns targetX, int targetY) {
        if (!Chessboard.bounds(targetX, targetY)) {
            return false;
        }
        int temp = currentX.getIndex();
        int temp2 = targetX.getIndex();
        if (Math.abs(temp - temp2) > 0 && Math.abs(temp - temp2) < 8 && 
            Math.abs(targetY - currentY) > 0 && Math.abs(targetY - currentY) < 8) {
            if (Math.abs(temp - temp2) == Math.abs(targetY - currentY)) {
                return true;
            }
        }
        
        return false;
    }
}
