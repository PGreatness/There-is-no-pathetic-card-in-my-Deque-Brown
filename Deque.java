/******************************************************************
 * Interface Deque<T>
 * A double-ended queue where elems can enter or exit from either
 * side. Queue has infinite capacity and is represented via doubly
 * linked nodes. 
 * Stores type T where T is a typed-variable
 *****************************************************************/

public interface Deque<T> extends Iterable<T> {
    //# of meaningful items in queue
    public int size();
    
    //add to the beginning of the queue
    public void addFirst(T x);
    //add to the end of queue
    public void addLast(T x);
    
    //return the first elem and remove it
    public T removeFirst();
    //return the last elem and remove it
    public T removeLast();
    
    //attempt to return the first elem w/o altering the queue
    //return null if queue is empty
    public T peekFirst();
    //attempt to return the end elem w/o altering the queue
    //return null if queue is empty
    public T peekLast();
    
    //return the first elem w/o altering queue
    public T getFirst();
    //return last elem w/o altering queue
    public T getLast();

    //true if the first occurrence of the val is removed, false else
    public boolean removeFirstOccurrence(T x);
    //true if the last occurrence of the val is removed, false else
    public boolean removeLastOccurrence(T x);
    
    //remove the front elem in the queue or return null
    public T poll();
    //remove the front elem in the queue or return null
    public T pollFirst();
    
    //attempt to insert elem at the front. return false if not possible
    public boolean offerFirst(T x);
    //attempt to insert elem at the end. return false if not possible
    public boolean offerLast(T x);
    
    //puruses through collection searching for val, returns true if found. 
    //collection is unaltered
    public boolean contains(T x);
}
