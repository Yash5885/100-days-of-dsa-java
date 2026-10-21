class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0; int counter=0;
        ArrayList <Integer> list= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            else{
                nums[j]=nums[i];
                counter++;
                list.add(nums[i]);
                j++;
            }
        }
        return counter;
    }
}