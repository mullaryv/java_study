public class Tester {

	public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        StackWithMin2 stack2 = new StackWithMin2();

        int[] array = {6, 7, 3, 2, 5, 1, 4};
        for (int value : array) {
            stack.push(value);
            stack2.push(value);
            System.out.print(value + ", ");
        }
        System.out.println('\n');
//        for (int i = 0; i < array.length; i++) {
//            System.out.println("S1: popped " + stack.pop().value);
//        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("S1: popped " + stack.pop().value + ",  new min is " + stack.min());
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("S2: popped " + stack2.pop() + ",  new min is " + stack2.min());
        }
    }

}
