
public class DeleteAllOccur {
    static class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static Node deleteAllOccurrences(Node head, int target) {
        Node curr = head;

        while (curr != null) {
            if (curr.val == target) {
                Node nextNode = curr.next;
                Node prevNode = curr.prev;

                if (prevNode != null) {
                    prevNode.next = nextNode;
                } else {
                    head = nextNode;
                }

                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                curr = nextNode;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}