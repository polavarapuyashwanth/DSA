

// This program is to demonstrate subsequences type of patterns
// using iterative approach rather than recursive one
import java.util.*;
public class IterativeSubsequence {
    public static void main(String[] args){
       int[] arr = {1,2,2};
       List<List<Integer>> ans ;

        //sort array if duplicates are given
        Arrays.sort(arr);
       ans =  getSubsequencesUnique(arr);

       //Printing subsequences
        for (List i : ans)
            System.out.println(i);
    }

    //Method to get subsequences using iterative approach
    public static List<List<Integer>> getSubsequences(int[] arr){

        // Outer list or the main list
        List<List<Integer>> outer = new ArrayList<List<Integer>>();

        outer.add(new ArrayList<Integer>());

        for(int i : arr){
            int n = outer.size();
            // For every element in array we try to add it to the list
            for(int j = 0; j < n ; j++){
                ArrayList<Integer> inner = new ArrayList<Integer>(outer.get(j));// Helps to have outer list elements by passing as argument

                inner.add(i);
                outer.add(inner);
            }

        }
       return  outer;
    }

    //Method to get unique subsequences if duplicates are given using iterative approach
    public static List<List<Integer>> getSubsequencesUnique(int[] arr){

        // Outer list or the main list
        List<List<Integer>> outer = new ArrayList<List<Integer>>();

        outer.add(new ArrayList<Integer>());
        int end = 0;
        for(int i = 0; i < arr.length; i++){
            int start = 0;


            if(i > 0 && arr[i] == arr[i - 1])
                start = end;

            end = outer.size();
            int n = outer.size();

            // For every element in array we try to add it to the list
            for(int j = start; j < n ; j++){


                ArrayList<Integer> inner = new ArrayList<Integer>(outer.get(j));// Helps to have outer list elements by passing as argument

                inner.add(arr[i]);
                outer.add(inner);
            }

        }
        return  outer;
    }

}
