using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    class Caretaker
    {

        List<Memento> listOfArticles = new();

        public void AddMemento(Memento memento)
        {
            listOfArticles.Add(memento);
        }

        public Memento GetMemento(int index)
        {
            return listOfArticles[index];
        }
    }
}
