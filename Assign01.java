// Q1: implement a problem of zeros
//   given an array of ones and zeros which has all is followed by zero. find number of zeros and give count of no of zeros in given array 
//   i/p: 110000
//   o/p:4



public class Assign01{
public static String countZeros(String input) {

int n = input.length();
//char[] arr = input.tocharArray();
int left = 0, right = n - 1;
int firstZeroIndex = -1;

while (left <= right) {
int mid = left + (right - left) / 2;
char ch = input.charAt(mid);
if (ch == '0') {
firstZeroIndex = mid;
right = mid - 1;
} else if (ch == '1') {
left = mid + 1;
} else {
return "invalid";
}
}

if (firstZeroIndex == -1) {
return "0";
}

//verify again
//for (int i = firstZeroIndex; i < n; i++) {
//if (input.charAt(i) != '0') {  
//return "invalid";
//}}

return String.valueOf(n - firstZeroIndex);
}

public static void main(String[] args){
System.out.println(countZeros("111100"));
}


}
