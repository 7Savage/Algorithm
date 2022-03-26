package base.array;

//差分数组的主要适用场景是频繁对原始数组的某个区间的元素进行增减
public class Difference {

    int[] diff;

    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < diff.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

    /**
     * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
     * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
     * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
     *
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        //全部初始化为0
        Difference diff = new Difference(res);
        for (int[] booking :
                bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            diff.increment(i, j, val);
        }
        return diff.result();
    }

    /**
     * 假设你是一位顺风车司机，车上最初有 capacity 个空座位可以用来载客。由于道路的限制，车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。
     * <p>
     * 这儿有一份乘客行程计划表 trips[][]，其中 trips[i] = [num_passengers, start_location, end_location] 包含了第 i 组乘客的行程信息：
     * <p>
     * 必须接送的乘客数量；
     * 乘客的上车地点；
     * 以及乘客的下车地点。
     * 这些给出的地点位置是从你的 初始 出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。
     * <p>
     * 请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利
     *
     * @param trips
     * @param capacity
     * @return
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference diff = new Difference(nums);
        for (int[] trip :
                trips) {
            int val = trip[0];
            int i = trip[1];
            int j = trip[2] - 1;
            diff.increment(i, j, val);
        }

        int[] res = diff.result();
        for (int i = 0; i < res.length; i++) {
            if (res[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            //确定数组长度
            int last = 0;
            for (int[] trip : trips) {
                int last1 = trip[2] ;//终点
                last = Math.max (last, last1);
            }

            int[] nums = new int[last];
            //确定旅客人数
            for (int[] trip : trips) {
                int val = trip[0];
                int i = trip[1] ;
                int j = trip[2] - 1;
                nums[i] += val;
                if (j < last -1) {
                    nums[j + 1] -= val;
                }
            }
            for (int i = 1; i < last; i++) {
                nums[i] += nums[i - 1];
            }
            //比较旅客人数与核载人数
            for(int i : nums){
                if (i > capacity) {
                    return false;
                }
            }

            return true;
        }
    }
}
