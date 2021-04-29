import static java.lang.Character.toUpperCase;

public abstract class Character {
    String type;
    boolean alive;
    boolean white;
    int hierarchy;
    int [] position = new int[2];

    public abstract boolean move(int x, int y);               // depending on which character we move, this method returns if the field is accessable
   // public abstract boolean move(char x, int posY, boolean pawnWouldKill);

    public int StringToPosition(char x){
        char c = toUpperCase(x);
        int pos = (int)c-65;
        return pos;
    }

    public boolean isInField(int x, int y){
        if(x > 7 || y > 7 || x < 0 || y < 0) return false;
        return true;
    }

    @Override
    public String toString(){
        if(this.type.equals("King")){
            if(this.white == false) return "KING-B";
            else return "KING-W";
        }
        else if(this.type.equals("Knight")){
            if(this.white == false) return "KNGT-B";
            else return "KNGT-W";

        }
        else if(this.type.equals("Pawn")){
            if(this.white == false) return "PAWN-B";
            else return "PAWN-W";
        }
        else if(this.type.equals("Queen")){
            if(this.white == false) return "QUEN-B";
            else return "QUEN-W";
        }
        else if(this.type.equals("Rook")){
            if(this.white == false) return "ROOK-B";
            else return "ROOK-W";
        }
        else if(this.type.equals("Bishop")){
            if(this.white == false) return "BSHP-B";
            else return "BSHP-W";
        }
        return "XXXX-X";
    }


}
