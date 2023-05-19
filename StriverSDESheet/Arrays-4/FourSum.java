
// Given an array nums of n integers, return an array of all the unique quadruplets
// [nums[a], nums[b], nums[c], nums[d]] such that:
// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

import java.util.*;
public class FourSum {
    public static void main(String[] args){
        // Inputs
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;

        // Need to sort to perform two pointer
        Arrays.sort(nums);
        List<List<Integer>>ans = new ArrayList<>();
        getQuadruples(nums,ans,target);
        for(List i : ans)
            System.out.println(i);
    }

    // Method to find Quadruples equals target sum
    public static void getQuadruples(int[] nums, List<List<Integer>> ans, int target){
        int n = nums.length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int left = j + 1;
                int right = n - 1;
                while(left < right){
                    int sum = nums[i] + nums[j];
                    int target2 = target - sum;
                    int sum2 = nums[left] + nums[right];
                    List<Integer> list = new ArrayList<>();
                    if(sum2 < target2)
                        left++;
                    else if(sum2 > target2)
                        right--;
                    else {
                        Collections.addAll(list, nums[i], nums[j], nums[left], nums[right]);
                        ans.add(new ArrayList<>(list));
                        list.clear();

                        // Skipping duplicates for left and right pointers
                        while (left + 1 < right && nums[left] == nums[left + 1]) ++left;
                        ++left;
                        while (right - 1 > left && nums[right] == nums[right - 1]) --right;
                        --right;

                    }
                }
                // Skipping duplicates for 2nd element in Quadruple
                while(j + 1 < n && nums[j] == nums[j + 1]) j++;
            }
            // Skipping duplicates for 1st element in Quadruple
            while(i + 1 < n && nums[i] == nums[i + 1]) i++;
        }
    }

} // End of class

