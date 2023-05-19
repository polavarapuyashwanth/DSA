
// Best way to do Subsequences is using power set algorithm O(n)
// But in this program we try to implement using recursive approach

import  java.util.ArrayList;
public class Subsequences {
    public static void main(String[] args){
        int[] arr = {3,1,2};
        ArrayList<Integer> list = new ArrayList<Integer>();
        getSubsequences(0,arr,list );
    }

    // Method to find subsequence sets
    public static  void getSubsequences(int index, int[] arr, ArrayList<Integer> list){
        //Base condition
        if(index >= arr.length){
            System.out.println(list);
            return;
        }
        //Not - take
        getSubsequences(index + 1,arr,list );

        //Take
        list.add(arr[index]);
        getSubsequences(index + 1, arr, list);
        list.remove(Integer.valueOf(arr[index]));

    }

}

