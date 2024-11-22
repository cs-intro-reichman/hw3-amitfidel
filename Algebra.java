// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5= 243
   		System.out.println(div(12,3));   // 12 / 3  =4
   		System.out.println(div(5,5));    // 5 / 5  =1
   		System.out.println(div(25,7));   // 25 / 7 =3
   		System.out.println(mod(25,7));   // 25 % 7 =4
   		System.out.println(mod(120,6));  // 120 % 6 =0   
   		System.out.println(sqrt(36));  //=6
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(17)); //76123
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		for(int i=0; i<x2; i++)
		{
			x1++;
		}
		return x1;
		
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		for(int i=0; i<x2; i++)
		{
			x1--;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int num=0;
		for(int i=0; i<x2; i++)
		{
			num=plus(num, x1);
		}
		x1=num;
		return x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int num=x;
		for(int i=1; i<n; i++)
		{
			num=times(num, x);
			
		}
		return num;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int num=0;
		int counter=1;
			while (num<x1) {
				num=plus(num, x2);
				if(minus(x1, num)>=x2)
				{
					counter++;
				}
				
			}
			return counter;
		
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int num=div(x1, x2);
		x1=minus(x1,times(x2, num));
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int num=0;
		while (pow(num,2)<x) 
		{
			if (pow(num+1, 2)>x&x>pow(num, 2)) 
			{
				return num;
			}
			else num++;
			
		}
		return num;
	}	  	  
}