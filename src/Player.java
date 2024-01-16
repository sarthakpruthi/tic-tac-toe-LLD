import Peice.Piece;

public class Player {
    String name;
    Piece piece;

    Player(String name, Piece piece){
        this.name = name;
        this.piece = piece;
    }

    public String getName(){
        return this.name;
    }

    public Piece getPeice(){
        return this.piece;
    }
}
