public class MyDoublyLinkedList<E> {
	private int size;
	private Node<E> head, tail;

	// Constructors
	public MyDoublyLinkedList() {
		head = tail = null;
	}

	public MyDoublyLinkedList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	// Methods

	// *** ADDING ***
	public void add(E e) {
		addLast(e);
	}

	public void addFirst(E e) { /** add code to set 'previous' [1 mark] */ // DONE
		Node<E> newNode = new Node<E>(e); // Create a new node
		if (tail == null) // if empty list
			head = tail = newNode; // new node is the only node in list
		else {
			newNode.next = head; // link the new node with the head
			head.previous = newNode; // [added previous] set the previous of head to the newNode
			head = newNode; // head points to the new node
		}
		size++;
	}

	public void addLast(E e) { /** add code to set 'previous' [1 mark] */ // DONE
		Node<E> newNode = new Node<E>(e); // Create a new for element e
		if (tail == null) // if empty list
			head = tail = newNode; // new node is the only node in list
		else {
			tail.next = newNode; // Link the new with the last node
			newNode.previous = tail; // [added previous] set the previous of the newNode to the tail.
			tail = tail.next; // tail now points to the last node
		}
		size++;
	}

	public void add(int index, E e) {/** add code to set 'previous' & to improve performance [2 marks] */ // DONE
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException(); // according to Java doc.
		else if (index == 0)
			addFirst(e);
		else if (index == size)
			addLast(e);
		else {
			Node<E> newNode = new Node<E>(e);
			Node<E> current = head; // ]
			// for (int i = 1; i < index; i++) // ]- get a reference to index-1
			// current = current.next; // ]
			current = getNodeAt(index); // [improves performance]
			current.previous.next = newNode;
			newNode.next = current;
			newNode.previous = current.previous;
			current.previous = newNode;
			size++;
		}
	}

	// *** REMOVING ***
	public E removeFirst() {
		/** add code to set 'previous' [1 mark] */ // DONE
		if (size == 0)
			return null;
		else {
			Node<E> temp = head; // element will be returned
			head = head.next;
			head.previous = null; // [added previous] make head.previous point to null, because it was still
									// pointing to the temp.
			size--;
			if (head == null) // if list becomes empty
				tail = null;
			return temp.element; // return the removed element
		}
	}

	public E removeLast() { /** improve performance using 'previous' [1 mark] */ // DONE
		if (size == 0)
			return null;
		else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			Node<E> temp = tail; // to return it
			// [improve performance]
			tail = tail.previous;
			tail.next = null; // remove last
			size--;
			return temp.element; // return last
		}
	}

	public E remove(int index) { /** add code to use and set 'previous' [2 marks] */ // DONE
		if (index < 0 || index >= size)
			return null;
		else if (index == 0)
			return removeFirst();
		else if (index == size - 1)
			return removeLast();
		else {
			Node<E> prev = getNodeAt(index - 1), current = prev.next.next, temp = prev.next;
			prev.next = current;
			current.previous = prev;
			size--;
			return temp.element;
		}
	}

	public boolean remove(E e) {
		if (indexOf(e) >= 0) { // if the element exists
			remove(indexOf(e)); // call the other remove method
			return true;
		} else
			return false;
	}

	public void clear() {
		size = 0;
		head = tail = null;
	}

	// *** GETTING ***
	public E getFirst() {
		if (size == 0)
			return null;
		else
			return head.element;
	}

	public E getLast() {
		if (size == 0)
			return null;
		else
			return tail.element;
	}

	public E get(int index) { /** improve performance using 'previous' [1 mark] */
		if (index < 0 || index >= size)
			return null;
		else if (index == 0)
			return getFirst();
		else if (index == size - 1)
			return getLast();
		else {
			return getNodeAt(index).element;
		}
	}

	// *** SETTING ***
	public E set(int index, E e) { /** improve performance using 'previous' [1 mark] */
		if (index < 0 || index > size - 1)
			return null;
		Node<E> current = getNodeAt(index); // use get note at instead
		E temp = current.element;
		current.element = e;
		return temp;
	}

	// *** TOSTRING ***
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null)
				result.append(", "); // Separate two elements with a comma
			else
				result.append("]"); // Insert the closing ] in the string
		}
		return result.toString();
	}

	public String toReversedString() {
		/**
		 * write code to return a string representing the list from right to left [3
		 * marks]
		 */ // DONE
		StringBuilder result = new StringBuilder("[");
		Node<E> current = tail;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.previous;
			if (current != null)
				result.append(", "); // Separate two elements with a comma
			else
				result.append("]"); // Insert the closing ] in the string
		}
		return result.toString();
	}

	// *** CHECKING ***
	public int size() {
		return size;
	}

	public boolean contains(E e) {
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(e))
				return true;
			current = current.next;
		}
		return false;
	}

	public int indexOf(E e) {
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(e))
				return i;
			current = current.next;
		}
		return -1;
	}

	public int lastIndexOf(E e) { /** improve performance using 'previous' [3 marks] */ // DONE
		Node<E> current = tail;
		for (int i = size - 1; i >= 0; i--) {
			if (current.element.equals(e))
				return i;
			current = current.previous;
		}
		return -1;
	}

	// *** HELPER METHODS ***
	private void checkIndex(int idx) {
		if (idx < 0 || idx >= size)
			throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + size);
	}

	private Node<E> getNodeAt(int index) {
		/**
		 * write code for this method to return a reference to a node at a given
		 * index [3 marks]
		 */
		Node<E> current;
		if (index < size / 2) {
			// check if it is closer to the head
			current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
		} else {
			// check if it is closer to the tail instead
			current = tail;
			for (int i = size - 1; i > index; i--) {
				current = current.previous;
			}
		}
		return current;
	}

	// *** INNER NODE CLASS ***
	private static class Node<E> {
		/** add code to consider 'previous' [1 mark] */
		E element;
		Node<E> next, previous;

		public Node(E e) {
			element = e;
		}
	}
}