public class MyLinkedList<E> {
    public static final String INDEX_OUT_OF_BOUNDS_EXCEPTION = "Index out of bounds exception!";
    private Node<E> head;
    private int numNodes = 0;

    public int getNumNodes() {
        return numNodes;
    }

    public MyLinkedList(E data) {
        this.head = new Node<>(data);
        numNodes++;
    }

    public void add(int index, E data) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS_EXCEPTION);
        }
        Node<E> holder;
        Node<E> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }                                   // The Node temp now refers to the Node[index-1]
        holder = temp.getNext();            // hold the Node[index] before being unlinked
        temp.setNext(new Node<>(data));     // let the new Node be linked by the Node[index-1], then we have newNode[index]
        temp.getNext().setNext(holder);     // link the new Node[index] to the previous Node[index] (now, Node[index+1])
        numNodes++;                         // increase number of Nodes
    }

    public void addFirst(E data) {
        Node<E> temp = head;                    // hold the first Node
        head = new Node<>(data);                // let head be the new Node
        head.setNext(temp);                     // link the new head to the previous one
        numNodes++;                             // increase number of Nodes
    }

    public void addLast(E data) {
        Node<E> temp = head;                    // the temp Node now refers to the head Node
        while (temp.getNext() != null){         // Remember that a node can be null
            temp = temp.getNext();
        }                                       // At the end of "while", it refers to the last Node
        temp.setNext(new Node<>(data));         // link the last Node to the new one
        numNodes++;                             // increase number of Nodes
    }

    public void printList() {
        Node<E> temp = head;
        while (temp != null) {                  // Remember that a node can be null
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS_EXCEPTION);
        }
        if (index == 0){
            return head.getData();
        }
        Node<E> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }                                       // At the end of "for", it refers to the Node[index-1]
        Node<E> holder = temp.getNext();        // hold the Node[index]
        temp.setNext(temp.getNext().getNext()); // link the previous and the following of the Node[index]
        numNodes--;
        return holder.getData();
    }

    public boolean remove(Object object) {
        Node<E> temp = head;
        if (head.getData().equals(object)){
            numNodes--;
            return true;
        }
        while (temp.getNext() != null) {
            if (temp.getNext().getData().equals(object)) {
                temp.setNext(temp.getNext().getNext() == null ? null : temp.getNext().getNext());
                numNodes--;
                return true;
            }
            temp = temp.getNext();
        }
        numNodes--;
        return false;
    }

    private E removeLast(){
        Node<E> temp = head;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        Node<E> last = temp;
        temp = null;
        numNodes--;
        return last.getData();
    }

    public E get(int index){
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public int size(){
        return numNodes;
    }

    public E getFirst(){
        return head.getData();
    }

    public E getLast(){
        Node<E> temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public void clear(){
        Node<E> holder;
        while (head.getNext() != null){
            holder = head;
            head = null;
            head = holder.getNext();
        }
        numNodes = 0;
    }

    public MyLinkedList<E> clone(){
        return this;
    }

    public boolean contains(Object object){
        return indexOf(object) != -1;
    }

    public int indexOf(Object object) {
        Node<E> temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(object)) {
                return i;
            }
            temp = temp.getNext();
        }
        return -1;
    }

    @Override
    public String toString() {
        String displayString = numNodes + " node: ";
        Node<E> temp = head;
        while (temp.getNext() != null) {
            displayString += temp.getData() + " ";
        }
        return displayString;
    }
}
