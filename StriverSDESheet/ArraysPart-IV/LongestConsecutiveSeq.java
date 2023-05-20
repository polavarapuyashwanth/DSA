
// Leetcode - 128:
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// Test case - 1 :
// Input: nums = [100,4,200,1,3,2]
//        Output: 4
//        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

// Approaches :
// 1. Sort the Array and find the consecutive elements (TC : O(nlogn) + O(n), Sc : O(1))
// 2. Using Hash set and finding smallest number
//     (TC : O(n) )

import java.util.*;
public class LongestConsecutiveSeq {
    public static void main(String[] args) {
         int[] nums = {100,4,200,1,3,2};
        // int ans = getLongestSeq(nums);  // Calling method for Approach - 1
         int ans = getLongestSeq2(nums);  // Calling method for Approach - 2
        System.out.println(ans);
    }

    // Approach - 1
    // Sort the Array and find the consecutive elements (TC : O(nlogn) + O(n), Sc : O(1))
    public static int getLongestSeq(int[] nums){
        Arrays.sort(nums); // sorting the array

        int count = 1; int max = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]) continue; // if both are same elements
            else if(Math.abs(nums[i] - nums[i - 1]) == 1){
                count++;
                max = Math.max(max,count);
            }
            else
                count = 1;
        }
        return max;
    }

    // Approach - 2 - Most Optimal
    // Using Hash set and finding smallest number
    public static int getLongestSeq2(int[] nums){
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        // Putting everything into set
        for(int i : nums)
            set.add(i);

        for(int i : nums){
            if(!set.contains(i - 1)){
                int count = 0;
                int temp = i;
                while(set.contains(temp++)){
                    count++;
                    max = Math.max(max,count);
                }
            }
        }
        return max;
    }
}
