import java.util.*;

public class Testing{
    public static void main(String[] args) {
        int[] arr = {2,1,4};
        int maxSize = 1;
        for(int i : arr)
            maxSize = Math.max(i,maxSize);
        int[][]dp = new int[maxSize + 1][maxSize + 1];
        for(int[]i : dp)
            Arrays.fill(i,-1);

        int ans = sumOfPower(arr,dp);
        System.out.println(ans);

    }
        public static int sumOfPower(int[] nums,int[][] dp) {
            return generate(nums,nums.length - 1, Integer.MAX_VALUE, Integer.MIN_VALUE,dp);
        }

        // Generate all possible susbsets
        public static int generate(int[] nums, int index, int min, int max,int[][] dp){
            // Base condition
            if(index < 0){
                if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) return 0;
                int ans = 0;
                ans += (int)(Math.pow(max,2) * min);
                return ans;

            }
            if(max != Integer.MIN_VALUE && min != Integer.MAX_VALUE && dp[min][max] != -1 ) return dp[min][max];

            int take = 0;
            int notTake = 0;

            // Not take
            notTake =  generate(nums,index - 1, min, max,dp);

            // Take
            min = Math.min(min,nums[index]);
            max = Math.max(max,nums[index]);
            take = generate(nums,index - 1, min,max,dp);

            if(max != Integer.MIN_VALUE && min != Integer.MAX_VALUE)
                dp[min][max] = take + notTake;
            else return take + notTake;

            return dp[min][max];


        }
}
