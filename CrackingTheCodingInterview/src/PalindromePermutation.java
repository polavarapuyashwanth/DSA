// Given a string write a function to check if it is a permutation of a palindrome.
// Ex :
// Input : Tact Coa
// Output : True
// Explanation : As all the letter frequencies of String "TactCoa" obey palindrome rules
//               t - 2 , c - 2, a - 2, o - 1
//               So the potential palindrome string can be tcaoact and given string can be permutation of this

// Approaches :
//  1.Using Set or Freq Array to count the freq of the letters and all the letters count should be 2 except for anyone 1 letter
//    If more than one letter have freq 1 that means it is not a palindrome
//  2.Using Bits to store the character

public class PalindromePermutation {
    public static void main(String[] args) {
         String s = "Tact Coa";
         s = s.toLowerCase();    // Changing to lower so that we have to only deal with 26 characters in this case
        System.out.println(isPermutation2(s));

    }

    // Approach - 1 : Using Hash set or Freq array
    // TC : O(n) , Sc : O(1) - 26 alphabet array only
    public static boolean isPermutation(String s){
        int[] freq = new int[25];
        for(char c : s.toCharArray()){
            int val = c - 'a';
            if(c >= 'a' && c <= 'z')
                freq[val]++;
        }

        boolean oneCount = false;
        for(int i : freq){
            if(i % 2 == 1){
                if(oneCount) return false;
                oneCount = true;
            }

        }
        return true;
    }

    // Approach - 2 : Using Bits to store the character
    // TC : O(n) , SC : O(1)
    public static boolean isPermutation2(String s){
        int checker = 0;
        for(char c : s.toCharArray()){
            int val =  c - 'a';
            if(c >= 'a' && c <= 'z'){
                if((checker & 1 << val) == 0)
                    checker = checker | 1 << val;
                else
                    checker = checker ^  1 << val;
            }
        }

        // Checking if only one character has 1 bit
        return  checker == 0 || (checker & (checker - 1)) == 0;
    }


}
