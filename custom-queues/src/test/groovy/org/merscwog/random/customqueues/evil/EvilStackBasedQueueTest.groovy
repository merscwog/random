package org.merscwog.random.customqueues.evil

import org.merscwog.random.customqueues.CustomQueue

/**
 * Created by spencer on 6/26/2014.
 */
class EvilStackBasedQueueTest extends spock.lang.Specification {
    def 'Retrieve from empty queue'() {
        given:
            CustomQueue<Integer> queue = new EvilStackBasedQueue<>()

        when:
            queue.retrieve()

        then:
            thrown NoSuchElementException
    }

    def 'Insert and retrive same element'() {
        given:
            CustomQueue<Integer> queue = new EvilStackBasedQueue<>()

        when:
            queue.insert(7)

        then:
            queue.retrieve() == 7
    }

    def 'Simple insert and retrieve of multiple elements'() {
        given:
            CustomQueue<Integer> queue = new EvilStackBasedQueue<>()

        when:
            queue.insert(3)
            queue.insert(2)
            queue.insert(1)

        then:
            queue.retrieve() == 3
            queue.retrieve() == 2
            queue.retrieve() == 1
    }
}
