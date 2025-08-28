import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    private class Node {
        public Node prev;
        public Node next;
        public T item;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;

    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    @Override
    public void addFirst(T x) {
        Node xNode = new Node(sentinel, x, sentinel.next);
        sentinel.next.prev = xNode;
        sentinel.next = xNode;
    }

    @Override
    public void addLast(T x) {
        Node xNode = new Node(sentinel.prev, x, sentinel);
        sentinel.prev.next = xNode;
        sentinel.prev = xNode;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        for (Node flag = sentinel.next; flag != sentinel; flag = flag.next) {
            returnList.addLast(flag.item);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public T removeFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFirst'");
    }

    @Override
    public T removeLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeLast'");
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public T getRecursive(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecursive'");
    }

}
