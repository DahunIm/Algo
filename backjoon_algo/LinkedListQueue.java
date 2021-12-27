package backjoon_algo;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

class Node <E>{
	
	E data;
	Node<E> next;
	
	Node(E data){
		this.data = data;
		this.next = null;
	}
	
	
}

public class LinkedListQueue<E> implements Queue<E> {
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public LinkedListQueue() {
		
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		for(Node<E> x = head; x != null; x = x.next) {
			if(o.equals(x.data)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(E e) {
		Node<E> newNode = new Node<E>(e);
		
		if(size == 0) {
			head = newNode;
		}
		
		else {
			tail.next = newNode;
		}
		
		tail = newNode;
		size++;
		
		return true;
	}

	@Override
	public E remove() {
		E element = poll();
		
		if( element == null) {
			throw new NoSuchElementException();
		}
		return element;
	}

	@Override
	public E poll() {
		if(size == 0) {
			return null;
		}
		
		E element = head.data;
		
		Node<E> nextNode = head.next;
		
		head.data = null;
		head.next = null;
		
		head = nextNode;
		size--;
		
		return element;
	}

	@Override
	public E element() {
		E element = peek();
		
		if(element == null) {
			throw new NoSuchElementException();
		}
		return element;
	}

	@Override
	public E peek() {
		if(size == 0) {
			return null;
		}
		return head.data;
	}

	

	
}
