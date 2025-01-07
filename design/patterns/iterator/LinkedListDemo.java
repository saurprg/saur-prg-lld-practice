import java.util.Iterator;

class List<T> implements Iterable<T> {
    private ListNode<T> head;

    List(ListNode<T> head) {
        this.head = head;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(head);
    }
    
}

class ListNode<T> {
    public ListNode<T> next;
    public T val;

    ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }
}

class ListIterator<T> implements Iterator<T> {

    private ListNode<T> current;

    ListIterator(ListNode<T> current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current.next != null;
    }

    @Override
    public T next() {
        return current.next.val;
    }
    
}

public class LinkedListDemo {

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(0, new ListNode<>(1, new ListNode<>(3, null)));
        List<Integer> lst = new List<>(head);
        for(Integer l : lst) {
            System.out.println(l);
        }
    }
}
