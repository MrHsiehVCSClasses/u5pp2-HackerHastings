package u5pp;

public class Knight extends ChessPiece {

    public Knight(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    public boolean canMoveTo(int row, int col){
        if(row > -1 && row < 8 && col > -1 && col < 8) {
            if(row == this.row && col == this.col){
                return false;
            }
            for(int i = this.row - 2; i < this.row + 3; i++){
                if(i != this.row){
                    if(row == i){
                    if(i == this.row - 2 || i == this.row + 2){
                        if((col == this.col - 1) || (col == this.col +1)){
                            if((board[row][col] == null) || (board[row][col].getIsWhite() != this.isWhite)){
                                return true;
                            }
                        }
                    } else {
                        if((col == this.col - 2) || (col == this.col +2)){
                            if((board[row][col] == null) || (board[row][col].getIsWhite() != this.isWhite)){
                                return true;
                            }
                        }
                    }
                }
                }
            }
        } else {
            return false;
        }
        return false;
    }
    
    public String toString(){
        return isWhite == true ? "N" : "n";
    }

}
