//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        while (t-- > 0) {
            long n = ob.nextLong();
            Solution ab = new Solution();
            long k = ab.findNth(n);
            System.out.println(k);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    long findNth(long n) {
        long result = 0;
        long multiplier = 1;
        
        // Correct the while condition to process as long as n > 0
        while (n > 0) {
            // Extract the base-9 digits and convert them to a decimal-like number
            result += (n % 9) * multiplier;
            
            // Move to the next base-9 "digit"
            n /= 9;
            
            // Increase multiplier by 10 to shift decimal positions
            multiplier *= 10;
        }
        
        return result;
    }
}
