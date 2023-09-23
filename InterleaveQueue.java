/*
    Time complexity: O(N)
    Space complexity: O(N)

    where N is the size of the queue
*/

import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void interLeaveQueue(Queue < Integer > q) {

        // Initialize an empty stack of int type.
        Stack < Integer > s = new Stack < Integer > ();
        int halfSize = q.size() / 2;

        // Push first half elements into the stack.
        for (int i = 0; i < halfSize; i++) {
            s.push(q.peek());
            q.remove();
        }

        // Enqueue back the stack elements.
        while (!s.isEmpty()) {
            q.add(s.peek());
            s.pop();
        }

        // Dequeue the first half elements of queue and enqueue them back.
        for (int i = 0; i < halfSize; i++) {
            q.add(q.peek());
            q.remove();
        }

        // Again push the first half elements into the stack.
        for (int i = 0; i < halfSize; i++) {
            s.push(q.peek());
            q.remove();
        }

        // Interleave the elements of queue and stack.
        while (!s.isEmpty()) {
            q.add(s.peek());
            s.pop();
            q.add(q.peek());
            q.remove();
        }
    }

}
