package object_2;

public class encapsulation {
//     Java 封装
//     封装是面向对象编程的重要功能之一。封装是指将字段和方法绑定在单个类中。
//     将类中的类似字段和方法捆绑在一起也有助于隐藏数据。
}
// 在Java中，我们可以将在单个类中一起操作的字段和方法捆绑在一起。例如，
class Rectangle1 {
   int length;
   int breadth;
   public void getArea() {}
}

// 数据隐藏是一种通过隐藏实现细节来限制数据成员访问的方法。
// 封装还提供了一种隐藏数据的方法。
// 数据隐藏可以通过访问修饰符来实现。
class Person {
   private int age;//将age设置为私有，可以限制来自类外部未经授权的访问。这是数据隐藏。

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }
}

class MainE {
   public static void main(String[] args) {
      Person p1 = new Person();
      p1.setAge(24);
      System.out.println("我的年龄是 " + p1.getAge());
   }
}

// 为什么要封装？
    // 在Java中，封装可帮助我们将相关的字段和方法保持在一起，从而使我们的代码更整洁且易于阅读。
    // 它有助于控制我们数据字段的修改。 考虑一种情况，我们希望类中的age字段为非负数。 在这里，我们可以将age设为私有，并可以在setAge()方法内部应用逻辑。 例如，

// class PersonE {
//    private int age;

//    public void setAge(int age) {
//      if (age >= 0) {
//         this.age = age;
//      }
//    }
// }

// getter和setter方法提供对我们的类字段的只读或只写访问。例如，
// getName()   // 提供只读访问
// setName()   //提供只写访问

// 它有助于解耦系统的组件。这些解耦的组件可以独立且同时进行开发，测试和调试。并且，特定组件的任何更改都不会对其他组件产生任何影响。

// 数据隐藏 与 封装
// 人们通常认为封装是数据隐藏，但这并不完全正确。
// 封装是指将相关字段和方法捆绑在一起。这使得我们能够实现数据隐藏。封装本身并不是数据隐藏。