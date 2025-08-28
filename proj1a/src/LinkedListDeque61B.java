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
    private int size;

    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;

        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node xNode = new Node(sentinel, x, sentinel.next);
        sentinel.next.prev = xNode;
        sentinel.next = xNode;

        size++;
    }

    @Override
    public void addLast(T x) {
        Node xNode = new Node(sentinel.prev, x, sentinel);
        sentinel.prev.next = xNode;
        sentinel.prev = xNode;

        size++;
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
        if (sentinel.next == sentinel) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        T temp = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return temp;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        T temp = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return temp;
    }

    @Override
    public T get(int index) {
        int i = 0;
        for (Node flag = sentinel.next; flag != sentinel; flag = flag.next) {
            if (i == index) {
                return flag.item;
            }
            i++;
        }
        return null;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(index, sentinel);
    }

    private T getRecursiveHelper(int idx, Node temp) {
        if (idx == 0) {
            return temp.next.item;
        } else {
            return getRecursiveHelper(idx - 1, temp.next);
        }
    }

}
