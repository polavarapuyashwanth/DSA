

//Introduction program to backtracking;
import java.util.*;

public class Backtracking {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        boolean[][] arr = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        maze(arr,0,0,"",list);
        System.out.println(list);
    }

    // Method to find all possible to path for given maze
    public static void maze(boolean[][] arr,int row, int col, String  ans, List<String> list){



        //Base condition
        if(row == arr.length - 1 && col == arr[0].length - 1){
            list.add(ans);
            return;
        }

        arr[row][col] = false;

        //Condition for up
        if(row > 0 && arr[row - 1][col]){

            maze(arr,row - 1, col , ans + 'U',list);

        }
        ///Condition for down
        if(row < arr.length - 1 && arr[row + 1][col]){
            maze(arr,row + 1, col , ans + 'D',list);

        }

        //Condition for Right
         if(col < arr[0].length - 1  && arr[row][col + 1]){
            maze(arr,row,col + 1,ans + 'R',list);

        }

        //Condition for left
        if(col > 0  && arr[row][col - 1])
            maze(arr,row, col - 1, ans + 'L',list);


        arr[row][col] = true;
    }
}

