package base.math;

//智力题
public class Intelligence {
    /**
     * 你和你的朋友，两个人一起玩 Nim 游戏：
     * <p>
     * 桌子上有一堆石头。
     * 你们轮流进行自己的回合， 你作为先手 。
     * 每一回合，轮到的人拿掉 1 - 3 块石头。
     * 拿掉最后一块石头的人就是获胜者。
     * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false
     *
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    /**
     * 初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭第二个。
     * <p>
     * 第三轮，你每三个灯泡就切换第三个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换第 i 个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
     * <p>
     * 找出并返回 n 轮后有多少个亮着的灯泡。
     *
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
