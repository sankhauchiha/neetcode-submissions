func twoSum(nums []int, target int) []int {
    seen := make(map[int]int)

    for idx, val := range nums {
        need := target - val
        i, ok := seen[need]
        if ok {
            if idx != i {
                return []int{i, idx}
            }
        }

        seen[val] = idx
    }

    return []int{0, 0}
}
