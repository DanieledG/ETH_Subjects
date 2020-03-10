package graphs;

import java.io.*;
import java.util.*;
public class Tester {
	public static void main(String[] args) throws FileNotFoundException {
//		File file = new File("test.txt");
//		PrintStream out = new PrintStream(new File("out.txt"));
//		Scanner fileScan = new Scanner(file);
//		while (fileScan.hasNextLine()) {
//			String line = fileScan.nextLine();
//			char[] temp = line.toCharArray();
//			for (int i = temp.length - 1; i >= 0; i--) {
//				out.print(temp[i]);
//			}
//			out.println();
//		}
//		fileScan.close();
		Car car = new Audi();
		Audi audi = new Audi();
		Car BMW = new BMW();
		audi.start_stop();
		car.shift();
		BMW.shift();
		fly(BMW);
		fly(audi);
		Map<String,Integer> salaries = new TreeMap<String, Integer>();
		salaries.put("Peter", 40000);
		salaries.put("Clara", 90000);
		salaries.put("Jane", 56000);
		salaries.put("Robert", 80000);
		salaries.put("Clara", 50000);
		salaries.put("Dada", 10);
	}
	
	public static void fly(Car car) {
		if (car.getClass().isInstance(new BMW())) {
			((BMW) car).drive();
			int x = 20;}
		else {
			int x;
			((Audi) car).start_stop();
		}
	}
}

class Car{
	int wheels;
	double capacity;
	String brand;
	public Car() {
		System.out.println("super constructor");
	}
	static void test(double i) {
		System.out.println("static method");
	}
	
	void test() {
		System.out.println("non-static method");
	}
	void shift() {
		System.out.println("all cars can do this");

	}
}

class Audi extends Car{
	public Audi() {
		System.out.println("Audi constructor");
	}
	public void start_stop(){
		System.out.println("only Audis can do this");
		super.shift();
		shift();
	}
	void shift() {
		System.out.println("but Audis do it better");
	}
}

class BMW extends Car{
	public void drive() {
		System.out.println("BMW driving");
	}
	
	@Override
	public void shift() {
		System.out.println("Shiftami Michele");
		
	}
}
class Problem13{
	public static void main(String[] args) {
		
	}
}
