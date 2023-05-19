
//Program to return Ceiling and Floor from an array
//Ceiling  : The smallest number greater that or equal to the given number.
//Floor    : The Greatest number smaller than or equal to the given number.

//Same as Binary search except we return start for ceiling and end for floor.

public class CeilingAndFloorOfaNumber {
    public static void main(String args[]){
        int[] arr = { 2,3,5,9,14,16,18};
        int target = 10;
        System.out.println("Ceiling : " + arr[getCeiling(arr,target)]);
        System.out.println("Floor : " + arr[getFloor(arr,target)]);
    }

    //Method to get index for Ceiling of a number
    static int getCeiling(int[] arr, int target){

        //If the target Number is greater than any of the array values
        if(target > arr[arr.length - 1])
            return -1;

        //Initializing start and end variables
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end -start)/2;

            if(target == arr[mid])
                return mid;
            else if (target < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;   // We should return start for ceiling.
    }

    //Method to get index for Floor of a number
    static int getFloor(int[] arr, int target){

        //if target is the smallest of all array elements
        if(target < arr[0])
            return  - 1;

        //Initializing start and end variables
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end -start)/2;

            if(target == arr[mid])
                return mid;
            else if (target < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return end;   // We should return end for floor.
    }

}
