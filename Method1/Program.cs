using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Method1
{
    class Program
    {
        static void Main(string[] args)
        {

            //char stop;
            //bool sent = false;
            //for (int x = 0; x < 5; x++)
            //{
            //    Console.WriteLine($"Randomize Password: {randomString(target)}");

            //}

            //Console.WriteLine("Would you like to stop:(Y/N) ");
            //stop = Convert.ToChar(Console.ReadLine());

            //while (!sent)
            //{
            //    Console.WriteLine("Enter the password: ");
            //    target = Console.ReadLine();

            //    Console.WriteLine($"Password: {target}");

            //    for (int x = 0; x < 5; x++)
            //    {
            //        Console.WriteLine($"Randomize Password: {randomString(target)}");
            //    }

            //    Console.WriteLine("Would you like to stop:(Y/N) ");
            //    stop = Convert.ToChar(Console.ReadLine());

            //    if (stop == 'Y')
            //    {
            //        sent = true;
            //    }
            //    else
            //    {
            //        sent = FALSE;
            //    }
            //}



            string target;
            Console.WriteLine("Enter the password: ");
            target = Console.ReadLine();

            Console.WriteLine($"Password: {target}");
            Console.WriteLine($"Randomize Password: {randomString(target)}");


            Simulation(target);
            Console.ReadKey();


        }

        public static string randomString(string word)
        {
            Random r = new Random();

            string random = new string(word.ToCharArray().OrderBy(s => (r.Next(2) % 2) == 0).ToArray());

            return random;
        }

        public static void Simulation(string password)
        {
            password.ToCharArray();

            char[] alphabet = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

            foreach (char c in alphabet)
            {
                foreach (var item in password)
                {
                    if (c.Equals(item))
                    {
                    }
                }
            }
        }
    }
}
