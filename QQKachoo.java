/******************************************************************
 * Class QQKachoo<T>
 * Implements interface Deque. Uses doubly linked nodes (DLLNodes)
 * to represent data. The data is structured as linear rather than
 * circular to avoid mishaps. 
 * Represents type T where T is a typed-variable
 ****************************************************************/
import java.util.Iterator;
import java.util.NoSuchElementException;
public class QQKachoo<T> implements Deque<T> {
    private DLLNode<T> front;
    private DLLNode<T> end;
    private int size;

    public QQKachoo() {
        //in the beginning, there was nothing...
        front = null; 
        end = null;
        size = 0;
    }
	
    /*******************************************
     * Add given value to the front of the queue.
     * @param val where is the value to be added
     * @see {@code addLast()}
     ******************************************/
    public void addFirst(T val) { //O(1)
        DLLNode<T> tmp = new DLLNode<T>(val, null, null); //a temp storage
        if (front == null || end == null) { //if the queue is empty
            front = tmp;
            end = tmp;
        }else{ //queue has 1 or more elems in it
            front.setPrev(tmp); //set link from current front to tmp
            tmp.setNext(front); //tmp links backwards to current front
            front = front.getPrev(); //front pointer moves to true front
        }
        size++; //increment size
    }
	
    /**************************************
     * Add given value to the end of queue
     * @param val value to be added
     * @see {@code addFirst()}
     **************************************/
    public void addLast(T val) {
        DLLNode<T> tmp = new DLLNode<T>(val, null, null); //temp storage
        if (front == null || end == null) { //queue is empty
            front = tmp;
            end = tmp;
        }else{ //queue has 1 or more elems
            end.setNext(tmp); //set link to tmp
            tmp.setPrev(end); //tmp sets link to current end
            end = end.getNext(); //end pointer is moved down to tmp
        }
        size++; //increment size
    }
    
