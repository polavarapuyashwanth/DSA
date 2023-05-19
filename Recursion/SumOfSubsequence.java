
// Print Subsequences whose sum is k.

import java.util.ArrayList;

public class SumOfSubsequence {
    public static void main(String[] args){
       int[] arr = {1,2,1};
       ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println(subsequence(arr,list,0,4));
    }

    // Method to Print or find subsequences whose sum is equals to k.
    public static int subsequence(int[] arr, ArrayList<Integer> list,int index,int sum){
        if(index >= arr.length) {
            int sum_local = 0;
            for(int i : list){
                sum_local += i;
            }
            if(sum_local == sum)
                return 1;
            return 0;
        }

        //Not take
        int l = subsequence(arr,list,index + 1,sum);

        //Take
        list.add(arr[index]);
         int r = subsequence(arr,list,index + 1,sum);
        list.remove(Integer.valueOf(arr[index]));

        return l + r;
    }
}
