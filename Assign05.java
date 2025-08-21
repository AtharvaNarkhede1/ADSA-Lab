/*
5. Implement a problem of activity selection problem with K persons.
Statement: Given two arrays S[] and E[] of size N denoting starting and
closing time of the shops and an integer value K denoting the number
of people, the task is to find out the maximum number of shops they
can visit in total if they visit each shop optimally based on the following
conditions:
 A shop can be visited by only one person.
 A person cannot visit another shop if its timing collides with it
*/

import java.util.*;

public class ActivitySelectionKPersons {

    public static int maxShops(int[] S, int[] E, int K) {
        int N = S.length;

        // Pair shops as (start, end)
        int[][] shops = new int[N][2];
        for (int i = 0; i < N; i++) {
            shops[i][0] = S[i];
            shops[i][1] = E[i];
        }

      
        Arrays.sort(shops, (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;

        for (int[] shop : shops) {
            int start = shop[0];
            int end = shop[1];

            if (pq.size() < K) {
                pq.offer(end);
                count++;
            } else if (pq.peek() <= start) {
                pq.poll();
                pq.offer(end);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] S = {1, 3, 3, 5, 7};
        int[] E = {2, 4, 6, 8, 9};
        int K = 2;

        System.out.println("Maximum shops visited: " + maxShops(S, E, K));
    }
}
