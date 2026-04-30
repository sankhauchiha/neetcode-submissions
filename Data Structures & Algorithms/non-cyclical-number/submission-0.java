class Solution {
    private int f(int n){
        int res = 0;
        while(n > 0){
            int temp = n % 10;
            res += (temp*temp);
            n = n / 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> s = new HashSet<>();
        while(n != 1){
            if(s.contains(n)) return false;
            s.add(n);
            n = f(n);

        }
        return true;
    }
}
