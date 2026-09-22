
public class DeleteNode {
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static Node deleteNode(Node head, int target) {
        if (head == null) return null;

        Node curr = head;
        Node prev = null;

        while (curr.val != target) {
            if (curr.next == head) return head;
            prev = curr;
            curr = curr.next;
        }

        if (curr == head && curr.next == head) {
            return null;
        }

        if (curr == head) {
            prev = head;
            while (prev.next != head) {
                prev = prev.next;
            }
            head = head.next;
            prev.next = head;
        } else {
            prev.next = curr.next;
        }

        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head; 

        head = deleteNode(head, 2);

        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.val + " ");
                temp = temp.next;
            } while (temp != head);
        } else {
            System.out.println("List is empty.");
        }
    }
}