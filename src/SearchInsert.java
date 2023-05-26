public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int high = nums.length-1;
        int mid=0,low = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target < nums[mid]){
                high = mid - 1;
                continue;
            }
            else if(target > nums[mid]){
                low = mid + 1;
                continue;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},2));
    }
}
