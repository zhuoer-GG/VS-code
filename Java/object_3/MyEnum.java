package object_3;

public class MyEnum {
// 在Java中，枚举是一种具有固定的可能值集的类型。我们使用enum关键字来声明枚举。例如，
enum Size { 
   SMALL, MEDIUM, LARGE, EXTRALARGE 
}
// 在这里，我们创建了一个名为Size的枚举。
// 花括号内的值称为枚举值（常量）。这些是枚举类型可以保留的唯一值。
// 注意：枚举常量通常以大写形式表示。

// 同样，我们可以创建枚举类型的变量。例如，
Size pizzaSize;
// 在这里，pizzaSize是Size类型的变量。它只能分配4个值。

static class Test {
 Size pizzaSize;
 public Test(Size pizzaSize) {
   this.pizzaSize = pizzaSize;
 }
 public void orderPizza() {
   switch(pizzaSize) {
     case SMALL:
       System.out.println("我点了一个小号比萨饼。");
       break;
     case MEDIUM:
       System.out.println("我点了一个中号的披萨。");
       break;
     default:
       System.out.println("我不知道该点哪一种。");
       break;
   }
 }
}
public static void main(String[] args) {
    Test t1 = new Test(Size.MEDIUM);
    t1.orderPizza();
    }
}
// 在上面的程序中，我们创建了一个枚举类型Size。然后，我们声明Size类型的变量pizzaSize。
// 变量pizzaSize只能分配4个值（SMALL，MEDIUM，LARGE，EXTRALARGE）。
// 变量pizzaSize分配了MEDIUM常数。 基于此，将打印switch case语句的一种情况


// Java枚举类

// 在Java中，枚举类型被认为是类的一种特殊类型。它是在Java 5发行版中引入的。
// 枚举类可以像常规类一样包含方法和字段。
// enum Size {
//     constant1, constant2, …, constantN;

//     //方法和字段
// }
// 枚举常量始终默认为public static final。
// 当创建enum类时，编译器还将创建每个enum常量的实例(对象)。
enum Size{
   SMALL, MEDIUM, LARGE, EXTRALARGE;

   public String getSize() {

      //这将引用对象SMALL
      switch(this) {
         case SMALL:
          return "small";

         case MEDIUM:
          return "medium";

         case LARGE:
          return "large";

         case EXTRALARGE:
          return "extra large";

         default:
          return null;
      }
   }

   public static void main(String[] args) {

      //使用对象SMALL调用方法getSize()
      System.out.println("披萨的大小是 " + Size.SMALL.getSize());
   }
}
// 在上面的示例中，我们创建了一个枚举类 Size。它有四个常数 SMALL，MEDIUM，LARGE和EXTRALARGE。
// 由于Size是枚举类，因此编译器会自动为每个枚举常量创建实例。
// 在main()方法内部，我们已使用实例SMALL调用getSize()方法。


// 枚举类的方法
// 枚举类中有一些预定义的方法可以随时使用。

// ordinal()方法
// ordinal()方法返回枚举常量的位置。例如，
// ordinal(SMALL) 
//返回 0

// compareTo()方法
// compareTo()方法根据序数值比较枚举常量。例如，
// Size.SMALL.compareTo(Size.MEDIUM)
 //返回 ordinal(SMALL) - ordinal(MEDIUM)

// toString()方法
// toString()方法返回枚举常量的字符串表示形式。例如，
// SMALL.toString()
//返回 "SMALL"

// name()方法
// name()方法以字符串形式返回枚举常量的定义名称。name()方法返回的值为final。例如，
// name(SMALL)
//返回 "SMALL"

// valueOf()方法
// valueOf()方法采用字符串，并返回具有相同字符串名称的枚举常量。例如，
// Size.valueOf("SMALL")
//返回常量 SMALL

// values()方法
// values()方法返回包含所有枚举常量的枚举类型数组。例如，
// Size[] enumArray = Size.value();

// 在Java中，枚举类可能包含类似于常规类的构造函数。这些枚举构造函数是
    // private-在类内可以访问
    // 或
    // package-private - 可在包内访问

// 示例：枚举构造函数
enum Size1 {

   //枚举常量，调用枚举构造函数
   SMALL("尺寸很小。"),
   MEDIUM("尺寸中等。"),
   LARGE("尺寸很大。"),
   EXTRALARGE("尺寸超大。");

   private final String pizzaSize;

   //私有枚举构造函数
   private Size1(String pizzaSize) {
      this.pizzaSize = pizzaSize;
   }

   public String getSize() {
      return pizzaSize;
   }
}

class Main1 {
   public static void main(String[] args) {
      Size size = Size.SMALL;
      System.out.println(size.getSize());
   }
}
// 在上面的示例中，我们创建了一个enum Size。它包含一个private枚举构造函数。构造函数将字符串值作为参数，并将值分配给变量pizzaSize。
// 由于构造函数是private，我们无法从类外部访问它。但是，我们可以使用枚举常量来调用构造函数。
// 在Main类中，我们将SMALL分配给枚举变量size。 然后，常量SMALL以字符串为参数调用构造函数Size。
//  最后，我们使用size调用getSize()。 


// 更改枚举的默认字符串值
// 我们可以通过重写toString()方法来更改枚举常量的默认字符串表示形式。例如，

enum Size2 {
   SMALL {

      //重写toString()为SMALL
      public String toString() {
        return "The size is small.";
      }
   },

   MEDIUM {

     //重写toString()为MEDIUM
      public String toString() {
        return "The size is medium.";
      }
   };
}

// class Main {
//    public static void main(String[] args) {
//       System.out.println(Size.MEDIUM.toString());
//    }
// }

// 输出结果
// The size is medium.
// 在上面的程序中，我们创建了一个枚举Size。并且我们已经重写了枚举常量SMALL和MEDIUM的toString()方法。
// 注意：我们无法重写name()方法。这是因为name()方法是final类型。