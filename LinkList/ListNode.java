public class ListNode<E> {
    ListNode<E> next;
    ListNode<E> prev;
    E data;

    public ListNode(E data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}


