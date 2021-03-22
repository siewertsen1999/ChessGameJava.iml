public class Queen extends Character {
    public Queen(boolean white) {
        alive = true;
        type = "Queen";
        this.white = white;
        if (white) position = new int[]{0, 3};
        else position = new int[]{7, 3};
    }

    @Override
    public boolean move(char x, int posY) {
        int posX = StringToPosition(x);
        if(!isInField(posX, posY)){
            System.out.println("Position not inside the field");
            return false;
        }
        if(Math.abs(posX - position[0]) == Math.abs(posY - position[1]) || posX == position[0] || posY == position[1]) return true;
        System.out.println("Queen cannot move this way - Please check the rules again!");
        return false;
    }
}
