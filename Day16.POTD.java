//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution {
    public String smallestWindow(String s, String p) {
        int n = s.length();
        int m = p.length();
        
            if (m > n) {
            return "-1";
        }
        
        HashMap<Character, Integer> p_freq = new HashMap<>();
        for (char ch : p.toCharArray()) {
            p_freq.put(ch, p_freq.getOrDefault(ch, 0) + 1);
        }
        
        int required = p_freq.size();
        int formed = 0; 
        
        HashMap<Character, Integer> window_freq = new HashMap<>();
        int minLength = Integer.MAX_VALUE; 
        int start = 0;
        int left = 0; 
        
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            window_freq.put(ch, window_freq.getOrDefault(ch, 0) + 1);
            
                if (p_freq.containsKey(ch) && window_freq.get(ch).intValue() == p_freq.get(ch).intValue()) {
                formed++;
            }
            
                while (left <= right && formed == required) {
                char leftChar = s.charAt(left);
                
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                
                window_freq.put(leftChar, window_freq.get(leftChar) - 1);
                if (p_freq.containsKey(leftChar) && window_freq.get(leftChar).intValue() < p_freq.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? "-1" : s.substring(start, start + minLength);
    }
}
