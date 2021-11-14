using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    interface Chain
    {

        public void setNextChain(Chain nextChain);

        public void calculate(Numbers request);
    }
}
