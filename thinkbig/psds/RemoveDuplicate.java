package thinkbig.psds;

/**
 * @author Jaanu
 * @link https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1
 */
import java.util.*;

class RemoveDuplicate
{
	static class Node
	{
		int data;
		Node next;
		Node(int d) {data = d; next = null; }
	}
	
	Node head;  
	public void addToTheLast(Node node) 
	{
		if (head == null) 
		{
			head = node;
		} else 
		{
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}
	
	void printList()
	{
		Node temp = head;
		while (temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}  
		System.out.println();
	}
	
	// head: head node
	static Node removeDuplicates(Node root)
	{
		Node node = root;
		while(node.next != null)
		{
			if(node.next.data == node.data)
			{
				node.next = node.next.next;
			}
			else
			{
				node = node.next;
			}
		}
		return root;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			RemoveDuplicate llist = new  RemoveDuplicate(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}

			llist.head = removeDuplicates(llist.head);
			llist.printList();

			t--;		
		}
	}
}


