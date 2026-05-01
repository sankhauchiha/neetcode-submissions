func isValidSudoku(board [][]byte) bool {
    rowMap := make([]map[byte]struct{}, len(board))
    colMap := make([]map[byte]struct{}, len(board))
    gridMap := make([]map[byte]struct{}, len(board))

    for i := 0; i < len(board); i++ {
        rowMap[i] = make(map[byte]struct{})
        colMap[i] = make(map[byte]struct{})
        gridMap[i] = make(map[byte]struct{})
    }
    for r := 0; r < len(board); r++ {
        for c := 0; c < len(board); c++ {
            if board[r][c] == '.' {
                continue
            }

            _, rVal := rowMap[r][board[r][c]]
            if rVal {
                return false
            }

            _, cVal := colMap[c][board[r][c]]
            if cVal {
                return false
            }

            gridCt := (r/3)*3 + c/3
            _, gVal := gridMap[gridCt][board[r][c]]
            if gVal {
                return false
            }

            rowMap[r][board[r][c]] = struct{}{}
            colMap[c][board[r][c]]= struct{}{}
            gridMap[gridCt][board[r][c]] = struct{}{}
        }
    }

    return true
}