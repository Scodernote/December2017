import static java.lang.System.*;
import java.util.Arrays;
import java.util.Random;
class ArrayTest {
	public static void main(String[] args){
		
		int [] a1 = {1,2,3,4,5};
		int a2[];
		a2 = a1;
		for(int  i = 0 ; i < a2.length ;i++){
			a2[i] = a2[i] + 1; 
		}
		for(int x: a1)
			out.print(x + " ");
		out.println();
		
		Random rand = new Random(47);
		int [] b = new int[rand.nextInt(20)];
		out.println("b.length " + b.length);
		for(int  i = 0 ; i < b.length ; i++)
			b[i] = rand.nextInt(500); // Autoboxing
		out.println(Arrays.toString(b));
		// array initialization using curly brace-enclosed list.
		// method 1
		Integer [] d  = { new Integer(1),
						  new Integer(2),
						  3, // autoboxing  // last comma is optional,
						};
		out.println(Arrays.toString(d));
		//method 2
		Integer [] e = new Integer[] { new Integer(1),
									   new Integer(2),
									   3
									 };
		out.println(Arrays.toString(e));
		// You can even create an array at time method call as argument.
		Other.main(new String[] {"Arun" , "Kumar" , "Gupta"});
		printArray(new Integer(1),new Float(1),new Double(1));
		printArray(47, 3.14F, 11.11);
		// Passing reference of object to printArray
		printArray(new A(), new A(), new A());
		// which will print something like A@124342 --> className@garbageNumber
		
		// Casting of Interger array to object array
		printArray((Object[])(new Integer[] {1,2,3,4}));
		
		printArray2(1,"one");
		printArray2(1,"one","two");
		printArray2(0); // zero argument
		
		// getClass method is inherited from Object class to every class.
		// getClass() method use to get the class type of object.
		int [] f = {1,2,3,4,5};
		// class type [ I   (array of integers)
		out.println("class of an interger array : " + f.getClass());
		// class type : java.lang.String
		String ss = new String();
		out.println("class of an interger array : " + ss.getClass());
		
		out.println("class of an interger array : " + new Integer[0].getClass());
		
	}
	// variable number arguments 
	// All classes in java are ultimately inherited from common root class Object.
	// ifunction printArray can accept a list of arguments like 47, 3.14F, 11.11 or array
	// internally basically trailing is an array. And if we don't pass anything to this function , it will have an array of size zero.	.
	static void printArray(Object... args){
		for(Object ob : args){
			out.print(ob + " ");
		}
		out.println();
	}
	
	// varargs , you can also  use variable number of arguments with specified type like String or int other than Object tupe.
	// But the type of arguments whatever we are passing while calling this functions  should be match otherwise compiler will give an error.
	 
	static void printArray2(int required , String... trailing){
		out.print(required + " ");
		for(String ob : trailing){
			out.print(ob + " ");
		}
		out.println();
	}
}

class A {}
class Other {

	public static void main(String [] args){
		for(String s : args)
			out.print(s + " ");
		out.println();
	}
}

// a1 and a2 are reference to an array. sometimes we a1 and a2 are alias .
//  each array in java has a default member called "length" which tell the number of elements in a array.
//  You can step out of array bound. if you are stepping out , java interpreter will give you a run- time error (exception) .
// Array class is define in util library.
// After creating array of reference for "b", we can initialize the reference by creating the object (rand.nextInt(500);)    here autoboxing is used by java interpreter to create an object for b[i]  and initilize with value produce by rand.
// Arrays is class define util library which has static member fucntion toString()  to convert an array in string format;