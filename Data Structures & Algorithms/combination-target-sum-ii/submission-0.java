class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> currCom = new ArrayList<>();
        //Sorting to avoid duplicate
        Arrays.sort(candidates);
        findSum2(candidates, 0, target, currCom, sol);
        return sol;
    }

    void findSum2(int[] arr, int index, int target, List<Integer> currentCombination, List<List<Integer>> solution) {
        if (target == 0) {
            solution.add(new ArrayList<>(currentCombination));
            return;
        }

        for(int i = index, n = arr.length; i < n; i++){
            if(i>index && arr[i] == arr[i-1]) continue;
            if(arr[index] > target) break;

            currentCombination.add(arr[i]);
            findSum2(arr, i+1, target-arr[i], currentCombination, solution);
            currentCombination.remove(currentCombination.size()-1);
        }
    }    
}
