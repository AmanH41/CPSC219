import static org.junit.Assert.*;

import org.junit.Test;

public abstract class SuperClass {
	   public String x = "super";
	   public SuperClass(String s) {
	     x = x + s;
	   }
	   public abstract String abstractMethod(int y);

	   public String aMethod(int y){
	     return x + abstractMethod(y);
	   }
	}

	public abstract class One extends SuperClass {
	   public String z = "one";
	   public One(String s){
	      super(s + 1);
	   }

	   public String concreteMethod(int y) {
	     z = z + y;
	     return z;
	   }
	}

	public class Two extends One {
	    public Two(String s){
	    super(s + 2);
	}

	   public String abstractMethod(int y) {
	     return super.abstractMethod(y) + 2;
	   }
	}

	public class Test2 {
	   public static void main(String[] args) {
	   SuperClass a = new One("a_one");
	   SuperClass b = new Two("b_one");

	   System.out.println(a.x); // first
	   System.out.println(b.x); // second

	   b.x = "b";
	   a.x = "a";

	   System.out.println(a.aMethod(5)); // third
	   System.out.println(b.aMethod(10)); // fourth

	   }
	}