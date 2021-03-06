

class Node3
{
    int data;
    Node3 next;
 
    Node3(int data, Node3 next)
    {
        this.data = data;
        this.next = next;
    }
 
    Node3() {}
}
 
class Main
{
    // Helper function to print a given linked list
    public static void printList(String msg, Node3 head)
    {
        System.out.print(msg);
 
        Node3 ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
 
        System.out.println("null");
    }
 
    
    public static Node3 sortedMerge(Node3 a, Node3 b)
    {
        
        Node3 dummy = new Node3();
 
        
        Node3 tail = dummy;
 
        while (true)
        {
            
            if (a == null)
            {
                tail.next = b;
                break;
            }
            else if (b == null)
            {
                tail.next = a;
                break;
            }
 
            if (a.data <= b.data)
            {
                if (a != null)
                {
                    Node3 newNode = a;
                    a = a.next;
 
                    newNode.next = tail.next;
                    tail.next = newNode;
                }
            }
            else {
                if (b != null)
                {
                    Node3 newNode = b;
                    b = b.next;
 
                    newNode.next = tail.next;
                    tail.next = newNode;
                }
            }
            tail = tail.next;
        }
 
        return dummy.next;
    }
 
    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5, 6, 7 };
 
        Node3 a = null, b = null;
        for (int i = keys.length - 1; i >= 0; i = i - 2) {
            a = a = new Node3(keys[i], a);
        }
 
        for (int i = keys.length - 2; i >= 0; i = i - 2) {
            b = b = new Node3(keys[i], b);
        }
 
        // print both lists
        printList("First List: ", a);
        printList("Second List: ", b);
 
        Node3 head = sortedMerge(a, b);
        printList("After Merge: ", head);
    }
}
