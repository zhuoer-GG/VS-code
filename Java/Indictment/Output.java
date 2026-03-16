package Indictment;

public class Output {
        public static void main(String[] args) {
    	// System 是一个类
        // out 是一个public static字段：它接受输出数据。

        System.out.println("1. println ");
        System.out.println("2. println ");
    	
        System.out.print("1. print ");
        System.out.print("2. print");

    // print() - 它在引号内打印字符串。

    // println() - 它在引号内打印字符串，类似于print()方法。然后光标移动到下一行的开头。

    // printf() - Tt提供字符串格式化（类似于C / C ++编程中的printf）。

        Double number = -10.6;
        System.out.println(5);
        System.out.println(number);
        //为了显示整数、变量等等，我们没有使用引号

        System.out.println("I am " + "awesome.");
        //使用了+运算符来连接（串联）两个字符串
        System.out.println("Number = " + number);
        //首先求变量number的值。 然后将该值连接到字符串
    }
}
