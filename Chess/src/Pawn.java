public class Pawn extends Character {

    public Pawn(boolean white, int position[]) {
        alive = true;
        type = "Pawn";
        this.white = white;
        this.position[0] = position[0];
        this.position[1] = position[1];
    }

    public boolean move(char x, int posY){
        int posX = StringToPosition(x);
        if(!isInField(posX, posY)){
            System.out.println("Position not inside the field");
            return false;
        }
        if((posX - position[0] == 0 && posY - position[1] == 1) || (posX - position[0] == 0 && posY - position[1] == 1 && position[1] == 1) ) return true;

            System.out.println("Pawn cannot move this way - Please check the rules again!");
        return false;
    }


}
