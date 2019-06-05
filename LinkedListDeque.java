public class LinkedListDeque<T> implements Deque<T> {
    private class TNode {
        public T item;
        public TNode prev;
        public TNode next;

        public TNode(T item_, TNode prev_, TNode next_) {
            this.item = item_;
            this.prev = prev_;
            this.next = next_;
        }
    }

    private TNode sentinel;
    private int size;
    public int size() {
        return size;
    }
    public LinkedListDeque() {
        sentinel = new TNode((T) "63", null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public LinkedListDeque(T item_) {
        sentinel = new TNode((T) "63", null, null);
        sentinel.next = new TNode(item_, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }
    public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new TNode(other.sentinel.item, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        for (int i = 0; i < other.size; i++) {
            addLast(other.get(i));
        }
    }
    public T getFirst() {
        return sentinel.next.item;
    }
    public T getLast() {
        return sentinel.prev.item;
    }
    public void addFirst(T item_) {
        sentinel.next = new TNode(item_, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }
    public void addLast(T item_) {
        sentinel.prev = new TNode(item_, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        TNode removed = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return removed.item;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        TNode removed = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return removed.item;
    }

    public T get(int index) {
        TNode p = sentinel.next;
        while (index != 0) {
            p = p.next;
            index--;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        T res = getRecursiveHelper(sentinel.next, index);
        return res;
    }
    private T getRecursiveHelper(TNode p_, int index_) {
        if (index_ == 0) {
            return p_.item;
        } else {
            T res_ = getRecursiveHelper(p_.next, --index_);
            return res_;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void printDeque() {
        TNode p = sentinel.next;
        while(p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

}