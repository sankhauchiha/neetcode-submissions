func canFinish(limit int, h int, piles []int) bool {
    total := 0
    for _, val := range piles {
        total += val/limit
        if val % limit != 0{
            total++
        }
    }
    return h >= total
}

func minEatingSpeed(piles []int, h int) int {
    max := 0
    for _, val := range piles{
        if val > max {
            max = val
        }
    }
    
    rate := max
    l , r := 1, max
    for l <= r {
        mid := l + (r - l)/2
        if canFinish(mid, h, piles) {
            rate = mid
            r = mid - 1
        }else{
            l = mid + 1
        }
    }

    return rate
}