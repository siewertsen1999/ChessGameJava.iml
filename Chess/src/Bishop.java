public class Bishop extends Character{
    public int hierarchy = 2;

    public Bishop(boolean white, int position[]) {
        alive = true;
        type = "Bishop";
        this.white = white;
        this.position[0] = position[0];      // y - position
        this.position[1] = position[1];      // x - position
    }

    @Override
    public boolean move(int posX, int posY) {    // posX = y on chessboard , yPos = a-h
        System.out.println("position:   0 = " + position[0] + "  1  = " + position[1]);
        System.out.println("posX = " + posX + "  posY =  " + posY );

        if(!isInField(posX, posY)){
            System.out.println("Position not inside the field");
            return false;
        }
        if(Math.abs(posX - position[0]) == Math.abs(posY - position[1]) && characterBlocksWay(posX,posY)==true){
            position[0] = posX;
            position[1] = posY;
            return true;
        }
        System.out.println("Bishop cannot move this way - Please check the rules again!");
        return false;
    }

    public boolean characterBlocksWay(int x, int y){
        int xtemp = position[0];
        int ytemp = position[1];
        if(y > ytemp && x > xtemp){
            while (ytemp < y-1 && xtemp < x-1){                 // right down diagonal
                xtemp++;
                ytemp++;
                if(Chessboard.chessboard[xtemp][ytemp]!=null){
                    System.out.println("Another Character is in the way!");
                    return false; // if theres a character in the way we cant move this way
                }
            }
        }
        else if(y < ytemp && x > xtemp){                    // left down diagonal
            while (ytemp > y+1 ){
                xtemp++;
                ytemp--;
                if(Chessboard.chessboard[xtemp][ytemp]!=null){
                    System.out.println("Another Character is in the way!");
                    return false; // if theres a character in the way we cant move this way
                }
            }
        }

        else if(y < ytemp && x < xtemp){                    // left up diagonal
            System.out.println("y = "+ y + " x = " + x +" ,  y temp = " + ytemp + ", x temp = " + xtemp);
            while (ytemp > y+1 ){
                xtemp--;
                ytemp--;
                if(Chessboard.chessboard[xtemp][ytemp]!=null){
                    System.out.println("Another Character is in the way!");
                    return false; // if theres a character in the way we cant move this way
                }
            }
        }

        else if(y > ytemp && x < xtemp){                    // right up diagonal
            while (ytemp < y-1 ){
                xtemp--;
                ytemp++;
                if(Chessboard.chessboard[xtemp][ytemp]!=null){
                    System.out.println("Another Character is in the way!");
                    return false; // if theres a character in the way we cant move this way
                }
            }
        }

        return true;
    }

}

