import static java.lang.System.*;
import java.util.Random;
// Interface and abstract class provide a more structure way to seperate interface from Implementation.
enum Notes {
	MIDDLE_C,
	C_SHARP,
	B_FLAT
}

// only public and package access modifier can be used as qualifier of a class. not private or protected
public class AbstractInterface {
	public static void main(String [] args){
		Dexercise3 d = new Dexercise3();
		d.print();
	}
}

abstract class Exercise3 {
	public Exercise3(){
		print();
	}
	abstract public void print();
}

class Dexercise3 extends Exercise3{
	private int i =7;
	public void print(){
		out.println("i = " + i);
	}
}


// If there is abstract method  inside a class , compiler will force you to qualify the class with abstract keywork. This class known as abstract class.
// it is possible to make a class abstract without having an abstract method in it.  Sole purpose of doing  this is, you don't want to create an object of this class.
// Compiler doesn't force you make all methods as abstract method if class is abstract class.
abstract class Instrument {
	private int i;
	// To make a method an abstract method, you need to qaulify method with abstract method.
	// abstract method doesn't have method body .(it only a declaration .)
	abstract public void play(Notes n);
	public String what(){return "Instrument";}
	public abstract void adjust();
}

// a new class Wind is inherited from abstract class Instrument.
// if obeject of wind class will be create , you should define all abstract methods of base class in it. Otherwise compiler will force to do that.
// if you don't define the abstract methods in Wind class, it will also a abstract class and compiler will force to qaulify Wind class with abstract keyword.
class Wind extends Instrument {
	public void play(Notes n){
		out.println("Wind().play   = " + n);
	}	
	
	public String what() {
		return "Wind";
	}
	
	public void adjust(){
		out.println("Wind().adjust");
	}
}

class Percussion extends Instrument {
	public void play(Notes n){
		out.println("Percussion().play   = " + n);
	}
	
	public String what(){
		return "Percussion";
	}
	
	public void adjust(){
		out.println("Percussion().adjust");
	}
}


class Stringed extends Instrument {
	public void play(Notes n){
		out.println("Stringed().play   = " + n);
	}
	
	public String what(){
		return "Stringed";
	}
	
	public void adjust(){
		out.println("Stringed().adjust   = ");
	}
}


class Woodwind extends Wind {
	public void play(Notes n){
		out.println("Woodwind().play   = " + n);
	}
	
	public String what(){
		return "Woodwind";
	}
} 


class Brass extends Wind {
	public void play(Notes n){
		out.println("Brass().play   = " + n);
	}
	
	public void adjust(){
		out.println("Woodwind().adjust()   = ");
	}
}


class Music {
	 static void tune(Instrument i){
		i.play(Notes.MIDDLE_C);
	 }
	 
	 static void tuneAll(Instrument [] e){
		for(Instrument x : e){
			tune(x);
		}
	 }
	
	public static void main(String [] args){
		Instrument [] orchestra = {new Wind(),
								   new Percussion(),
								   new Stringed(),
								   new Woodwind(),
								   new Brass()};
		tuneAll(orchestra);
	}
}

/////////////////////////////////////////////////////////////////////////////////////////////////////


// interface keyword produces a complete abstract class , one that provides no implementation at all.
// By default interface access is package access or you can add public qualifier  sothat it can be implemented any where.
// you can leave a field inside an interface definition blank; means int VALUE ; compiler give an error;
//4. But field can be initailize with non-constants expression.
 interface IInstrument {
	//4.
	Random RAND = new Random(47);
	int VALUE1 = RAND.nextInt(10);
	// Cann't be applied to float  and char premitivies random .
	double VALUE2 = RAND.nextDouble();
	char VALUE3 = 'A';
	int VALUE4 = RAND.nextInt(10);
	// By defalut field members inside a interface are static and final;
	int VALUE = 5; // static final int VALUE=5;
	// a interface contains only methods declaration not implementation.
	//  by default all methods access qualifier in an interface are public .
	// in ther derive the class , you must specify public keyword as qualifier in method header. Otherwise compiler give an error.
	void play(Notes n);
	public String what();
	void adjust();
}

