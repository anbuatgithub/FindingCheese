package anbu.apexon;

public class SingleLinkedListTraversal {
    public static void main(String[] args) {

        Node n1 = new Node(5);
        Node n2 = new Node(10);
        Node n3 = new Node(15);

        n1.next = n2;
        n2.next = n3;

        LinkedList linkedList= new LinkedList(n1);
        linkedList.addAfter(15,17);
        linkedList.addToEnd(50);
        System.out.println(linkedList);
        linkedList.addToStart(1);
        System.out.println(linkedList);
        linkedList.printNodes();

        System.out.println(linkedList.deleteLastNode());
        System.out.println(linkedList);
        System.out.println(linkedList.deleteStartNode());
        System.out.println(linkedList);
        System.out.println(linkedList.deleteAfter(15));
        System.out.println(linkedList);

        linkedList.printNodes();

        linkedList.reverse();
        linkedList.printNodes();

    }
}

class LinkedList{
    Node head;

    public LinkedList(Node head) {
        this.head = head;
    }

    void addToEnd(int data){
        if(head ==null ){
            head = new Node(data);
        } else{
            Node curr = head;
            while(curr.next != null ){
                curr = curr.next;
            }
            curr.next= new Node(data);

        }



    }


    void addAfter(int insertAfter , int data){
        Node curr = head;

        while(curr != null){
            if(curr.data == insertAfter){
                Node n=new Node(data);
                n.next = curr.next;
                curr.next = n;
                break;
            }
            curr = curr.next;
        }
    }


    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                '}';
    }

    public void addToStart(int data) {
        Node curr = head;
        head = new Node(data);
        head.next = curr;

    }

    public Node deleteLastNode() {
        Node curr = head;
        if(curr == null || curr.next == null ){
            head = null;
            return curr;
        }

        Node nextNode = curr.next;

        while(curr.next != null){
            if(nextNode.next == null){
                curr.next = null;
                break;
            }
            curr = nextNode;
            nextNode = nextNode.next;
        }
        return curr;
    }


    public Node deleteStartNode() {
        if(head  != null){
            Node toDelete = head;
           head = head.next;
           return toDelete;
        }
        return null;
    }

    public Node deleteAfter(int data) {
        Node curr = head;
        Node toDelete = null;
        while(curr != null){
            if(curr.data == data && curr.next !=null){
                toDelete =curr.next;
                curr.next = toDelete.next;
                break;
            }
            curr = curr.next;
        }
        return toDelete;
    }

    public void printNodes() {
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public Node reverse() {
        Node previous = null;
        Node curr = head;
        while(curr !=null){
            Node next = curr.next;
            curr.next = previous;
            previous =curr;
            curr = next;

        }
        return previous;
    }


}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}