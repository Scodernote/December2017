import static java.lang.System.*;
import java.util.Random;

class Value {
	int i;
	public Value(int i){
		this.i = i;
	}
}

public class FinalTest{
	// priavte and static following statement , making rand reference  is not accessible from the outside word and FinalTest class has only one storage for rand variable.
	private static Random rand = new Random(47);
	private String id;
	public FinalTest(String id){
		this.id = id;
		xx =18;
		//out.println(xx);
	}
	// final is used to make varibale constant. it means , it can not be changed through out the life of an object of this class.
	private final int valueOne = 9;
	// final keyword must be initailize at the time definition.  and adding static with final makes varibale is class variable that can not be changed through out life time of program.  
	private final static int VALUE_TWO=99;
	// These are compile time constants. means they will  have storage at stack.
	public static final int VALUE_THREE=39;
	// These are run-time constants means after assigning the reference of an object to these variable ..  Reference will become constant but object data can be changed. 
	private final int i4 = rand.nextInt(20);
	static final int INT_5= rand.nextInt(20);
	// By convention , static final variable should be capital letter.  one copy which will not change through out life of program. 
	private Value v1=new Value(11);
	private final Value v2 = new Value(22);
	private static final Value VAL_3= new Value(33);
	// Here array reference is constants ... but elements in array can be changed.
	private final int[] a= {1,2,3,4,5,6};
	// blank final .. means without initalization. And it  should be initialize before getting use. That you have to do inside the constructor only otherwise it will give compiler error;
	// compiler will not automatically initialize a final varibale;  
	private final int xx; // compiler will through an error : varibale might not be initialize;
	private int yy;
	void testMd(){
		//xx = 13; // compiler error: you can change the value of xx because it is final;
	}
	public String toString(){
		return id + " : " + " i4 = " + i4 + " , INT_5 = " + INT_5;
	}
	
	public static void main(String [] args){
		FinalTest fd = new FinalTest("FD1");
		//!fd.valueOne++;
		fd.v2.i++; //! fd.v2= new Value(134) ; same for VAL_3 also;
		fd.v1 = new Value(345);
		for(int  i = 0 ; i < fd.a.length;i++){
			fd.a[i]++;
		}
		out.println(fd);
		out.println("Creating new Final Data");
		FinalTest fd2 = new FinalTest("fd2");
		out.println(fd);
		out.println(fd2);
	}
}


class Gizmo {
	public void spin(){
		out.println("spin()");
	}
}


class FinalArguments {
		void with(final Gizmo g){
			//!g = new Gizmo();  final argument you can change inside the method body.  
		}
		void withOut(Gizmo g){
			g = new Gizmo();
			g.spin();
		}
		
		void f(final int i ){
			//! i++; final argument you can change inside the method body.   
		}
		
		void g(int i){
			i+=2;
		}
	public static void main(String [] args){
		FinalArguments fg = new FinalArguments();
		fg.with(null);
		fg.withOut(null);		
	}
}

//  main reason to make method final is to put a "lock"  on it to prevent any inheritance class from changing its meaning. means cannot be overridden.


class WithFinals {
	private final void f() {
		out.println("WithFinals f()");
	}
	private void g(){
		out.println("WithFinals g()");
	}
}

class OverridingPrivate extends WithFinals {
	private final void f() {
		out.println("OverridingPrivate f()");
	}
	private void g(){
		out.println("OverridingPrivate g()");
	}
}

class OverridingPrivate2 extends OverridingPrivate {
	public final void f() {
		out.println("OverridingPrivate2 f()");
	}
	public void g(){
		out.println("OverridingPrivate2 g()");
	}	
	
	public static void main(String [] args){
		OverridingPrivate2 ob = new OverridingPrivate2();
		ob.f();
		ob.g();
		OverridingPrivate ob2 = ob; // upcasting
		//!ob2.f(); you can not call it because it is private in base class. 
		//!ob2.g();
		
	}
}

class SmallBrain{}

final class Dinosaur {
	int  i = 7;
	int  j = 1;
	SmallBrain x = new SmallBrain();
	void f(){}
	
}

// Cann't be inherit from final class.
//!class Further extends Dinosaur {
//! }

class Jurassic {
	public static void main(String [] args){
		Dinosaur d = new Dinosaur();
		d.f();
		d.i=40;
		d.j=10090;
		d.x = new SmallBrain();
	}
}