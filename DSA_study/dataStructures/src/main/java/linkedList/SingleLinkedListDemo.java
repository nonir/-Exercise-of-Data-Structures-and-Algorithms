package linkedList;

/**
 * @author non
 * @date 2020/6/28 - 21:03
 * 链表的基本元素为节点 节点内包含 数据 和下一个节点的地址
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        node node1 = new node(1, "test1");
        node node2 = new node(2, "test2");
        node nodd3 = new node(3, "test3");
        list.addReorder(node2);
        list.addReorder(node1);
        list.addReorder(nodd3);
        list.showLinkedList();
        System.out.println("节点数量为:" + list.getNumOfNode());
    }
//  链表显示 (遍历  , 辅助节点), 增删改查.
}

class SingleLinkedList {
    private node head = new node(0, "");

    public node getHead() {
        return head;
    }

    //显示链表内容
    public void showLinkedList() {
        node temp = head.next;
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            System.out.println(temp);
            if (temp.next != null) {
                temp = temp.next;
            } else break;
        }
    }

    //增  从链表最后添加
    public void addLinkedList(node node) {
        node temp = head;
        while (true) {
            if (temp.next != null) {
                temp = temp.next;
            } else {
                temp.next = node;
                break;
            }
        }
    }

    //删  删除目标id 数据
    public void delLinkedList(int id) {
        node temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("没有找到目标数据");
                if (temp.next.id == id) {
                    temp.next = temp.next.next;
                    break;
                } else temp = temp.next;
            }
        }
    }

    // 改 ,修改目标id下链表数据
    public void updateLinkedList(node node) {
        if (node.id == head.id) {
            System.out.println("链表为空");
        }
        node temp = head;
        while (true) {
            if (temp == null) {
                System.out.println("没有找到目标数据");
                break;
            }
            if (temp.id == node.id) {
                temp.name = node.name;
                break;
            } else temp = temp.next;
        }
    }

    //查找目标id的name
    public void searchLinkedList(int id) {
        node temp = head;
        while (true) {
            if (temp.id == id) {
                System.out.println(temp.name);
                break;
            } else temp = temp.next;
        }
    }

    //添加节点时排序
    public void addReorder(node node) {
        node temp = head;
        while (true) {
            if (node.id > temp.id && temp.next == null) {
                temp.next = node;
                break;
            } else if (node.id > temp.id && node.id < temp.next.id) {
                node.next = temp.next;
                temp.next = node;
                break;
            } else if (temp.id == node.id) {
                System.out.println("id重复");
                break;
            } else temp = temp.next;
        }
    }

    //获取节点个数
    public int getNumOfNode() {
        int i = 0;
        node temp = head;
        while (temp.next != null) {
            i++;
            temp = temp.next;
        }
        return i;

    }

}
//节点
class node {
    int id;
    String name;
    node next;

    node(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    // 返回节点String
    public String toString() {
        return " [id=" + id + ", name=" + name + "]";
    }
}