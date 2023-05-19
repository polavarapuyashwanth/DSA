
//Bubble sort also known as sink sort or exchange sort is a simple and stable sorting technique
// Best-case(sorted) - O(n)
// Worst-case - O(n^2)

import java.util.Arrays;

public class BubbleSort {
    public static void main(String args[]){
        int[] arr = {5,4,3,2,1};
        getSortedarray(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Method to implement bubble sort
    static void getSortedarray(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            boolean swapped = false;
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!swapped)
                 break;
        }
    }
}
