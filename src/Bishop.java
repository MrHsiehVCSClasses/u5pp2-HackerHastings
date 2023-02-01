package u5pp;

public class Bishop extends ChessPiece {

    public Bishop(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    public boolean canMoveTo(int row, int col){

      if(row > -1 && row < 8 && col > -1 && col < 8) {
        if(row == this.row || col == this.col){
            return false;
        }

        if(row < this.row){
            int count = 1;
        for(int i = this.row - 1; i > -1; i--){
                System.out.println(i);
                System.out.println(count);

                if(col > this.col){
                    if(this.col +count < 8){
                    
                    if(board[i][this.col +count] != null){
                    if(board[i][this.col +count].getIsWhite() == this.isWhite){
                        return false;
                    } 
                    }
                    if (row < i && board[i][this.col +count] != null){
                        return false;
                    }

                    } else {
                        return false;
                    }
                }

                if(col < this.col){
                    if(this.col -count > -1){

                    if(board[i][this.col -count] != null){
                    if(board[i][this.col -count].getIsWhite() == this.isWhite){
                        return false;
                    } 
                    }
                    
                    if (row < i && board[i][this.col -count] != null){
                        return false;
                    }
                    } else {
                        return false;
                    } 
                }

                if(this.col -count > -1){
                if(board[row][col] == board[i][this.col-count]){
                    if((board[row][col] == null) || (board[row][col].getIsWhite() != isWhite)){
                        return true;
                    }
                } 
            }
                if(this.col +count < 8){
                if (board[row][col] == board[i][this.col+count]){
                    if((board[row][col] == null) || (board[row][col].getIsWhite() != isWhite)){
                        return true;
                    }
                }
            }
                count++;
        }
    }
    

        if(row > this.row){
            int count = 1;
        for(int i = this.row + 1; i < row + 1; i++){
            System.out.println(i);
            System.out.println(count);

                if(col > this.col){
                    if(this.col +count < 8){
                    
                    if(board[i][this.col +count] != null){
                    if(board[i][this.col +count].getIsWhite() == this.isWhite){
                        return false;
                    } 
                    }
                    
                    if(row > i && board[i][this.col +count] != null){
                        return false;
                    }
                    } else {
                        return false;
                    }
                }
    
                if(col < this.col){
                    if(this.col -count > -1){
                    
                    if(board[i][this.col -count] != null){
                    if(board[i][this.col -count].getIsWhite() == this.isWhite){
                        return false;
                    } 
                    }
                    
                    if (row > i && board[i][this.col -count] != null){
                        return false;
                    }
                    } else {
                        return false;
                    }
                }

                if(this.col -count > -1){
                    if(board[row][col] == board[i][this.col-count]){
                        if((board[row][col] == null) || (board[row][col].getIsWhite() != isWhite)){
                            return true;
                        }
                    } 
                }
                    if(this.col +count < 8){
                    if (board[row][col] == board[i][this.col+count]){
                        if((board[row][col] == null) || (board[row][col].getIsWhite() != isWhite)){
                            return true;
                        }
                    }
                }
                count++;
        }
    }
        return false;
      } else{
        return false;
      }
    }
    
    public String toString(){
        return isWhite == true ? "B" : "b";
    }

}
