/*
    SLL.java
    - Singly Linked List
    Template Created By Juan Lee <juanlee@kaist.ac.kr>
*/

public class SLL {
    // class Node
    class Node {
        String elem; // element of the node
        Node next; // pointer pointing to the next

        // constructor: create new node with element
        public Node(String elem) {
            this.elem = elem;
            this.next = null;
        }

        // constructor: create new node with element and pointer
        public Node(String elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }

    Node head = null;
    int size = 0;

    // isEmpty: void -> boolean
    // - return True if SLL is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // insertFront: String -> void
    // - insert at the front
    public void insertFront(String newElem) {
        head = new Node(newElem, head);
        size++;
    }

    // deleteFront: void -> void
    // - delete at the front
    public void deleteFront() {
        if (isEmpty())
            return; // do nothing
        head = head.next;
        size--;
    }

    // insertAt: int, String -> void
    // - insert new element at the given position
    public void insertAt(int idx, String newElem) {
        // TODO: please insert newElem at the idx position.
        // Example: with A -> B -> C, insertAt(1, "D") will result in A -> D -> B -> C
        // If idx is less than 0, then insert at the front.
        // If idx is greater than SLL's last index, then insert at the back.
        if (idx <= 0) {
            head = new Node(newElem, head);
        }
        else {
            temp1 = head;
            for (int i = 0; i < idx-1; i++) {
                temp = temp.next;
            }
            temp.next = newElem
            Node newElem.before.next = newElem.next;
        }
        size++;
    }

    // deleteAt: int -> void
    // - delete an element of given position
    public void deleteAt(int idx) {
        // TODO: please delete an element of given position, idx
        // Example: with A -> B -> C, deleteAt(1) will result in A -> C
        // If idx is out of the range, do nothing but prints "Index Out Of Range"
        if (idx > size-1)
            System.out.println("Index Out Of Range");
            return;
        temp1 = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        temp1.next = temp1.next.next
    }

    // describe: void -> void
    // - show all the elements in the list
    public void describe() {
        Node current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.elem);
            if (current.next != null)
                System.out.print(", ");

            current = current.next;
        }
        System.out.println("]");
    }

    // Main
    public static void main(String[] args) {
        SLL list = new SLL();
        list.insertFront("C");
        list.insertFront("B");
        list.insertFront("A");
        list.describe(); // [A, B, C]

        list.deleteFront();
        list.describe(); // [B, C]

        list.insertAt(1, "D");
        list.insertAt(1, "E");
        list.describe(); // [B, E, D, C]

        list.deleteAt(2);
        list.describe(); // [B, E, C]
    }
}
