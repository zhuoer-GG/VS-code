package object_1;
class Lamp {//创建了一个名为Lamp的类。

    // 该类有一个实例变量isOn和两个方法turnOn()和turnOff()。 

    boolean isOn;

    void turnOn() {
        // 初始化值为true的变量
        isOn = true;
        System.out.println("点亮? " + isOn);

    }

    void turnOff() {
        //初始化值为false的变量
        isOn = false;
        System.out.println("点亮? " + isOn);
    }
}
public class object {
    public static void main(String[] args) {
  
        //创建了Lamp类的两个对象l1和l2。
        Lamp l1 = new Lamp();
        Lamp l2 = new Lamp();
  
        //使用l1对象调用turnOn()，使用l2对象调用turnOff()
        l1.turnOn();
        l2.turnOff();
    }

    public static void myMethod() {
        System.out.println("我的函数");
    }
    // 在这里，我们创建了一个名为myMethod()的方法。
    // public - 访问修饰符。这意味着可以从任何地方访问该方法。
    // static - 这意味着可以在没有任何对象的情况下访问该方法。
    // void - 这意味着该方法不返回任何值。
    
    // Java中方法定义的完整语法为：
    // modifier static returnType nameOfMethod (parameters) {
    // // method body
    // }
    // modifier - 它定义访问方法是公共方法，私有方法等。

    // static - 如果使用static关键字，则无需创建对象即可对其进行访问。
    // 例如，sqrt()标准Math类的方法是静态的。因此，我们可以直接调用Math.sqrt()而无需创建Math类的实例。

    // returnType - 它指定方法返回的值的类型。例如，如果方法具有int返回类型，则它返回整数值。
    // 一种方法，可以返回原始数据类型（int，float，double等），原生对象（String，Map，List等），或任何其他的内置和用户定义的对象。
    // 如果该方法未返回值，则其返回类型为void。

    // nameOfMethod - 它是一个标识符，用于引用程序中的特定方法。
    // 我们可以给方法起任何名字。但是，以它执行的任务命名是更常规的做法。例如calculateArea()，display()等。

    // parameters （arguments） - 这些是传递给方法的值。我们可以将任意数量的参数传递给方法。

    // method body - 它包括用于执行某些任务的编程语句。方法主体包含在花括号内{ }。
}

