package DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueInResizingArray implements Iterable {
	private int[] array;
	private int headIndex;
	private int tailIndex;
	private int size;
	
	public QueueInResizingArray() {
		array = new int[2];
		headIndex = 0;
		tailIndex = 0;
		size = 0;
	}
	
	public boolean isEmpty() {
		return size ==0;
	}
	
	public int size() {
		return this.size;
	}
	
	public void enqueue(int number) {
		if(size == array.length)
			resize(array.length *2);
		array[size++] = number;
		if(tailIndex == array.length)
			tailIndex = 0;
		size++;
			
	}
	
	public int dequeue() {
		if(isEmpty())
			throw new NoSuchElementException("queue underflow");
		int current = array[headIndex++];
		size--;
		if(headIndex == array.length)
			headIndex = 0;
		//decrease the size
		if(size > 0 && size == array.length/4)
			resize(array.length/2);
		return current;
	}
	
	public int peek() {
		if(isEmpty()) 
			throw new NoSuchElementException("Queue underflow");
		return array[headIndex];
	}
	
	public void resize(int capacity) {
		int[] buffer = new int[capacity];
		for(int i=0;i<size;i++) {
			buffer[i] = array[(headIndex + i) % array.length];
		}
		array = buffer;
		headIndex = 0;
		tailIndex = size;
	}
	

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator{
		private int index;
		
		public QueueIterator() {
			index = 0; 
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index < size;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if(!hasNext())
				throw new NoSuchElementException("queue underflow");
			int current = array[(headIndex + index) % array.length];
			index++;
			return current;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
	}

}
