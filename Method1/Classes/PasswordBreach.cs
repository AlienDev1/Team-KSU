using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Method1.Classes
{
    public class PasswordBreach
    {
        private string[] tumblerlist;
        private string[,] padlock;

        public PasswordBreach(string[,] newPadLock, int row)
        {
            padlock = newPadLock;
            tumblerlist = new string[row];
        }

        //public void TumblerList(string[,] pad, int row, int columnNumber)
        //{
        //    for (int x = 0; x < row; x++)
        //    {
        //        //string temp = pad[x, columnNumber];
        //        for (int y = 0; y < row; y++)
        //        {
        //            string temp2 = pad[y, columnNumber];
        //            if (x == y)
        //            {
        //                break;
        //            }

        //            tumblerlist[y] = temp2;
        //        }
        //    }

        //    for (int i = 0; i < tumblerlist.Length; i++)
        //    {
        //        Console.Write(tumblerlist[i] + " ");
        //    }
        //    Console.WriteLine();
        //}

        public void DisplayColumns(int n)
        {
            string[] tumblerList = new string[n];
            for (int i = 0; i < n; i++)
            {
                //TumblerList(padlock, n, i);
            }
        }
    }
}
