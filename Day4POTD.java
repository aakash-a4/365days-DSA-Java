//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int CHAR = 26;  // There are 26 lowercase English letters
    
    // Function to check if the given array of strings can form a circle
    public int isCircle(String[] arr) {
        int n = arr.length;

        // Arrays to store in-degree and out-degree of each character
        int[] inDegree = new int[CHAR];
        int[] outDegree = new int[CHAR];

        // Adjacency list for graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < CHAR; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph based on the first and last characters of each string
        for (String s : arr) {
            int first = s.charAt(0) - 'a';  // First character
            int last = s.charAt(s.length() - 1) - 'a';  // Last character
            
            outDegree[first]++;  // Outgoing edge from 'first'
            inDegree[last]++;  // Incoming edge to 'last'
            
            graph.get(first).add(last);  // Add directed edge from first to last
        }

        // Check if in-degree and out-degree of every character are the same
        for (int i = 0; i < CHAR; i++) {
            if (inDegree[i] != outDegree[i]) {
                return 0;  // Not possible to form a circle
            }
        }

        // Check if the graph is strongly connected
        if (!isStronglyConnected(arr[0].charAt(0) - 'a', graph, n)) {
            return 0;
        }

        return 1;  // All conditions met, strings can form a circle
    }

    // Function to check if the graph is strongly connected using DFS
    private boolean isStronglyConnected(int start, List<List<Integer>> graph, int n) {
        boolean[] visited = new boolean[CHAR];

        // Perform DFS from the first character
        dfs(start, graph, visited);

        // Check if all nodes corresponding to characters are visited
        for (int i = 0; i < CHAR; i++) {
            if (!graph.get(i).isEmpty() && !visited[i]) {
                return false;
            }
        }

        // Create a reverse graph to check if it is strongly connected
        List<List<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < CHAR; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        for (int u = 0; u < CHAR; u++) {
            for (int v : graph.get(u)) {
                reverseGraph.get(v).add(u);  // Reverse the direction of the edge
            }
        }

        // Reset the visited array and perform DFS on the reversed graph
        Arrays.fill(visited, false);
        dfs(start, reverseGraph, visited);

        // Check if all nodes are reachable in the reverse graph
        for (int i = 0; i < CHAR; i++) {
            if (!graph.get(i).isEmpty() && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    // DFS helper function
    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}
