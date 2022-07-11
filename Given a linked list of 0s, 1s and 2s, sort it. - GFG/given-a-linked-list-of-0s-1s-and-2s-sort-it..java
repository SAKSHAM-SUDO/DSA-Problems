// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    
    static Node segregate(Node head)
    {
        int count[] = new int[3];
        int size = 0;
        Node curr = head;
        while(curr != null)
        {
            count[curr.data]++;
            curr = curr.next;
            size++;
        }
        
        Node updated = new Node(0);
        Node c = updated;
        
        while(count[0]-- != 0)
        {
            Node n = new Node(0);
            c.next = n;
            c = c.next;
        }
        while(count[1]-- != 0)
        {
            Node n = new Node(1);
            c.next = n;
            c = c.next;
        }
        while(count[2]-- != 0)
        {
            Node n = new Node(2);
            c.next = n;
            c = c.next;
        }
        
        return updated.next;
    }
}


