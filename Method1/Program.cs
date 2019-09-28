using Method1.Classes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Method1
{
    class Program
    {
        private static Random random = new Random();

        static void Main(string[] args)
        {
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
                TumblerList(pass,padLock.padlock, letters, begin);
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
