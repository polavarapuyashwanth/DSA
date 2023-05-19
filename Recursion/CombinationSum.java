
// Leet code problem - Combination sum
// Tags : Backtracking , Recursion

import java.util.ArrayList;

public class CombinationSum {
    public static void main(String[] args){
        int[] arr = {2,3,6,7};
        int target = 7;
        ArrayList<Integer> list = new ArrayList<Integer>();
        printPairs(arr,0,target,list);
        System.out.println( "total count : " + count);
    }

    //Method to find combination which equals to target sum
    // each element can be repeated to form a successful sub-array to form sum
   static  int count = 0;
    public static void printPairs(int[] arr, int index, int target, ArrayList<Integer> list){
       count++;
        //Base condition
        if(index >= arr.length){
            if(target == 0)
                System.out.println(list);
            return;
        }

        //Picking condition
        if(target - arr[index] >= 0){
            list.add(arr[index]);
            printPairs(arr,index,target - arr[index],list);
        }

        //Not pick condition
        printPairs(arr,index + 1,target,list);
        list.remove(Integer.valueOf(arr[index]));
    }
}
