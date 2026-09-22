// package LinkedList;
public class LinkedListPrint {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr!=null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp!=null) {
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }

    public static int count(Node head) {
        int count = 0;
        Node temp = head;
        while (temp!=null) {
            count++;
            temp=temp.next;
        }
        return count;
    }
    
    

    public static boolean search(Node head, int target) {
        Node temp = head;
        while (temp!=null) {
            if(temp.data==target) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static int findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }


    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        // print(head);
        // System.out.println(count(head));
        // System.out.println(findMiddle(head));
        head = reverse(head);
        print(head);
    }
}