func twoSum(numbers []int, target int) []int {
    i, j := 0, len(numbers) - 1
    for i < j {
        req := target - numbers[i]
        if req > numbers[j] {
            i++
        }else if req < numbers[j] {
            j--
        }else{
            break
        }
    }
    return []int{i+1, j+1}
}