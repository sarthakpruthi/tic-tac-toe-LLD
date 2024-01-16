import Peice.Piece;

public class Board {
    int size;
    Piece[][] pieces;

    int availablePiece;

    Board(int size){
        this.size = size;
        pieces = new Piece[size][size];
        availablePiece = size * size;
    }

    public int addPeice(int x, int y, Piece piece){
        if(pieces[x][y]!=null){
            return 0;
        }
        availablePiece--;
        pieces[x][y] = piece;
        if(availablePiece<=0){
            return -1;
        }
        return 1;
    }

    public Piece[][] getPeices(){
        return pieces;
    }

}
