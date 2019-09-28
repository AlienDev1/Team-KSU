
// Hackathon Java Password cracking
import java.util.Scanner;
//import java.io.*;


class BruteForce{


	// Declares Variable 
	private static String password;  
	private static StringBuilder build = new StringBuilder("");
	// private static int min = 33, max = 127; Syntax for full ASCII 
	private static int min = 65, max = 90; // 65 - 90 is just Letters 
	private static long start;


	// METHOD THAT SEARCH ASCII AND COMPARE TARGET (USER INPUT) 
	// ONCE TARGET AND STRING-BUILDER OBJECT MATCHES THEN IT SHOULD CALL
	// TIME METHOD. 

	public static void search(int index, String target) {

		for(int i = min; i < max; i++) {

			build.setCharAt(index, (char) i);
			if(index < build.length() -1){
				search(index + 1, target);
			}

			System.out.println(build);
			if(build.toString().equals(target)) {

				System.err.println("password found: " + build);
				System.err.println("I took : " + time(System.currentTimeMillis() - start));
				System.exit(0);
			}
		}
	}

	// MAIN METHOD 

	public static void main(String [] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choosen password");
		String target = sc.nextLine();

//		String target = tar.toUpperCase(); 

		start = System.currentTimeMillis();
		while(true){

			build.append((char) min);

			for(int i = 0; i < build.length() - 1; i++) {

				for(int j = min; j < max; j++) {

					build.setCharAt(i, (char) j);
					search((i + 1), target);
				}
			}
		}	
	}

	public static String time(long input) {

		int day = 0, hour = 0, minute = 0, second = 0, millis = 0;

		day = 2;
		hour = 48;
		minute = 2880;
		second = 172800;

		if( input >= day) {

			day = (int) (input / day);
			millis = (int) (input % day);
		}
		else {

			millis = (int) input;
		}
		if(millis >= hour) {

			hour = millis / hour;
			millis = millis % minute;
		}
		if(millis >= minute) {

			minute = millis / minute;
			millis = millis % minute;
		}
		if(millis >= second) {

			second = millis / second;
			millis = millis % second;
		}

		return (day + " day(), " + hour + "h, " + minute + "min, " + second + "s and " + millis + "ms");
	}
}