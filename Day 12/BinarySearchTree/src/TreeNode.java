public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode (E e){
        element = e;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "element=" + element +
                '}';
    }
}
