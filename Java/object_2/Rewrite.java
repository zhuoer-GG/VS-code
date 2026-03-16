package object_2;
// 在上一教程中，我们了解了继承。继承是一个OOP属性，
// 它使我们可以从现有的类（父类）派生一个新的类（子类），而子类继承超类的属性和方法。
// 现在，如果在父类和子类中都定义了相同的方法，则子类的方法将覆盖超类的方法。
// 这称为方法覆盖（方法重写）。
public class Rewrite {
    
}
//示例：方法覆盖
class Animal {
   public void displayInfo() {
      System.out.println("I am an animal.");
   }
}

class Dog extends Animal {
   @Override
// @Override注释告诉编译器，该注释之后的方法将覆盖超类的方法。
// 使用@Override不是强制性的。但是，当我们使用这个方法时，
// 该方法应该遵循覆盖的所有规则。否则，编译器将生成错误。
   public void displayInfo() {
      System.out.println("I am a dog.");
   }
}

class Main {
   public static void main(String[] args) {
      Dog d1 = new Dog();
      d1.displayInfo();
   }
}
// displayInfo()方法同时存在于Animal父类和Dog子类中。
// 当我们使用d1对象(子类的对象)调用displayInfo()时，会调用子类Dog中的方法。
// 子类的displayInfo()方法覆盖父类的相同方法。

// 重写规则
// 父类和子类都必须具有相同的方法名称，相同的返回类型和相同的参数列表。
// 我们不能重写声明为final和static的方法。
// 我们应该始终重写超类的抽象方法（将在以后的教程中进行讨论）。

// 我们可以在重写后访问超类的方法吗？
// 答案是肯定的。要从子类访问超类的方法，我们使用super关键字。
class Animal1 {
   public void displayInfo() {
      System.out.println("I am an animal.");
   }
}

class Dog1 extends Animal1 {
   public void displayInfo() {
      super.displayInfo();
      System.out.println("I am a dog.");
   }
}
// 当我们使用Dog子类的d1对象调用displayInfo()方法时，将调用Dog子类内部的方法。 不会调用父类内部的方法。
// 在Dog子类的displayInfo()内部，我们使用了super.displayInfo()来调用父类的displayInfo()。

class Main1 {
   public static void main(String[] args) {
      Dog1 d1 = new Dog1();
      d1.displayInfo();
   }
}

// 方法重写中的访问说明符
// 在父类及其子类中声明的相同方法可以具有不同的访问说明符。但是，有一个限制。
// 我们只能，在提供比父类的访问说明符更大的访问权限的子类中使用的那些访问说明符。 例如，
// 假设父类中的方法myClass()被声明为protected。
// 然后，myClass()子类中的相同方法可以是 public 或 protected，但不能是private。