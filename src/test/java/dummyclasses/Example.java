package dummyclasses;

public class Example {

	private int entero1 = 0;
	private Integer entero2 = new Integer(0);
	
	public static void test1(int a, int b, String c) {	
	}
	
	public int test2() {
		return entero1 + entero2;
	}

	public int longMethod() {
		int a = 1;
		int b = 4;

		int j = a >> b;

		return j;
	}
}
