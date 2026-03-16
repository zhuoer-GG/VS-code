package Indictment;

class Vehicle { }
// instanceof 运算符
// 该运算符用于操作对象示例，检查该对象是否是一个特定类型（类类型或接口类型）。
// instanceof运算符使用格式如下：
// ( Object reference variable ) instanceof  (class/interface type)
// 如果运算符左侧变量所指的对象，是操作符右侧类或接口(class/interface)的一个对象，那么结果为真。
// 下面是一个实例：
// String name = "James";
// boolean result = name instanceof String; // 由于 name 是 String 类型，所以返回真
// 如果被比较的对象兼容于右侧类型,该运算符仍然返回true。
public class Car extends Vehicle {// Car 类继承自 Vehicle 类
   public static void main(String[] args){
      Vehicle a = new Car();
      boolean result =  a instanceof Car;
      System.out.println( result);
   }
}