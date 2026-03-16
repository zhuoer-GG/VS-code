package object_3;

// public class nesting {
    // 在Java中，您可以在另一个类中定义一个类。这样的类称为nested class（嵌套类）。例如，

class OuterClass {
    // ...
    class NestedClass {
        // ...
    }
}
// }
// 非静态嵌套类（内部类）
// 非静态嵌套类是另一个类中的一个类。它有权访问封闭类（外部类）的成员。它通常被称为inner class（内部类）。
// 由于内部类存在于外部类中，因此必须首先实例化外部类，以便实例化内部类。
class CPU {
    double price;
    // 嵌套类
    class Processor{

        //嵌套类的成员
        double cores;
        String manufacturer;

        double getCache(){
            return 4.3;
        }
    }

    //嵌套受保护的类
    protected class RAM{

        //受保护的嵌套类的成员
        double memory;
        String manufacturer;

        double getClockSpeed(){
            return 5.5;
        }
    }
}

public class nesting {
    public static void main(String[] args) {

        //创建外部类CPU的对象
        CPU cpu = new CPU();

       //使用外部类创建内部类Processor的对象
        CPU.Processor processor = cpu.new Processor();
        // 我们使用点（.）运算符使用外部类创建内部类的实例。

        //使用外部类CPU创建内部类RAM的对象
        CPU.RAM ram = cpu.new RAM();
        System.out.println("Processor Cache = " + processor.getCache());
        System.out.println("Ram Clock speed = " + ram.getClockSpeed());
    }
}

// 访问内部类中的外部类成员
// 我们可以使用this关键字访问外部类的成员。

class Car {
    String carName;
    String carType;

    //使用构造函数赋值
    public Car(String name, String type) {
        this.carName = name;
        this.carType = type;
    }

    // private 方法
    private String getCarName() {
        return this.carName;
    }

    //内部类
    class Engine {
        String engineType;
        void setEngine() {

           //访问Car的carType属性
            if(Car.this.carType.equals("4WD")){
            // 我们使用this关键字来访问carType外部类的变量。您可能已经注意到，使用Car.this.carType而不是使用this.carType。
            // 这是因为如果我们没有提到外部类的名称Car，那么this关键字将表示内部类中的成员。

                //调用Car的getCarName()方法
                if(Car.this.getCarName().equals("Crysler")) {
                // 需要注意的是，尽管getCarName()是一个private方法，但我们能够从内部类访问它。
                    this.engineType = "Smaller";
                } else {
                    this.engineType = "Bigger";
                }

            }else{
                this.engineType = "Bigger";
            }
        }
        String getEngineType(){
            return this.engineType;
        }
    }
}

// 静态嵌套类
// 在Java中，我们还可以在另一个类中定义一个静态（static）类。 这种类称为静态嵌套类（static nested class）。 静态嵌套类不称为静态内部类。
// 与内部类不同，静态嵌套类无法访问外部类的成员变量。这是因为静态嵌套类不需要您创建外部类的实例。
// OuterClass.NestedClass obj = new OuterClass.NestedClass();
// 在这里，我们仅通过使用外部类的类名来创建静态嵌套类的对象。因此，不能使用OuterClass.this引用外部类。

class MotherBoard {
   String model;
   public MotherBoard(String model) {
       this.model = model;
   }

   //静态嵌套类
   static class USB{
       int usb2 = 2;
       int usb3 = 1;
       int getTotalPorts(){
           //访问外部类的变量model
        //    if(MotherBoard.this.model.equals("MSI")) {
            // 当我们尝试运行该程序时，将出现错误
            // 这是因为我们没有使用外部类的对象来创建内部类的对象。 
            // 因此，没有引用存储在Motherboard.this中的外部类Motherboard。
            //    return 4;
        //    }
        //    else {
            //    return usb2 + usb3;
        //    }
              return usb2 + usb3;
       }
   }
}

// 要记住的要点
//     Java将内部类视为类的常规成员。它们就像在类中声明的方法和变量一样。
//     由于内部类是外部类的成员，所以可以将任何访问修饰符(如private、protected)应用到内部类，这在普通类中是不可能的。
//     由于嵌套类是其封闭的外部类的成员，因此您可以使用点（.）表示法访问嵌套类及其成员。
//     使用嵌套的类将使您的代码更具可读性，并提供更好的封装。
//     非静态嵌套类（内部类）可以访问外部/封闭类的其他成员，即使它们被声明为私有的也是如此。


//   创建外部类的对象
//   Animal animal = new Animal();

//   非静态类的对象创建
//   Animal.Reptile reptile = animal.new Reptile();
//   reptile.displayInfo();

//   静态嵌套类的对象创建
//   Animal.Mammal mammal = new Animal.Mammal();
//   mammal.displayInfo();

// 只有嵌套类可以是静态的。我们不能有静态的顶级类。