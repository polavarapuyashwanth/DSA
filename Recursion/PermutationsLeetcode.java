
// Important used built-in methods
// 1.Arrays.copyOfRange(arr,start index, end_index)
// list.subList

import java.util.*;

class PermutationsLeetcode{

    public static void main(String[] args) {

        int[] arr = {1,2,3};
        List<List<Integer>> ans = permute(arr);
        System.out.println(ans);


    }

    // Method to get permutations of integer array
    public static List<List<Integer>> permute(int[] nums) {

        // Array to check whether element is already inserted or not
        boolean[] freq = new boolean[nums.length];

        List<List<Integer>> ans = new ArrayList<>();
       //getPermutations(nums,new ArrayList<Integer>(),ans);
        getPermutations2(nums,new ArrayList<Integer>(),ans,freq);
//        getPermutations3(nums,0,ans);

        return ans;

    }


    // Method - 1 ( did same as for string permutation program)
    // Helper function
    public static void getPermutations(int[] nums, ArrayList<Integer> list,List<List<Integer>> ans){

        //Base condition
        if(nums.length == 0){
            ans.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = 0; i <= list.size(); i++){
            list.add(i,nums[0]);
            int[] temp = Arrays.copyOfRange(nums,1,nums.length);
            getPermutations(temp,list,ans);
            list.remove(i);
        }
    }


    // Method - 2  : By taking a extra 0(n) space array to check whether the element
    //               is inserted or not

    public static void getPermutations2(int[] nums,ArrayList<Integer> list, List<List<Integer>> ans, boolean[] freq){

        // Base condition
        if(list.size() == 3){
            ans.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!freq[i]){
                list.add(nums[i]);
                freq[i] = true;
                getPermutations2(nums,list,ans,freq);
                list.remove(list.size() - 1);
                freq[i] = false;
            }
        }
    }


    // Method - 3  : Using swapping technique and without using any extra space
    //               we will use the given array to swap and when completing recursion
    //               we will again swap back to its original position

    public static void getPermutations3(int[] nums, int index, List<List<Integer>> ans){

        // Base condition
        if(index == nums.length){
            ArrayList<Integer> list = new ArrayList<Integer>();

            // copying answer to list so that we could add that final answer list ans
            for(int i = 0; i < nums.length;i++)
                list.add(nums[i]);

            ans.add(new ArrayList<>(list));
        }

        for(int i = index; i < nums.length; i++){
            swap(index,i,nums);
            getPermutations3(nums,index + 1,ans);
            swap(index,i,nums);
        }
    }

    // swap method
    public static void swap(int index1, int index2, int[] arr){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}