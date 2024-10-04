//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class LinkedList {
    // Function to print nodes in a given circular linked list
    static void printList(Node head) {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int key = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            tail.next = head; // Make the list circular
            Solution ob = new Solution();
            Node current = ob.deleteNode(head, key);
            Node rev = ob.reverse(current);
            printList(rev);
        }
    }
}

// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/

class Solution {
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        if (head == null || head.next == head) {
            return head; // Empty or single-node circular list
        }

        Node prev = null;
        Node curr = head;
        Node next = null;

        // Loop until we complete one full traversal of the circular list
        do {
            next = curr.next;     // Store the next node
            curr.next = prev;     // Reverse the current node's link
            prev = curr;          // Move prev to current
            curr = next;          // Move to the next node
        } while (curr != head);

        // Adjust the head and make the last node point to the new head
        head.next = prev;
        head = prev;

        return head;
    }

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        if (head == null) {
            return null; // Empty list
        }

        Node curr = head;
        Node prev = null;

        // If the head itself holds the key to be deleted
        if (curr.data == key) {
            // If there is only one node in the list
            if (curr.next == head) {
                return null; // The list becomes empty after deletion
            }

            // Find the last node to adjust its next pointer after deleting the head
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }

            // Set head to the next node and adjust the last node's next pointer
            head = head.next;
            temp.next = head;

            return head;
        }

        // Traverse to find the node to delete
        do {
            prev = curr;
            curr = curr.next;
        } while (curr != head && curr.data != key);

        // If the key is found, delete the node by adjusting the pointers
        if (curr.data == key) {
            prev.next = curr.next;
        }

        return head;
    }
}
