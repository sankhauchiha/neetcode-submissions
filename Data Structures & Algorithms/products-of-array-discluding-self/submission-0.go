func productExceptSelf(nums []int) []int {
    ans := make([]int, len(nums))

    prefix := 1
    for i := 0; i < len(nums); i++ {
        ans[i] =  prefix
        prefix = prefix * nums[i]
    }

    suffix := 1
    for i := len(nums) - 1; i >= 0; i-- {
        ans[i] = ans[i] * suffix
        suffix = suffix * nums[i]
    }

    return ans
}
