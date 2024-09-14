//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int num : arr) {
            if (num >= 0) {
                pos.add(num);  
            } else {
                neg.add(num);
            }
        }

        int i = 0, p = 0, n = 0;
        boolean positiveTurn = true;
        while (p < pos.size() && n < neg.size()) {
            if (positiveTurn) {
                arr.set(i++, pos.get(p++));
            } else {
                arr.set(i++, neg.get(n++));
            }
            positiveTurn = !positiveTurn;  
        }
        while (p < pos.size()) {
            arr.set(i++, pos.get(p++));
        }
        while (n < neg.size()) {
            arr.set(i++, neg.get(n++));
        }
    }
}
