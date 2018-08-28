import MyLibrary.AssortedMethods;

public class FixedMultiStack {
    private int NUMBER_OF_STACK = 3; 

    private int capacity;
    private int [] storage;
    private int [] sizes;

    public FixedMultiStack (int size) {
        storage = new int[NUMBER_OF_STACK * size];
        sizes = new int[NUMBER_OF_STACK];
        capacity = size;
    }

    public void push (int num, int data) throws FullStackException {
        if (sizes[num] < capacity) {
            storage[num*capacity + sizes[num]] = data;
            sizes[num] += 1;
        }
        else {
            throw new FullStackException ("stack capacity overflow: " + capacity); 
        }
    }

    public int pop (int num) throws EmptyStackException {
        if (sizes[num] == 0) {
            throw new EmptyStackException ("Stack [" + num + "] is empty"); 
        }

        int data = storage[num*capacity + sizes[num]];
        storage[num*capacity + sizes[num]] = 0; //strictly speaking, not required
        sizes[num] -= 1;
        return data;
    }

    public String toString() {
//System.out.println (storage.length);
        return AssortedMethods.arrayToString(storage);
    }	

//    public String stackToString(int stackNum) {
//        int[] items = getStackValues(stackNum);
//        return stackNum + ": " + AssortedMethods.arrayToString(items);
//    }	

}