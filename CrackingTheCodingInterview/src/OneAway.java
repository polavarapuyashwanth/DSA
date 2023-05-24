
// There are three types of edits that can be performed on a string :
//  1.Insert a character
//  2.Remove a character
//  3.Replace a character

// Example :
// pale, ple   -> true  (we can insert only one character and they become equal)
// pales, pale -> true  (we can remove only one character and they become equal)
// plae, bale  -> true  (we can replace only one character and they become equal)
// plae, bae   -> false (we have to perform more than one operation to make them equal)


// Approach : 1. For Insertion case we can see if length of one is and another is 1 and if it is then
//               we can see if only one element is missing.
//            2. For Removal case is same as insertion but we see if only one element is extra and
//               all other are same
//            3. For replace we simple loop through both of them and only one character can be different.
public class OneAway {
    public static void main(String[] args) {
        String s1 = "pale";
        String s2 = "bae";
        boolean ans;
        // Checking which operation to perform
        if(s1.length() != s2.length() && Math.abs(s1.length() - s2.length()) != 1)
            ans = false;

        if(s1.length() == s2.length())
            ans = checkReplace(s1,s2);
        else if(s1.length() > s2.length())
            ans = checkInsertRemove(s1,s2);
        else
            ans = checkInsertRemove(s2,s1);

        System.out.println(ans);
    }

    // Method to check Replace operation
    public static boolean checkReplace(String s1, String s2){
        int index1 = 0, index2 = 0;
        boolean oneChar = false;
        while(index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(oneChar) return false;
                oneChar = true;
            }
            index1++;
            index2++;
        }
        return true;
    }

    // Method to check Insert operation
    public static boolean checkInsertRemove(String s1, String s2){
        int index1 = 0, index2 = 0;

        while(index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 == index2)
                    index1++;
                else
                    return false;
            }
            else{
                index1++;
                index2++;
            }
        }
        return true;
    }
}
