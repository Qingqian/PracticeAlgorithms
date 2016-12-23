package DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackInResizingArray implements Iterable {
	// We are going to use the efficient option
	// push() --- double the size if the array is full
	// pop() --- half the size if the array s quarter full
	
	private int[] array;
	private int size;
	
	public StackInResizingArray() {
		array = new int[2];
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return size ==0;
	}
	
	public int size() {
		return this.size;
	}
	
	public void push(int number) {
		if(size == array.length) {
			resize(2 * array.length);
		}
		array[size++] = number;
		
	}
	
	public int pop() {
		if(isEmpty())
			throw new NoSuchElementException("stack underflow");
		int current = array[--size];
		//set the value to null to avoid loitering -- garbage collection
		if(size > 0 && size == array.length/4)
			resize(array.length/2);
		return current;
		
	}
	
	public int peek() {
		if(isEmpty())
			throw new NoSuchElementException("stack underflow");
		return array[size-1];
	}
	
	public void resize(int capacity) {
		int[] buffer = new int[capacity];
		for(int i=0;i<size;i++) {
			buffer[i] = array[i];
		}
		array = buffer;
	}
	
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator{
		private int index;
		
		public StackIterator() {
			index = size-1;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index >=0;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if(!hasNext())
				throw new NoSuchElementException("stack underflow");
			return array[index--];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
	}
}
