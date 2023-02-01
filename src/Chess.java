package u5pp;

import java.util.Scanner;

public class Chess {


    /**
     * Used to print a chess board out.
     */
    public static String boardToString(ChessPiece[][] board) {

        String output = "";
        output += " ".repeat(3);

        for(int i = 0; i < 8; i++) {
            output += " " + (char)('a' + i) + "  ";
        }
        
        output += "\n";
        output += "  " + "┌───" + "┬───".repeat(7) + "┐";
        output += "\n";
        for(int r = 0; r < board.length; r++) {
            output += (r)+1 + " │";
            for(int c = 0; c < board[r].length; c++) {
                output += " ";
                if(board[r][c] == null) {
                    output += " ";
                } else {
                    output += board[r][c];
                }
                output += " │";
            }
            output += (" " + (r+1));
            output += "\n";
                    
            if(r == board.length-1) {
                output += "  " + "└───" + "┴───".repeat(7) + "┘";
            } else {
                output += "  " + "├───" + "┼───".repeat(7) + "┤";
            }
            output += "\n";
        }
        
        output += " ".repeat(3);

        for(int i = 0; i < 8; i++) {
            output += " " + (char)('a' + i) + "  ";
        }

        return output;
        
    }

    void play(Scanner scanner){
        InputHelper inputHelper = new InputHelper(scanner);
        ChessPiece[][] board = new ChessPiece[8][8];

        board[7][0] = new Rook(board, 0, 0, false);
        board[7][1] = new Knight(board, 0, 1, false);
        board[7][2] = new Bishop(board, 0, 2, false);
        board[7][3] = new Queen(board, 0, 3, false);
        board[7][4] = new King(board, 0, 4, false);
        board[7][5] = new Bishop(board, 0, 5, false);
        board[7][6] = new Knight(board, 0, 6, false);
        board[7][7] = new Rook(board, 0, 7, false);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(board, 1, i, false);
        }
        
        board[0][0] = new Rook(board, 0, 0, true);
        board[0][1] = new Knight(board, 0, 1, true);
        board[0][2] = new Bishop(board, 0, 2, true);
        board[0][3] = new Queen(board, 0, 3, true);
        board[0][4] = new King(board, 0, 4, true);
        board[0][5] = new Bishop(board, 0, 5, true);
        board[0][6] = new Knight(board, 0, 6, true);
        board[0][7] = new Rook(board, 0, 7, true);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(board, 1, i, true);
        }

        System.out.println(boardToString(board));

        boolean play = true;

        while(play){

            System.out.println(("White turn"));

        //ask which guy u wanna move, checks if they can move at all.
        int whichOne[] = new int[2];
        boolean dummy = true;
        while(dummy){
            int answer[] = inputHelper.getChessLocation("Which piece u wanna move breh");
            whichOne[0] = answer[0];
            whichOne[1] = answer[1];
            if(board[whichOne[0]][whichOne[1]] != null && board[whichOne[0]][whichOne[1]].getIsWhite() == true){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[whichOne[0]][whichOne[1]].canMoveTo(i, j) == true){
                        dummy = false;
                        System.out.println(boardToString(board));
                    }
                }
            }
        }

        } 


        int whereOne[] = new int[2];
        //Asks where u wanna move until you give a real answer and not a stupid one
        boolean idiot = true;
        while(idiot){
            int answer[] = inputHelper.getChessLocation("Where u wanna move piece breh");
            whereOne[0] = answer[0];
            whereOne[1] = answer[1];
            if(board[whichOne[0]][whichOne[1]].canMoveTo(whereOne[0], whereOne[1]) == true){
                idiot = false;
                board[whichOne[0]][whichOne[1]].moveTo(whereOne[0], whereOne[1]);
                System.out.println(boardToString(board)); 
            }
        }

        if(getWinner(board) != 0){
            if(getWinner(board) == 1){
                System.out.println("White #1!!!");
                play = false;
                break;
            } else if(getWinner(board) == -1){
                System.out.println("Black #1!!!");
                play = false;
                break;
            }
        }

        System.out.println(("Blacck turn"));

        int whichOneB[] = new int[2];
        boolean dummy2 = true;
        while(dummy2){
            int answer[] = inputHelper.getChessLocation("Which piece u wanna move breh-");
            whichOneB[0] = answer[0];
            whichOneB[1] = answer[1];
            if(board[whichOneB[0]][whichOneB[1]] != null && board[whichOneB[0]][whichOneB[1]].getIsWhite() == false){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[whichOneB[0]][whichOneB[1]].canMoveTo(i, j) == true){
                        dummy2 = false;
                        System.out.println(boardToString(board));
                    }
                }
            }
        }
        } 

        //Asks where u wanna move until you give a real answer and not a stupid one
        boolean idiot2 = true;
        int whereOneB[] = new int[2];
        while(idiot2){
            int answer[] = inputHelper.getChessLocation("Where u wanna move piece breh");
            whereOneB[0] = answer[0];
            whereOneB[1] = answer[1];
            if(board[whichOneB[0]][whichOneB[1]].canMoveTo(whereOneB[0], whereOneB[1]) == true){ //NOTWORKING
                idiot2 = false;
                board[whichOneB[0]][whichOneB[1]].moveTo(whereOneB[0], whereOneB[1]);
                System.out.println(boardToString(board)); 
            }
        }

        if(getWinner(board) != 0){
            if(getWinner(board) == 1){
                System.out.println("White #1!!!");
                play = false;
                break;
            } else if(getWinner(board) == -1){
                System.out.println("Black #1!!!");
                play = false;
                break;
            }
        }

    }
        
    
        //the main game loop. Example output in `ChessExample.txt`. You are allowed to make it a 2 player or 1 player game (vs. computer). Ideas for simple chess AI are at the bottom of this README.
    }

    static int getWinner(ChessPiece[][] board){
        boolean isWKA = false;
        boolean isBKA = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != null){
                if (board[i][j].toString().equals("k")){
                    isBKA = true;
                } else if (board[i][j].toString().equals("K")){
                    isWKA = true;
                }
            }
            }
        }
        if(isWKA == true && isBKA == true){
            return 0;
        } else if (isWKA == true){
            return 1;
        } else if (isBKA == true){
            return -1;
        } else {
            return 0;
        }
        //a `static` method that returns `1` if white has won, returns `-1` if black has won, and `0` otherwise. A side wins if the other side does not have a king. If both sides have the same number of kings, the function should return `0`.
        
    }
}
