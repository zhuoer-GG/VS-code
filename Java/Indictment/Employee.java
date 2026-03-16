package Indictment;
//Java语言支持的变量类型有：
//     类变量：独立于方法之外的变量，用 static 修饰。
//    实例变量：独立于方法之外的变量，不过没有 static 修饰。
//    局部变量：类的方法中的变量
// public class Variable {
//     static int allClicks=0;    // 类变量
 
//     String str="hello world";  // 实例变量
 
//     public void method(){
 
//         int i =0;  // 局部变量
 
//     }
// }
public class Employee{
   // 这个实例变量对子类可见
   public String name;
   // 私有变量，仅在该类可见
   private double salary;
   //在构造器中对name赋值
   public Employee (String empName){
      name = empName;
   }
   //设定salary的值
   public void setSalary(double empSal){
      salary = empSal;
   }  
   // 打印信息
   public void printEmp(){
      System.out.println("名字 : " + name );
      System.out.println("薪水 : " + salary);
   }
 
   public static void main(String[] args){
      Employee empOne = new Employee("nhooo");
      empOne.setSalary(1000.0);
      empOne.printEmp();
   }
}