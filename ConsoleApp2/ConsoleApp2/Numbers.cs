using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    class Numbers
    {
        private int num1;
        private int num2;

        private string operation;
        
        public Numbers(int num1, int num2, string operation)
        {
            this.num1 = num1;
            this.num2 = num2;
            this.operation = operation;
        }

        public int getNum1()
        {
            return num1;
        }
        public int getNum2()
        {
            return num2;
        }
        public string getOperation()
        {
            return operation;
        }
    }
}
