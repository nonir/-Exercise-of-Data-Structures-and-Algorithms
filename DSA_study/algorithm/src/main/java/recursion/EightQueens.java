package recursion;

/**
 * @author non
 * @date 2020/7/2 - 19:44
 *
 * 使用一个数组arr模拟棋子摆放位置   arr[x] = y  其中 x代表第x+1个棋子放在第x+1行   y代表棋子放在第y+1列
 * queenNum为需要放置皇后数量  count为解法数量
 */
public class EightQueens {
    private int queenNum;
    private int[]arr;
    public static int count = 0;

    public EightQueens(int queenNum) {
        this.queenNum = queenNum;
        arr = new int[queenNum];
    }

    public static void main(String[] args) {
        EightQueens queen = new EightQueens(8);
        queen.placePiece(0);
        System.out.println(count);
    }
    //显示
    public void showBoard(){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    //判断当前棋子是否和之前棋子有冲突   放置第n+1个棋子判断  有冲突返回false
    public boolean judge(int n){
        for (int i = 0; i <n ; i++) {
            if (arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }
    //递归回溯   放置第n+1个棋子  每放置一个棋子，都需要冲突判断  防止棋子后判断是否与之前的棋子冲突
    public void placePiece(int n){
        //if n==queenNum为8 则开始放置第9个棋子  即八个棋子都放置完成  直接显示并返回即可
        if (n == queenNum){
            count++;
            showBoard();
            return;
        }
        for (int i = 0; i <queenNum ; i++) {
            arr[n] = i;
            if (judge(n)){
                placePiece(n+1);
            }
        }
    }

}
