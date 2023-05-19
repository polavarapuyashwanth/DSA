

import java.util.* ;
import java.io.*;
public class MergeSortCountInversion {
        public static void main(String[] args){
            long[] arr = {5,4,3,2,1};
            long temp = getInversions(arr,arr.length - 1);
            System.out.println("Array : " + Arrays.toString(arr));
            System.out.println();
            System.out.println(temp);
        }
        public static long getInversions(long arr[], int n) {
            return mergeSort(arr,0,n);

        }

        // Method to perform mergeSort
        public static long mergeSort(long[] arr, int left, int right){
            long countInverse = 0;
            // Base condition
            if(left < right){
                int mid = (left + right) / 2;
                countInverse += mergeSort(arr,left,mid);
                countInverse += mergeSort(arr,mid + 1,right);
                countInverse += merge(arr,left,mid,right);
            }

            return countInverse;
        }

        // Method to perform merge of left and right
        public static long merge(long[] arr, int left, int mid , int right){

            long countInverse = 0;

            long[] leftArr = Arrays.copyOfRange(arr,left,mid + 1);
            long[] rightArr = Arrays.copyOfRange(arr,mid + 1,right + 1);


            int i = 0; // for left array
            int j = 0; // for right array
            int k = left; // for temp array

            while(i < leftArr.length && j < rightArr.length){
                if(leftArr[i] <= rightArr[j]){
                    arr[k] = leftArr[i];
                    i++;
                }
                else{
                    arr[k] = rightArr[j];
                    j++;
                    countInverse += leftArr.length - i;
                }
                k++;
            }

            while(i < leftArr.length)
                arr[k++] = leftArr[i++];
            while(j < rightArr.length)
                arr[k++] = rightArr[j++];


            // arr = Arrays.copyOfRange(temp,0,temp.length);

            System.out.println("Sorted array :" + Arrays.toString(arr));

            return countInverse;

        }
    }

