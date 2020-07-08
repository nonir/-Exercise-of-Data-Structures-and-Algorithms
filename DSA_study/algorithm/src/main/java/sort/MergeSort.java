package sort;

/**
 * @author non
 * @date 2020/7/8 - 22:08
 */

//将数组元素以mid为中心拆分为两个数组 直到拆分到不能再分   再将数组合并
//合并时使用一个临时数组， 将需要合并的数组元素依次添加到temp中
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 1, 7, 4, 8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.divide(arr, 0, arr.length - 1, new int[arr.length]);
        //显示
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public void divide(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            divide(arr, left, mid, temp);
            divide(arr, mid + 1, right, temp);
            mergeSort(arr, left, mid, right, temp);
        }
    }

    //合  将arr left到right部分排序

    /**
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public void mergeSort(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int j = mid + 1;
        int t = 0;  //temp索引
        while (l <= mid && j <= right) {
            if (arr[l] < arr[j]) {
                temp[t] = arr[l];
                t++;
                l++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        while (l <= mid) {
            temp[t] = arr[l];
            t++;
            l++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
        t = 0;
        int key = left;
        while (key <= right) {
            arr[key] = temp[t];
            key++;
            t++;
        }

    }


}
