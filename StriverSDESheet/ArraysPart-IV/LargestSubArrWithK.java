// Given an array having both positive and negative integers.
// The task is to compute the length of the largest subarray with sum 0.
//
//        Example 1:
//
//        Input:
//        N = 8
//        A[] = {15,-2,2,-8,1,7,10,23}
//        Output: 5
//        Explanation: The largest subarray with
//        sum 0 will be -2 2 -8 1 7.


// Approaches :
// 1 : Brute force (TC : O(n2) SC : O(1)
// 2 : Optimized - Using Hashmap (TC : O(n), SC : O(n)) - TC will be O(n) if hashmap uses good hash and not chaining occurs
//     The second approach works for both -ve and +ve values

import java.util.HashMap;

public class LargestSubArrWithK {
    public static void main(String[] args) {
       int nums[] = {-5, 8, -14, 2, 4, 12 };
       int k = -5;  // Target
       //int ans = getSubArr(nums,k); // Calling Method for Approach - 1
       int ans = getSubArr2(nums,k); // Calling Method for Approach - 2
        System.out.println(ans);
    }

    // Approach - 1 : Brute force (TC : O(n2) SC : O(1)
    public static int getSubArr(int[] arr,int k){
        int max = 0;

        for(int i = 0; i < arr.length; i++){
            int sum = arr[i];
            int count = 1;
            if(sum == k)
                max = Math.max(max,count);
            for(int j = i + 1; j < arr.length; j++){
                sum += arr[j];
                count++;
                if(sum == 0)
                    max = Math.max(max,count);
            }
        }

        return max;
    }

    // Approach - 2 : Optimized using HashMap (TC : O(n) SC : O(n))
    public static int getSubArr2(int[] arr,int k){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            int diff = sum - k;
            if(sum == k)
                max = Math.max(max, i + 1);
            else if(map.containsKey(diff))
                max = Math.max(max,i - map.get(diff));
            if(!map.containsKey(sum))
                map.put(sum,i);
        }

        return max;
    }
}
