package u5pp;

public class ChessPiece {

    ChessPiece board[][];
    int row;
    int col;
    boolean isWhite = false;

    public ChessPiece(ChessPiece[][] board, int row, int col, boolean isWhite){
        this.board = board;
        this.row = row;
        this.col = col;
        this.isWhite = isWhite;
    }

    public ChessPiece[][] getBoard(){
        return board;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return col;
    }

    public boolean getIsWhite(){
        return isWhite;
    }

    public boolean canMoveTo(int row, int col){
        //which returns true if the indicated space is a valid move for this piece, false otherwise. Does not alter the board.
        if((row > 0) && (row < board.length) && (col > 0) && (col < board[row].length)){
            if(board[row][col] == null){
                return true;
            } else if (board[row][col].isWhite == this.isWhite){
                return false;
            } else {
                return true;
            }
        } else{
            return false;
        }
    }
    
    public void moveTo(int row, int col){
        //which moves the piece to the indicated space.
        board[row][col] = board[this.row][this.col];
        board[this.row][this.col] = null;
        this.row = row;
        this.col = col;
        

    }

    public String toString(){
        //to be implemented by each child class, based on how they are to be represented
        return "Yo";
    }

}
