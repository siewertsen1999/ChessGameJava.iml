import static java.lang.Character.toUpperCase;

public class Chessboard {
    public static Character[][] chessboard;

    public Chessboard(){
        this.chessboard = new Character[8][8];
    }

 
    public void move( int xOld, int yOld, int xNew, int yNew) {    // x -> A-H on board,y -> 1-8 on board, board as third parameter always has to be the chessboard
        //int posXOld = (int) toUpperCase(xOld) - 65;
        //int posXNew = (int) toUpperCase(xNew) - 65;
        chessboard[xNew][yNew] = chessboard[xOld][yOld];
        chessboard[xOld][yOld] = null;
        //chessboard.pos

    }




}
