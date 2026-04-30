class Solution {
    public int reverse(int x) {

        boolean negative = false;
        if(x < 0) {
            negative = true;
        }
        String s = Integer.toString(Math.abs(x));
        String res = "";
        for(int i = s.length()-1; i>=0; i--){
           res = res + s.charAt(i);
        }
        try {
            if(negative){
                return -Integer.valueOf(res);
            }else{
                return Integer.valueOf(res);
            }
        }catch (Exception e){
            return 0;
        }

    }
}
