
//String permutations are different from subsequences
// Perumutations requires all the letter or elements in a string to be considered

// Ex : string "abc"  -  [ abc,acb,bac,bca,cab,cba]
// The all possible permutations can be calculated by length of the string factorial
// In this case 3! = 3 x 2 = 6 possible combinations


import java.util.*;

public class StringPermutation {
    public static void main(String[] args){
          String s = "abcd";
         List<String> list = getPermutations(s,"");
        System.out.println(list);
    }

    // Method to return all possible combinations
    public static List<String> getPermutations(String s, String ans){

        ArrayList<String> list = new ArrayList<>();

        //Base case
        if(s.length() == 0) {
            //System.out.println(ans);
            list.add(ans);
            return list;
        }

        char ch = s.charAt(0);
        for(int i = 0; i <= ans.length(); i++){
           String temp = ans.substring(0,i) + ch + ans.substring(i,ans.length());
            list.addAll(getPermutations(s.substring(1),temp));
        }

        return list;
    }
}
