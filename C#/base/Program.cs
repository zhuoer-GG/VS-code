using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpTutorials
{
    class Program
    {
        static void Main(string[] args)
        {
            string message = "Hello World!!";

            Console.WriteLine(message);
        }
    }
}
// 每个.NET应用程序都引用它计划与using关键字一起使用的.NET Framework命名空间引用（例如，using System.Text）。
// 使用 namespace 关键字声明当前类的名称空间，例如，namespace CSharpTutorials.FirstProgram
// 然后，我们使用class关键字声明一个类：class Program
// Main()是Program类的方法，是控制台应用程序的入口点。
// String 是一种数据类型。
// message 是保存指定数据类型的值的变量。
// "Hello World!!" 是message变量的值。
// Console.WriteLine() 的是一个静态方法，它是用来在控制台上显示文本。 