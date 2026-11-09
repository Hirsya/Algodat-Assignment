public class HirsyaQueue<T> {

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        private Node(T value) {
            this(value, null);
        }

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> front;
    private Node<T> end;
    private int size;

    public HirsyaQueue() {
        this.front = null;
        this.end = null;
        this.size = 0;
    }

    public void add(T obj) {
        Node<T> newNode = new Node<>(obj);
        if (isEmpty()) {
            front = newNode;
        } else {
            end.next = newNode;
        }
        end = newNode;
        size++;
    }

    public T remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        T value = front.value;
        front = front.next;
        if (front == null) end = null;
        size--;
        return value;
    }

    public T getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return front.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        front = null;
        end = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node<T> n = front; n != null; n = n.next) {
            sb.append(n.value);
            if (n.next != null) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}
