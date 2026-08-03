public class DynamicArray {
    private Object[] data;
    private int size;

    /**
     * Creates a DynamicArray with the given initial capacity.
     * The size should start at 0.
     */
    public DynamicArray(int initialCapacity) {
        this.data = new Object[initialCapacity];
        this.size = 0;
    }

    /**
     * Creates a DynamicArray with a default initial capacity of 10.
     */
    public DynamicArray() {
        this(10);
    }

    /**
     * Returns the number of elements currently stored in the array.
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if the array contains no elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the element at the given index.
     * Should throw IndexOutOfBoundsException if index < 0 or index >= size.
     */
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    /**
     * Replaces the element at the given index with the new value.
     * Should throw IndexOutOfBoundsException if index < 0 or index >= size.
     */
    public void set(int index, Object value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = value;
    }

    /**
     * Adds a new element to the end of the array.
     * If the internal array is full, it should grow (double its capacity)
     * before adding the element.
     */
    public void add(Object value) {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[size] = value;
        size++;
    }

    /**
     * Inserts a new element at the given index, shifting all elements
     * after that index one position to the right.
     * If the internal array is full, it should grow before inserting.
     * Should throw IndexOutOfBoundsException if index < 0 or index > size.
     */
    public void add(int index, Object value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    /**
     * Removes the element at the given index and returns it.
     * All elements after the removed one should shift one position to the left.
     * Should throw IndexOutOfBoundsException if index < 0 or index >= size.
     */
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object removedValue = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return removedValue;
    }

    /**
     * Returns true if the array contains the given value.
     * Use .equals() for comparison (handle null safely).
     */
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (value == null) {
                if (data[i] == null) {
                    return true;
                }
            } else if (value.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the given value,
     * or -1 if the value is not found.
     */
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (value == null) {
                if (data[i] == null) {
                    return i;
                }
            } else if (value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes all elements from the array. Size becomes 0.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * Returns a string representation of the array.
     * Example format: [1, 2, 3]
     * Empty array: []
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(data[i]);

            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append("]");

        return result.toString();
    }

    // ---- Private helper methods ----

    /**
     * Doubles the capacity of the internal array and copies all
     * existing elements into the new array.
     * (Hint: create a new Object[] with double length, copy elements, reassign)
     */
    private void grow() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * Checks whether the given index is valid (0 <= index < size).
     * If not, throws IndexOutOfBoundsException.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
