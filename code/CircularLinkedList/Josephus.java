
public class Josephus {
    
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node createList(int n) {
        Node head = null;
        Node tail = null;

        for(int i = 1; i <=n; i++) {
            Node newNode = new Node(i);
            if(head==null) {
                head=newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        tail.next = head;
        return head;
    }

    static int josephus(int n, int k) {
        Node head = createList(n);
        Node prev = head;
        Node curr = head;

        while (prev.next!=head) {
            prev = prev.next;
        }

        while (curr.next!=curr) {
            for(int i = 1; i <= k; i++) {
                prev= curr;
                curr = curr.next;
            }

            System.out.println("Eliminated " + curr.data);
            prev.next = curr.next;
            curr = curr.next;
        }
3
        return curr.data;
    }

    public static void main(String[] args) {
        int win = josephus(6, 2);
        System.out.println(win);
    }
}
