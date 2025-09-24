public abstract class ChessPiece {
    protected String name;
    protected Colors color;
    protected Columns currentX;
    protected int currentY;

    public ChessPiece() {
    }

    public ChessPiece(String name, Colors color, Columns currentX, int currentY) {
        this.name = name;
        this.color = color;
        this.currentX = currentX;
        this.currentY = currentY;
    }

    public abstract boolean validMove(Columns targetX, int targetY);

    public void setColor(Colors color) {
        this.color = color;
    }
    public Colors getColor() {
        return this.color;
    }
    public void setCurrentX(Columns currentX) {
        this.currentX = currentX;
    }
    public Columns getCurrentX() {
        return this.currentX;
    }
    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }
    public int getCurrentY() {
        return this.currentY;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

