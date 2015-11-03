/**
 * 
 */
package datastructures;

/**
 * @author om
 *
 */
public class MyLinkedList {
	private Node firstNode;
	private Node currNode;
	private static int size;

	/**
	 * @param element
	 *            Inserts element at the starting of the list
	 */
	public void insertFirst(int element) {
		Node newNode = new Node(element);
		if (size == 0) {
			firstNode = newNode;
			currNode = firstNode;
			size++;
			return;
		}
		newNode.next = firstNode;
		firstNode = newNode;
		size++;
	}

	/**
	 * @param element
	 *            Inserts element at the end of the list
	 */
	public void insertLast(int element) {
		if (size == 0) {
			insertFirst(element);
			return;
		}

		Node newNode = new Node(element);
		Node temp = currNode;
		temp.next = newNode;
		currNode = newNode;
		size++;
	}

	/**
	 * @param index
	 * @param element
	 *            Adds element at index position
	 */
	public void insertMiddle(int index, int element) {
		if (size == 0)
			insertFirst(element);
		if (index == size + 1)
			insertLast(element);
		if (index > size + 1)
			throw new IndexOutOfBoundsException();

		Node temp = firstNode;
		for (int i = 1; i < index - 1; i++) {
			temp = temp.next;
		}
		Node newNode = new Node(element);
		newNode.next = temp.next;
		temp.next = newNode;
		size++;
	}

	/**
	 * Deletes the first element in the LinkedList
	 */
	public void deleteFirst() {
		if (size == 0) {
			throw new IndexOutOfBoundsException("Trying to delete element in an Empty Linked List");
		}
		if (size == 1) {
			firstNode = null;
			currNode = null;
			size = 0;
			return;
		}
		firstNode = firstNode.next;
		size--;
	}

	/**
	 * Deletes the last element in the LinkedList
	 */
	public void deleteLast() {
		if (size == 0) {
			throw new IndexOutOfBoundsException("Trying to delete element in an Empty Linked List");
		}
		if (size == 1) {
			deleteFirst();
		}
		Node temp = firstNode;
		for (int i = 1; i < size - 1; i++) {
			temp = temp.next;
		}
		temp.next = null;
		currNode = temp;
		size--;
	}

	/**
	 * @param index
	 *            Deletes element at specified index position
	 * 
	 */
	public void deleteMiddle(int index) {
		if (size == 0) {
			throw new IndexOutOfBoundsException("Trying to delete element in an Empty Linked List");
		}
		Node temp = firstNode;
		for (int i = 1; i < index - 1; i++) {
			temp = temp.next;
		}
		Node temp2 = temp.next;
		temp.next = temp2.next;
		size--;
	}

	/**
	 * @param element
	 *            Deletes element in the linked list
	 * @throws Exception
	 */
	public void deleteElement(int element) {
		boolean elementFound = false;
		if (size == 0) {
			throw new IndexOutOfBoundsException("Trying to delete element in an Empty Linked List");
		}
		if (firstNode.value == element) {
			deleteFirst();
		}
		if (currNode.value == element) {
			deleteLast();
		}

		Node temp = firstNode;
		int index = 1;
		for (int i = 1; i < size; i++) {
			temp = temp.next;
			index++;
			if (temp.value == element) {
				elementFound = true;
				break;
			}
		}
		if (!elementFound)
			return;
		deleteMiddle(index);

	}

	public void display() {
		if (size == 0) {
			System.out.println("No Elements in LinkedList");
			return;
		}
		System.out.println("size=" + size);
		System.out.println("FirstNode=" + firstNode);
		System.out.println("CurrNode=" + currNode);

		Node temp = firstNode;
		System.out.println("All Elements in the LinkedList :");
		System.out.println(temp.value);
		for (int i = 1; i < size; i++) {
			temp = temp.next;
			System.out.println(temp.value);

		}
	}

}

/**
 * Node class will hold an int value and reference to next node
 *
 */
class Node {
	int value;
	Node next;

	public Node(int value) {
		this.value = value;
		next = null;
	}

	public String toString() {
		return "[" + value + "]";
	}

}
