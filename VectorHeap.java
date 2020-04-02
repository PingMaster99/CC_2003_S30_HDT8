import java.util.Vector;
/**
 * <h1>VectorHeap</h1>
 * Heap used to implement a priority queue
 *
 * References:
 * Bailey, D. A. (2007). Java Structures. Massachusetts: Williams College
 * <p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-01
 **/
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    protected Vector<E> data; // the data, kept in heap order
    /**
     * Constructor for the VectorHeap
     */
    public VectorHeap()
    // post: constructs a new priority queue
    {
        data = new Vector<E>();
    }

    /**
     * Builds a VectorHeap from a vector
     * @param v the original vector
     */
    public VectorHeap(Vector<E> v)
    // post: constructs a new priority queue from an unordered vector
    {
        int i;
        data = new Vector<E>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++)
        { // add elements to heap
            add(v.get(i));
        }
    }

    /**
     * Checks if the heap is empty or not
     * @return boolean if its empty or not
     */
    public boolean isEmpty() {
        if(data.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Gets the size of the heap
     * @return its size
     */
    public int size() {
        return data.size();
    }

    /**
     * Clears the heap
     */
    public void clear() {
        data.clear();
    }
    /**
     * Gets the first element in the heap
     * @return the first element
     */
    public E getFirst()
    // pre: !isEmpry()
    // post: returns the minimum value of the priority queue
    {
        return data.get(0);
    }

    /**
     * Returns the parent of a particular element
     * @return parent node
     */
    protected static int parent(int i)
    // pre: 0 <= i < size
    // post: returns parent of node at location i
    {
        return (i-1)/2;
    }

    /**
     * Returns the left child of a particular element
     * @return locarion of left child
     */
    protected static int left(int i)
    // pre: 0 <= i < size
    // post: returns index of left child of node at location i
    {
        return 2*i+1;
    }

    /**
     * Returns the right child of a particular element
     * @return locarion of right child
     */
    protected static int right(int i)
    // pre: 0 <= i < size
    // post: returns index of right child of node at location i
    {
        return (2*i+1) + 1;
    }

    /**
     * Moves the current element to its appropiate position
     * @param leaf the element to percolate
     */
    protected void percolateUp(int leaf)
    // pre: 0 <= leaf < size
    // post: moves node at index leaf up to appropriate position
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(data.get(parent)) < 0))
        {
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }

    /**
     * Adds a new element to the heap
     * @param value to be added
     */
    public void add(E value)
    // pre: value is non-null comparable
    // post: value is added to priority queue
    {
        data.add(value);
        percolateUp(data.size()-1);
    }

    /**
     * Moves the element at the root to its appropiate location
     * @param root of the heap
     */
    protected void pushDownRoot(int root)
    // pre: 0 <= root < size
    // post: moves node at index root down
    // to appropriate position in subtree
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos+1)).compareTo
                                (data.get(childpos)) < 0))
                {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo
                        (value) < 0)
                {
                    data.set(root,data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root,value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root,value);
                return;
            }
        }
    }

    /**
     * Removes an element of the heap (highest priority)
     * @return the element that was removed
     */
    public E remove()
    // pre: !isEmpty()
    // post: returns and removes minimum value from queue
    {
        E minVal = getFirst();
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }


}