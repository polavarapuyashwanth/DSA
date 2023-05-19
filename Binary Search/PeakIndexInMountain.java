public class PeakIndexInMountain {
    public static void main(String args[]){
       int[] arr = {3,5,3,2,0};
       int index = peakIndexInMountainArray(arr);
        System.out.println(index);
    }

    //Finding Peak of mountain using binary search
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length -1 ;
        while(start <= end){
            int mid = start + (end - start)/2;
            if((mid != 0) && (mid != arr.length - 1)){
                if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                    return mid;
            }
            if(arr[mid] > arr[mid + 1])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}
