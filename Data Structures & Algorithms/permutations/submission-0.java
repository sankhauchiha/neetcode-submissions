class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermutation(nums, 0, ans);
        return ans;
    }

    void findPermutation(int[] arr, int start, List<List<Integer>> sol){
        // Base case: if we've considered all elements
        if(start == arr.length){
         List<Integer> l  = new ArrayList<>();
         for( int i : arr){
             l.add(i);
         }
         sol.add(l);
         return;
        }

        // Recursive case: swap the current element with every element that comes after it
        for(int i = start, n = arr.length; i <n ; i++ ){
            swap(arr, start, i);// swap the element to find a new permutation
            findPermutation(arr, start+1, sol);//search for other possible permutations recursively
            swap(arr, start, i);//backtrack to make the solution correct
        }
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
