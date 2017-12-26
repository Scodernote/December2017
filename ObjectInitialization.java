import static java.lang.System.*;

// there are four places where we can initial a reference inside a class (ex: ObjectInitialization) ;

class Soap {
	private String s;
	Soap(){
		out.println("Soap()");
		s = "Constructed";
	}	
	public String toString(){
		return s;
	}
}

public class ObjectInitialization {
	private String s1 = "Happy", //  1. at the point of object definition . it always gets initialize before constructor is called.
				   s2 = "Happy",
				   s3,s4;
	private Soap castille;
	private int i;
	private float toy;
	public ObjectInitialization(){
		out.println("inside Bath()");
		// 2. in the constructor of that class.
		s3 = "Joy";
		toy = 3.4f;
		castille = new Soap();
	}
	{
		//3. instance initialization
		i =47;
	}
	public String toString(){
		if(s4 == null)
			s4= "Joy"; // 4. Right before you actually need to use the object. this is often called lazy initialization 
		return 
			"s1 = " + s1 + "\n" +
			"s2 = " + s2 + "\n" +
			"s3 = " + s3 + "\n" +
			"s4 = " + s4 + "\n" +
			"i = " + i + "\n" +
			"toy = " + toy + "\n" +
			"castille = " + castille + "\n";
	}
	
	public static void main(String [] args){
		ObjectInitialization bath = new ObjectInitialization();
		out.println(bath);
	}
}