class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Base case: If the node is null, return
        if (node == null) {
            return;
        }

        // Recursively convert left and right subtrees
        mirror(node.left);
        mirror(node.right);

        // Swap the left and right children of the current node
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}