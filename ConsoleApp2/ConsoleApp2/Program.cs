using System;

namespace ConsoleApp2
{
    class Program
    {
        static void Main(string[] args)
        {
            Chain calculation1 = new AddNumbers();
            Chain calculation2 = new SubstractNumbers();
            Chain calculation3 = new MultiplyNumbers();
            Chain calculation4 = new DivideNumbers();

            calculation1.setNextChain(calculation2);
            calculation2.setNextChain(calculation3);
            calculation3.setNextChain(calculation4);

            Numbers request = new Numbers(10, 22, "add");

            calculation1.calculate(request);
        }
    }
}
