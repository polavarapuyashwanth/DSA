
// Sudoku Solver - Leet code question

public class SudokuSolver {
    public static void main(String[] args) {
       char[][] board = {
               {'5','3','.','.','7','.','.','.','.'},
               {'6','.','.','1','9','5','.','.','.'},
               {'.','9','8','.','.','.','.','6','.'},
               {'8','.','.','.','6','.','.','.','3'},
               {'4','.','.','8','.','3','.','.','1'},
               {'7','.','.','.','2','.','.','.','6'},
               {'.','6','.','.','.','.','2','8','.'},
               {'.','.','.','4','1','9','.','.','5'},
               {'.','.','.','.','8','.','.','7','9'}
       };

       if(solve(board)){
           for(char[] arr : board){
               for(char ch : arr)
                   System.out.print(ch + " ");
               System.out.println();
           }
       }
    }

    // Method to solve sudoku puzzle
    public static boolean solve(char[][] board){

        // Outer loop for row
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char ch = '1'; ch <= '9'; ch++){
                        if(isSafe(board,i,j,ch)){
                            board[i][j] = ch;

                            if(solve(board) == true)
                                return  true;
                            else
                                board[i][j] = '.';
                         }

                    }
                    return false;
                }

            }
        }
        return true;
    } // solve method ending

   // Method to check whether placing the character is safe or not
    public static boolean isSafe(char[][] board,int row,int col, char ch){

        for(int i = 0; i < board.length; i++){
            //checking for row
            if(board[row][i] == ch)
                return false;
            if(board[i][col] == ch)
                return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch)
                return false;
        }
        return true;
    }
}








