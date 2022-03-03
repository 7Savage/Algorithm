package hot100;

public class P75_颜色分类 {
    public void sortColors(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[ptr];
                nums[ptr]=temp;
                ptr++;
            }
        }
        for (int i = ptr; i < nums.length; i++) {
            if (nums[i]==1){
                int temp=nums[i];
                nums[i]=nums[ptr];
                nums[ptr]=temp;
                ptr++;
            }
        }
    }
}
