
// Finding the Next greater element for circular array
// Leet code - 503. Next Greater Element II

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {3,10,4,2,1,2,6,1,7,2,9};
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 2 * arr.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i % arr.length])
                stack.pop();

            if(i < arr.length){
                if(!stack.isEmpty() && stack.peek() > arr[i % arr.length]){
                    ans[i] = stack.peek();
                }
                else
                    ans[i] = -1;
            }
            stack.push(arr[i % arr.length]);
        }


        System.out.println(Arrays.toString(ans));
    }
}
