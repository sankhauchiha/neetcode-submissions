class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if(n1 + n2 != n3) return false;

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i = 0, j = 0;
        for(int k = 0; k < n3; k++){
            char ch = s3.charAt(k);
            if(i < n1 && ch == s1.charAt(i))
                i++;
            else
                sb1.append(ch);

            if(j < n2 && ch == s2.charAt(j))
                j++;
            else
               sb2.append(ch);
        }

        return (sb1.toString().equals(s2) || sb2.toString().equals(s1));
    }
}
