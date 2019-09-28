
// Hackathon Java Password cracking

import java.util.Scanner;
import java.io.*;


class BruteForce{

	// Declares Variable 

	private static String password;  
	private static StringBuilder build = new StringBuilder("");
	private static int fullMin = 33, fullMax = 127; // Syntax for full ASCII 
	private static int min = 65, max = 90; // 65 - 90 is just Letters 
	private static long start = 0l;




	// MAIN METHOD 

	public static void main(String [] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choosen password");
		String target = sc.nextLine(); 
		start = System.currentTimeMillis();


		Scanner opt1 = new Scanner(System.in);

		System.out.println("QUESTION 1:\n Run Brute Force Attack (Enter 1)" +
			"\n Run Dictionary Attack (Enter 2)\n" +
			"QUESTION 2:\n Recieve analytics for Q2 (Enter 3)" +
			"\nQUESTION 3:\n Recieve analytics for Q3 (Enter 4");

		byte selection = opt1.nextByte();
					if(selection == 1) {
						
						while(true) {

							build.append((char) min);

							for(int i = 0; 9 < build.length() - 1; i++) {

								for(int j = min; j < max; j++) {

									build.setCharAt(i, (char) j);
									search((i + 1), target);
								}
							}
						}

					}
					if(selection == 2) {

						readDictionary(target);
						
					}
					if(selection == 3) {

						// some code
						System.out.print("selection 3");
					}
					if(selection == 4) {

						// some code
						System.out.print("selection 4");

					}
	}			
		







	// METHOD THAT SEARCH ASCII AND COMPARE TARGET (USER INPUT) 
	// ONCE TARGET AND STRING-BUILDER OBJECT MATCHES THEN IT SHOULD CALL
	// TIME METHOD. 


	public static void search(int num, String target) {

		for(int i = min; i < max; i++) {

			build.setCharAt(num, (char) i); // Turns i to ASCII Character A then increments up

			if(num < build.length() -1) {

				search(num + 1, target);
			}

			System.out.println(build);
			if(build.toString().equals(target)) {

				System.err.println("password found: " + build);
				System.err.println("I took : " + time(System.currentTimeMillis() - start));
				System.exit(0);
			}
		}
	}




	// Alphabetical Binary Search Method 


	public static boolean binarySearch(int [] arr, int target) {

		boolean found = false;

		int low = 0, mid = 0, high = arr.length;

		while(!found) {

			mid = (low + high) / 2;

			if (target == arr[mid]) {

				return true;

			} else if(target < arr[mid]) {

				 high = mid;

			}else {

				low = mid;
			}
			if(low >= high -1) {

				return false;
			}
		}

		return found;
	}












	// Method responsible for writing output to a file 
	// Shoud be used to print possible combinations {Qusetion 3} And Graphing Point for marketing 


	public static void bufferedWriterMethod(String intel, int linesOnPage) {

	//File that I am writting to.(If you decide to run this on your machine change this file to a Directory/File)
		File fileName = new File("D:/SWE/Hacking/Brute Force Password Cracking/Hackathon/BruteForce_data.txt");
		FileWriter fr = null;
		BufferedWriter br = null;
		String space = intel + System.getProperty("line.seperator");

		try {

			fr = new FileWriter(fileName);
			br = new BufferedWriter(fr);
			for(int i = linesOnPage; i > 0; i--) {

				br.write(intel);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally{

			try {

				br.close();
				fr.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}











	// Method that keeps time of the application 


	public static String time(long input) {

		int day = 0, hour = 0, minute = 0, second = 0, millis = 0;

		day = 2;
		hour = 48;
		minute = 2880;
		second = 172800;

		if( input >= day) {

			day = (int) (input / day);
			millis = (int) (input % day);
		} else {

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























	// Method Responsible for adding Dictionary 
	// Recieves target looks at the lenght and based off of the length 
	// Determines which Dictionary to use based off of lenght to speed up process. 


	public static void readDictionary(String target) {

		byte length = (byte) target.length();


				if(target.length() == 2) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "twoLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
				if(target.length() == 3) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "threeLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 4) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "fourLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 5) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "fiveLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 6) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "sixLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 7) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "sevenLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 8) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "eightLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 9) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "nineLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 10) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "tenLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 11) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "elevenLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 12) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "twelveLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 13) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "thirteenLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 14) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "fourteenLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 15) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "fifteenLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 16) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "sixteenLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 17) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "seventeenLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 18) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "eighteenLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 19) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "nineteenLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

				if(target.length() == 20) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "twentyLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 21) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "twentyoneLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 22) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "twentytwoLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 23) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "twentythreeLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 24) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "twentyfourLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

				if(target.length() == 25) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "twentyfiveLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 26) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "twentysixLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 27) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "twentysevenLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 28) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "twentyeightLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 29) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "twentynineLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 30) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "thirtyLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(target.length() == 31) {

					BufferedReader br = null;
					try {

						br = new BufferedReader(new FileReader(/**"Dictionary.txt"*/ "thirtyoneLetter.txt"));
						String line;

						while((line = br.readLine()) != null) { 

							System.out.println(line);
							// line is the word we will use to access the library
							// This will be iterated throughout the different switch statements

							// Code to Compare String with Managed Dictionary
						}

					}catch (IOException e) {

						e.printStackTrace();
					} finally {
						try {
							br.close();
						} catch (IOException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

	} 
}