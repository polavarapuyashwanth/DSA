//The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from the unsorted part and putting it at the beginning.
//
//        The algorithm maintains two subarrays in a given array.
//
//        The subarray which already sorted.
//        The remaining subarray was unsorted
//        It is unstable sorting algorithm

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        sorting(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sorting(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int index = getMaxElement(arr,0,arr.length-i-1);
            swap(arr,index,arr.length-i-1);
        }
    }
    //Method to find Max element and return index of that element
    public static int getMaxElement(int[] arr, int start, int end){
        int max = start;
        for(int i = start; i <= end; i++){
            if(arr[i] > arr[max])
                max = i;
        }
        return max;
    }
    public static void swap(int[] arr, int max_index,int last_index){
        int temp = arr[max_index];
        arr[max_index] = arr[last_index];
        arr[last_index] = temp;
    }
}
