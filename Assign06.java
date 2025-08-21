/*
6. Implement a problem of maximizing Profit by trading stocks based on
given rate per day.
Statement: Given an array arr[] of N positive integers which denotes
the cost of selling and buying stock on each of the N days. The task is
to find the maximum profit that can be earned by buying a stock on or
selling all previously bought stocks on a particular day.
*/

public class Assign06 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;

        // Greedy: add all positive differences
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4}; // Example input
        System.out.println("Maximum Profit: " + maxProfit(arr));
    }
}
