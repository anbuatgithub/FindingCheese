package anbu.algo;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 4;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        //System.out.println(size + " " + elements.length);
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public int size() {
        return size;
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        Object Newelements[] = new Object[newSize];
        // elements=Arrays.copyOf(elements, newSize);
        elements = copyOf(elements, Newelements);
        //System.out.println(elements.length);
    }

    private  Object[] copyOf(Object[] oldArray, Object[] newArray) {
        for (int i = 0; i < size; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= size || index < 0) {
			/*throw new ArrayIndexOutOfBoundsException("Index: " + index
					+ ", Size " + size);*/
        }
        return (E) elements[index];
    }

    public Object remove(int index) {              // 6 7 8  9
        if (index < size) {
            Object obj = elements[index];
            elements[index] = null;
            int tmp = index;
            size--;
            while (tmp < size) {
                elements[tmp] = elements[tmp + 1];
                elements[tmp + 1] = null;
                tmp++;
            }

            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

}
