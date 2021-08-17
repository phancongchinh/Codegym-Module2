public class MyLinkedList {
    private Node head;
    private int numOfNodes;

    public MyLinkedList(Object data){
        this.head = new Node(data);
    }

    public void add(int index, Object data){
        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node (data);
        temp.next.next = holder;
        numOfNodes++;
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numOfNodes++;
    }

    public Node get(int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void printList(){
        Node temp = head;
        while (temp!= null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
