package implementations;

public class TestDriver {

	public static void main(String[] args) {
		MyArrayList<Integer> myList = new MyArrayList<Integer>();

		int one = 1;
		int two = 2;
		int three = 3;
		int four = 4;
		int five = 5;

		System.out.println(myList.toString());

		System.out.println(myList.size() + "\n");

		myList.add(one);

		myList.add(two);
		myList.add(three);
		myList.add(four);
		myList.add(five);

		myList.print();
		System.out.println("\n");
		myList.set(1, four);
		System.out.println("\n");
		myList.print();

		System.out.println(myList.add(2, two));
		System.out.println(myList.get(2) + "\n");

		myList.print();

		System.out.println(myList.remove(1));
		myList.print();

		myList.add(0, three);
		// myList.add( 0, two );
		// myList.add( 0, one );

		myList.print();
	}

}