// IWind class implementing the IInstrument interface.  it means you have to defines all the methods of interface.
// With interface technique, you can achieve multiple inheritance in java. by implementing the multiple inheritances;

 class IWind implements IInstrument {
	public void play(Notes n){
		out.println(this + ".play   = " + n);
	}	
	
	public String what() {
		return "Wind";
	}
	public void adjust(){
		out.println(this + ".adjust");
	}
	
}

class IPercussion implements IInstrument {
	public void play(Notes n){
		out.println(this + ".play   = " + n);
	}
	
	public String what(){
		return "Percussion";
	}
	
	public void adjust(){
		out.println(this+".adjust");
	}
}


class IStringed implements IInstrument {
	public void play(Notes n){
		out.println(this + ".play   = " + n);
	}
	
	public String what(){
		return "Stringed";
	}
	
	public void adjust(){
		out.println(this + ".adjust   = ");
	}
}


class IWoodwind extends IWind {
	public void play(Notes n){
		out.println(this + ".play   = " + n);
	}
	
	public String what(){
		return "Woodwind";
	}
} 


class IBrass extends IWind {
	public void play(Notes n){
		out.println(this + ".play   = " + n);
	}
	
	public void adjust(){
		out.println(this + ".adjust()   = ");
	}
}


class IMusic {
	 static void tune(IInstrument i){
		i.play(Notes.MIDDLE_C);
	 }
	 
	 static void tuneAll(IInstrument [] e){
		for(IInstrument x : e){
			tune(x);
		}
	 }
	
	public static void main(String [] args){
		IInstrument [] orchestra = {new IWind(),
								    new IPercussion(),
								    new IStringed(),
								    new IWoodwind(),
								    new IBrass()};
		tuneAll(orchestra);
	}
}


class A {
	// you can define an interface inside a class.
	interface B {
		void f();
	}
	// inner class implementing the interface B
	public class BImp implements B{
		public void f(){
			out.println("BImp.f()");
			
		}
	}
	
	public class BImp2 implements B{
		public void f(){
			out.println("BImp2.f()");
			
		}
	}
	
	public interface C{
		void f();
	}
	
	class CImp implements C{
		public void f(){
			out.println("CImp.f()");
			
		}
	}
	private class CImp2 implements C{
		public void f(){
			out.println("CImp2.f()");
			
		}
	}	
	// you can n't access a private interface  outside of class.  
	private interface D{
		void f();
	}
	private class DImp implements D{
		public void f(){
			out.println("DImp.f()");
			
		}
	}
	public class DImp2 implements D{
		public void f(){
			out.println("DImp2.f()");
			
		}
	}	
	
	public D getD(){return new DImp2();}
	private D dRef;
	public void receiveD(D d){
		dRef = d;
		dRef.f();
	}
}

interface E {
	// by default public access specifier.
	// grouping of interfaces
	interface G{
		void f();
	}
	
	public interface H{
		void f();
	}
	
	void g();
	//! private interface I {} 
}

class NestingInterfaces {
	// Using period you can access the class A public members like A.B etcs; 
	public class BImp implements A.B{
		public void f(){out.println("NestingInterfaces.BImp.f()");}
	}
	
	class CImp implements A.C{
		public void f(){out.println("NestingInterfaces.CImp.f()");}
	}

	// Cann't implement a private interface except within the interface defining class.
	//!public class DImp implements A.D{
		//!public void f(){out.println("NestingInterfaces.DImp.f()");}
	//!}	
	
	class EImp implements E {
		public void g(){out.println("NestingInterfaces.EImp.g()");}
	}
	
	class EGImp implements E.G {
		public void f(){out.println("NestingInterfaces.EGImp.f()");}
	}
	
	class EGImp2 implements E {
		public void g(){out.println("NestingInterfaces.EImp2.g()");}
		class EG implements E.G{
			public void f(){out.println("NestingInterfaces.EGImp2.EG.f()");}
		}
	}	
	
	public static void main(String [] args){
		A a = new A();
		// you cann't  access  a private member of class.
		//! A.D ad = a.getD() ;
		// Doesn't return anything but A.D which is not accessible to outside world. 
		//!A.DImp2 adimp2 = a.getD();
		// Cann't access a member of an interface because it is private;
		//!a.getD().f(); 
		// Only a another A can do anything with getD() ;  
		A a2 = new A();
		a2.receiveD(a.getD());
	}
}



