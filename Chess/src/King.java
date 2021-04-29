public class King extends Character {
    public int hierarchy = 4;
    // can only move one Step in any direction
    // if dead game lost

    public King(boolean white) {
        alive = true;
        type = "King";
        this.white = white;
        if (white) position = new int[]{0, 4};
        else position = new int[]{7, 4};
    }

    @Override
    public boolean move(int x, int posY) {
        int posX = x;
        if(!isInField(posX, posY)){
            System.out.println("Position not inside the field");
            return false;
        }
        if(Math.abs(posX - position[0]) <= 1 && Math.abs(posY - position[1]) <= 1) return true;
        System.out.println("King cannot move this way - Please check the rules again!");
        return false;
    }

}
