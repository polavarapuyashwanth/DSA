
// Problem no - 1.2 from arrays and strings - cracking the coding interview

// Method -1  : Brute force - Using backtracking to find all permutations of a string and compare it with another one
//         TC : O(N X N!) and SC : O(1)

// Method -2  : Taking frequency of characters of both strings and comparing them
//         TC : O(N) and SC : O(1) - even though extra space it does not increase with n so constant

// Method - 3 : we can sort the strings and simply compare them
//         TC : O(N log n)

import java.util.*;

public class CheckPermutation_60 {
    public static void main(String[] args) {
        String str = "abc";
        String str2 = "dbc";
        //System.out.println(permutations(str,str2,0));   // Method - 1
        System.out.println(isSame(str,str2));

    }

    // Method - 1
    // Permutations of a string
    public static boolean permutations(String s,String s2, int index){
        if(index >= s.length()){
            if(s.equals(s2))
                return true;
        }

        for(int i = index; i < s.length(); i++){
            s = swap(index, i,s);
            if(permutations(s,s2,index + 1))
                return true;
            s = swap(index,i,s); // deswapping
        }
        return false;
    }

    // Method to do swap
    public static String swap(int index1, int index2,String s){
        char[] arr = s.toCharArray();
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

        return String.valueOf(arr);

    }

    // Method 2 - using character frequency array
    public static boolean isSame(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for(int i = 0; i < s1.length(); i++){
            int char_val = s1.charAt(i);
            freq1[char_val]++;
            char_val = s2.charAt(i);
            freq2[char_val]++;
        }

        // Checking if both the strings are same
        for(int i = 0; i < freq1.length; i++){
            if(freq1[i] != freq2[i])
                return false;
        }
        return true;
    }
}
