
//Order Agnostic Binary search is a method used when we don't know the order (Ascending or descending)
//Of a given array
// We know that array is sorted but don't know whether it is ascending or descending

//We can solve this problem by just comparing the first and last elements of array

public class OrderAgnosticBinarySearch {
    public static void main(String args[]){
        int[] arr =  {4,9,14,19,44,67,89}; // Ascending
        //int[] arr=  {89,67,44,19,14,9,4};
        int target = 4;
        int indexOfTargetElement = orderAgnosticBS(arr,target);
        if (indexOfTargetElement != -1)
            System.out.println("The target element : "+arr[indexOfTargetElement]+ " is found at :" + indexOfTargetElement);
        else
            System.out.println("Element not found");
    }

    //Binary search logic
    //return index if found target element
    //return -1 if not found the target element

    static int orderAgnosticBS(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        //The problem with the below statement is that sometimes when the start and end values are large
        //and gets out of integer then it may throw some error.
        //int mid = (start + end)/2;

        //Finding whether the array is ascending or descending order
        boolean isAscen = arr[0] < arr[arr.length-1];



        while(start <= end){
            //The better version of above statement is
            int mid = start + (end - start)/2;

            if(target == arr[mid])    //Common for both ascending and descending
                return  mid;

            //If ascending
            if(isAscen) {
                if (target < arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else {  // If descending
                if (target > arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }

        //If we don't find target value return - 1
        return  -1;
    }
}
