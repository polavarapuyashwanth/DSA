// Susbset2 problem from leetcode

import java.util.*;

public class Subsets2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> ans = subsetsWithDup(arr);
        System.out.println(ans);
    }

    // Method to get subsets
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        getSubsequences(nums, 0, list, ans);
        return ans;
    }

    // Helper function
    public static void getSubsequences(int[] nums, int index, ArrayList<Integer> list, List<List<Integer>> ans) {

        //Base condition
            ans.add(new ArrayList<Integer>(list));


        //we will try to use for loop to run through all array and only allow the
        // first occuring elements

        for (int i = index; i < nums.length; i++) {

            if (i != index && nums[i] == nums[i - 1])
                continue;

                list.add(nums[i]);
                getSubsequences(nums, i + 1, list, ans);
                list.remove(list.size()-1);


        }
    }
}
