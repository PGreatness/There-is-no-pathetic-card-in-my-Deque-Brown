/******************************************************************
 * Interface Deque<T>
 * A double-ended queue where elems can enter or exit from either
 * side. Queue has infinite capacity and is represented via doubly
 * linked nodes. 
 * Stores type T where T is a typed-variable
 *****************************************************************/

public interface Deque<T> extends Iterable<T> {
    //add to the beginning of the queue
    public void addFirst(T x);
    //add to the end of queue
    public void addLast(T x);
    //return the first elem w/o altering queue
    public T peekFirst();
    //return last elem w/o altering queue
    public T peekLast();
    //# of meaningful items in queue
    public int size();
    //return the first elem and remove it
    public T removeFirst();
    //return the last elem and remove it
    public T removeLast();
    //true if the first occurrence of the val is removed, false else
    public boolean removeFirstOccurrence(T x);
    //true if the last occurrence of the val is removed, false else
    public boolean removeLastOccurrence(T x);
}
