import java.util.NoSuchElementException;
import java.io.PrintStream;

public class StringDoubleEndedQueueImpl implements StringDoubleEndedQueue{
    private Node head;
    private Node tail;

    public StringDoubleEndedQueueImpl(){
        this.head = null;
        this.tail = null;
    }
    public boolean isEmpty()
    {
        return head==null && tail==null;
    }
    public void addFirst(String item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    public void addLast(String item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    @Override
    public String removeFirst() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        String removedData = head.data;
        if (head.next != null) {
            head = head.next;
            head.prev = null;
        } else {
            head = null;
            tail = null;
        }
        return removedData;
    }
    public String removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        String removedData = tail.data;
        if (tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }
        return removedData;
    }
    public String getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return head.data;
    }

    public String getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return tail.data;
    }
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    public void printQueue(PrintStream ps) {
        Node current = head;
        ps.print("Deque: ");
        while (current != null) {
            ps.print(current.data + " ");
            current = current.next;
        }
        ps.println();
    }
}
