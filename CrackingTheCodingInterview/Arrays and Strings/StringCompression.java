
// Implement a method to perform basic string compression using the counts of repeated characters.
// Example :
// String s = "aabcccccaaa would give
//  ouput : a2b1c5a3
// If the compressed string is not smaller than original string return original string

public class StringCompression {
    public static void main(String[] args) {
        String s = "abcdef";
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count++;
            if(i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)){
                ans.append(s.charAt(i));
                ans.append(count);
                count = 0;
            }

        }
        if(ans.length() < s.length())
            System.out.println(ans);
        else
            System.out.println(s);
    }
}
