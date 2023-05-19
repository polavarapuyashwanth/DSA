
//Leet code - Combination sum 2
import  java.util.*;

public class CombinationSum2 {
    public static void main(String[] args){
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(arr,target));

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        //Helper function
        getUniquePairs(candidates,target,0,list,ans);
        return ans;
    }


    // We will be following take and not-take approach but for unique combinations which means for both
    // But for this questions as we should only have unique combinations we are going to sort the array
    // and try to do only recursion for one of the same repeated elements


    public static void  getUniquePairs(int[] candidates,int target,int index,ArrayList<Integer> list,List<List<Integer>> ans){
        //Base condition 1
        if(target == 0){
            ans.add(new ArrayList<Integer>(list));
            return;
        }

        //Base conditon 2
        if(target < 0)
            return;

        //Main conditon part

        for(int i = index; i < candidates.length ; i++){
            if(i == index || candidates[i] != candidates[i - 1]){
                list.add(candidates[i]);
                getUniquePairs(candidates,target - candidates[i],i + 1, list,ans);
                list.remove(list.size() - 1);
            }
        }

    }

}

