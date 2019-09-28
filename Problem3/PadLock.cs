using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem3
{
    internal class PadLock
    {
        private int tumblers;
        private int letters;
        private Random random = new Random();
        public string[,] padlock { get; set; }

        public PadLock(int numTumblers, int numLetters, string[,] newPadLock)
        {
            tumblers = numTumblers;
            letters = numLetters;
            padlock = newPadLock;
        }

        public void PopulateLock()
        {
            for (int n = 0; n < letters; n++)
            {
                for (int m = 0; m < tumblers; m++)
                {
                    padlock[n, m] = RandomLetters(1);
                }
            }
        }
        public string RandomLetters(int length)
        {
            const string chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            return new string(Enumerable.Repeat(chars, length)
                .Select(s => s[random.Next(s.Length)]).ToArray());
        }

        public void DisplayLock()
        {
            for (int n = 0; n < letters; n++)
            {
                for (int m = 0; m < tumblers; m++)
                {
                    Console.Write(padlock[n, m]);
                }
                Console.WriteLine();
            }
        }
    }
}