using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    class DivideNumbers : Chain
    {

        private Chain nextInChain;

        public void setNextChain(Chain nextChain)
        {
            this.nextInChain = nextChain;
        }

        public void calculate(Numbers request)
        {
            if (request.getOperation() == "divide")
            {
                Console.WriteLine(request.getNum1() / request.getNum2());
            }
            else
            {
                Console.WriteLine("Error! You can provide only add, sub, mult and divide operations");
            }
        }
    }
}


