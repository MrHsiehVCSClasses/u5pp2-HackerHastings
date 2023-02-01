package u5pp;

public class Queen extends ChessPiece {

    public Queen(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    public boolean canMoveTo(int row, int col){
        if(row > -1 && row < 8 && col > -1 && col < 8) {
            if(row == this.row && col == this.col){
                return false;
            }

        int rowShiz = Math.abs(row-this.row);
        int colShiz = Math.abs(col-this.col);

            if(rowShiz != 0 && colShiz != 0 && rowShiz != colShiz){
                return false;
            }

        int rowUp;
        int colUp;

        if(this.row == row){
            rowUp = 0;
        } else {
            rowUp = (row-this.row) / rowShiz;
        }

        if(this.col == col){
            colUp = 0;
        } else {
            colUp = (col - this.col) / colShiz;
        }

        int iRow = this.row + rowUp;
        int jCol = this.col + colUp;

        while(iRow != row || jCol != col){
            if(board[iRow][jCol] != null){
                return false;
            }
            iRow += rowUp;
            jCol += colUp;
        }

        if(board[row][col] == null || board[row][col].getIsWhite() != isWhite){
            return true;
        } else {
            return false;
        }

        } else{
            return false;
        }       
    }
    
    public String toString(){
        return isWhite == true ? "Q" : "q";
    }

}
