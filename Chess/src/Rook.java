import java.lang.reflect.Array;

public class Rook extends Character{
    public int hierarchy = 1;

    public Rook(boolean white, int position[]) {
        alive = true;
        type = "Rook";
        this.white = white;
        this.position[0] = position[0];
        this.position[1] = position[1];
    }

    @Override
    // X and Y are swapped like array uses it
    public boolean move(int posX, int posY) {
        System.out.println("position X: " + position[0]);
        System.out.println("position Y: " + position[1]);
        System.out.println("destination X: " + posX);
        System.out.println("destination Y: " + posY);

        int xtemp = position[0];
        int ytemp = position[1];
        if(posX == position[0] || posY == position[1]) {


            while (ytemp != posY) {
                ytemp++;
                if (Chessboard.chessboard[xtemp][ytemp] != null) {
                    System.out.println("Another Character is in the way!");
                    return false; // if theres a character in the way we cant move this way
                }
            }
            while (xtemp != posX) {
                xtemp++;
                if (Chessboard.chessboard[xtemp][ytemp] != null) {
                    System.out.println("Another Character is in the way!");
                    return false; // if theres a character in the way we cant move this way
                }
            }

            if (!isInField(posX, posY)) {
                System.out.println("Position not inside the field");
                return false;
            }

            System.out.println("Rook cannot move this way - Please check the rules again!");
        }
        return true;
    }
}
