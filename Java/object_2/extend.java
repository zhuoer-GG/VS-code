package object_2;

public class extend {
    
}

class Animal {

   public void eat() {
      System.out.println("I can eat");
   }

   public void sleep() {
      System.out.println("I can sleep");
   }
}

class Dog extends Animal {
   public void bark() {
      System.out.println("I can bark");
   }
}

class Main {
   public static void main(String[] args) {

      Dog dog1 = new Dog();

      dog1.eat();
      dog1.sleep();

      dog1.bark();
   }
}
// 在Java中，我们使用extends关键字从类继承。在这里，我们从Animal类继承了Dog类。
// Animal是超类（父类或基类），而Dog是子类（子类或派生类）。 子类继承超类的字段和方法。

class Animal1 {
   public Animal1() {
     System.out.println("I am an Animal");
   }

   public void eat() {
     System.out.println("I can eat");
   }
}

class Dog1 extends Animal1 {
   public Dog1(){
      super();
      System.out.println("I am a dog");
   }

  @Override
  public void eat() {
     super.eat();
     System.out.println("I eat dog food");
  }

   public void bark() {
      System.out.println("I can bark");
   }
}
// 在这里，我们使用了super关键字通过super()来调用构造函数。
// 另外，我们使用super.eat()调用Animal超类的eat()方法。
class Main1 {
   public static void main(String[] args) {
      Dog1 dog1 = new Dog1();

      dog1.eat();
      dog1.bark();
   }
}