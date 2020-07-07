package sort;

/**
 * @author non
 * @date 2020/7/6 - 23:41
 */
public class QuickSort {
    private int[] arr;

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort(new int[]{8,9,7,3,4,3});
        quickSort.quickSort(quickSort.arr, 0, quickSort.arr.length - 1);
        quickSort.showArr();
    }

    public void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        //    //pivot 中轴值
        int pivot = arr[(l + r) / 2];
        int temp;
        while (r > l) {
            //在 pivot 的左边一直找,找到大于等于 pivot ,才退出
            while (arr[l] < pivot) {
                l++;
            }
            //在 pivot 的右边一直找,找到小于等于 pivot ,才退出
            while (arr[r] > pivot) {
                r--;
            }
            //如果 l >= r 说明 pivot  的左右两的值，已经按照左边全部是
            //小于等于 pivot 值，右边全部是大于等于 pivot 值
            if (l>=r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现 arr[l] == pivot  则将r--， 前移
            if (arr[l] == pivot){
                r--;
            }

            //如果交换完后，发现 arr[r] == pivot  则将l++， 前移
            if (arr[r]==pivot){
                l++;
            }

        }
        //防止栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //递归

        if (left<r){
            quickSort(arr,left,r);
        }
        if (right>l){
            quickSort(arr,l,right);
        }
    }

    private void showArr() {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public QuickSort(int[] arr) {
        this.arr = arr;
    }
}
