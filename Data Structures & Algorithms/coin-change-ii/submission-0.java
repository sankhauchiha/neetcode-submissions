class Solution {
    public int change(int amt, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amt + 1], cur = new int[amt + 1];

        prev[0] = cur[0] = 1;

        for (int amount = 1; amount <= amt; amount++)
            if (amount % coins[0] == 0)
                prev[amount] = 1;

        for (int index = 1; index < n; index++) {
            for (int amount = 1; amount <= amt; amount++) {
                cur[amount] = prev[amount];
                if (coins[index] <= amount)
                    cur[amount] += cur[amount - coins[index]];
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        }

        return prev[amt];
    }
}
