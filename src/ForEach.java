/**
 * Created with IntelliJ IDEA.
 * User: 17773
 * Date: 2/27/13
 * Time: 9:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class ForEach {
    public static void main(String[] args) {
        int[] nums = new int[1000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 2001) - 1000;
        }

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

      /*  for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
        }*/
    }
}
