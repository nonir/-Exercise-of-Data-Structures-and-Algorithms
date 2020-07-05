package sort;

/**
 * @author non
 * @date 2020/7/5 - 20:48
 */

//  默认arr[i]为最小元素  ， 用变量min存储   将后续每一个元素(从i+1开始)与其相比  选出最小的元素 ，和arr[i]交换
public class SelectSort {
    private int[] arr;

    public static void main(String[] args) {
        int[] arr = new int[50000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 50000);
        }
        SelectSort selectSort = new SelectSort(arr);
        selectSort.select();
    }

    public SelectSort(int[] arr) {
        this.arr = arr;
    }

    public void select() {
        long date1 = System.currentTimeMillis();
        int value;
        int key;
        for (int i = 0; i < arr.length - 1; i++) {
            key = i;
            value = arr[i];
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[j] < value) {
                    key = j;
                    value = arr[j];
                }
            }
            if (arr[i] != value) {
                arr[key] = arr[i];
                arr[i] = value;
            }
        }
        showArr();
        long date2 = System.currentTimeMillis();
        System.out.println(date2-date1);
    }

    private void showArr() {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
