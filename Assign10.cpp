/*Implement Subset Sum Problem. Statement:-Given a set of nonnegative integers and a value sum, the task is to check if there is a
subset of the given set whose sum is equal to the given sum*/

#include <iostream>
using namespace std;

int main() {
    int N, sum;
    cout << "Enter number of elements: ";
    cin >> N;

    int arr[100]; // allow up to 100 elements
    cout << "Enter elements: ";
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    cout << "Enter the sum: ";
    cin >> sum;

    bool dp[101][1001];  //here sum is assumed <= 1000   dp[N+1][sum+1]
    
    for (int i = 0; i <= N; i++) {
        for (int j = 0; j <= sum; j++) {
            if (j == 0)
                dp[i][j] = true;   // sum=0 is always possible
            else if (i == 0)
                dp[i][j] = false;  // no elements but sum>0 = false
            else if (arr[i-1] <= j)
                dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
            else
                dp[i][j] = dp[i-1][j];
        }
    }

    if (dp[N][sum])
        cout << "Subset with given sum exists\n";
    else
        cout << "Subset with given sum does not exist\n";

    return 0;
}


/*INPUT:-
Enter number of elements: 5
Enter elements: 3
4
6
7
2
Enter the sum: 34 */

//OUTPUT:-Subset with given sum does not exist
