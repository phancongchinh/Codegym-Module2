public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);

        display(myLinkedList);

        myLinkedList.add(3,8);

        display(myLinkedList);

        myLinkedList.addLast(1000);

        display(myLinkedList);

        System.out.println(myLinkedList.remove(3));

        display(myLinkedList);

    }

    private static void display(MyLinkedList<Integer> myLinkedList) {
        myLinkedList.printList();
        System.out.println("Number of nodes = " + myLinkedList.getNumNodes());
    }
}
