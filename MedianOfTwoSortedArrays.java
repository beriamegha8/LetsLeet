class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] num = new int[totalLength];

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                num[k++] = nums1[i++];
            } else {
                num[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            num[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            num[k++] = nums2[j++];
        }
        if (totalLength % 2 == 0) {
            double median = (num[totalLength / 2 - 1] + num[totalLength / 2]) / 2.0;
            return median;
        } else {
            double median = num[totalLength / 2];
            return median;
        }
    }
}
