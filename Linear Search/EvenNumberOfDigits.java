
//Leet code question based on Linear Search Topic
//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

//Solution Approach: We have two possible approaches
// 1st being general,
// 2nd being mathematical(more optimized)

//Input: nums = [12,345,2,6,7896]
//        Output: 2
//        Explanation:
//        12 contains 2 digits (even number of digits).
//        345 contains 3 digits (odd number of digits).
//        2 contains 1 digit (odd number of digits).
//        6 contains 1 digit (odd number of digits).
//        7896 contains 4 digits (even number of digits).
//        Therefore only 12 and 7896 contain an even number of digits.

public class EvenNumberOfDigits {
    public static void main(String args[]){
        int[] nums = {12,345,2,6,7896,44};
        System.out.println(NumberOfDigits(nums)); // 1st Approach
        System.out.println(NumberOfDigits2(nums)); // 2nd Approach
    }

    //1st approach
    static int NumberOfDigits(int[] arr){
        int final_count = 0;
        for(int val : arr){
            int count = 0;

            //Checking for negative integer case
            if(val < 0)
                val = val * -1;

            //Counting no of digits
            while (val > 0){
                count++;
                val = val/10;
            }
            if((count & 1) != 1)
                final_count++;
        }
        return final_count;
    }

    //2nd approach - Using Mathematics
    static int NumberOfDigits2(int[] arr){
        int final_count = 0;
        for(int val : arr){
            int count = 0;

            //Checking for negative integer case
            if(val < 0)
                val = val * -1;

            //Counting no of digits
            count = (int)(Math.log10(val)) + 1;
            if((count & 1) != 1)
                final_count++;
        }
        return final_count;
    }
}
