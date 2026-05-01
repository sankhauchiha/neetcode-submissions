func hasDuplicate(nums []int) bool {
    set := make(map[int]struct{})

    for _, n := range nums {
        _, ok := set[n]
        if ok {
            return true
        }

        set[n] = struct{}{}
    }

    return false
}
