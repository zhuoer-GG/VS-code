package object_3;

// public class Reflection {
    // 在Java中，反射允许我们在运行时检查和操作类、接口、构造函数、方法和字段。
// }

// 在学习Java反射之前，我们需要了解一个名为Class的Java类。
// Java中有一个名为Class的类，该类在运行时保留有关对象和类的所有信息。
// Class对象描述了特定类的属性。该对象用于执行反射。

// 创建名为Class的类的对象
// 我们可以创建Class的对象，通过：

// 使用forName()方法
// forName()接受字符串参数（类的名称）并返回Class对象。返回的对象引用字符串指定的类。例如，
// Class Dog {  }
// Class c1 = Class.forName("Dog");

// 使用getClass()方法
//  getClass()方法使用特定类的对象来创建新的对象Class。例如，
// Dog d1 = new Dog()
// Class c1 = d1.getClass();

// 使用.class
// 我们还可以使用.class扩展名创建Class对象。例如，
// Class c1 = Dog.class;

// 创建Class对象后，我们可以使用这些对象执行反射。

// 获取接口
// 我们可以使用Class的getInterfaces()方法来收集类实现的接口的信息。此方法返回一个接口数组。
// 示例：获取接口

import java.lang.Class;
import java.lang.reflect.Modifier;
// import java.lang.reflect.*;

interface Animal {
   public void display();
}

interface Mammal {
   public void makeSound();
}

class Dog implements Animal, Mammal {
   public void display() {
      System.out.println("I am a dog.");
   }

   public void makeSound() {
      System.out.println("Bark bark");
   }
}

class ReflectionDemo {
  public static void main(String[] args) {
      try {
          //创建一个Dog类的对象
          Dog d1 = new Dog();

          //使用getClass()创建Class对象
          Class<? extends Dog> obj = d1.getClass();
        
          //查找由Dog实现的接口
          Class<?>[] objInterface = obj.getInterfaces();
          for(Class<?> c : objInterface) {

              //打印接口名称
              System.out.println("Interface Name: " + c.getName());
          }
      }

      catch(Exception e) {
          e.printStackTrace();
      }
   }
}

// 获取超类和访问修饰符
// 类Class的方法getSuperclass()可用于获取有关特定类的超类的信息。
// 而且，Class提供了一种getModifier()方法，该方法以整数形式返回class的修饰符。

// interface Animal {
//    public void display();
// }

// public class Dog implements Animal {
//    public void display() {
//        System.out.println("I am a dog.");
//    }
// }

class ReflectionDemo1 {
   public static void main(String[] args) {
       try {
           //创建一个Dog类的对象
           Dog d1 = new Dog();

           //使用getClass()创建Class对象
           Class<?> obj = d1.getClass();

           //以整数形式获取Dog的访问修饰符
           int modifier = obj.getModifiers();
           System.out.println("修饰符： " + Modifier.toString(modifier));

           //找到Dog的超类
           Class<?> superClass = obj.getSuperclass();
           System.out.println("Superclass: " + superClass.getName());
       }

       catch(Exception e) {
           e.printStackTrace();
       }
   }
}

// Java 反射与字段
//  我们可以使用Field类提供的各种方法检查和修改类的不同字段。

//     getFields() - 返回该类及其超类的所有公共字段
//     getDeclaredFields()  - 返回类的所有字段
//     getModifier() - 以整数形式返回字段的修饰符
//     set(classObject,value) - 使用指定的值设置字段的值
//     get(classObject) - 获取字段的值
//     setAccessible(boolean) - 使私有字段可访问

// 注意：如果我们知道字段名称，则可以使用
//     getField("fieldName"） - 从类返回名称为fieldName的公共字段。
//     getDeclaredField("fieldName"） - 从类返回名称为fieldName的字段。

// Java 反射与方法
// 像字段一样，我们可以使用Method类提供的各种方法来检查类的不同方法。

//     getMethods() - 返回该类及其超类的所有公共方法
//     getDeclaredMethod() - 返回该类的所有方法
//     getName() - 返回方法的名称
//     getModifiers() - 以整数形式返回方法的访问修饰符
//     getReturnType() - 返回方法的返回类型

// Java 反射与构造函数
// 我们还可以使用Constructor类提供的各种方法检查类的不同构造函数。

//    getConstructors() - 返回该类的所有公共构造函数以及该类的超类
//    getDeclaredConstructor() -返回所有构造函数
//    getName() - 返回构造函数的名称
//    getModifiers() - 以整数形式返回构造函数的访问修饰符
//    getParameterCount() - 返回构造函数的参数数量