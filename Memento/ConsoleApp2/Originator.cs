using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    class Originator
    {

        private string article;

        public void setArticle(string article)
        {
            this.article = article;
        }

        public Memento storeInMenento()
        {
            return new Memento(article);
        }

      
    }
}
