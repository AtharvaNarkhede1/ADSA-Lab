public class Assign02{
public static void moveZeros(int[] arr, int left, int right) {
if (left >= right) return;

int mid = (left + right) / 2;
moveZeros(arr, left, mid);
moveZeros(arr, mid + 1, right);
merge(arr, left, mid, right);
}
private static void merge(int[] arr, int left, int mid, int right) {
int[] temp = new int[right - left + 1];
int k = 0;

for (int i = left; i <= right; i++) {
if (arr[i] != 0) temp[k++] = arr[i];
}

while (k < temp.length) {
temp[k++] = 0;
}

for (int i = 0; i < temp.length; i++) {
arr[left + i] = temp[i];
}
}

public static void main(String[] args) {
int[] arr = {1, 0, 5, 0, 3, 0, 2, 2};
moveZeros(arr, 0, arr.length - 1);

for (int num : arr) {
System.out.print(num);
}

}
}
