package sort;

/**
 * @author non
 * @date 2020/7/8 - 22:08
 */
//  桶排序不能直接处理负数！！！
public class BucketSort {
    private int[]arr;

    public BucketSort(int[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {
        int arr[] = { 51, 1, 4324,21, 14, 23};
        BucketSort bucketSort = new BucketSort(arr);
        bucketSort.radixSort();

    }

    //基数排序 (桶排序)
    public  void radixSort() {

        long date1 = System.currentTimeMillis();
        //得到数组中最大的数的位数
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int maxLength = (max + "").length();

        //定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        //3. 明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据,定义一个一维数组来记录各个桶的每次放入的数据个数
        //比如：bucketElementCounts[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];


        //循环进行桶排序  次数为maxlength
        for(int i = 0 , n = 1; i < maxLength; i++, n *= 10) {
            //依次将每个元素放入桶中
            for(int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //将桶中的元素依次放回arr中
            //按照桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            //遍历桶，并将桶中是数据，放入到原数组
            for(int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据才放入到原数组
                if(bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶(即第k个一维数组), 放入
                    for(int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //将bucketElementCounts置零
                bucketElementCounts[k] = 0;

            }

        }
        showArr();
        //排序所用时间
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

