// We need to find the Non-repeated integer
// Ex : [1,1,2,3,3,4,4,5,5,6,6]  - answer : 2 . Note : all integers are repeated 2 times


public class SingleNonRepeatedDigit {

    public static void main(String args[]){
        int[] arr = {1,1,2};
        int ans = singleNonDuplicate(arr);
        System.out.println(ans);
    }
    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end   = nums.length - 1;
        //First time to search in the left part
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid == 0){
                if(nums[mid] < nums[mid + 1]){
                    return nums[mid];
                }
                else
                    end = mid - 1;
            }
            else if(mid == nums.length - 1){
                if(nums[mid] > nums[mid - 1]){
                    return nums[mid];
                }
            }
            else if(nums[mid] > nums[mid -1] && nums[mid] < nums[mid + 1]){
                return mid;
            }
            else if(nums[mid] == nums[mid - 1])
                end = mid - 1;
            else
                end = mid;
        }

        //For Second half
        start = 0;
        end   = nums.length - 1;
        //Second time to search in the right part
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid == 0){
                if(nums[mid] < nums[mid + 1])
                    return nums[mid];
            }
            else if(mid == nums.length - 1){
                if(nums[mid] > nums[mid - 1])
                    return nums[mid];
                else
                    start = mid + 1;
            }
            else if(nums[mid] > nums[mid -1] && nums[mid] < nums[mid + 1])
                return mid;
            else if(nums[mid] == nums[mid + 1])
                start =  mid + 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}
