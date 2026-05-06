func searchMatrix(matrix [][]int, target int) bool {
    i, j := 0, len(matrix) - 1
    row := 0
    for i <= j {
        row = i + (j - i)/2
        if matrix[row][0] > target {
            j = row - 1
        }else if matrix[row][len(matrix[0]) - 1] < target {
            i = row + 1
        }else{
            break
        }
    }

    l, r := 0, len(matrix[0]) - 1
    for l <= r {
        mid := l + (r-l)/2
        if matrix[row][mid] > target {
            r = mid - 1
        }else if matrix[row][mid] < target {
            l = mid  + 1
        }else{
            return true
        }
    }

    return false
}