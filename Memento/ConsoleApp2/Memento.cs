using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    class Memento
    {
        private string article;

        public Memento(string article)
        {
            this.article = article;
        }

        public string getArticle()
        {
            return article;
        } 
    }
}
