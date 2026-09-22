
public class InsertBeginning {
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static Node insertAtBeginning(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
        return newNode;
    }
    public static void printList(Node head) {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.print(temp.val + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head; 

        System.out.print("Original list: ");
        printList(head);

        head = insertAtBeginning(head, 0);
        System.out.print("List after inserting 0 at the beginning: ");
        printList(head);
    }
}