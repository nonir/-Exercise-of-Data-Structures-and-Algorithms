package sort;

/**
 * @author non
 * @date 2020/7/5 - 20:50
 */

public class ShellSort {
    private int[] arr;

    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
        }
        ShellSort shellSort = new ShellSort(arr);
        shellSort.shell();
    }

    private void shell() {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共 gap 组，每组有个元素),  步长 gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        showArr();
    }

    public ShellSort(int[] arr) {
        this.arr = arr;
    }

    private void showArr() {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
