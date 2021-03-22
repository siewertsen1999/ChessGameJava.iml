public class Knight extends Character{
    public Knight(boolean white, int position[]){
        alive = true;
        type = "Knight";
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
        if(Math.abs(posX - position[0]) == 2 && Math.abs(posY - position[1]) == 1 || Math.abs(posX - position[0]) == 1 && Math.abs(posY - position[1]) == 2 ) return true;
        System.out.println("Knight cannot move this way - Please check the rules again!");
        return false;
    }
}
