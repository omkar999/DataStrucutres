package datastructures;

public class MyLinkedListCLient {

	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();

		linkedList.insertFirst(1);
		linkedList.insertLast(2);
		linkedList.insertMiddle(2, 5);
		linkedList.display();
		
		linkedList.deleteElement(5);
		linkedList.display();
		linkedList.deleteLast();
		linkedList.deleteFirst();
		linkedList.display();

	}

}
