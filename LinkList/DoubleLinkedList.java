public class DoubleLinkedList<E> {
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    public DoubleLinkedList() {
        size = 0;
        head = new ListNode<E>(null);
        tail = new ListNode<E>(null);
        head.next = tail;
        tail.prev = head;
    }

    public boolean add(E element )
	{
		LLNode<E> newNode = new LLNode<E>(element);
		tail.prev.next = newNode;
		newNode.prev = tail.prev;
		newNode.next = tail;
		tail.prev = newNode;
		this.size++;
		return true;
    }
    
    public E get(int index) 
	{
		if (index > this.size - 1 || index < 0) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}

		int i = 0;
		LLNode<E> p = head;
		while( (p = p.next) != tail) {
			if (i == index) {
				break;
			}
			i += 1;
		}

		return p.data;
	}

    public void add(int index, E element ) 
	{
		if (index < 0 || index > this.size ) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}

		if (index == this.size) {
			this.add(element);
			return;
		}

		LLNode p = head;

		LLNode<E> newNode = new LLNode<E>(element);
		int count = 0;
		while((p = p.next) != tail) {
			if (count == index) {
				break;
			}
			count++;
		}
		p.next.prev = newNode;
		newNode.prev = p;
		newNode.next = p.next;
		p.next = newNode;
		this.size++;
	}

    public int size() 
	{
		return this.size;
    }
    
    public E remove(int index) 
	{
		if (index <= -1 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index out of bound");
		} else {
			LLNode<E> removeNode = head;
			int i  = 0;
			while ((removeNode = removeNode.next) != tail) {
				if (i == index) {
					removeNode.prev.next = removeNode.next;
					removeNode.next.prev = removeNode.prev;
					removeNode.next = null;
					removeNode.prev = null;
					this.size--;
					break;
				}
				i++;
			}
			return removeNode.data;
		}
    }
    
    public E set(int index, E element) 
	{
	   	LLNode<E> p = head;
	   	if (index >= this.size || index <= -1) {
	   		throw new IndexOutOfBoundsException("Index out of bound");
		}
		int i = 0;
	   	while((p = p.next) != tail) {
	   		if (index == i) {
	   			p.data = element;
	   			break;
			}
			i++;
		}
		return p.data;
	}   
}