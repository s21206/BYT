using System;

namespace ConsoleApp2
{
    class Program
    {
        static void Main(string[] args)
        {
            Originator originator = new Originator();
            Caretaker caretaker = new Caretaker();

            string text = "1242351";
            originator.setArticle(text);
            caretaker.AddMemento(originator.storeInMenento());

            text = "ghfgh";
            originator.setArticle(text);
            caretaker.AddMemento(originator.storeInMenento());

            text = "fhkghkjk";
            originator.setArticle(text);
            caretaker.AddMemento(originator.storeInMenento());

        }
    }
}
