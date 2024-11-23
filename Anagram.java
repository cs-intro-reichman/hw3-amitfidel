/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1=preProcess(str1);
		str2=preProcess(str2);
		int index=0;
		for(int i=0;i<str1.length();i++)
		{
			index=str2.indexOf(str1.charAt(i));
			if (index==-1) 
				{
					return false;
				}
				else
				{
					if(index==0)
					{
						str2=str2.substring(index+1);
					}
					else
					str2=str2.substring(0, index)+str2.substring(index+1,str2.length());
				}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String goodStr="";
		for(int i=0;i<str.length();i++)
		{
			if (str.charAt(i)>=97&&str.charAt(i)<=122) 
			{
				goodStr+=(char)(str.charAt(i));
			}
				if (str.charAt(i)>64&&str.charAt(i)<90) 
			{
				goodStr+=(char)(str.charAt(i)+32);
			}
			
		}
		return goodStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) 
	{
		str=preProcess(str);
		String str2="";
		int rnd=0;
		int num=str.length();
		for(int i=0;i<num;i++)
		{
			
			rnd=(int)(Math.random()*(str.length()));
			if(rnd==0)
				{
					str2+=str.charAt(rnd);
					str=str.substring(rnd+1);
				}
				else
				{
					str2+=str.charAt(rnd);
					str=str.substring(0, rnd)+str.substring(rnd+1,str.length());
				}
		}
		
		return str2;
	}
}
