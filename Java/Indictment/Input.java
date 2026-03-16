package Indictment;
import java.util.Scanner;//为了使用的对象Scanner，我们需要导入java.util.Scanner包。

class Input {
    public static void main(String[] args) {
    	
        Scanner input = new Scanner(System.in);
    	//创建Scanner类对象。我们可以使用该对象从用户那里获取输入
        System.out.print("输入一个整数: ");
        int number = input.nextInt();
        //调用Scanner类的nextInt()方法以从用户获取整数输入
        System.out.println("您输入 " + number);

        //获取float输入
        System.out.print("Enter float: ");
        float myFloat = input.nextFloat();
        System.out.println("Float entered = " + myFloat);
    	
        //获取double输入
        System.out.print("Enter double: ");
        double myDouble = input.nextDouble();
        System.out.println("Double entered = " + myDouble);
    	
        //获取字符串输入
        System.out.print("Enter text: ");
        String myString = input.next();
        System.out.println("Text entered = " + myString);

        //关闭scanner对象
        input.close();
        //建议一旦输入，就关闭scanner对象。

    }
}