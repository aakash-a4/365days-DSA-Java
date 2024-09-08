//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    static int minJumps(int[] arr) {
        // If the array has only one element, no jump is needed
        if (arr.length == 1) {
            return 0;
        }

        // If the first element is 0, it's impossible to reach the end
        if (arr[0] == 0) {
            return -1;
        }

        // Initialize variables
        int maxReach = arr[0];  // The farthest point reachable
        int steps = arr[0];     // Steps available before a jump is needed
        int jumps = 1;          // Minimum jumps needed

        // Start from the second element
        for (int i = 1; i < arr.length; i++) {
            // If we have reached the end of the array
            if (i == arr.length - 1) {
                return jumps;
            }

            // Update the farthest point reachable
            maxReach = Math.max(maxReach, i + arr[i]);

            // Use a step to move to the next element
            steps--;

            // If no more steps are left
            if (steps == 0) {
                jumps++;  // Increment the jump counter

                // Check if we can reach further
                if (i >= maxReach) {
                    return -1;  // If we can't go further, return -1
                }

                // Reinitialize the steps for the new range
                steps = maxReach - i;
            }
        }

        return -1;  // If end is not reachable
    }
}
