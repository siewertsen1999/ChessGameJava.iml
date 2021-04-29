import static java.lang.Character.toUpperCase;

public class Chessboard {
    public static Character[][] chessboard;

    public Chessboard(){
        this.chessboard = new Character[8][8];
    }

    // this method will only be executed if the move funktion of the Character returns true
   /* public void move(char xOld, int yOld, char xNew, int yNew){    // x -> A-H on board,y -> 1-8 on board, board as third parameter always has to be the chessboard
        int posXOld = (int)toUpperCase(xOld) - 48;
        int posXNew = (int)toUpperCase(xNew) - 48;
        chessboard[posXNew][yNew] = chessboard[posXOld][yOld];
        chessboard[posXOld][yOld] = null;
        //chessboard.pos
    }

    */
    public void move( int xOld, int yOld, int xNew, int yNew) {    // x -> A-H on board,y -> 1-8 on board, board as third parameter always has to be the chessboard
        //int posXOld = (int) toUpperCase(xOld) - 65;
        //int posXNew = (int) toUpperCase(xNew) - 65;
        chessboard[xNew][yNew] = chessboard[xOld][yOld];
        chessboard[xOld][yOld] = null;
        //chessboard.pos

    }




}
