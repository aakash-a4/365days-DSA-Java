#User function Template for python3
class Solution:
    def findSmallest(self, arr):
        # Initialize the smallest unreachable number as 1
        smallest_unreachable = 1
        
        # Traverse the sorted array
        for num in arr:
            # If current element is greater than smallest_unreachable,
            # we cannot form smallest_unreachable
            if num > smallest_unreachable:
                break
            # Otherwise, we update smallest_unreachable
            smallest_unreachable += num
        
        return smallest_unreachable


#{ 
 # Driver Code Starts
#Initial Template for Python 3


def main():
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        ob = Solution()
        ans = ob.findSmallest(arr)
        print(ans)


if __name__ == "__main__":
    main()

# } Driver Code Ends
