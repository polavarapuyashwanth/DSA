
// Binary Search in Rotated Arrays
// Ex : [4,5,6,7,1,2,3]  here [4,5,6] - first half
//                            [1,2,3] - second half
//                                 7  - pivot element

public class RotatedBinarySearch {
    public static void main(String args[]){
        int[] arr = {2,9,2,2,2};
        int target  = 2 ;
        int val = rbs(arr,target);
        System.out.println(val);

    }

    // Method to use Binary search in Rotated array
    // We need following steps to achieve that :
    // 1. Find Pivot element.
    // 2. Search from index - 0 to pivot.
    // 3. Search from Pivot + 1 - arr.length.

    private static int rbs(int[] arr, int target){

        if(arr.length == 1){
            if(arr[0] == target)
                return  0;
            else
                return  -1;
        }
        // Finding pivot element
         int pivot = getPivot(arr);
        //System.out.println("Pivot val : " + arr[pivot]);

         

         int first_half = bs(arr,0, pivot,target);
         int second_half = -1;
         if(first_half == -1) {
             second_half = bs(arr, pivot + 1, arr.length - 1, target);
             return second_half;
         }
         else
             return first_half;
    }

    //Method to find Pivot element
    private static int getPivot(int[] arr){
        int start = 0;
        int end   = arr.length - 1;
        int ans = Integer.MIN_VALUE;
        while(start <= end){
            int mid = start + (end - start)/2;

            if(mid < arr.length - 1 && arr[mid] > arr[mid + 1]){
                    ans = arr[mid];
                    return mid;
            }
            else if(arr[mid] < arr[0])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    //Method to do Binary search
    private static int bs(int[] arr, int start_index, int end_index, int target){
        int start = start_index;
        int end = end_index;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;

        }
        return -1;
    }
}
