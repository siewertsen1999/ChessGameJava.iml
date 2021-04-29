public class Queen extends Character {
    public int hierarchy = 0;

    public Queen(boolean white) {
        alive = true;
        type = "Queen";
        this.white = white;
        if (white) position = new int[]{0, 3};
        else position = new int[]{7, 3};
    }

    @Override
    // positions x and y are changed like array uses it.


    /***
     * queen for player 2 not working - right up ?
     */
    public boolean move(int posX, int posY) {
        if(!isInField(posX, posY)){
            System.out.println("Position not inside the field");
            return false;
        }
        int xtemp = position[0];
        int ytemp = position[1];

        System.out.println("destination: posX = " + posX);
        System.out.println("destination: pos Y= " + posY);
        System.out.println("position : xtemp =" + xtemp);
        System.out.println("position : ytemp =" + ytemp);

        // x old = x new (y coordinates in coordinate system)
        if ( posX == xtemp){
            if(ytemp < posY) {
                while (ytemp != posY) {
                    ytemp++;
                    if (Chessboard.chessboard[xtemp][ytemp] != null) {
                        System.out.println("Another Character is in the way!");
                        return false; // if theres a character in the way we cant move this way
                    }
                }
            }
            else{
                while (ytemp != posY) {
                    ytemp--;
                    if (Chessboard.chessboard[xtemp][ytemp] != null) {
                        System.out.println("Another Character is in the way!");
                        return false; // if theres a character in the way we cant move this way
                    }
                }
            }
        }
        if ( posY == ytemp && (posX-xtemp<0)){
            while(xtemp != posX){
                xtemp--;
                if(Chessboard.chessboard[xtemp][ytemp]!=null){
                    System.out.println("Another Character is in the way!");
                    return false; // if theres a character in the way we cant move this way
                }
            }
        }
        if ( posY == ytemp && (posX-xtemp>0)){
            while(xtemp != posX-1){
                xtemp++;
                if(Chessboard.chessboard[xtemp][ytemp]!=null){
                    System.out.println("Another Character is in the way!");
                    return false; // if theres a character in the way we cant move this way
                }
            }
        }
        //diagonal left up
        if (posX != xtemp && posY != ytemp && ytemp>posY && xtemp>posX) {
            while(xtemp!=posX+1 && ytemp!=posY+1) {
                xtemp--;
                ytemp--;
                if (Chessboard.chessboard[xtemp][ytemp] != null) {
                    System.out.println("Another Character is in the way!");
                    return false;
                }
            }
        }
        // diagonal right up
        if (posX != xtemp && posY != ytemp && ytemp<posY && xtemp>posX) {
            while(xtemp!=posX+1 && ytemp!=posY-1) {
                xtemp--;
                ytemp++;
                if (Chessboard.chessboard[xtemp][ytemp] != null) {
                    System.out.println("Another Character is in the way!");
                    return false;
                }
            }
        }

        // diagonal right down
        if (posX != xtemp && posY != ytemp && ytemp<posY && xtemp<posX) {
            while(xtemp!=posX-1 && ytemp!=posY-1) {
                xtemp++;
                ytemp++;
                if (Chessboard.chessboard[xtemp][ytemp] != null) {
                    System.out.println("Another Character is in the way!");
                    return false;
                }
            }
        }

        // diagonal left down
        if (posX != xtemp && posY != ytemp && ytemp>posY && xtemp<posX) {
            while(xtemp!=posX-1 && ytemp!=posY+1) {
                xtemp++;
                ytemp--;
                if (Chessboard.chessboard[xtemp][ytemp] != null) {
                    System.out.println("Another Character is in the way!");
                    return false;
                }
            }
        }


        if(Math.abs(posX - position[0]) == Math.abs(posY - position[1]) || posX == position[0] || posY == position[1]){
            position[1] = posY;
            position[0] = posX;
            return true;
        }
        System.out.println("Queen cannot move this way - Please check the rules again!");
        return false;
    }
}
