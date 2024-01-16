import Peice.Piece;
import Peice.*;

import java.util.*;

public class Game {

    Queue<Player> players;
    Board board;

    Game(int boardSize){
        players = new LinkedList<>();
        board = new Board(boardSize);
        initializeGame();
        printBoard();

    }

    public void initializeGame(){
        //creating 2 players
        Player p1 = new Player("pruthi", new PieceX());
        Player p2 = new Player("babbar", new PieceO());

        players.add(p1);
        players.add(p2);

        System.out.println("Game Initialized for " + p1.getName() + " and " + p2.getName());
    }


    public void startGame(){
        while(true){

            Player playerTop = players.peek();
            Scanner s = new Scanner(System.in);

            System.out.print("Turn: " + playerTop.getName() + " Piece: "+ playerTop.getPeice().getPieceType() +" Enter row, column! ");
            int x =  s.nextInt(), y = s.nextInt();

            if(x<0 || x>2 || y<0 || y>2){
                System.out.println("Please enter a valid position");
                printBoard();
                continue;
            }

            int canPieceBePlaced = board.addPeice(x,y,playerTop.getPeice());

            if(canPieceBePlaced == -1){
                System.out.println("Draw!!!, Play again");
                printBoard();
                break;
            }
            else if(canPieceBePlaced == 0){
                System.out.println("Not a valid position");
                printBoard();
                continue;
            }

            printBoard();

            players.remove();
            players.add(playerTop);

            boolean playerWin = checkWinner(x,y,playerTop.getPeice().getPieceType());
            if(playerWin){
                System.out.println("Congratulations " + playerTop.getName() + " you won!");
                break;
            }
        }
    }

    public boolean checkWinner(int ro, int col, PieceType pieceType){
       Piece[][] pieces =  board.getPeices();
       int size = pieces.length;
        boolean rowMatch = true, columnMatch = true, diagonalMatch = true, antiDiagonalMatch = true;

       //row wise check
       for(int j=0;j<size;j++){
           if (pieces[ro][j] == null || pieces[ro][j].getPieceType() != pieceType) {
               rowMatch = false;
               break;
           }
       }

       //column wise check
        for(int i=0;i<size;i++){
            if(pieces[i][col]==null || pieces[i][col].getPieceType()!=pieceType){
                columnMatch = false;
                break;
            }
        }

        //diagonal match
        for(int i=0;i<size;i++){
            if(pieces[i][i]==null || pieces[i][i].getPieceType()!=pieceType){
                diagonalMatch = false;
                break;
            }
        }

        //anti-diagonal match
        for(int i=size-1;i>=0;i--){
            if(pieces[size-1-i][i]==null || pieces[size-1-i][i].getPieceType()!=pieceType){
                antiDiagonalMatch = false;
                break;
            }
        }

       return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

    public void printBoard(){
        Piece[][] pieces = board.getPeices();
        int sz = pieces.length;
        for(int i=0;i<sz;i++){
            for(int j=0;j<sz;j++){

                System.out.print( (pieces[i][j]==null ? " " : pieces[i][j].getPieceType()) + " | ");
            }
            System.out.println();
        }
    }

}
