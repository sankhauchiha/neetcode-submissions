type Solution struct{}

func ShiftString(input string, x int) string {
	var result strings.Builder

	x = x % 26
    if x < 0 {
        x += 26
    }

    for _, char := range input {
        if char >= 'a' && char <= 'z' {
            // Calculate the new rune for lowercase letters
            shifted := 'a' + (char-'a'+rune(x))%26
            result.WriteRune(shifted)
        } else if char >= 'A' && char <= 'Z' {
            // Calculate the new rune for uppercase letters
            shifted := 'A' + (char-'A'+rune(x))%26
            result.WriteRune(shifted)
        } else {
            // Keep non-alphabet characters as they are
            result.WriteRune(char)
        }
    }

    return result.String()
}

func (s *Solution) Encode(strs []string) string {
    if len(strs) == 0 {
        return ""
    }

    var encodeStr strings.Builder
    for _, str := range strs {
        shifted := ShiftString(str, 1)
        encodeStr.WriteString(strconv.Itoa(len(shifted)))
        encodeStr.WriteString("#") 
        encodeStr.WriteString(shifted) 
    }

    return encodeStr.String()
}

func (s *Solution) Decode(encoded string) []string {
    if encoded == "" {
        return []string{}
    }

    i := 0
    ans := make([]string, 0)
    for i < len(encoded){
        j := i
        for string(encoded[j]) != "#" {
            j++
        }

        l, _ := strconv.Atoi(encoded[i:j])
        ans = append(ans, ShiftString(encoded[j+1:j+1+l], -1))
        i = l + 1 + j
    }

    return ans
}
