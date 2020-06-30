package linkedList;

/**
 * @author non
 * @date 2020/6/30 - 20:56
 */
public class Josephus {
    public static void main(String[] args) {
        circleSingleLinkedList josephusList = new circleSingleLinkedList();
        josephusList.addjnode(5);
        josephusList.countOrder(3, 2);
//        josephusList.showList();
    }
}

class circleSingleLinkedList {
    private jnode head = null;

    //添加节点   num个节点   从1开始
    public void addjnode(int num) {
        jnode cur = null;
        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                head = new jnode(i);
                head.next = head;
                cur = head;
            } else {
                jnode temp = new jnode(i);
                cur.next = temp;
                temp.next = head;
                cur = temp;


            }

        }
    }

    //显示
    public void showList() {
        jnode temp = head;
        while (true) {
            System.out.print(temp.id);
            if (temp.next == head) {
                break;
            }
            temp = temp.next;
        }

    }

    // 从第m个节点开始  计数n
    public void countOrder(int m, int n) {
        jnode last = head;
        System.out.print("出圈顺序：");
        // 让last 指向最后一个节点
        while (true) {
            if (last.next == head) {
                break;
            }
            last = last.next;
        }
        for (int i = 0; i < m - 1; i++) {
            head = head.next;
            last = last.next;
        }
        while (true) {
            for (int i = 0; i < n - 1; i++) {
                head = head.next;
                last = last.next;

            }
            System.out.print(head.id + " ");
            head = head.next;
            last.next = head;
            if (last == head) {
                System.out.print(last.id + " ");
                break;
            }
        }
    }

    class jnode {
        private int id;
        private jnode next;

        public jnode(int id) {
            this.id = id;
        }


    }

}
