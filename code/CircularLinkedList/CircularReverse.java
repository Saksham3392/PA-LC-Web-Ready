public class CircularReverse {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data=data;
        } 
    }

    static Node head = null;

    static void insert(int data) {
        Node newNode = new Node(data);

        if(head==null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next!=head) {
            temp=temp.next;
        }

        temp.next=newNode;
        newNode.next=head;
    }

    static void printReverse(Node curr, Node start) {
        if(curr.next==start) {
            System.out.println(curr.data + " ");
            return;
        }

        printReverse(curr.next, start);
        System.out.println(curr.data+" ");
    }

    static void middle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next!=head && fast.next.next!=head) {
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println("Middele: "+slow.data);
    }


    public static void main(String[] args) {
        insert(10);
        insert(20);
        insert(30);
        insert(40);
        insert(50);
        printReverse(head, head);
        middle(head);
    }
}
