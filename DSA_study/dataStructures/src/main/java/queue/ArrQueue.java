package queue;

/**
 * @author non
 * @date 2020/6/27 - 20:17
 */
public class ArrQueue {
    public static void main(String[] args) {
        queue q = new queue(10);
        q.addData(3);
        q.addData(5);
        q.addData(7);
        q.showQueue();
        System.out.println(q.getData());
        q.showQueue();


    }
}

class queue {
    private int maxSize;
    private int[] arr;
    private int front = 0;
    private int rear = 0;

    public queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断是否为满
    public boolean isFull() {
        return rear == maxSize;
    }

    //判断是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加元素
    public void addData(int data) {
        if (isFull()) {
            System.out.println("队列已满，无法添加");
        } else {
            arr[rear++] = data;
        }
    }
    //删除元素（取出）
    public int getData(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法取出");
        }else{
            return arr[front++];
        }
    }
    //显示队列元素
    public void showQueue(){
        for (int i = front; i <rear ; i++) {
            System.out.print(" ["+arr[i]+"] ");
        }
        System.out.println();
    }
}
