package object_2;

public class polymorphic {
    // 多态是面向对象编程的重要概念。它只是意味着不止一种形式。
    // 也就是说，同一实体（方法，运算符或对象）在不同情况下的行为会有所不同

    // 在Java中，多态可以分为两种类型：

    // 运行时多态
    // 在Java中，可以通过方法重写来实现运行时多态。
    // 假设在父类及其子类中创建了相同的方法。在这种情况下，将要调用的方法取决于用于调用该方法的对象。
    abstract class Animal {
    public abstract void makeSound();
    }

    class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark bark..");
    }
    }

    class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow meow..");
    }
    }
    // 在上面的示例中，该方法makeSound()在两个不同的类中具有不同的实现。
    // 在程序执行期间确定将要调用的方法。因此，方法重写是运行时多态。
    
    
    // 编译时多态

    // 可以通过Java中的方法重载和运算符重载来实现编译时多态。
    // 在Java类中，如果参数不同，则可以使用相同的名称创建方法。例如，

    void func() {   }
    void func(int a) {   }
    float func(double a) {  return 0;  }
    float func(int a, float b) {  return 0;  }

    // 这在Java中称为方法重载。


    // 运算符重载

    // Java中的某些运算符对不同的操作数的行为有所不同。 
    // Java中的+运算符用于执行两个特定功能。与数字（整数和浮点数）一起使用时，将执行加法运算。例如，

    int a = 5;
    int b = 6;
    int sum = a + b;     //  sum = 11

    // 当我们将+运算符与字符串一起使用时，它将执行字符串连接。例如，

    String firstName = "abc ";
    String lastName = "xyz";
    String name = firstName + lastName;     //  name = abc xyz

    // 在像C ++这样的语言中，我们可以定义运算符以对不同的操作数进行不同的处理。但是，Java不支持用户定义的运算符重载。    
}

// 多态变量
// 在Java中，对象变量（实例变量）表示多态变量的行为。
// 这是因为类的对象变量可以引用其类的对象及其子类的对象。例如，

class AnimalP {
   public void displayInfo() {
      System.out.println("I am an animal.");
   }
}

class DogP extends AnimalP {
   @Override
   public void displayInfo() {
      System.out.println("I am a dog.");
   }
}

class MainP {
   public static void main(String[] args) {
    
      //声明Animal类的对象变量a1
      AnimalP a1;
    
     //创建Animal类的对象
      a1 = new AnimalP();
      a1.displayInfo();
     //dog类的对象创建
      a1 = new DogP();
      a1.displayInfo();
   }
}
// 在上面的示例中，我们创建了Animal类的对象变量a1。在这里，a1是一个多态变量。
// 这是因为，
//     在语句中 a1 = new Animal()，a1引用Animal类的对象。
//     在语句中 a1 = new Dog()，a1引用Dog类的对象。