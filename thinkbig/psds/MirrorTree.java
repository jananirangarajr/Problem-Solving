package thinkbig.psds;

/**
 * @author Jaanu
 * @link https://practice.geeksforgeeks.org/problems/mirror-tree/1
 */

//{ Driver Code Starts
//Initial Template for Java

//INITIAL CODE
import java.util.*;
import java.lang.*;
import java.io.*;

//A Binary Tree node
class Node
{
 int data;
 Node left, right;

 Node(int item)
 {
     data = item;
     left = right = null;
 }
}



class MirrorTree
{
	 void inOrder(Node node) {
     if (node == null) {
         return;
     }

     inOrder(node.left);
     System.out.print(node.data + " ");

     inOrder(node.right);
 }
	
 // driver function to test the above functions
 public static void main(String args[])
 {
     // Input the number of test cases you want to run
     Scanner sc = new Scanner(System.in);
		MirrorTree mt = new MirrorTree();
     int t = sc.nextInt();

     while (t > 0)
     {
         HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
         int n = sc.nextInt();

         Node root = null;

         while (n > 0)
         {
             int n1 = sc.nextInt();
             int n2 = sc.nextInt();
             char lr = sc.next().charAt(0);

             //  cout << n1 << " " << n2 << " " << (char)lr << endl;
             Node parent = m.get(n1);
             if (parent == null)
             {
                 parent = new Node(n1);
                 m.put(n1, parent);
                 if (root == null)
                     root = parent;
             }

             Node child = new Node(n2);
             if (lr == 'L')
                 parent.left = child;
             else
                 parent.right = child;
             m.put(n2, child);
             n--;
         }

         Tree g = new Tree();
         g.mirror(root);
			mt.inOrder(root);
			System.out.println();
         t--;
     }
 }
}

class Tree
{
 void mirror(Node node)
 {
	// Your code here
	if(node == null || (node.left == null && node.right == null))
	{
	    return;
	}
	else{
	    if(node.left == null && node.right != null)
	    {
	        mirror(node.right);
	        node.left = node.right;
	        node.right = null;
	    }
	    else if(node.right == null && node.left != null)
	    {
	        mirror(node.left);
	        node.right = node.left;
	        node.left = null;
	    }
	    else
	    {
	        mirror(node.left);
	        mirror(node.right);
	        Node left = node.left;
	        node.left = node.right;
	        node.right = left;
	    }
	}
 }
}
