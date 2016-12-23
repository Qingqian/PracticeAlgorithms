package DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueInLinkedList<Integer> implements Iterable<Integer> {
	private Node head;
	private Node tail;
	private int size;
	
	private static class Node{
		int data;
		Node next;
	}
	
	public QueueInLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public int size() {
		return size;
	}
	
	public void enqueue(int data) {
		Node newTail = new Node();
		newTail.data = data;
		newTail.next = null;
		
		if(isEmpty()) {
			this.head = newTail;
			this.tail = newTail;
		} else {
			Node oldTail = this.tail;
			oldTail.next = newTail;
			this.tail = newTail;
		}
		size++;
	}
	
	public int dequeue(){
		if(isEmpty())
			throw new NoSuchElementException("queue underflow");
		Node oldFirst = this.head;
		this.head = oldFirst.next;
		size--;
		// to avoid loitering
		if(isEmpty())
			this.tail = null;
		return oldFirst.data;
	}
	
		
	@Override
	public Iterator<Integer> iterator(){
		// TODO Auto-generated method stub
		return new QueueIterator<Integer>(head);
	}
	
	private class QueueIterator<Integer> implements Iterator<Integer>{
		private Node current;
		
		public QueueIterator(Node head){
			current = head;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			if(!hasNext())
				throw new NoSuchElementException("Queue underflow");
			int currentData = current.data;
			current = current.next;
			return new Integer(currentData);
				
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
	}
	
}
