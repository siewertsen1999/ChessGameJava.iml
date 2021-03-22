import java.lang.reflect.Array;

public class Rook extends Character{
    public Rook(boolean white, int position[]) {
        alive = true;
        type = "Rook";
        this.white = white;
        this.position[0] = position[0];
        this.position[1] = position[1];
    }

    @Override
    public boolean move(char x, int posY) {
        int posX = StringToPosition(x);
        if(!isInField(posX, posY)){
            System.out.println("Position not inside the field");
            return false;
        }
        if(posX == position[0] || posY == position[1]) return true;
        System.out.println("Rook cannot move this way - Please check the rules again!");
        return false;
    }
}
