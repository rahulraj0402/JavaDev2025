import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Stack;
//Input:  [4, 5, 2, 10, 8]
//        Output: [2, 2, -1, 8, -1]
public class dsaQuestion {
    public static void main(String[] args) {
        int []arr = {0,2,1,2,0};
        int []res = NSR(arr);
        int []res2 = NSL(arr);
        for(int i = 0 ; i < res.length ; i++){
            System.out.print(res[i] + " ");

        }
        System.out.println();
        for (int i = 0 ; i < res2.length ; i++){
            System.out.print(res2[i] + " ");
        }
    }

    public static int[]NSL(int []heights){
        int n = heights.length;
        int out_of__bound_index = -1;
        int []left = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < n ; i++){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                left[i] = out_of__bound_index;
            }else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        return left;
    }
    public static int[] NSR(int []heights){
        int n = heights.length;
        int []right = new int[n];

        int out_of_bound_index = n;
        Stack<Integer> stack = new Stack<>();

        for (int i = n-1 ; i >= 0 ; i--){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
           if (stack.isEmpty()){
               right[i] = out_of_bound_index;
           }else {
               right[i] = stack.peek();
           }
           stack.push(i);
        }
        return right;
    }





}
