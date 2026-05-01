func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }

    dict := make(map[rune]int)
    for _, c := range s {
        v, _ := dict[c]
        dict[c] = v + 1
    }

    for _, c := range t {
        v, ok := dict[c]
        if !ok {
            return false
        }

        if v == 0 {
            return false
        }

        dict[c] = v - 1
    }
    
    return true
}