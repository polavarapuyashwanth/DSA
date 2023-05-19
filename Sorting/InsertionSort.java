import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1,-2,-1};
        Insertionsorting(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void Insertionsorting(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i + 1; j > 0; j--){
                if(arr[j] < arr[j-1])
                    swap(arr,j,j-1);
                else
                    break;
            }
        }
    }
    public static void swap(int[] arr, int start_index,int end_index){
        int temp = arr[start_index];
        arr[start_index] = arr[end_index];
        arr[end_index] = temp;
    }
}
