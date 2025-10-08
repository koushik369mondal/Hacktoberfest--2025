class Node {
    int data;
    Node next;
    
    Node(int d) {
        data = d;
        next = null;
    }
}

public class ReverseLinkedList {
    Node head;
    
    // Iterative approach
    public Node reverseIterative(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    // Recursive approach
    public Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
    
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        
        System.out.println("Original list:");
        list.printList(list.head);
        
        list.head = list.reverseIterative(list.head);
        System.out.println("Reversed list:");
        list.printList(list.head);
    }
}
