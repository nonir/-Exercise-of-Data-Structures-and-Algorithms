package sort;

/**
 * @author non
 * @date 2020/7/5 - 20:49
 */


//插入排序
//将数组分为两段  开始将第一个数据视为第一个数组 ， 将第二个数组的元素依次插入到第一个数组中
public class InsertSort {
    private int[] arr;

    public static void main(String[] args) {
        int[] arr = new int[50000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 50000);
        }
        InsertSort insertSort = new InsertSort(arr);
        insertSort.insert();
    }

    public InsertSort(int[] arr) {
        this.arr = arr;
    }

    public void insert() {
        long date1 = System.currentTimeMillis();
        for (int i = 1; i < arr.length; i++) {  //arr[i]为待插入元素

            int insertVal = arr[i];
            int insertIndex = i - 1;            // 即 arr[i]的前面这个数的下标
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];       // arr[insertIndex]
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

//            int value = arr[i];
//            for (int j = i-1; j >=0 ; j--) {
//                if (value<arr[j]){
//                    arr[j+1] = arr[j];
//                }
//                if (value>arr[j]){
//                    break;
//                }
//            }
//            if (){
//                arr[j+1]=value;
//            }
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
