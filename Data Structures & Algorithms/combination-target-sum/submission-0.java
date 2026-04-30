class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> currCom = new ArrayList<>();
        findSum(nums, 0, target, currCom, l);
        return l;
    }

    void findSum(int[] arr, int index, int target, List<Integer> currentCombination, List<List<Integer>> solution) {
        // Base case: if we've considered all elements
        if (index >= arr.length || target < 0) {
            return;
        } // target sum found
        else if (target == 0) {
            solution.add(new ArrayList<>(currentCombination));
            return;
        }

        // Include the current element and check the rest possible combination without excluding current element
        currentCombination.add(arr[index]);
        findSum(arr, index, target-arr[index], currentCombination, solution);

        // Backtrack: remove the last added element to explore other combinations
        currentCombination.remove(currentCombination.size() - 1);
        findSum(arr, index+1, target, currentCombination, solution);
    }
}
