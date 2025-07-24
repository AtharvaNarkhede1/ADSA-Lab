//Q3: implement a problem of smallest number with atleast no trailing zeros in factorial
//given a no n the task is to find the smallests tno whose factorial contains at leaast n trailing zeros
//i/p: 2
//o/p: 10

public class Assign03 {
    static int findNum(int n){
        int low =0;
        int high= 5*n;
        int ans=0;
        while(low<=high){
            int mid =low+ (high-low)/2;
            int zeroes = no_of_zeroes(mid);
            if(zeroes >=n){
                ans=mid;
                high = mid-1;  // try to find a smaller number
            }
            else{
                low =mid+1;  // increase the number to find more zeroes
            }
        }
        return ans;
    }

    static int no_of_zeroes(int a){
        int denominator=5;
        int zeroes = 0;
        while(a>=denominator){
            zeroes+=(a/denominator);
            denominator*=5;
        }
        return zeroes;
    }

    public static void main(String[] args) {
        int n =2; // Example input, you can change this value to test with different inputs
        System.out.print(findNum(n));
    }
}
