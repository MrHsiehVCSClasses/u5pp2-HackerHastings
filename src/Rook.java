package u5pp;

public class Rook extends ChessPiece {

    public Rook(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    public boolean canMoveTo(int row, int col){
        if(row > -1 && row < 8 && col > -1 && col < 8) {
            if(row == this.row && col == this.col){
                return false;
            }

            if(row == this.row){
                if(col < this.col){
                    for(int j = this.col - 1; j > col; j--){ 
                        if(board[this.row][j] != null){
                            return false;
                        }
                    }
                } else if(col > this.col){
                    for(int j = this.col + 1; j < col; j++){
                        if(board[this.row][j] != null){
                            return false;
                        }
                    }
                }
            } else if(col == this.col){
                if(row < this.row){
                    for(int j = this.row - 1; j > row; j--){
                        if(board[j][col] != null){
                            return false;
                        } 
                        
                    }
                } else if(row > this.row){
                    for(int j = this.col + 1; j < row; j++){
                        if(board[j][col] != null){
                            return false;
                        }
                    }
                }
            } else {
                return false;
            }
//checks if intended spot is null or enemy
            if(board[row][col] == null || board[row][col].isWhite != isWhite){
                return true;
            } else {
                return false;
            } 

        }
        return false;
    }
    
    public String toString(){
        return isWhite == true ? "R" : "r";
    }

}
