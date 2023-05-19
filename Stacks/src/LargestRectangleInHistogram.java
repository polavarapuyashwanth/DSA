

// Very important stack problem
// Leetcode - (84. Largest Rectangle in Histogram)
import java.util.Stack;
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] arr = {3,1,5,6,2,3};
        System.out.println(largestRectangleArea2(arr));
    }

    public  static  int largestRectangleArea(int[] heights) {

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;

        // Finding the left index of each element in O(n) time
        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()])
                stack.pop();
            if(!stack.isEmpty() && heights[i] > heights[stack.peek()])
                left[i] = stack.peek() + 1;
            else
                left[i] = 0;
            stack.push(i);

        }
        stack.clear();

        // Finding the right index of each element in O(n) time
        // Also calculating the answer in the same loop
        for(int i = heights.length - 1; i >= 0; i-- ){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()])
                stack.pop();
            if(!stack.isEmpty() && heights[i] > heights[stack.peek()])
                right[i] = stack.peek() - 1;
            else
                right[i] = heights.length - 1;
            stack.push(i);

            //Finding answer
            int ans = (right[i] - left[i] + 1) * heights[i];
            if(max < ans)
                max = ans;
        }

        return max;
    }


    // Method - 2 : Same as Method 1 but we try to find answer(finding left smaller and right smaller) in just one pass

    public static int largestRectangleArea2(int[] heights){
        Stack<Integer> stack = new Stack<Integer>();
        int left_ind = 0;
        int max = 0;
        for(int i = 0; i <= heights.length; i++){
            while(!stack.isEmpty() && (i == heights.length ||heights[i] <= heights[stack.peek()])){
                int current = stack.pop();
                int right_ind = i;
                if(!stack.isEmpty())
                    left_ind = stack.peek();
                else
                    left_ind = 0;

                // finding ans using right - left * arr[i]
                int ans = (right_ind - left_ind - 1) * heights[current];
                if(max < ans)
                    max = ans;
            }
            stack.push(i);
        }
        return max;
    }
}