    /**************************************************************
     * Return the value of the front of the queue without altering
     * it.
     * @return <i>T</i> where <i>T</i> is a typed-variable
     * @throws NoSuchElementException if queue is empty
     * @see {@code getLast()}
     **************************************************************/
    public T getFirst() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        return front.getCargo();
    }
	
    /************************************************************
     * Return the value of the end of the queue without altering
     * it.
     * @return <i>T</i> where <i>T</i> is a typed-variable
     * @throws NoSuchElementException if queue is empty
     * @see {@code getFirst()}
     ***********************************************************/
    public T getLast() {
        if (end == null) {
            throw new NoSuchElementException();
        }
        return end.getCargo();
    }
	
    /********************************************************
     * Return the number of meaningful elements in the queue
     * @return <i>int</i>, number of meaningful elements in queue
     ********************************************************/
    public int size() {
        return size;
    }

    /*******************************************************
     * Remove the first element of the queue and return it.
     * The next element becomes the front.
     * @return <i>T</i>, where <i>T</i> is a typed-variable
     * @throws NoSuchElementException if queue is empty
     * @see {@code removeLast()}
     ******************************************************/
    public T removeFirst() {
        DLLNode<T> tmp; //a temp storage used for the cargo it holds
        if (front == null) { //front doesn't exist, therefore, queue is empty
            throw new NoSuchElementException();
        }else{ //front does exist
            tmp = front; //tmp points to current front
            front = front.getPrev(); //front is changed to the next elem in queue
            front.setNext(null); //from relinquishes link to tmp
            tmp.setPrev(null); //tmp relinquishes link to front
            //tmp now is completely unconnected to rest of queue
        }
        size--; //decrement size
        return tmp.getCargo();
    }
	
    /*****************************************************
     * Remove last element of the queue and return it.
     * The previous element becomes the end.
     * @return <i>T</i>, where <i>T</i> is a typed-variable
     * @throws NoSuchElementException if queue is empty
     * @see {@code removeFirst()}
     ****************************************************/
    public T removeLast() {
        DLLNode<T> tmp; //tmp storage used for the cargo
        if (end == null) { //end doesn't exist because queue is empty
            throw new NoSuchElementException();
        }else{ //queue does exist
            tmp = end; //tmp points to current end
            end = end.getNext(); //end moves up one node
            end.setPrev(null); //end relinquishes link to tmp
            tmp.setNext(null); //tmp removes link to end
            //tmp is now unconnected to queue and will disappear
        }
        size--; //decrement size
        return tmp.getCargo();
    }
	
    /******************************************************************
     * Removes the first occurrence of the value given.
     * This starts from the front and goes to the end.
     * @param val, where val is a typed-variable
     * @return <i>true</i> if value removed, <i>false</i> if doesn't exist 
     * in queue
     * @see {@code removeLastOccurrence()}
     ******************************************************************/
    public boolean removeFirstOccurrence(T val) {
        DLLNode<T> tmp = front; //tmp to iterate through collection
        while (tmp != null) { //tmp checked all through to end
            if (tmp.getCargo().equals(val)) { //the value of tmp is equal to given
                if (tmp.getNext() != null && tmp.getPrev() != null) {
                    tmp.getPrev().setNext(tmp.getNext()); //set the next of the previous node to the next of tmp
                    tmp.getNext().setPrev(tmp.getPrev()); //set the prev of the next node to node before tmp
                }else{
                    if (tmp.getNext() == null) { //tmp is the last elem of list
                        end = end.getPrev(); //move end back one
                        tmp.getPrev().setNext(null); //cut off connection
                    }else{
                        front = front.getNext(); //tmp is the first elem of list
                        tmp.getNext().setPrev(null); //cut off connection
                    }
                }
                tmp.setNext(null); //tmp loses connection to end side of the queue
                tmp.setPrev(null); //tmp loses connection to the front side of the queue
                size--; //decrement size
                return true; //val was in the queue and removed
            }
            tmp = tmp.getNext(); //iterate tmp through collection
        }
        return false; //val does not exist in collection
    }
	
    /******************************************************************
     * Removes the last occurrence of the value given.
     * This starts from the end and goes to the front.
     * @param val, where val is a typed-variable
     * @return <i>true</i> if value removed, <i>false</i>
     *  if doesn't exist in queue
     * @see {@code removeFirstOccurrence()}
     *****************************************************************/
    public boolean removeLastOccurrence(T val) {
        DLLNode<T> tmp = end; //tmp to iterate through collection
        while (tmp != null) { //tmp checked through all through to the front
            if (tmp.getCargo().equals(val)) { //tmp's cargo matches given
                if (tmp.getNext() != null && tmp.getPrev() != null) {
		    tmp.getPrev().setNext(tmp.getNext()); //previous node of tmp sets next as the node ahead of tmp
		    tmp.getNext().setPrev(tmp.getPrev()); //next node of tmp sets prev as the node before tmp
                }else{
                    if (tmp.getNext() == null) { //tmp is last elem of queue
                        end = end.getPrev(); //move end up one
                        tmp.getPrev().setNext(null); //cut connection
                    }else{
                        front = front.getNext(); //move front down one
                        tmp.getNext().setPrev(null); //cut off connection
                    }
                }
                tmp.setNext(null); //tmp loses connection to end side of queue
                tmp.setPrev(null); //tmp loses connection to front side of queue
                size--; //decrement size
                return true; //val was in the queue and was removed
            }
            tmp = tmp.getPrev(); //iterate through collection
        }
        return false; //val was not in queue 
    }
	
    /****************************************************************
     * Returns true if there are no meaningful elements in the queue
     * @return <i>true</i> if queue is empty, <i>false</i> otherwise
     ***************************************************************/
    public boolean isEmpty() {
        return size == 0;
    }
	
    /**********************************************************************
     * Attempts to remove the front of the queue. Returns the value if
     * successful, else returns null.
     * @return <i>T</i>, where <i>T</i> is a typed-variable, or <i>null</i>
     * if queue is empty
     * @see {@code removeFirst()}
     **********************************************************************/
    public T poll() {
        try {
            return removeFirst();
        }catch(Exception e) {
            return null;
        }
    }
	
    /**********************************************************************
     * Attempts to remove the front of the queue. Returns the value if
     * successful, else returns null.
     * @return <i>T</i>, where <i>T</i> is a typed-variable, or <i>null</i>
     * if queue is empty
     * @see {@code poll()} 
     * @see {@code removeFirst()}
     **********************************************************************/
    public T pollFirst() {
        return poll();
    }
	
    /**********************************************************************
     * Attempts to add given value to the front of the queue. Returns true
     * if successful, else returns false
     * @return <i>true</i> if val was added else <i>false</i> otherwise
     * @see {@code addFirst()}
     *********************************************************************/
    public boolean offerFirst(T val) {
        try {
            addFirst(val);
            return true;
        }catch(Exception e) {
            return false;
        }
    }
	
    /***********************************************************************
     * Attempts to look at the front of the queue. Returns the value if 
     * successful, else return null
     * @return <i>T</i>, where <i>T</i> is a typed-variable, or <i>null</i>
     * if queue is empty
     * @see {@code getFirst()}
     ***********************************************************************/
    public T peekFirst() {
        try {
            return getFirst();
        }catch(Exception e) {
            return null;
        }
    }
	
    /***********************************************************************
     * Attempts to look at the end of the queue. Returns the value if 
     * successful, else return null
     * @return <i>T</i>, where <i>T</i> is a typed-variable, or <i>null</i>
     * if queue is empty
     * @see {@code getLast()}
     **********************************************************************/
    public T peekLast() {
        try {
            return getLast();
        }catch(Exception e) {
            return null;
        }
    }
	
    /*********************************************************************
     * Attempts to add given value to the end of the queue. Returns true
     * if successful, else returns false
     * @return <i>true</i> if val was added else <i>false</i> otherwise
     * @see {@code addLast()}
     ********************************************************************/
    public boolean offerLast(T val) {
        try {
            addLast(val);
            return true;
        }catch(Exception e) {
            return false;
        }
    }
	
    /******************************************************************
     * Searches through collection checking if given value is present.
     * Returns true if found, false otherwise
     * @return <i>true</i> if val was found, <i>false</i> otherwise
     *****************************************************************/
    public boolean contains(T val) {
        Iterator<T> itr = this.iterator();
        while (itr.hasNext()) {
            T nodeCargo = itr.next();
            if (nodeCargo.equals(val)) {
                return true;
            }
        }
        return false;
    }

    //String representation of the collection
    public String toString() {
        String ans = "FRONT->";
        DLLNode<T> tmp = front;
        while (tmp != null) {
            ans += tmp.getCargo() + "-->";
            tmp = tmp.getNext();
        }
        return ans + "END";
    }

    public Iterator<T> iterator()
    {
	return new MyIterator();
    }
    
    //Nested class Iterator
    private class MyIterator implements Iterator<T> 
    {
	private DLLNode<T> _dummy;   // dummy node to tracking pos
	private boolean _okToRemove; // flag indicates next() was called
    
	//constructor 
	public MyIterator() 
	{
	    //place dummy node in front of head
	    _dummy = new DLLNode<T>( null, null, front );
	    _okToRemove = false;
	}
	
	//-----------------------------------------------------------
	//--------------v  Iterator interface methods  v-------------
	//return true if iteration has more elements.
	public boolean hasNext() 
	{
	    return _dummy.getNext() != null;
	}


	//return next element in this iteration
	public T next() 
	{
	    _dummy = _dummy.getNext();
	    if ( _dummy == null )
		throw new NoSuchElementException();
	    _okToRemove = true;
	    return _dummy.getCargo();
	}


	//return last element returned by this iterator (from last next() call)
	//postcondition: maintains invariant that _dummy always points to a node
	//               (...so that hasNext() will not crash)
	public void remove() 
	{
	    if ( ! _okToRemove )
		throw new IllegalStateException("must call next() beforehand");
	    _okToRemove = false;

	    //If removing only remaining node...
	    //maintain invariant that _dummy always points to a node
	    //   (...so that hasNext() will not crash)
	    if ( front == end ) {
		front = end = null;
	    }
	    //if removing first node...
	    else if ( front == _dummy ) {
		front = front.getNext();
		front.setPrev( null ); //just to save mem
	    }
	    //if removing last node...
	    else if ( end == _dummy ) {
		end = end.getPrev();
		end.setNext( null );
	    }
	    //if removing an interior node...
	    else {
		_dummy.getNext().setPrev( _dummy.getPrev() );
		_dummy.getPrev().setNext( _dummy.getNext() );
		//Q: How could the line below cause trouble?
		//_dummy = _dummy.getPrev();
	    }

	    size--; //decrement size attribute of outer class LList      
	}//end remove()
	//--------------^  Iterator interface methods  ^-------------
	//-----------------------------------------------------------
    }//*************** end inner class MyIterator ***************

    public static void main(String[] args) {
        QQKachoo<String> test = new QQKachoo<String>();
        test.addFirst("val");
        System.out.println(test);
        test.addFirst("x");
        System.out.println(test);
        test.addFirst("qwerty");
        System.out.println(test);
        test.addLast("qwerty");
        test.addLast("x");
	System.out.println("Now testing iterability.....");
	System.out.println(test);
	for (String x:test){
	    System.out.println(x);

	}
	    System.out.println("iterability successful");
        System.out.println(test.front.getCargo());
        System.out.println(test.removeFirstOccurrence("qwerty"));
        System.out.println(test.front.getCargo());        
        System.out.println(test);
        test.removeLastOccurrence("x");
        System.out.println(test);
    }
}
