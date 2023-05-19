import javax.naming.PartialResultException;
import java.lang.reflect.Array;
import java.util.*;

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        getPermutations2(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Method - 1 - BruteForce
    // TC : O(n! x n)
    // Sc : O(n! x n)

    public static void nextPermutation(int[] nums) {
        // if empty or one element return
        if(nums.length <= 1)
            return;

        int[] temp = Arrays.copyOfRange(nums,0,nums.length);
        Arrays.sort(temp);
        boolean[] freq = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();

        // calling Helper function
        getPermutations(temp,freq,new ArrayList<>(), ans);

        int index = -1;
        // checking array present in list or not
        for(int i = 0; i < ans.size(); i++){
            boolean flag = true;
            for(int j = 0; j < ans.get(i).size(); j++){
                if(nums[j] != ans.get(i).get(j))
                    flag = false;
            }
            if(flag == true && i >= ans.size() - 1){
                System.out.println("Inside last case");
                index = 0;
            }
            else if(flag == true)
                index = i + 1;
        }
        System.out.println(index);
        for(int i = 0; i < ans.get(index).size(); i++){
            nums[i] = ans.get(index).get(i);
        }
        System.out.println(Arrays.toString(nums));
    }

    // Helper function
    public static void getPermutations(int[] arr, boolean freq[], List<Integer> list,List<List<Integer>> ans){

        // Base condition
        if(list.size() == arr.length){
            ans.add(new ArrayList<Integer>(list));
            return;
        }

        // Main logic
        for(int i = 0; i < arr.length;i++){
            if(!freq[i]){
                list.add(arr[i]);
                freq[i] = true;
                getPermutations(arr,freq,list,ans);
                list.remove(list.size() - 1);
                freq[i] = false;
            }
        }
    }


    // Method - 2 : Efficient Method (Narayana pandita from 15th century source : wikipedia)
    // TC   : O(3n) = O(n)
    // SC   : O(1)
    public static void getPermutations2(int[] arr){
        int n = arr.length;
        int i = 0, j = 0;

        // To find the number from right to left which is not increase in an ascending order
        for( i = arr.length - 2; i >=0 ; i--){
            if(arr[i] < arr[i + 1])
                break;
        }

        if(i < 0){   // if given like - 5 4 3 2 1 then reverse complete array
            reverse(arr,0,arr.length - 1);
        }
        else{
            // To find the smallest number greater than previously found number
            for( j = arr.length - 1; j >= 0; j--){
                if(arr[j] > arr[i])
                    break;
            }
            swap(arr,i,j);
            reverse(arr,i + 1,arr.length - 1);
        }
    }

    // Reversing array
    public static void reverse(int[] arr, int index1, int index2){
        int start = index1;
        int end = index2;

        while(start < end){
            swap(arr,start,end);
            start++;
            end--;
        }

    }

    // Swapping array
    public static void swap(int[] arr,int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

