package linkedList;

/**
 * @author non
 * @date 2020/6/28 - 22:55
 */

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        doubleLinkedList doubleLinkedList = new doubleLinkedList();
        doubleNode doubleNode1 = new doubleNode(1,"aa");
        doubleNode doubleNode2 = new doubleNode(2,"bb");
        doubleNode doubleNode3 = new doubleNode(3,"cc");
        doubleNode doubleNode4 = new doubleNode(3,"dd");
        doubleLinkedList.addByOrder(doubleNode1);
        doubleLinkedList.addByOrder(doubleNode3);
        doubleLinkedList.addByOrder(doubleNode2);
        doubleLinkedList.updateDoubleNode(doubleNode4);
        doubleLinkedList.delDoubleNode(doubleNode2);
        doubleLinkedList.showLinkedList();
    }
}

class doubleLinkedList {
    private doubleNode head = new doubleNode(0, "");

    //显示
    public void showLinkedList() {
        doubleNode temp = head.next;
        if (temp == null) {
            System.out.println("空链表");
            return;
        }
        while (true) {
            System.out.println(temp);
            temp = temp.next;
            if (temp == null) {
                break;
            }
        }
    }


    //链表添加节点
    public void addDoubleNode(doubleNode doubleNode) {
        doubleNode temp = head;

        while (true) {
            if (temp.next == null) {
                temp.next = doubleNode;
                doubleNode.pre = temp;
                break;
            }
            temp = temp.next;
        }

    }

    //删除节点
    public void delDoubleNode(doubleNode doubleNode) {
        doubleNode temp = head;
        if (temp.name == null) {
            System.out.println("空链表");
            return;
        }
        while (true) {
            if (temp == doubleNode) {
                temp.next.pre = temp.pre;
                temp.pre.next = temp.next;
                break;
            }
            if (temp.next ==null){
                System.out.println("未找到目标节点");
            }
            temp = temp.next;
        }
    }

    //修改  (按id)
    public void updateDoubleNode(doubleNode doubleNode) {
        doubleNode temp = head;
        if (temp.next == null) {
            System.out.println("空链表");
        }
        while (true) {
            if (temp.id == doubleNode.id) {
                temp.name = doubleNode.name;
                break;
            }
            if (temp.next == null) {
                System.out.println("未找到目标节点");
                break;
            }
            temp = temp.next;
        }
    }

    //查询目标id下的name
    public String search(int id) {
        doubleNode temp = head;
        while (true) {
            if (temp.id == id) {
                return temp.name;
            }
            if (temp.next == null) {
                System.out.println("未找到目标元素");
            }
            temp = temp.next;
        }
    }

    //按id顺序添加
    public void addByOrder(doubleNode doubleNode) {
        doubleNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = doubleNode;
                doubleNode.pre = temp;
                break;
            } else if (doubleNode.id > temp.id && doubleNode.id < temp.next.id) {
                temp.next.pre = doubleNode;
                doubleNode.next = temp.next;
                doubleNode.pre = temp;
                temp.next = doubleNode;
                break;
            }
            temp = temp.next;
        }
    }
}

class doubleNode {
    protected int id;
    protected String name;
    doubleNode next;
    doubleNode pre;

    public doubleNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + "id:" + id + ", name:" + name + ']';
    }
}
