package anbu;

public class DoubleLinkedListExample {
    public static void main(String[] args) {

        DllNode n1 = new DllNode(1);
        n1.next = null;
        n1.prev = null;
        DoubleLinkedList doubleLinkedList=new DoubleLinkedList(n1,null);

        System.out.println(doubleLinkedList);
        doubleLinkedList.addToEnd(5);
        System.out.println(doubleLinkedList);
        System.out.println();

    }
}

class DoubleLinkedList{
    DllNode head;

    DllNode tail;
    public DoubleLinkedList(DllNode head,DllNode tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                "head=" + head +
                '}';
    }

    void addToEnd(int data){
        DllNode n = new DllNode(data);

        if(head ==null ){
            head = n;
        } else{
            DllNode curr = head;
            while(curr.next != null ){
                curr = curr.next;
            }
            curr.next= n;
            n.prev = curr;

        }



    }
}

class DllNode {
    int data;
    DllNode prev;
    DllNode next;
    public DllNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "DllNode{" +
                "data=" + data +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}
