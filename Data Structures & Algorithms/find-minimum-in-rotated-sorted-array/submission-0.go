func swap(l int, mid int, nums []int) {
	if nums[l] > nums[mid + 1] {
		temp := nums[l]
		nums[l] = nums[mid + 1]
		nums[mid + 1] = temp
	}
}

func cut(l int, r int, nums []int) {
	if l < r {
		mid := l + (r - l)/2
		cut(l, mid, nums)
		cut(mid + 1, r, nums)

		swap(l ,mid, nums)
	}
}

func findMin(nums []int) int {
	cut(0, len(nums) - 1, nums)
	return nums[0]
}
