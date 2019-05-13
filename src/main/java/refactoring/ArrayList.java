package refactoring;

public class ArrayList<T> implements Stack<T> {

	// Constant
	private static final int DEFAULT_CAPACITY = 20;

	// Instance Variables
	private T[] _elements;
	private int _capacity;
	private int _top;

	// Constructor
	@SuppressWarnings("unchecked")
	public ArrayList() {
		this._elements = (T[]) new Object[ArrayList.DEFAULT_CAPACITY];
		this._capacity = ArrayList.DEFAULT_CAPACITY;
		this._top = -1;
	}
	@SuppressWarnings("unchecked")
	public ArrayList(int givenCapacity) {
		this._elements = (T[]) new Object[givenCapacity];
		this._capacity = givenCapacity;
		this._top = -1;
	}

	// Public Methods
	public boolean isEmpty() {
		if(this._top == -1) {
			return true;
		}
		else {			
			return false;
		}
	}
	public boolean isFull() {
		if(this._top + 1 == this._capacity) {
			return true;
		}
		else {			
			return false;
		}
	}
	public int size() {
		return this._top + 1;
	}
	public boolean push(T anElement) {
		if(this.isFull()) {
			return false;
		}
		this._elements[++this._top] = anElement;
		return true;
	}
	public T pop() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			T popElement = this._elements[this._top];
			this._elements[this._top--] = null;
			return popElement;
		}
	}
	public T peek() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this._elements[this._top];
		}
	}
	public void clear() {
		while (!this.isEmpty()) {
			this._elements[this._top--] = null;
		}
	}
	public T elementAt(int aPostion) {
		return this._elements[aPostion];
	}

}