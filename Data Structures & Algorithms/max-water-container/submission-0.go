func maxArea(height []int) int {
    maxWater := 0
    l, r := 0, len(height) - 1

    for l < r {
        currWater := (r-l) 
        if height[l] < height[r] {
            currWater *= height[l]
            l++
        }else{
            currWater *= height[r]
            r--
        }

        if currWater > maxWater {
            maxWater = currWater
        }
    }

    return maxWater
}