
// Same as NQueen problem but isSafe Method will change
// Instead of using while loops to check whether to place queen safe or not
// we will use mathematical calculations and by taking extra space

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens2 {
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

        // Extra arrays to keep track of queen placing row wise and diagonally
        int[] left_check = new int[size];   // For checking left side row of queen
        int[] upper_diag_check = new int[2 * size - 1];
        int[] lower_diag_check = new int[2 * size - 1];
        int col = 0;
        List<List<String>> ans = new ArrayList<>();
        solveNQueens(size, col, board, ans,left_check,upper_diag_check,lower_diag_check);
        return ans;
    }


    //Method to solve NQueens (main logic)
    public static void solveNQueens(int size, int col, char[][] board, List<List<String>> ans,int[] left_check,int[] upper_diag_check,int[] lower_diag_check) {

        // Base condition
        if (col == size) {
            ans.add(fillAnsList(board));
            return;
        }

        //Main row loop
        for(int row = 0; row < size; row++){
            if(isSafe(row,col,board,left_check,upper_diag_check,lower_diag_check)){
                board[row][col] = 'Q';
                left_check[row] = 1;
                upper_diag_check[row + col] = 1;
                lower_diag_check[(size - 1) + col - row] = 1;
                solveNQueens(size,col + 1, board,ans,left_check,upper_diag_check,lower_diag_check);
                left_check[row] = 0;
                upper_diag_check[row + col] = 0;
                lower_diag_check[(size - 1) + col - row] = 0;
                board[row][col] = '.';
            }

        }
    }


    // Method to check whether the queen placed is safe or not
    public static boolean isSafe(int row, int col, char[][] board,int[] left_check,int[] upper_diag_check,int[] lower_diag_check){

        int temp_row = row;
        int temp_col = col;

        if(left_check[row] != 1 && upper_diag_check[row + col] != 1 && lower_diag_check[(board.length - 1) + col - row] != 1)
            return true;

        return false;
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
