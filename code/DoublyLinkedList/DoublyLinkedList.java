public class DoublyLinkedList {
    static class Node {

        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    static void printForward(Node head) {
        Node temp = head;

        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static Node insertBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;

        if(head!=null) {
            head.prev = newNode;
        }

        head = newNode;

        return head;

    }

    static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);

        Node temp = head;

        while(temp.next!=null) {
            temp=temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    static void printReverse(Node head) {
        Node temp = head;
        while(temp.next!=null) {
            temp=temp.next;
        }
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.prev;
        }
    }

    static Node deleteFromFirst(Node head) {

        if(head==null) {
            return null;
        }

        head = head.next;
        
        if(head!=null) {
            head.prev = null;
        }

        return head;
    }

    static Node reverse(Node head) {
        Node curr = head;
        Node newhead = null;

        while(curr!=null) {
            Node temp =  curr.prev;
            curr.prev = curr.next;

            curr.next = temp;
            newhead = curr;
            curr = curr.prev;
        }

        return newhead;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;
        printForward(head);
        printReverse(head);
        head = insertBeginning(head, 50);
        printForward(head);
        head = insertAtEnd(head, 60);
        printForward(head);
        head = deleteFromFirst(head);
        printForward(head);
        head = reverse(head);
        printForward(head);
    }
}
