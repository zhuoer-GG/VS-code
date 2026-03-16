package object_3;

public class anonymous_class {
// 在Java中，一个类可以包含另一个称为嵌套类的类。可以在不提供任何名称的情况下创建嵌套类。
// 没有任何名称的嵌套类称为匿名类。
// 必须在另一个类中定义一个匿名类。因此，它也被称为匿名内部类。其语法为：
class outerClass {

    //定义匿名类
    // object1 = new Type(parameterList) {
    //      //匿名类的主体
    // };
}
// 匿名类通常继承子类或实现接口。
// 在这里，类型(Type)可以是
    // 匿名类继承的超类
    // 匿名类实现的接口
// 上面的代码在运行时创建了一个匿名类的对象object1。
// 注意：匿名类在表达式内定义。因此，在匿名类的末尾使用分号来表示表达式的末尾。
}


// 匿名内部类继承类
class Polygon {
   public void display() {
      System.out.println("在Polygon类内");
   }
}

class AnonymousDemo {
   public void createClass() {

      //创建匿名类，继承类Polygon
      Polygon p1 = new Polygon() {
         public void display() {
            System.out.println("匿名类的内部。");
         }
      };
      p1.display();
   }
}
// 在上面的示例中，我们创建了一个类Polygon。它只有一个方法display()。
// 然后，我们创建了一个匿名类，该类继承类Polygon并重写了display()方法。
// 当我们运行该程序时，将创建一个匿名类的对象p1。然后该对象调用匿名类的display()

// 实现接口的匿名类

interface Polygon1 {
   public void display();
}

class AnonymousDemo1 {
   public void createClass() {

      //匿名类实现接口
      Polygon1 p1 = new Polygon1() {
         public void display() {
            System.out.println("匿名类的内部。");
         }
      };
      p1.display();
   }
}

// 匿名类的优点
// 在匿名类中，只要需要就创建对象。即，创建对象以执行某些特定任务。例如，

// Object = new Example() {
//    public void display() {
//       System.out.println("匿名类重写display()方法。");
//    }
// };

// 在这里，当我们需要重写display()方法时，将动态创建匿名类的对象。
// 匿名类也有助于我们使代码简洁。