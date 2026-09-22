
public class Palindrome {
    static class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node right = head;
        while (right.next != null) {
            right = right.next;
        }

        Node left = head;
        while (left != right && left.prev != right) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }

        return true;
    }
}