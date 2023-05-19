import  java.util.Scanner;

//Searching character in a String
class StringSearch{
    public static void main(String args[]){

        Scanner scan = new Scanner(System.in); // Intializing Scanner class

        String input; //Declaring variables

        System.out.println("Enter the string:");
        input = scan.next(); // Taking input from user
        System.out.println("Enter the character to search in String:");
        char character = scan.next().charAt(0); // Taking input from user
        int index = find_element(input,character);

        //output type 1
        if(index == -1)
            System.out.println(character + " not present in "+input);
        else
            System.out.println("The element you are searching for " + character+" is found at "+index+" index in "+input);

       //output type 2
        System.out.println("\n\n\nThis is Type 2 printing \n ====================================");
        int ele = find_element2(input,character);
        if(ele == Integer.MAX_VALUE)
            System.out.println(character + " not present in "+input);
        else
            System.out.println("The element you are searching for " + character+" is found in "+input);

    }

    //Main Linear search logic
    private static int find_element(String s, char element){
        for(int i = 0; i < s.length(); i++){
            if(element == s.charAt(i))
                return i;     // Returning index
        }
        return -1;
    }

    //Main Linear search logic in alternative for loop
    private static int find_element2(String s, char element){
       for(char c : s.toCharArray()){
           if (element == c)
               return c ;
       }
       return Integer.MAX_VALUE;
    }
}