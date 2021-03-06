package org.merscwog.random.customqueues.evil;

import org.merscwog.random.customqueues.CustomQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * Created by spencer on 6/26/2014.
 *
 * Uses "internal" stacks to implement a simple queue.  Two stacks are "used", and both implement the push() and
 * pop() methods, but not in a very expected way, as technically the real second stack is the method frame stack
 * which is used implicitly, so one could argue that only one stack class is necessary.  The second stack class
 * is really only instantiated in order to satisfy the requirements.
 *
 * Odds are very high that the recursion will cause things to blow up if the queue length is extremely long.
 * It is also very inefficient at retrieving.  It could be made to be fast for insert or retrieve, but not
 * both.
 *
 * This differs from the likely implementation that pushes elements onto an insertion stack and when a retrieve is
 * called and the retrieval stack is empty, all elements are popped off the insertion stack and pushed onto the other
 * stack for retrieval until the retrieval stack is empty again.  Could even optimize for the 1-element on insertion
 * stack case, but probably not worth it.  This would give fast insert and relatively fast retrieve with best
 * performance if retrieves only take place after multiple inserts beforehand.
 *
 * This implementation takes the penalty of always popping everything off the stack to get the earliest element
 * and then pushing all others back on, but it is doing it in an "evil" recursive way, so it must be "cooler" :-)
 */
public class EvilStackBasedQueue<T> implements CustomQueue<T> {
    /**
     * This is the stack that will actually interact with elements.
     */
    private Deque<T> realStack = new ArrayDeque<T>();

    /**
     * This poor stack only gets instantiated to satisfy the requirements to use two stacks.
     */
    private Deque<T> unused = new ArrayDeque<T>(0);

    @Override
    public void insert(T element) {
        realStack.push(element);
    }

    @Override
    public T retrieve() {
        if (realStack.isEmpty()) {
            throw new NoSuchElementException("No element to retrieve");
        }

        return internalEvilRecursiveRetrieve(realStack);
    }

    /**
     * Returns the bottom-most element from the stack.
     *
     * @param stack the stack to utilize.
     * @return the bottom-most element from the stack.
     */
    private T internalEvilRecursiveRetrieve(Deque<T> stack) {
        T result;

        if (stack.size() == 1) {
            result = stack.pop();
        }
        else {
            T methodSavedStackVar = stack.pop();
            result = internalEvilRecursiveRetrieve(stack);
            stack.push(methodSavedStackVar);
        }

        System.out.println("bob");

        return result;
    }
}
