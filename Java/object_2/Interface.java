package object_2;

public class Interface {
    // 在Java中，接口定义了其他类必须实现的一组规范。例如，
    interface Polygon {
        public void getArea();
        public static final String color = "blue";//接口可以包含抽象方法和常量。
    }
    // 这里Polygon是一个接口。我们使用了interface关键字来声明一个接口。
    // getArea()方法是在Polygon接口中定义的规范，所有使用此接口的类都必须实现getArea()方法。

    //重要的是要注意，接口内的所有方法都是隐式的public，所有字段都是隐式的public static final。
    // 因此，不必在接口内部指定访问说明符。
    // 我们可以将上面的代码编写为:
    // interface Polygon {
    // String color = "blue";
    
    // void getArea();
    // }
}

// 接口 与 implements 关键字

// 像抽象类一样，我们无法创建接口的对象。但是，我们可以在其他类中实现接口。
// 在Java中，我们使用 implements关键字来实现接口。例如，
interface Polygon {
    void getArea(int length, int breadth);
}

class Rectangle implements Polygon {
    public void getArea(int length, int breadth) {
        System.out.println("矩形的面积是 " + (length * breadth));
    }
}

class MainRec {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.getArea(5, 6);
    }
}

// 为什么要使用接口？

// 现在我们知道了接口是什么，让我们了解为什么在Java中使用接口。
//     接口提供了类（实现它）必须遵循的规范。
//     在上面的示例中，我们已使用getArea()作为接口Polygon中的规范。 这就像设置一个规则，即我们应该能够获取每个多边形的面积。 
//     因此，任何实现Polygon接口的类都必须提供getArea()方法的实现。
//     与抽象类相似，接口可以帮助我们实现Java抽象。在这里，我们知道getArea()计算多边形的面积，但是对于不同的多边形，计算面积的方式是不同的。因此，getArea()的实现彼此独立。
//     接口还用于在Java中实现多重继承。如果子类是从两个或多个类继承的，则它是多重继承。

//     在Java中，无法通过继承类来实现多重继承。但是，一个类可以实现多个接口。这使我们可以获得Java中多重继承的功能。

// 接口中的私有方法和静态方法

// Java 8中，接口现在可以包含静态方法。
// 与类相似，我们可以使用其引用访问接口的静态方法。
// 另外，接口在Java 9发行版中支持私有方法。现在，您可以在接口中使用私有方法和私有静态方法。
// 由于无法实例化接口，因此将私有方法用作辅助方法，以为接口中的其他方法提供支持。

// 接口中的默认方法
// Java 8中，在接口内部引入了带有实现的方法（默认方法）。
// 假设我们需要在接口中添加一个新方法。
// 我们可以轻松地在接口中添加该方法，而无需执行。但是，这还不是故事的结局。我们实现该接口的所有类都必须提供该方法的实现。
// 如果大量类正在实现此接口，则我们需要跟踪所有这些类并对其进行更改。这不仅繁琐，而且容易出错。
// 为了解决这个问题，Java引入了默认方法。默认方法像普通方法一样继承。

interface  Polygonr {
   void getArea();
   default void getSides() {
      System.out.println("我可以得到多边形的边。");
   }
}

class Rectangler implements Polygonr {
   public void getArea() {
      int length = 6;
      int breadth = 5;
      int area = length * breadth;
      System.out.println("矩形的面积是 "+area);
   }

   public void getSides() {
      System.out.println("我有四条边。");
   }
}

class Squarer implements Polygonr {
   public void getArea() {
      int length = 5;
      int area = length * length;
      System.out.println("正方形的面积是 "+area);
   }
}

class Mainr {
   public static void main(String[] args) {
      Rectangler r1 = new Rectangler();
      r1.getArea();
      r1.getSides();

      Squarer s1 = new Squarer();
      s1.getArea();
   }
}

// 接口 与 extends 关键字
// 与类相似，接口可以继承其他接口，extends关键字被用于继承接口。

interface Line {
   //Line接口的成员
}

interface Polygonl extends Line {
   //Polygon接口和Line接口的成员
}
// 现在，如果一个类实现了Polygon，则它应该为Line和Polygon的所有抽象类提供实现。

// 注意，一个接口可以继承多个接口，类似于实现多个接口的类。