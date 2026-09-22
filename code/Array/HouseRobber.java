package Array;

public class HouseRobber {

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int can = 0;
        int cannot = 0;

        for (int num : nums) {
            
            int newCan = cannot + num;

            int newCannot = Math.max(can, cannot);

            can = newCan;
            cannot = newCannot;
        }
        return Math.max(can, cannot);
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,1};
        int result = rob(nums);
        System.out.print(result);
    }
}
