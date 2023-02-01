package u5pp;

public class King extends ChessPiece {

    public King(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    public boolean canMoveTo(int row, int col){

        //board[row][col].toString() != "k" && board[row][col].toString() != "K" put in somehow

    if(row > -1 && row < 8 && col > -1 && col < 8) {
        if(row == this.row && col == this.col){
            return false;
        }
        

            if(row == this.row){
              if(col == this.col + 1 || col == this.col - 1){
                if((board[row][col] == null || board[row][col].isWhite != this.isWhite)){
                    if(isEnemyNear(board, row, col, this.row, this.col, isWhite) == false){
                        return true;
                    }
                }
              }
            } else if(row == this.row + 1 || row == this.row - 1){
                if(col == this.col || col == this.col + 1 || col == this.col - 1){
                    if((board[row][col] == null || board[row][col].isWhite != this.isWhite)){
                        if(isEnemyNear(board, row, col, this.row, this.col, isWhite) == false){
                            return true;
                        }
                    }
                  }
            }
            return false;
    }
    return false;
    }

    private boolean isEnemyNear(ChessPiece[][] board, int row, int col, int thisRow, int thisCol, boolean isWhite){
        for(int i = row + 1; i > row - 2; i--){
            for(int j = col - 1; j < col + 2; j++){
                if(i > -1 && i < 8 && j > -1 && j < 8){
                        if(board[i][j] != null){
                        if(isWhite == true){
                            if(board[i][j].toString() == "k"){
                                return true;
                            }
                        } else if(isWhite == false){
                            if(board[i][j].toString() == "K"){
                                return true;
                            }
                        }
                        }
                    
                }
            }
        }
        return false;
    }

    public String toString(){
        return isWhite == true ? "K" : "k";
    }

}
