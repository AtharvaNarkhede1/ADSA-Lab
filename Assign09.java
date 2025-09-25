/*Q9] Implement Coin Change problem. Statement: - Given an integer array of coins [] of size N representing different types of currency and an integer sum, 
The task is to find the number of ways to make sum by using different combinations from coins[]*/

import java.util.Scanner;

public class Assign09 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of coins
        System.out.print("Enter number of coins: ");
        int N = sc.nextInt();

        int[] coins = new int[N];
        System.out.println("Enter coin values: ");
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        // Input target sum
        System.out.print("Enter the sum: ");
        int sum = sc.nextInt();

        // DP array
        int[] dp = new int[sum + 1];
        dp[0] = 1; // base case

        // Fill dp array
        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        // Output result
        System.out.println("Number of ways to make sum = " + dp[sum]);

        sc.close();
    }
}
