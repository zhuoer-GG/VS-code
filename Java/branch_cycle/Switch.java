package branch_cycle;
import java.util.Scanner;

public class Switch {
     public static void main(String[] args) {

        char operator;
        Double number1, number2, result;

        //创建一个Scanner类的对象
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入运算符 (选项： +, -, * 或 /): ");

        //要求用户输入运算符
        operator = scanner.next().charAt(0);
        System.out.print("分别输入数字1和数字2: ");

        //要求用户输入数字
        number1 = scanner.nextDouble();
        number2 = scanner.nextDouble();

        switch (operator) {

            //两个数字相加
            case '+':
                result = number1 + number2;
                System.out.print(number1 + "+" + number2 + " = " + result);
                break;

            //两个数字相减
            case '-':
                result = number1 - number2;
                System.out.print(number1 + "-" + number2 + " = " + result);
                break;

            //两个数字相乘
            case '*':
                result = number1 * number2;
                System.out.print(number1 + "*" + number2 + " = " + result);
                break;

            //两个数字相除
            case '/':
                result = number1 / number2;
                System.out.print(number1 + "/" + number2 + " = " + result);
                break;

            default:
                System.out.println("Invalid operator!");
                break;
        }
        //关闭scanner对象
        scanner.close();
    }
}
