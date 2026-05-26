class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minBuy = prices[0];
        for(int curSell: prices) {
            maxProfit = Math.max(maxProfit, curSell - minBuy);
            minBuy = Math.min(minBuy, curSell);
        }
        return maxProfit;
    }
}
