package Peice;

public class Piece {

    PieceType pieceType;

    Piece(PieceType type){
        this.pieceType = type;
    }

    public PieceType getPieceType(){
        return this.pieceType;
    }
}
