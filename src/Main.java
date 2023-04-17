

public class Main {
    public static void main(String[] args) {
        TestList lst = new TestList();

        lst.addFirst(1);
        lst.addFirst(2);
        lst.addFirst(3);
        lst.addFirst(4);
        lst.addFirst(5);


        lst.show();
        lst.reverse();
        System.out.println("reverse");
        lst.show();

    }
}

class TestList {
    Node head;

    public void show() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.getNext();
        }
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        node.setNext(head);
        head = node;
    }

    public void reverse() {
        Node current = head;
        head = null;
        while (current.next != null) {
            this.addFirst(current.value);
            current = current.next;
        }
        this.addFirst(current.value);
    }


    static class Node {
        public int value;
        public Node next;
        public Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


    }
}

