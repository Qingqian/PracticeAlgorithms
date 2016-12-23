package DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackInLinkedList<Integer> implements Iterable<Integer> {
	Node head;
	int size;
	
	private static class Node{
		int data;
		Node next;
	}
	
	public StackInLinkedList(){
		head = null;
		size =0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size(){
		return this.size;
	}
	
	public void push(int number) {
		Node oldHead = head;
		Node newHead = new Node();
		newHead.data = number;
		newHead.next = oldHead;
		head = newHead;
		size++;
	}
	
	public int pop(){
		if(isEmpty()){
			throw new NoSuchElementException("stack underflow");
		}
		Node oldHead = head;
		head = head.next;
		size--;
		return oldHead.data;
		
	}
	
	public int peek(){
		if(isEmpty())
			throw new NoSuchElementException("stack underflow");
		return head.data;
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new StackIterator<Integer>(head);
	}
	
	private class StackIterator<Integer> implements Iterator<Integer>{
		private Node current;
		
		public StackIterator(Node head){
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
				throw new NoSuchElementException();
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
