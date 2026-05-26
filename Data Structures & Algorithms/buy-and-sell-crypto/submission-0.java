class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int l = 0; int r = 1;
        int maxProfit = 0;

        while (r < prices.length) {
            if(prices[l] < prices[r]) {
                int currentProfit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, currentProfit);
            } else {
                l = r;
            }
            r++;
        }
        return maxProfit;
    }
}
