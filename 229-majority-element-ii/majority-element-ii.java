class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }

        int count1 = 0, count2 = 0;
        int ele1 = 0, ele2 = 0;

        for (int num : nums) {
            if (ele1 == num) count1++;
            else if (ele2 == num) count2++;
            else if (count1 == 0) {
                ele1 = num;
                count1 = 1;
            } 
            else if (count2 == 0) {
                ele2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0; 
        count2 = 0;
        for (int num : nums) {
            if (num == ele1) count1++;
            else if (num == ele2) count2++;
        }

        int t = nums.length / 3 + 1;
        if (count1 >= t) list.add(ele1);
        if (count2 >= t) list.add(ele2);
        return list;
    }
}