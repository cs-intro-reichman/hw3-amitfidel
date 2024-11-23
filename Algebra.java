// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
		System.out.println(plus(2,-3)); //-1
		System.out.println(minus(2,-3)); //5
		System.out.println(times(2,-3)); //-6
		System.out.println(plus(-2,-3)); //-5
		System.out.println(minus(-2,-3)); //1
		System.out.println(times(-2,-3)); //6
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

	public static int myAbs(int x)
	{
		int num=0;
		if (x>=0) 
		{
			return x;
		}
			
		for(int i=x; i<0; i++)
		{
			num++;
		}
		return num;
	}
	// Returns x1 + x2
	public static int plus(int x1, int x2) 
	{
			for(int i=0; i<myAbs(x2); i++)
		{
			if (x2<0) 
			{
				x1--;
			}
			else
			x1++;
		}
		return x1;
		
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) 
	{
		
			for(int i=0; i<myAbs(x2); i++)
			{
				if (x2<0) 
				{
					x1++;
				}
				else
				x1--;
			}
			return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int num=0;
		if((x2>=0&&x1>=0)||(x2<0&&x1<0))
		{
			
			for(int i=0; i<myAbs(x2); i++)
				{
				num=plus(num, myAbs(1));
				}
		}
		else
		{
			for(int i=0; i<myAbs(x2); i++)
			{
			num=minus(num, myAbs(x1));
			}
		}
		return num;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int num=x;
		if (x>0||x<0&mod(n, 2)==0) 
		{
			if (x<0) 
			{
				x=myAbs(x);
			}
		for(int i=1; i<n; i++)
		{
			num=times(num, x);
		}
		}
		else
		{
			for(int i=1; i<n; i++)
			{
			num=times(num, myAbs(x));
			}
		}
		return num;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int num=0;
		int counter=0;
		int x11=myAbs(x1);
		int x22=myAbs(x2);
			while (num<=x11) {
				num=plus(num, x22);
				if(minus(x1, num)>=x2)
				{
					if (x1>0&x2>0||x1<0&x2<0) 
					{
						counter++;
					}
					else counter--;
					
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
			if (pow(num+1, 2)>x) 
			{
				return num;
			}
			else num++;
			
		}
		return num;
	}	  	  
}