
// Program to implement Bubble sort using recursion technique

import java.util.Arrays;

public class BubbleSortRecursion {
    public static void main(String[] args){

        int[] arr = {1,2,4,3};
        bubbleSort(arr,arr.length,0);
        System.out.println(Arrays.toString(arr));
    }

    // Method to implement Bubble sort using recursion
    public static void bubbleSort(int[] arr,int row, int col){
        //Base condition
        if(row <= 0)
            return;

        // Iteration of each row
        if(row > col + 1){
            if(arr[col] > arr[col + 1]){
                //swap
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            bubbleSort(arr,row,col + 1);
        }
        else {
            bubbleSort(arr,row - 1,0);
        }
    }
}
