//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends

class Solve {
    int[] findTwoElement(int arr[]) {
        int n = arr.length;
        int[] result = new int[2]; 
              for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]); 
            if (arr[val - 1] > 0) {
                arr[val - 1] = -arr[val - 1]; 
            } else {
                result[0] = val; 
            }
        }
            for (int i = 0; i < n; i++) {
            if (arr[i] > 0) { 
                result[1] = i + 1; 
                break;
            }
        }
        
        return result;
    }
}
