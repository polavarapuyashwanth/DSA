import java.util.Arrays;

//This algorithm only works is the given numbers range is from (1 to N or 0 to N);

public class CycleSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1,};
        cycleSorting(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void cycleSorting(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct_index = arr[i] - 1;
            if(arr[i] != arr[correct_index])
                swap(arr,i,correct_index);
            else
                i++;
        }
    }
    public static void swap(int[] arr, int start_index,int end_index){
        int temp = arr[start_index];
        arr[start_index] = arr[end_index];
        arr[end_index] = temp;
    }
}
