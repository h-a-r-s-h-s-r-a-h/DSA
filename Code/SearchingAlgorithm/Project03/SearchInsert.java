package Code.SearchingAlgorithm.Project03;

public class SearchInsert {

    public int searchInsert(int[] nums, int key) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] == key) {
                return mid;
            }
            if (key < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 10, 20, 47, 59, 65, 75, 88, 99};
        SearchInsert si = new SearchInsert();
        System.out.println(si.searchInsert(nums, 66));
    }
}
