class Solution {
    public int[] sortedSquares(int[] nums) {
        int split=0;
        while(split<nums.length && nums[split]<0){
            split++;
        }
        int i=split-1;
        int j=split;

        int ans[]=new int[nums.length];
        int k=0;

        while(i>=0 && j<nums.length){
            int leftSquare=nums[i]*nums[i];
            int rightSquare=nums[j]*nums[j];

            if(leftSquare<rightSquare){
                ans[k++]=leftSquare;
                i--;
            }
            else{
                ans[k++]=rightSquare;
                j++;
            }
        }

        while(i>=0){
            ans[k++]=nums[i]*nums[i];
            i--;
        }
        while(j<nums.length){
            ans[k++]=nums[j]*nums[j];
            j++;
        }
        return ans;
    }
}