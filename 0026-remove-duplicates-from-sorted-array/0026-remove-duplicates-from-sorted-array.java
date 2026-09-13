class Solution {
    public int removeDuplicates(int[] nums) {
        int change=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[change-1]){
                nums[change]=nums[i];
                change++;
            }
        }
        return change;
    }
}