import static java.lang.System.*;
import java.util.*;
import java.nio.*;

public class InterfaceAdvance {
	public static void main(String [] args){
	}
}

interface CanFly{
	void fly();
}

interface CanFight{
	public void fight();
}

interface CanSwim {
	void swim();
}


class ActionCharacter {
	public void fight(int i){
		out.println("fight = " + i);
	}
}

// Only one concrete class (which doesn't have any abstract method or not an abstract class)  can be inherited into a new class.
// But multiple interfaces can be combined to form a single interface.
// With we can achieve multiple Inheritance in java.
class Hero extends ActionCharacter implements CanFly,CanFight,CanSwim{
	public void fight(){
		out.println("fight");
	}
	public void swim(){out.println("swim");}
	public void fly(){out.println("fly");}
	public void wow(){out.println("wow");}
}

class Adventure {
		public static void t(CanFight x){x.fight();((Hero)x).wow();}
		public static void u(CanSwim x){x.swim();}
		public static void v(CanFly x){x.fly();}
		public static void w(ActionCharacter x){x.fight(4);}
		public static void main(String [] args){
			Hero h = new Hero();
			t(h);  // object of hero can be upcasted to any interface and base class.
			u(h);
			v(h);
			w(h);
			
		}
}


interface Monster {
	void menace();
}


// you can extend an interface with "extends" keyword .
// after extends keyword you can specify list of interfaces only not class. 
interface DangerousMonster extends Monster {
	void destroy();
}

interface Lethal {
	void kill();
}

class DragonZilla implements DangerousMonster {
	public void menace(){out.println("DangoonZilla.menace()");}
	public void destroy(){out.println("DangoonZilla.destroy()");}
}

interface Vampire extends DangerousMonster,Lethal {
	void drinkBlood();
}


// you always have to extends first  than implements.
// Valid  : class VeryBadVampire extends DragonZilla implements Vampire
//Invalid : class VeryBadVampire  implements Vampire extends DragonZilla
class VeryBadVampire implements Vampire{
	public void menace(){out.println("Vampire.menace()");}
	public void destroy(){out.println("Vampire.destroy()");}
	public void kill(){out.println("Vampire.kill()");}
	public void drinkBlood(){out.println("Vampire.drinkBlood()");}
}



class HorrorShow {
	static void u(Monster b){b.menace();}
	static void v(DangerousMonster d){d.menace();d.destroy();}
	static void w(Lethal l){l.kill();}
	
	public static void main(String [] args){
		DangerousMonster barney = new DragonZilla();
		u(barney);
		v(barney);
		//!w(barney);  
		Vampire vlad = new VeryBadVampire();
		u(vlad);
		v(vlad);
		w(vlad);
	}
}


// Scanner class constructor has a Readable interface agrument  which means it can accept any object of class which implements this interface.
// Readable interface has only method called read() ;
class RandomWords implements Readable {
	private static Random rand = new Random(47);
	private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final char[] lowers =   "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final char[] vowels = "aeiou".toCharArray();
	private int count;
	public RandomWords(int count){this.count = count;}
	public int read(CharBuffer cb){
		if(count--  == 0)
			return -1;
		cb.append(capitals[rand.nextInt(capitals.length)]);
		for(int  i = 0 ; i < 4 ; i++){
			cb.append(vowels[rand.nextInt(vowels.length)]);
			cb.append(lowers[rand.nextInt(lowers.length)]);
		}
		cb.append(" ");
		return 10;
	}
	
	public static void main(String [] args){
		Scanner s = new Scanner(new RandomWords(10));
		while(s.hasNext()){
			out.println(s.next());
		}
	}
}

