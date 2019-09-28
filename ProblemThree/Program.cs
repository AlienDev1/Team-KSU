using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ProblemThree
{
    class Program
    {
        /// <summary>
        /// This provides of learning how to use File I/O in C#
        /// </summary>
        /// <param name="args"></param>
        static void Main(string[] args)
        {
            var currDir = new DirectoryInfo(".");
            var hackathon = new DirectoryInfo(@"C:\Users\dicti\OneDrive\Documents\Hackathon");

            Console.WriteLine(hackathon.FullName);
            Console.WriteLine(hackathon.Name);
            Console.WriteLine(hackathon.Parent);
            Console.WriteLine(hackathon.Attributes);
            Console.WriteLine(hackathon.CreationTime);

            var textDir = new DirectoryInfo(@"C:\Users\dicti\OneDrive\Documents\Hackathon\Text Files");

            string[] customers =
            {
                "Bob Smith",
                "Sally Smith",
                "Robert Smith",

            };

            string textFilePath = @"C:\Users\dicti\OneDrive\Documents\Hackathon\Text Files\testfile1.txt";
            File.WriteAllLines(textFilePath, customers);

            foreach(string cust in File.ReadAllLines(textFilePath))
            {
                Console.WriteLine($"Customer : {cust}");
            }

            //DirectoryInfo myDataDir = new DirectoryInfo(@"C:\Users\dicti\OneDrive\Documents\Hackathon\Text Files\testfile1.txt");

            //FileInfo[] txtFiles = myDataDir.GetFiles("*.txt", SearchOption.AllDirectories);

            //Console.WriteLine("Matches : {0}", txtFiles.Length);

            //foreach(FileInfo file in txtFiles)
            //{
            //    Console.WriteLine(file.Name);
            //    Console.WriteLine(file.Length);
            //}

            string textFilePath2 = @"C:\Users\dicti\OneDrive\Documents\Hackathon\Text Files\testfile2.txt";

            FileStream fs = File.Open(textFilePath2, FileMode.Create);

            string randString = "This is a random string";

            byte[] rsByteArray = Encoding.Default.GetBytes(randString);

            fs.Write(rsByteArray, 0, rsByteArray.Length);

            fs.Position = 0;

            byte[] fileByteArray = new byte[rsByteArray.Length];

            for(int i = 0; i < rsByteArray.Length; i++)
            {
                fileByteArray[i] = (byte)fs.ReadByte();
            }

            Console.WriteLine(Encoding.Default.GetString(fileByteArray));

            fs.Close();


            string textFilePath3 = @"C:\Users\dicti\OneDrive\Documents\Hackathon\Text Files\testfile3.txt";

            StreamWriter sw = File.CreateText(textFilePath3);

            sw.Write("This is a random ");
            sw.WriteLine("sentence");
            sw.WriteLine("This is another sentence");

            sw.Close();

            StreamReader sr = File.OpenText(textFilePath3);
            Console.WriteLine("Peek: {0}",
                Convert.ToChar(sr.Peek()));

            Console.WriteLine("1st String: {0}",
                sr.ReadLine());

            Console.WriteLine("Everything : {0}",
                sr.ReadToEnd());

            sr.Close();






            Console.ReadLine();
        }
    }
}
