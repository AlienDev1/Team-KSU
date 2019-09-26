// Hackathon Java Password cracking

//import java.util.Scanner;
//import java.io.*;


class Cipher{

	private static String password = "GOTIT";
	private static StringBuilder string = new StringBuilder("");
	private static int min = 32, max = 127;
	private static long start;

	public static void search(int index) {

		for(int i = min; i < max; i++) {

			string.setCharAt(index, (char) i);
			if(index < string.length() -1){
				search(index + 1);
			}

			System.out.println(string);
			if(string.toString().equals(password)) {

				System.err.println("password found: " + string);
				System.err.println("I took : " + time(System.currentTimeMillis() - start));
				System.exit(0);
			}
		}
	}

	public static void main(String [] args) {

//		Scanner sc = new Scanner(System.in);

//		System.out.println("Enter your choosen password");
//		String target = sc.nextLine();

		start = System.currentTimeMillis();
		while(true){

			string.append((char) min);

			for(int i = 0; i < string.length() - 1; i++) {

				for(int j = min; j < max; j++) {

					string.setCharAt(i, (char) j);
					search(i + 1);
				}
			}
		}	
	}

	public static String time(long input) {

		int day = 0, hour = 0, minute = 0, second = 0, millis = 0;

		day = 86400000;
		hour = 3600000;
		minute = 60000;
		second = 1000;

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