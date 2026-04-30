class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> currCom = new ArrayList<>();
        findCombinations(nums, 0, currCom, sol);
        return sol;
        
    }


    static void findCombinations(int[] arr, int index, List<Integer> currentCombination, List<List<Integer>> com) {
        // Base case: if we've considered all elements
        if (index == arr.length) {
            com.add(new ArrayList<>(currentCombination));
            return;
        }

        // Exclude the current element and move to the next
        findCombinations(arr, index + 1, currentCombination, com);

        // Include the current element and move to the next
        currentCombination.add(arr[index]);
        findCombinations(arr, index + 1, currentCombination, com);

        // Backtrack: remove the last added element to explore other combinations
        currentCombination.remove(currentCombination.size() - 1);
    }
}
