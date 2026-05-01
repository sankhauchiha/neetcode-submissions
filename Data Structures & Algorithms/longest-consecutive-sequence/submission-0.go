func longestConsecutive(nums []int) int {
    ct := 0
    
    seen := make(map[int]struct{})
    for _, num := range nums {
        seen[num] = struct{}{}
    }

    for num, _ := range seen {
        _, ok := seen[num-1]
        if ok {
            continue
        }

        tempCt := 1
        key := num + 1
        for {
            if _, exist := seen[key]; !exist {
                break
            }

            tempCt++
            key++
        }

        if tempCt > ct {
            ct = tempCt
        }
    }

    return ct
}