

// Program to place N-Knights on N x N chessboard without attacking each other

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NKnights {

        // Void main  Method
        public static void main(String[] args) {
            int size = 3;
            List<List<String>> ans = placeNKnights(size);
            int i = 0;
            for(List<String> l : ans) {
                System.out.println("Answer : " + ++i);
                for (String s : l) {
                    System.out.println(s);
                }
                System.out.println();
            }
        }

        // Wrapper method to place N-Knights on chess board
        public static List<List<String>> placeNKnights(int size) {

            char[][] board = fillBoard(size);
            int col = 0;
            List<List<String>> ans = new ArrayList<>();
            solveNKnights(size, col, board, ans);
            return ans;
        }


        //Method to solve NKnights (main logic)
        public static void solveNKnights(int size, int col, char[][] board, List<List<String>> ans){
            // Base condition
            if (col == size) {
                ans.add(fillAnsList(board));
                return;
            }

            //Main row loop
            for(int row = 0; row < size; row++){
                if(isSafe(row,col,board)){
                    board[row][col] = 'K';
                    solveNKnights(size,col + 1, board,ans);
                    board[row][col] = '.';
                }

            }
        }


        // Method to check whether the Knights placed is safe or not
        public static boolean isSafe(int row, int col, char[][] board){

            // To place N-Knights we have 4 conditions to check

            if(row - 2 >= 0 && col - 1 >= 0 && board[row - 2][col - 1] == 'K')
                return false;
            if(row - 1 >= 0 && col - 2 >= 0 && board[row -1][col - 2] == 'K')
                return false;
            if(row + 2 < board.length && col - 1 >= 0 && board[row + 2][col - 1] == 'K')
                return false;
            if(row + 1 < board.length && col - 2 >= 0 && board[row + 1][col - 2] == 'K')
                return false;

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

