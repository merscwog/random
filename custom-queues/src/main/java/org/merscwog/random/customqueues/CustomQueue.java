package org.merscwog.random.customqueues;

/**
 * Created by merscwog on 6/26/2014.
 *
 * Interface to represent a special CustomQueue that only implements two methods.
 */
public interface CustomQueue<T> {
    /**
     * Adds an element to the end of the queue.
     *
     * @param element the object to added.
     * @throws NullPointerException if null attempted to be inserted.
     */
    void insert(T element) throws NullPointerException;

    /**
     * Returns the oldest element added to the queue or null if there are no elements in the queue.
     *
     * @return the oldest element added to the queue or null if there are no elements in the queue.
     */
    T retrieve();
}
