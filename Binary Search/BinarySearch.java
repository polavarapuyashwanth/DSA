import javax.swing.*;

public class BinarySearch {
    public static void main(String args[]){
        int[] arr =  {4,9,14,19,44,67,89};
        int target = 90 ;
        int indexOfTargetElement = findElement(arr,target);
        if (indexOfTargetElement != -1)
            System.out.println("The target element : "+arr[indexOfTargetElement]+ " is found at :" + indexOfTargetElement);
        else
            System.out.println("Element not found");
    }

    //Binary search logic
    //return index if found target element
    //return -1 if not found the target element

    static int findElement(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        //The problem with the below statement is that sometimes when the start and end values are large
        //and gets out of integer then it may throw some error.
        //int mid = (start + end)/2;

        while(start <= end){
            //The better version of above statement is
            int mid = start + (end - start)/2;

            if(target == arr[mid])
                return  mid;
            else if (target < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }

        //If we don't find target value return - 1
        return  -1;
    }
}