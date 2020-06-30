package stack;

/**
 * @author non
 * @date 2020/6/30 - 20:56
 */
//数组实现堆栈功能
public class ArrStackDemo {
    public static void main(String[] args) {
        ArrStack arrStack = new ArrStack(5);
        arrStack.push(1);
        arrStack.push(2);
        arrStack.push(3);
        arrStack.showStack();
        System.out.println(arrStack.pop());
    }


}
class ArrStack{
    private int maxSize ;
    //arr 作为模拟堆栈存放信息
    private int[] arr ;
    // top 指向栈顶
    private int top = -1;

    public ArrStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }
    //判断满
    public boolean isFull(){
        if (top == maxSize -1){
            return true;
        }
        else{
            return false;
        }
    }
    //判断空
    public boolean isEmpty(){
        if (top == -1){
            return true;
        }
        else{
            return false;
        }
    }
    // 入栈
    public void push (int data){
        if (isFull()) {
            throw new RuntimeException("栈已满，无法入栈");
        }
        arr[++top] = data;
    }
    // 出栈
    public int  pop (){
        if (isEmpty()){
            throw new RuntimeException("空栈，无法出栈");
        }
        return arr[top--];
    }
    //显示  (从栈顶依次显示到栈底)
    public void showStack(){
        for (int i = top; i >= 0 ; i--) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
