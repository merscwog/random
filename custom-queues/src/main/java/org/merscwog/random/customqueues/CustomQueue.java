package org.merscwog.random.customqueues;

import java.util.NoSuchElementException;

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
     */
    void insert(T element);

    /**
     * Returns the oldest element added to the queue or null if there are no elements in the queue.
     *
     * @return the oldest element added to the queue or null if there are no elements in the queue.
     * @throws NoSuchElementException thrown if the queue is empty.
     */
    T retrieve() throws NoSuchElementException;
}
