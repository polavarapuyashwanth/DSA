
// Problem no - 1.1 from arrays and strings - cracking the coding interview

// Method -1  : Brute force -
//         TC : O(N2) and SC : O(1)

// Method -2  : Using constant extra array of 128 or 256 length-
//         TC : O(N) and SC : O(1) - even though extra space it does not increase with n so constant



public class IsUnique_60 {
    public static void main(String[] args) {
        String str = "abcdeffg";
        System.out.println(isUnique_arr(str));
    }

    // Method to check if string has all unique characters
    // Brute force approach  - O(N2), O(1)
    public static boolean isUnique_bf(String s){
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j < s.length(); j++)
                if(s.charAt(i) == s.charAt(j))
                    return false;
        }
        return true;
    }

    // Method  to check if string has all unique characters
    // using boolean array of ASCII character length  - O(N) , O(1) - as we are taking only 128 character array
    public static boolean isUnique_arr(String s){
        boolean[] check = new boolean[128];
        for(int i = 0; i < s.length(); i++){
            int char_val = s.charAt(i);
            if(check[char_val])
                return false;
            check[char_val] = true;
        }
        return true;
    }
}
