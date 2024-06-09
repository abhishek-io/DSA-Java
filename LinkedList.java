
import java.util.NoSuchElementException;

public class LinkedList {

    public static void main(String[] args) {

        var linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        // linkedList.print();
        linkedList.removeLast();
        linkedList.print();
        linkedList.addFirst(5);
        System.out.println(linkedList.contains(30));
        System.out.println(linkedList.indexOf(25));

    }

    private class Node {
        private int value;
        private Node next;

        public Node(int val) {
            this.value = val;
        }
    }

    private Node first;// x001
    private Node last; // x123

    private boolean isListEmpty() {
        return first == null;
    }

    public void addLast(int item) {
        var node = new Node(item);// newTempNode(x789) - [val:item,nextNodeAdd:null]

        if (isListEmpty())// if firstNode(x001) - [firstVal:null,nextNodeAdd:null]
            first = last = node;
        else {// firstNode(x001) - [val:1,nextNodeAdd:x123]-> secondNode(x123) -
              // [val:1,nextNodeAdd:null]
            last.next = node; // secondNode(x123) - [val:1,nextNodeAdd:x789]
            last = node; // firstNode(x001) - [val:1,nextNodeAdd:x123]-> secondNode(x123) -
                         // [val:1,nextNodeAdd:x789] -> thirdNode(x789) - [val:item,nextNodeAdd:null]
        }
    }

    public void addFirst(int item) {
        var node = new Node(item); // tempNode

        if (isListEmpty()) {
            first = last = null;
        } else {
            node.next = first;// set temp's next to firstNode
            first = node; // direct first to tempNode
        }
    }

    public int indexOf(int item) {
        var index = 0;
        var current = first;
        while (current.next != null) {
            if (current.value == item)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (isListEmpty())
            throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
    }

    public void removeLast() {
        if (isListEmpty())
            throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            return;
        }

        var temp = first;
        while (temp != null) {
            if (temp.next == last)
                break;
            var secondLast = temp;
            temp = temp.next;
            last = secondLast;
            last.next = null;
        }

    }

    public void print() {
        var temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

}
