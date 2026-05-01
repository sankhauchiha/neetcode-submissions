func threeSum(nums []int) [][]int {
    sort.Ints(nums)
    ans := [][]int{}

    for i := 0; i < len(nums); i++ {
        if i > 0 && nums[i] == nums[i-1] {
            continue
        }

        target := 0 - nums[i]
        l, r := i + 1, len(nums) - 1
        for l < r {
            if nums[l] + nums[r] > target {
                r--
            }else if nums[r] + nums[l] < target {
                l++
            }else{
                ans = append(ans, []int{nums[i], nums[l], nums[r]})
                l++
                r--

                for l < r && nums[l] == nums[l-1] {
                    l++
                }
                for l < r && nums[r] == nums[r+1] {
                    r--
                }
            }
        }
    }

    return ans
}