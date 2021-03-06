public class Node<E> {
    private Node<E> next;
    private E data;

    public Node(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getData() {
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data + " ";
    }
}