import java.util.Arrays;

//Searching for target element in 2D Arrays
public class Searching2dArrays {

    //Main Method
    public static  void main(String args[]){
        int[][] arr = {
                {23,4,1},
                {28,12,3,9},
                {78,99,340,56},
                {18,12}
        };

        int target = 12;
        int[] result = search(arr,target);

        //Output as index(row,column) for target element if found, else prints [-1,-1]
        System.out.println("Index : " + Arrays.toString(result));

        //Output for MAX element in array
        System.out.println("Max element in array is : " + max(arr));
    }

    //Method for searching target element in 2D array
    static private  int[] search(int[][] arr, int target){
        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col < arr[row].length; col++){
                if(target == arr[row][col])
                    return new int[] {row,col};
            }
        }
        return  new int[]{-1,-1};
    }


    //Method to find Max value in 2D Array
    static private int max(int[][] arr){
        int max = Integer.MIN_VALUE;
        for(int[] row : arr){
            for(int col : row){
                if(max < col)
                    max = col;
            }
        }
        return  max;
    }

}
