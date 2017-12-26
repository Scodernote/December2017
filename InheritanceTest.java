import static java.lang.System.*;

class Cleanser {
	private String s = "Cleanser";
	public void append(String a){
		s+=a; // for String  java has overloaded two operator + and +=.
	}
	// making the method public , means you are allow a class from the different package  to inherited it. Basically you are making this method inheritable from anywhere.
	// if you remove public keyword from fornt of this following method, still it can be inheritable from same package.
	public void dilute(){
		append(" dilute()");
	}
	 void apply(){
		append(" apply()");
	}
	public void scrub(){
		append(" scrub()");
	}	
	public String toString(){return s;}
	// you can create a main method for each class. with that you can test each class seperately.
	// Even you can call this main because this class has package access.
	public static void main(String [] args){
		Cleanser x = new Cleanser();
		out.println(x);
	}
}

// extends keyword is used when we want to inherited from a class.
public class InheritanceTest extends Cleanser {
	// you can even modify the inherited method from base in derived class.
	public void scrub(){
		append(" Detergent.scrub()");
		// with super keyword , you can call base class version of scrub()  method.
		super.scrub();
	}
	// you can also add a new method to derived class interface;
	public void foam() {
		append(" foam()");
	}
	
	public static void main(String [] args){
		InheritanceTest x = new InheritanceTest();
		x.dilute();
		x.apply();
		x.scrub();
		x.foam();
		out.println(x);
		out.println("Testing base class:");
		Cleanser.main(args);
	}
}