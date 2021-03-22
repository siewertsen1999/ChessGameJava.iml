import static java.lang.Character.toUpperCase;

public abstract class Character {
    String type;
    boolean alive;
    boolean white;
    int [] position = new int[2];

    public abstract boolean move(char x, int y);               // depending on which character we move, this method returns if the field is accessable
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


}
