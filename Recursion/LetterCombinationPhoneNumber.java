
// Leet code problem - Letter combination of a phone Number


public class LetterCombinationPhoneNumber {
    public static void main(String[] args){
        char[][] arr = {
                {},
                {},
                {'a','b','c'},
                {'d','e','f'}
        };
        String s = "23";
        getCombinations(s,"",arr);
    }

    // Method to find all combinations of phone numbers using string
    public static void getCombinations(String s, String ans, char[][] arr){

        //Base condition
        if(s.isEmpty()) {
            System.out.println(ans);
            return;
        }

        int index = Integer.parseInt(s.substring(0,1));

        for(int i = 0; i < 3; i++){
            char ch = arr[index][i];
            getCombinations(s.substring(1), ans + ch,arr);
        }
    }
}
