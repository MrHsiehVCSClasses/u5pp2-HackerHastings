package u5pp;

public class Pawn extends ChessPiece {

    boolean isFirstTurn = true;

    public Pawn(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }
    
    public boolean canMoveTo(int row, int col) {
        
    if(row > -1 && row < 8 && col > -1 && col < 8) {
        if(row == this.row && col == this.col){
            return false;
        }
        if(isWhite == true){
            if((row <= this.row)){
                return false;
            } else if(isFirstTurn == true){
                if((row == this.row + 1) && (col == this.col) && (board[row][col] == null)){
                    return true;
                } else if ((row == this.row + 2) && (col == this.col) && (board[row][col] == null) && (board[row-1][col] == null)){
                    return true;
                } else if ((row == this.row + 1) && ((col == this.col -1) || (col == this.col + 1)) && (board[row][col] != null)){
                    if(board[row][col].isWhite == false){
                    return true;
                    }
                } else {
                    return false;
                }
            } else {
                if((row == this.row + 1) && (col == this.col) && (board[row][col] == null)){
                    return true;
                } else if ((row == this.row + 1) && ((col == this.col - 1) || (col == this.col + 1)) && (board[row][col] != null)){
                    if(board[row][col].isWhite == false){
                        return true;
                    }
                } else {
                    return false;
                }
            }
        } else {
            if((row >= this.row)){
                return false;
            } else if(isFirstTurn == true){
                if((row == this.row - 1) && (col == this.col) && (board[row][col] == null)){
                    return true;
                } else if ((row == this.row - 2) && (col == this.col) && (board[row][col] == null) && (board[row+1][col] == null)){
                    return true;
                } else if ((row == this.row - 1) && ((col == this.col - 1) || (col == this.col + 1)) && (board[row][col] != null)){
                    if(board[row][col].isWhite == true){
                        return true;
                    }
                } else {
                    return false;
                }
            } else {
                if((row == this.row - 1) && (col == this.col) && (board[row][col] == null)){
                    return true;
                } else if ((row == this.row - 1) && ((col == this.col - 1) || (col == this.col + 1)) && (board[row][col] != null)){
                    if(board[row][col].isWhite == true){
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
    }
    return false;
    }

    public void moveTo(int row, int col){
        //which moves the piece to the indicated space.
        if(canMoveTo(row, col) == true){
        board[row][col] = board[this.row][this.col];
        board[this.row][this.col] = null;
        this.row = row;
        this.col = col;
        isFirstTurn = false;
        }

    }



    public String toString(){
        return isWhite == true ? "P" : "p";
    }

}
