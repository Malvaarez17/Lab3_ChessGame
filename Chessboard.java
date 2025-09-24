
public class Chessboard {

    public static final int MIN_ROW = 1;
    public static final int MAX_ROW = 8;


    public static boolean bounds(Columns x, int y) {
        if (x == null){ 
            System.out.println("Invalid X: " + x + ". It must be between A and H.");
            return false;
        }

        if (y < MIN_ROW || y > MAX_ROW){ 
            System.out.println("Invalid Y: " + y +".  Is invlaid please choose between 1 and 8");
            return false;
        }

        return true;
    }
    
}
