

// NQueens problem is a popular Backtracking problem

import java.util.*;

public class NQueens {

    // Void main  Method
    public static void main(String[] args) {
        int size = 4;
        List<List<String>> ans = placeNQueens(size);
        int i = 0;
        for(List<String> l : ans) {
            System.out.println("Answer : " + ++i);
            for (String s : l) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    // Wrapper method to place NQueens on chess board
    public static List<List<String>> placeNQueens(int size) {

        char[][] board = fillBoard(size);
        int col = 0;
        List<List<String>> ans = new ArrayList<>();
        solveNQueens(size, col, board, ans);
        return ans;
    }


    //Method to solve NQueens (main logic)
    public static void solveNQueens(int size, int col, char[][] board, List<List<String>> ans) {

        // Base condition
        if (col == size) {
            ans.add(fillAnsList(board));
            return;
        }

        //Main row loop
        for(int row = 0; row < size; row++){
            if(isSafe(row,col,board)){
                board[row][col] = 'Q';
                solveNQueens(size,col + 1, board,ans);
                board[row][col] = '.';
            }

        }
    }


    // Method to check whether the queen placed is safe or not
    public static boolean isSafe(int row, int col, char[][] board){

        int temp_row = row;
        int temp_col = col;

        // Checking for left side or if the queen is in the same row
        while(col >= 0){
            if(board[row][col] == 'Q')
                return false;
            col--;
        }

        col = temp_col;

        // Checking for upside left diagonally
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }

        row = temp_row;
        col = temp_col;

        // Checking for lowerside left diagonally
        while(row < board.length && col >= 0){
            if(board[row][col] == 'Q')
                return false;
            row++;
            col--;
        }

        return true;
    }


    // Method to fill chess board
    public static char[][] fillBoard(int size) {
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                board[i][j] = '.';
        }
        return board;
    }

    // Method to convert char array and to List<String>
    public static List<String> fillAnsList(char[][] board) {
        List<String> ans = new ArrayList<String>();

        for (int i = 0; i < board.length; i++) {
            String s = Arrays.toString(board[i]);
            ans.add(s);
        }
        return ans;
    }

}
