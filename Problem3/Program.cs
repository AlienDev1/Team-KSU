using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Collections;
using System.Diagnostics;

namespace Problem3
{
    class Program
    {
        static void Main(string[] args)
        {

            //string textFilePath = @"C:\Users\dicti\OneDrive\Documents\Hackathon\KSU-Hackathon\Dictionary.txt";
            //StreamReader sr = new StreamReader(textFilePath);
            //string word;
            //List<int> number = new 
            //while (!sr.EndOfStream)
            //{
            //    word = sr.ReadLine();
            //    int count = word.Length;

            //    if(word.Length == 1)
            //    {
            //        string path1 = @"C:\Users\dicti\OneDrive\Documents\Hackathon\KSU-Hackathon\WordList\oneLetter.txt";
            //        StreamWriter sw1 = File.CreateText(path1);
            //        sw1.WriteLine(word);
            //        sw1.Close();
            //    }
            //    else if(word.Length == 2)
            //    {
            //        string path2 = @"C:\Users\dicti\OneDrive\Documents\Hackathon\KSU-Hackathon\WordList\twoLetter.txt";
            //        StreamWriter sw2 = File.CreateText(path2);
            //        sw2.WriteLine(word);
            //        sw2.Close();
            //    }
            //    //Console.WriteLine(count);
            //}
            //sr.Close();
            //Console.ReadLine();

            Console.WriteLine("Enter the number of tumblers in the padlock (4 or 5): ");
            int tumblers = int.Parse(Console.ReadLine());

            Console.WriteLine("Enter the number of letters per tumbler on the padlock (Between 6 - 10): ");
            int letters = int.Parse(Console.ReadLine());

            Console.WriteLine("Enter the password: ");
            string password = Console.ReadLine();

            char[] pass = password.ToCharArray();

            Console.WriteLine(); //Spacing

            string[,] pad = new string[letters, tumblers];

            PadLock padLock = new PadLock(tumblers, letters, pad);
            padLock.PopulateLock();
            padLock.DisplayLock();

            PasswordBreach passwordBreach = new PasswordBreach(pad, letters);

            //passwordBreach.DisplayColumns(letters);

            Console.WriteLine();


            for (int begin = 0; begin < 5; begin++)
            {
                TumblerList(pass, padLock.padlock, letters, begin);
            }

            Console.ReadKey();
        }
        public static void TumblerList(char[] splitPassword, string[,] pad, int row, int columnNumber)
        {
            string[] tumblerlist = new string[row];
            for (int x = 0; x < row; x++)
            {
                string temp = pad[x, columnNumber];
                for (int y = 0; y < row; y++)
                {
                    string temp2 = pad[y, columnNumber];
                    if (x == y)
                    {
                        break;
                    }

                    tumblerlist[y] = temp2;
                }
            }

            Array.Sort(tumblerlist);


            for (int i = 0; i < tumblerlist.Length; i++)
            {
                Console.Write(tumblerlist[i] + " ");
            }
            Console.WriteLine();
        }
    }
}
