func isPalindrome(s string) bool {
    i, j := 0, len(s) - 1

    for i <= j {
        lRune := rune(s[i])
        rRune := rune(s[j])

        if !unicode.IsDigit(lRune) && !unicode.IsLetter(lRune) {
            i++
            continue
        }

        if !unicode.IsDigit(rRune) && !unicode.IsLetter(rRune) {
            j--
            continue
        }

        if unicode.ToLower(lRune) != unicode.ToLower(rRune) {
            return false
        }

        i++ 
        j--
    }

    return true
}