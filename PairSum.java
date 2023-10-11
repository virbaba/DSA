/*
    TIME COMPLEXITY: O(N^2)
    SPACE COMPLEXITY: O(1);
*/
import java.io.*;
import java.util.* ;

public class Solution{
    public static List<int[]> pairSum(int[] arr, int s) {
        // Write your code here.
        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == s) {
                    int[] pair = {Math.min(arr[i], arr[j]), Math.max(arr[i], arr[j])};
                    pairs.add(pair);
                }
            }
        }

        pairs.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        return pairs;
    }
}
