package object_2;

public class MySuper {
    // super关键字的使用

    //  调用子类中重写的父类的方法。
    // 如果超类(superclass)和子类(subclass)都有同名的属性，则访问超类的属性(字段)。
    // 从子类构造函数显式地调用超类无参数化构造函数或参数化构造函数。
}
class Animal {

  //方法
  public void display(){
    System.out.println("I am an animal");
  }
}

class Dog extends Animal {

  //重写方法
  @Override
  public void display(){
    System.out.println("I am a dog");
  }

  public void printMessage(){

    //这调用重写方法
    display();

    // 这调用父类的方法
    super.display();
  }
}

class Main {
  public static void main(String[] args) {
    Dog dog1 = new Dog();
    dog1.printMessage();
  }
}

// 访问超（父）类的属性

// 超类和子类可以具有相同名称的属性。我们使用super关键字来访问超类的属性。
// 示例3：访问超类属性

class Animal4 {
  protected String type="动物";
}

class Dog4 extends Animal4 {
  public String type="哺乳动物";

  public void printType() {
    System.out.println("我是 " + type);
    System.out.println("我是一只 " + super.type);
  }
}
// 在这个实例中，我们在超类Animal和子类Dog中定义了相同的实例字段类型。
// 然后我们创建了Dog类的对象dog1。然后，使用此对象调用printType()方法。

// 在printType()函数内部，
//     type  - 指的是子类Dog的属性。
//     super.type  - 指超类Animal的属性。

class Main4 {
  public static void main(String[] args) {
    Dog4 dog1 = new Dog4();
    dog1.printType();
  }
}

// 使用super()访问超类构造函数
// 众所周知，创建类的对象时，将自动调用其默认构造函数。
// 要从子类构造函数中显式调用超类构造函数，我们使用super()。这是super关键字的一种特殊形式。
// 注意：super() 只能在子类构造函数中使用，并且必须是第一条语句。

class Animal5 {

  //Animal类的默认或无参数构造函数
  Animal5() {
    System.out.println("I am an animal");
  }
}

class Dog5 extends Animal {

  // Dog类的默认或无参数构造函数
  Dog5() {

    //调用超类的默认构造函数
    super();

    System.out.println("I am a dog");
  }
}

class Main5 {
  public static void main(String[] args) {
    // Dog dog1 = new Dog();
    // 在这里，当Dog类的对象dog1被创建时，它会自动调用该类的默认或无参数构造函数。
    // 在子类构造函数中，super()语句调用超类的构造函数并执行其中的语句。
  }
}
// 但是，不是必须使用super()。 即使在子类构造函数中没有使用super()，编译器也会隐式调用超类的默认构造函数。
// 那么，如果编译器自动调用super()，为什么还要显式它，而使用冗余代码呢？
// 如果必须从子类构造函数中调用超类的参数化构造函数（带有参数的构造函数），则必须显式地使用它。
// 带参数的super()必须始终是子类的构造函数体中的第一个语句，否则，将出现编译错误。