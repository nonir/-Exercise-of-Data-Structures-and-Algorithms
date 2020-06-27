package sparseArray;

/**
 * @author non
 * @date 2020/6/27 - 13:48
 * 创建稀疏数组并还原     （本地存储可以通过io流实现）
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建11*11的棋盘数组   ， 0表示无棋子 1表示黑子，2表示白子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;
        int num = 0;
        // 显示原数组
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.print(data + "  ");
                if (data != 0) {
                    num++;
                }
            }
            System.out.println();
        }
        //创建稀疏数组
        int[][] sparseArr = new int[num + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = num;
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.print(data + "   ");
            }
            System.out.println();
        }
        //恢复原数组
        int[][] newArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        System.out.println(sparseArr.length);
        for (int i = 1; i < sparseArr.length; i++) {
            newArr[i][sparseArr[i][1]] = sparseArr[i][2];
        }
        for (int[] row : newArr) {
            for (int data : row) {
                System.out.print(data + "  ");
            }
            System.out.println();
        }
    }
}
