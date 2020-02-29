package thinkbig.psds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSortDLL {

	public static void main(String args[]) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			int noOfTestCases = Integer.parseInt(reader.readLine());

			for (int i = 0; i < noOfTestCases; i++) {
				QuickSortDLLImpl quickSortDLLImpl = new QuickSortDLLImpl();
				int noOfElements = Integer.parseInt(reader.readLine());
				Node head = null;

				for (int j = 0; j < noOfElements; j++) {
					int element = Integer.parseInt(reader.readLine());
					quickSortDLLImpl.constructDLL(element);
				}
				quickSortDLLImpl.quickSort();
				quickSortDLLImpl.printList();
			}

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}

class QuickSortDLLImpl {

	Node head = null;
	Node tail = null;
	class Node {
		int element;
		Node next, prev;

		Node(int element) {
			this.element = element;
			this.next = this.prev = null;
		}
	}
	public void constructDLL(int element) {
		Node node =  new Node(element);
		if (head == null) {
			head = node;
		}
		else {
			Node nodePointer = head;
			while (nodePointer.next != null) {
				nodePointer = nodePointer.next;
			}
			nodePointer.next = node;
			node.prev = nodePointer;
			tail = node;
		}

	}
	public void printList() {
		Node nodePointer = head;
		while (nodePointer != null) {
			System.out.print(" "+nodePointer.element);
			nodePointer = nodePointer.next;
		}
		System.out.println();
	}
	public void quickSort() {
		Node node = quickSortDLL(head,tail);
		quickSortDLL(head,node.prev);
		quickSortDLL(node.next,tail);
	}
	
	private Node quickSortDLL(Node h, Node t) {
		Node index = h;
		Node j = h;
		
		while (j != null) {
			if (j.element <= t.element) {
				swap(index,j);
				index = index.next;
			}
			j = j.next;
		}
		swap(index,t);
		return index;
		
	}
	private void swap(Node node1, Node node2) {
		int temp = node1.element;
		node1.element = node2.element;
		node2.element = temp;
	}

}
