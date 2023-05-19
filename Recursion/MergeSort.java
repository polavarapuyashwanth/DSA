
//Implementation of the Merge sort(not in-place) using recursion
// Time-complexity O(nlogn)

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
         int[] arr = {5,4,3,2,1};
         arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Method to sort array using Merge Sort
    public static int[] mergeSort(int[] arr){
        if(arr.length == 1)
            return arr;

        int mid = arr.length/2;
        //for left sub array
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));


        return merge(left,right);
    }

    // Method to merge two arrays by sorting them
    public static int[] merge(int[] left, int[] right){
        int[] merged_arr = new int[left.length + right.length];

        int i = 0; // pointer for left array
        int j = 0; // pointer for right array
        int k = 0; // pointer for new merged array

        //Sorting array while merging them into one
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                merged_arr[k] = left[i];
                i++;
            }
            else{
                merged_arr[k] = right[j];
                j++;
            }
            k++;
        }

        // If any one of the arrays are remaining while other is completed then following code will help to
        // implement remaining array elements

        while(i < left.length){      // If left array elements are remaining
            merged_arr[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length){     // If right array elements are remaining
            merged_arr[k] = right[j];
            j++;
            k++;
        }

        return merged_arr;

    }


}
