package object_1;

//在Java中，每个类都有它的构造函数，当类的对象被创建时，该构造函数将被自动调用。
// 一个Java方法和Java构造函数以通过其名称和返回类型进行区分。
//构造函数与类的构造函数同名，并且不返回任何值。

public class construct {
    private int x;

   // 构造函数体
   private construct(){
       System.out.println("构造函数被调用");
       x = 5;
   }
    // 构造函数的访问修饰符是私有(private)的
    // 这是因为该对象是从同一类中实例化的。因此，它可以访问构造函数。
    // 但是，如果对象是在类外部创建的，则必须声明构造函数为public才能访问它。
   public static void main(String[] args){
       //创建对象时调用构造函数
       construct obj = new construct();
       System.out.println("x 的值 = " + obj.x);
   }
}
//Java构造函数可以具有或可以不具有任何参数。如果构造函数不接受任何参数，则称为无参数构造函数。
//如果不创建任何构造函数，则Java编译器将在运行时自动创建无参数的构造函数。此构造函数称为默认构造函数。
//默认构造函数使用默认值初始化所有未初始化的实例变量。
//与方法类似，我们可以将参数传递给构造函数。此类构造函数称为参数化构造函数。
// class Vehicle {

//     int wheels;

//     //接受单个值的构造函数
//     private Vehicle(int wheels){
//         this.wheels = wheels;
//         System.out.println(wheels + " wheeler vehicle created.");
//     }

//     public static void main(String[] args) {
//         //通过传递单个值来调用构造函数
//         Vehicle v1 = new Vehicle(2);
//         Vehicle v2 = new Vehicle(3);
//         Vehicle v3 = new Vehicle(4);
//     }
// }

// 与方法重载类似，我们也可以在Java中重载构造函数
class Company {

    String domainName;

    //没有参数的构造函数
    public Company(){
        this.domainName = "default";
    }

    //具有单个参数的构造函数
    public Company(String domainName){
        this.domainName = domainName;
    }

    public void getName(){
        System.out.println(this.domainName);
    }

    public static void main(String[] args) {
        //不带参数调用构造函数
        Company defaultObj = new Company();

        //使用单个参数调用构造函数
        Company nhoooObj = new Company("(cainiaoplus.com)");
        defaultObj.getName();
        nhoooObj.getName();
    }
}

// 构造函数在实例化对象时被隐式调用。
// 创建构造函数的两个规则是：
//     构造函数的名称应与类的名称相同。
//     Java构造函数不得具有返回类型。
// 如果类没有构造函数，则Java编译器会在运行时自动创建默认构造函数。
// 默认构造函数使用默认值初始化实例变量。例如，int变量将被初始化为0
// 构造函数类型：
//     无参数构造函数  - 不接受任何参数的构造函数
//     默认构造函数  - 如果没有显式定义，Java编译器会自动创建一个构造函数。
//     参数化构造函数  - 接受参数的构造函数
// 构造函数不能是抽象的abstract 、static或final。
// 构造函数可以重载，但不能被重写。构造函数在实例化对象时被隐式调用。
// 创建构造函数的两个规则是：
//     构造函数的名称应与类的名称相同。
//     Java构造函数不得具有返回类型。
// 如果类没有构造函数，则Java编译器会在运行时自动创建默认构造函数。默认构造函数使用默认值初始化实例变量。例如，int变量将被初始化为0
// 构造函数类型：
//     无参数构造函数  - 不接受任何参数的构造函数
//     默认构造函数  - 如果没有显式定义，Java编译器会自动创建一个构造函数。
//     参数化构造函数  - 接受参数的构造函数
// 构造函数不能是抽象的abstract 、static或final。
// 构造函数可以重载，但不能被重写。