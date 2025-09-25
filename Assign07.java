/*Q7] Implement a problem of minimum work to be done per day to CO2 finish given tasks within D days problem. 
Statement: Given an array task [] of size N denoting amount of work to be done for each task, 
the problem is to find the minimum amount of work to be done on each day so that all the tasks can be completed in at most D days. 
Note: On one day work can be done for only one task.*/

import java.util.Scanner;

public class Assign07 {

    // Function to calculate minimum work per day
    public static int maxDays(int[] task, int size, int D) {
        int sum = 0, maxElement = -1;
        int calDays = 0, max = -1, minimumDays = -1;

        if (D < size) {
            System.out.println("Invalid no. of Days");
            return -1;
        }

        // Calculate total work and maximum single task
        for (int i = 0; i < size; i++) {
            sum += task[i];
            if (task[i] > maxElement) {
                maxElement = task[i];
            }
        }

        int mean = sum / size;

        // Try possible daily work from mean up to maxElement
        while (mean > 0 && mean <= maxElement) {
            calDays = 0;

            for (int i = 0; i < size; i++) {
                int work = task[i];
                while (work != -1) {
                    if (mean >= work) {
                        calDays++;
                        work = -1;
                    } else {
                        work -= mean;
                        calDays++;
                    }
                }
            }

            if (calDays == D) {
                return mean;
            } else if (calDays < D) {
                mean--;
            } else {
                mean++;
            }

            if (max < calDays && calDays < D) {
                max = calDays;
                minimumDays = mean;
            }
        }

        return minimumDays;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no. of Tasks: ");
        int size = sc.nextInt();
        int[] task = new int[size];

        System.out.println("Enter Tasks: ");
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + "] : ");
            task[i] = sc.nextInt();
        }

        System.out.print("Enter Days: ");
        int D = sc.nextInt();

        int minimumWork = maxDays(task, size, D);
        if (minimumWork != -1) {
            System.out.println("Minimum Work need to be done on each day is: " + minimumWork);
        }

        sc.close();
    }
}
