package object_2;

// 要记住的要点

//     我们使用abstract关键字来创建抽象类和方法。

//     抽象方法没有任何实现（方法体）。

//     包含抽象方法的类也应该是抽象的。

//     我们不能创建抽象类的对象。

//     为了实现抽象类的功能，我们从其继承子类并创建该子类的对象。

//     子类必须重写抽象类的所有抽象方法。但是，如果子类被声明为抽象的，则不必强制重写抽象方法。

//     我们可以使用抽象类的引用来访问抽象类的静态属性和方法。

public class MyAbstract {
    // 抽象类是无法实例化的类（我们无法创建抽象类的对象）。
    // 在Java中，我们使用abstract关键字声明一个抽象类。

    abstract class Animal1 {
    //属性和方法
    }
    // 如果尝试创建抽象类的对象，则会出现编译错误。
    // 尽管不能实例化抽象类，但是我们可以从中创建子类。
    // 我们可以创建子类的对象来访问抽象类的成员。

    // 我们使用相同的关键字abstract来创建抽象方法。
    // 重要的是要注意，只有一个抽象类才能包含抽象方法。
    // 如果我们在不是抽象的类中包含抽象方法，则会出现错误。
    abstract class Animal2 {
    public void displayInfo() {
        System.out.println("I am an animal.");
    }

    abstract void makeSound();// 抽象方法没有方法体。
    }

    
}
// 抽象类的继承
// 抽象类无法实例化。要访问抽象类的成员，我们必须继承它。
abstract class Animal {
public void displayInfo() {
System.out.println("I am an animal.");
}
}

class Dog extends Animal {

}
class Main {
public static void main(String[] args) {
Dog d1 = new Dog();
d1.displayInfo();
}
}

// 重写抽象方法

// 在Java中，必须在子类中重写超类的抽象方法。这是因为子类继承了超类的抽象方法。
//  因为我们的子类包含抽象方法，所以我们需要重写它们。
// 注意：如果子类也被声明为抽象，则不必强制重写抽象方法。

abstract class Animala {
   abstract void makeSound();

   public void eat() {
      System.out.println("I can eat.");
   }
}

class Doga extends Animala {

   public void makeSound() {
      System.out.println("Bark bark");
   }
}
class Maina {
   public static void main(String[] args) {
      Doga d1 = new Doga();
      d1.makeSound();
      d1.eat();
   }
}

// 与非抽象类相似，我们使用super关键字从子类访问抽象类的构造函数。
// 注意，super 始终应是子类构造函数的第一条语句。


// 为什么使用Java抽象？

// 抽象是面向对象编程的重要概念。抽象仅显示所需的信息，所有不必要的细节都保持隐藏。
// 这使我们能够通过使用更简单，更高级的想法省略或隐藏细节来管理复杂性。