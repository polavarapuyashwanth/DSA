
// We could solve this using two approaches:
// 1.Two pointer approach
// 2.Binary search


public class TargetSum {
        public static void main(String[] args) {
            int[] arr = {2,7,11,15};
            int[] ans = twoSum(arr,9);
          for(int i : ans)
              System.out.println(i);
        }

        // Two pointer approach
        public static int[] twoSum(int[] numbers, int target) {
//            int[] ans = {-1,-1};
//
//            int start = 0;
//            int end   = numbers.length - 1;
//            while(start <= end){
//                int sum = numbers[start] + numbers[end];
//                if(sum == target){
//                    ans[0] = start + 1;
//                    ans[1] = end + 1;
//                    return ans;
//                }
//                else if(sum > target)
//                    end--;
//                else
//                    start++;
//            }
//            return ans;

            /*=======================================================*/
            //Binary search approach
            int[] ans = {-1,-1};
            for(int i = 0; i < numbers.length; i++){

                int start = i + 1;
                int end   = numbers.length - 1;
                int tofind = target - numbers[i];
                while(start <= end){
                    int mid = start + (end - start)/2;

                    if(numbers[mid] == tofind){
                        ans[0] = i + 1;
                        ans[1] = mid + 1;
                        return ans;
                    }

                    else if(numbers[mid] > tofind)
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
            }
            return ans;
        }
    }

