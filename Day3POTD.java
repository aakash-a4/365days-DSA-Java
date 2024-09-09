import java.util.ArrayList;

class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        int low = 0, mid = 0;
        int high = arr.size() - 1;

        // Traverse the ArrayList and sort the elements
        while (mid <= high) {
            switch (arr.get(mid)) {
                case 0:
                    // Swap arr[low] and arr[mid], increment both low and mid
                    int temp0 = arr.get(low);
                    arr.set(low, arr.get(mid));
                    arr.set(mid, temp0);
                    low++;
                    mid++;
                    break;
                case 1:
                    // Just move mid pointer
                    mid++;
                    break;
                case 2:
                    // Swap arr[mid] and arr[high], decrement high
                    int temp2 = arr.get(mid);
                    arr.set(mid, arr.get(high));
                    arr.set(high, temp2);
                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(2);
        arr.add(1);
        arr.add(2);
        arr.add(0);

        solution.sort012(arr);

        // Print sorted array
        System.out.println(arr);  // Output: [0, 0, 1, 2, 2]
    }
}