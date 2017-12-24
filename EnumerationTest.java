import static java.lang.System.*;

// instances of enumerated type are constant.
// You can use it with enum type name followed by peroid followed by instance name; Spiciness.NOT
// inherited methods are toString : to print instances in string format;
//				ordinal()  :  to get declaration order of enum constant
//				values()  : static values mathod return an array of value of the enum constants in the order they were declared.
enum Spiciness{
	NOT,
	MILD,
	MEDIUM,
	HOT,
	FLAMING
}

class EnumerationTest {
	public static void main(String[] args){
		Spiciness hotness = Spiciness.NOT;
		out.println(hotness);
		out.println(Spiciness.NOT.ordinal());
		for(Spiciness s : Spiciness.values()){
			out.println(s + " , ordinal " + s.ordinal());
		}
	}
}

