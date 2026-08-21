public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // A and B are references to the two arrays.
        // We will ALWAYS perform binary search on A.
        int[] A = nums1;
        int[] B = nums2;

        // Total number of elements in both arrays combined.
        int total = A.length + B.length;

        // Number of elements that should be on the LEFT side
        // of our partition.
        //
        // +1 is important for odd-sized arrays.
        //
        // Example:
        // total = 5 → half = 3
        // total = 6 → half = 3
        int half = (total + 1) / 2;


        // We want to binary search on the SMALLER array.
        //
        // Why?
        // Because our binary search range will be:
        //
        // 0 ... A.length
        //
        // So if A is smaller, fewer possibilities to search.
        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }


        // Binary search for the correct partition position
        // in A.
        //
        // i represents how many elements from A
        // are placed on the LEFT side.
        int l = 0;
        int r = A.length;


        while (l <= r) {

            // Try putting i elements from A on the left.
            int i = (l + r) / 2;

            // We need exactly 'half' elements on the left
            // across BOTH arrays.
            //
            // If i elements come from A,
            // then j elements must come from B.
            int j = half - i;


            // -----------------------------------------
            // Find the 4 important values around partition
            // -----------------------------------------

            // Largest element on the LEFT side of A.
            //
            // If i == 0, nothing is on A's left side.
            // So use -infinity.
            int Aleft = i > 0
                    ? A[i - 1]
                    : Integer.MIN_VALUE;


            // Smallest element on the RIGHT side of A.
            //
            // If i == A.length, nothing is on A's right side.
            // So use +infinity.
            int Aright = i < A.length
                    ? A[i]
                    : Integer.MAX_VALUE;


            // Largest element on the LEFT side of B.
            //
            // If j == 0, nothing is on B's left side.
            int Bleft = j > 0
                    ? B[j - 1]
                    : Integer.MIN_VALUE;


            // Smallest element on the RIGHT side of B.
            //
            // If j == B.length, nothing is on B's right side.
            int Bright = j < B.length
                    ? B[j]
                    : Integer.MAX_VALUE;


            // -----------------------------------------
            // Check whether our partition is correct
            // -----------------------------------------
            //
            // We need:
            //
            // Aleft <= Bright
            //
            // and
            //
            // Bleft <= Aright
            //
            // If both are true, everything on the LEFT
            // is <= everything on the RIGHT.
            if (Aleft <= Bright && Bleft <= Aright) {

                // We found the correct partition!
                //
                // If total is odd, the median is simply
                // the largest value on the LEFT.
                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }

                // If total is even:
                //
                // Median = average of:
                //
                // largest element on LEFT
                // +
                // smallest element on RIGHT
                //
                return (Math.max(Aleft, Bleft)
                        + Math.min(Aright, Bright)) / 2.0;


            // A's left element is TOO BIG.
            //
            // Example:
            //
            // Aleft = 10
            // Bright = 7
            //
            // We have put too many large elements
            // from A on the left.
            //
            // Therefore move partition i LEFT.
            } else if (Aleft > Bright) {

                r = i - 1;


            // Otherwise:
            //
            // Bleft > Aright
            //
            // A's partition is too far LEFT.
            //
            // We need to move i RIGHT.
            } else {

                l = i + 1;
            }
        }

        // Should never happen for valid input.
        return -1;
    }
}