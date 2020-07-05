package sort;

/**
 * @author non
 * @date 2020/7/2 - 21:06
 */

//冒泡排序
//从0开始到第length-1个元素，依次将相邻两个数组元素比较大小，将较大元素放在后面 找到最大元素  然后从0到lengt-2 重复此操作
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort(new int[]{7, 6, 5, 3, 4, 2});
        bubbleSort.bubble();
    }

    private int[] arr;


    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    public void bubble() {
        int k;
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    k = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = k;
                    flag = false;
                }
            }
            if (flag) {
                break;
            } else flag = true;
        }
        showArr();
    }

    //显示
    private void showArr() {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
