package object_1;

// 在Java中，instanceof关键字是二进制运算符。它用于检查对象是否是特定类的实例。
// 运算符还检查对象是否是实现接口的类的实例（将在本教程后面讨论）。
// instanceof的语法为：

// result = objectName instanceof className;

//  instanceof运算符的左操作数是对象名，右操作数是类名。如果对象是类的实例，则结果为true；如果不是，则为false。

class Myinstanceof {
    public static void main (String[] args) {
        String name = "nhooo";
        Integer age = 22;

        System.out.println("name是String的实例吗: "+ (name instanceof String));
        System.out.println("age是Integer的实例吗: "+ (age instanceof Integer));
    }
}

// instanceof 和 继承
// 在继承的情况下，instanceof运算符用于检查子类的对象是否也是超类的实例。
class Animal {
}

//Dog类是Animal的子类
class Dog extends Animal {
}

class Main {
    public static void main(String[] args){
        Dog d1 = new Dog();

        //检查d1是否是Dog的对象
        System.out.println("d1是Dog的实例吗: "+ (d1 instanceof Dog));
       
        //检查d1是否是Animal的对象
        System.out.println("d1是Animal的实例吗: "+ (d1 instanceof Animal));
    }
}
// 在上面的示例中，d1是Dog和Animal类的实例。 因此，d1 instanceof Dog 和 d1 instanceof Animal 都为true。

// 在Java中，所有类都继承自Object类，继承Object类不使用extends关键字。这种继承在Java中隐式发生。

// 对象向上转型和向下转型
// 在Java中，子类的对象可以视为父类的对象。这称为向上转型。
// 通俗地讲即是将子类对象转为父类对象。此处父类对象可以是接口。
// Java编译器自动执行向上转型。
class Animal1 {
    public void displayInfo() {
        System.out.println("I am an animal.");
    }
}

class Dog1 extends Animal1 {
}

class Main1 {
    public static void main(String[] args) {
        Dog1 d1 = new Dog1();
        Animal1 a1 = d1;
        a1.displayInfo();
    }
}
// 在上面的实例中，我们创建了Dog类的对象d1。我们使用d1对象来创建Animal类的对象a1。
// 这在Java中称为向上转型。
// 该代码执行没有任何问题。这是因为向上转型是由Java编译器自动完成的。

// 向下转型是向上转型的相反过程，也就是与向上转型相反，即是把父类对象转为子类对象。
// 在向下转型的情况下，父类的对象被视为子类的对象。我们必须在Java中显式地指示编译器向下转型。

// 使用instanceof解决向下类型转换

class Animal2 {
}

class Dog2 extends Animal2 {
  public void displayInfo() {
     System.out.println("I am a dog");
  }
}

class Main2 {
  public static void main(String[] args) {
    Dog2 d1 = new Dog2();
    Animal2 a1 = d1;    // 向上转型

    if (a1 instanceof Dog2){
       Dog2 d2 = (Dog2)a1;    // 向下转型
       d2.displayInfo();
    }
  }
}
// 在上面的示例中，我们使用instanceof运算符检查a1对象是否为Dog类的实例。
// 仅当表达式a1 instanceof Dog为true时才进行向下类型转换。

// 接口中的instanceof

interface Animal3 {
}

class Dog3 implements Animal3 {
}

class Main3 {
   public static void main(String[] args) {
      Dog3 d1 = new Dog3();
      System.out.println("d1对象是Animal3的实例吗: "+(d1 instanceof Animal3));
   }
}

// 在上面的示例中，我们创建了一个Dog实现Animal接口的类。
// 然后，创建Dog类的对象d1。我们已经使用instanceof运算符来检查d1对象是否也是Animal接口的实例。