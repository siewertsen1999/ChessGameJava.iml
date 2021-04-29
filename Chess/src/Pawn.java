public class Pawn extends Character {
    public int hierarchy = 5;

    public Pawn(boolean white, int position[]) {
        alive = true;
        type = "Pawn";
        this.white = white;
        this.position[0] = position[0];
        this.position[1] = position[1];
    }

    // in Chessgame x and y is already changed in a way that x and y can be considered like in normal coordinate System
    // position[0] = y coordinate(default = 1)   -    position[1] = x coordinate(default 0-7 / A-H)
    public boolean move(int posY, int posX){
        if(!isInField(posX, posY)){
            System.out.println("Position not inside the field");
            return false;
        }
        // position[0] = y coordinate(default = 1)   -    position[1] = x coordinate(default 0-7 / A-H)

        if((Math.abs(posX - position[1]) == 0 && Math.abs(posY - position[0]) == 1) || (Math.abs(posX - position[1]) == 0 && Math.abs(posY - position[0]) == 2 && position[0] == 1) || (Math.abs(posX - position[1]) == 0 && Math.abs(posY - position[0]) == 2 && position[0] == 6) ){  //|| (posX - position[1] == 1 && posY - position[0] == 1 && this.chessboard[position[1]][position[0]])
            position[0] = posY;
            position[1] = posX;
            return true;
        }

           // System.out.println("posX = " + posX  + "-" +  "pos[1] = " + position[1] + "= " + (posX - position[1]));
          //  System.out.println("posY = " + posY  + "-" + "pos[0] = " + position[0] + "= " + (posY - position[0]));

            //System.out.println("Pawn cannot move this way - Please check the rules again!");
        return false;
    }


}
