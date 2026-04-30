class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> currCom = new ArrayList<>();
        //Sorting to avoid duplicate
        Arrays.sort(nums);
        findCombinationsWithDuplicate(nums,0,currCom,sol);
        return sol;
    }

    void findCombinationsWithDuplicate(int[] arr, int index, List<Integer> currentCombination, List<List<Integer>> com) {
        // Base case: if we've considered all elements
        int n = arr.length;
        if (index == n) {
            com.add(new ArrayList<>(currentCombination));
            return;
        }

        // Include the current element and move to the next
        currentCombination.add(arr[index]);
        findCombinationsWithDuplicate(arr, index + 1, currentCombination, com);
        // Backtrack: remove the last added element to explore other combinations
        currentCombination.remove(currentCombination.size() - 1);

        // Exclude the current element and duplicates to current element, move to the next
        int i = index;
        while (i+1 < n && arr[i] == arr[i+1]){ i++; }
        findCombinationsWithDuplicate(arr, i + 1, currentCombination, com);
    }
}
