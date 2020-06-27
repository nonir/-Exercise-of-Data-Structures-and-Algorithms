package queue;

/**
 * @author non
 * @date 2020/6/27 - 20:42
 * 循环队列中front指向第一个元素  ， rear指向最后一个元素的下一个元素地址。
 * 规定循环队列的元素个数最大值为maxSize-1 ，便于判断队列为满或空。
 */
public class CircleArrQueue {
    public static void main(String[] args) {
        circleQueue cq = new circleQueue(5);
        cq.addData(1);
        cq.addData(2);
        cq.addData(3);
        cq.addData(4);
        cq.showQueue();
        System.out.println(cq.isFull());
    }
}

class circleQueue {
    private int maxSize;
    private int front = 0;
    private int rear = 0;
    private int[] arr;

    public circleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断是否为满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加元素
    public void addData(int data) {
        if (isFull()) {
            throw new RuntimeException("队列为满，无法添加");
        } else {
            arr[rear] = data;
            rear = (rear+1)%maxSize;  //rear 后移
        }
    }

    //删除（获取）元素
    public int getData() {
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法删除");
        }else{
            int k = front;
            front = (front+1)%maxSize;
            return arr[k];
        }
    }
    //获取元素个数
    public int size(){
       return  (rear-front+maxSize)%maxSize;
    }

    //显示队列所有元素
    public void showQueue() {
        for (int i = front; i < front+size(); i++) {
            System.out.print(" ["+arr[(i+maxSize)%maxSize]+"] ");
        }
        System.out.println();
    }
}