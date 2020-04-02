/**
 * <h1>PriorityQueue</h1>
 * Interface of PriorityQueue used in VectorHeap
 *
 * References:
 * Bailey, D. A. (2007). Java Structures. Massachusetts: Williams College
 * <p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-01
 **/
public interface PriorityQueue<E extends Comparable<E>> {
    E getFirst();
    // pre: !isEmpty()
    // post: returns the minimum value in priority queue

    public E remove();
    // pre: !isEmpty()
    // post: returns and removes minimum value from queue

    public void add(E value);
    // pre: value is non-null comparable
    // post: value is added to priority queue

    public boolean isEmpty();
    // post: returns true iff no elements are in queue

    public int size();
    // post: returns number of elements within queue

    public void clear();
    // post: removes all elements from queue

}