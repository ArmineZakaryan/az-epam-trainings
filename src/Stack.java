import com.sun.source.tree.EmptyStatementTree;

import java.util.EmptyStackException;

public class Stack {

    private Object[] data;
    private int tos; // top-of-stack: points to the next free slot (also equals current size)

    /**
     * Creates a Stack with the given capacity.
     * The stack starts empty (tos = 0).
     */
    public Stack(int capacity) {
       if(capacity < 0){
           throw new IllegalArgumentException(
                   "Capacity must be non-negative, got: " + capacity);
       }
        data = new Object[capacity];
        tos = 0;
    }

    /**
     * Creates a Stack with a default capacity of 10.
     */
    public Stack() {
        this(10);
    }

    /**
     * Pushes (adds) an element onto the top of the stack.
     * If the stack is full, throw a RuntimeException with message "Stack is full".
     */
    public void push(Object value) {
        if (tos == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[tos] = value;
        tos++;
    }

    /**
     * Removes and returns the element at the top of the stack.
     * If the stack is empty, throw a RuntimeException with message "Stack is empty".
     */
    public Object pop() {
        if (tos == 0) {
            throw new EmptyStackException();
        }
        tos--;

        Object value = data[tos];
        data[tos] = null;

        return value;
    }

    /**
     * Returns the element at the top of the stack WITHOUT removing it.
     * If the stack is empty, throw a RuntimeException with message "Stack is empty".
     */
    public Object peek() {
        if (tos == 0) {
            throw new EmptyStackException();
        }

        return data[tos - 1];
    }

    /**
     * Returns true if the stack has no elements.
     */
    public boolean isEmpty() {
        return tos == 0;
    }
}