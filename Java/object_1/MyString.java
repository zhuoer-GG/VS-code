package object_1;

public class MyString {
    //创建一个字符串
    String type = "java programming";
    public static void main(String[] args) {

    //创建字符串
    String greet = "Hello! World";
    System.out.println("字符串是: " + greet);

    //checks the string length
    System.out.println("字符串的长度: " + greet.length());

    //创建字符串
    String greet1 = "Hello! ";
    System.out.println("第一个字符串: " + greet1);

    String name = "World";
    System.out.println("第二个字符串: " + name);

    //连接两个字符串
    String joinedString = greet1.concat(name);
    System.out.println("连接后的字符串: " + joinedString);
    // String joinedString = greet + name;
    //在Java中，我们还可以使用 + 运算符来连接两个字符串。

    //创建字符串s
    String first = "java programming";
    String second = "java programming";
    String third = "python programming";

    //比较第一个字符串和第二个字符串
    boolean result1 = first.equals(second);
    System.out.println("第一和第二个字符串相等: " + result1);

    //比较第一个和第三个字符串
    boolean result2 = first.equals(third);
    System.out.println("第一和第三个字符串相等: " + result2);
    // 在上面的示例中，我们使用了equals()方法来比较两个字符串的值。
    // 如果两个字符串相同，则该方法返回true，否则返回false。
    // 注意：我们还可以使用 == 运算符 和 compareTo()方法比较2个字符串。


    //返回位置3处的字符
    System.out.println("位置3处的字符: " + greet.charAt(3));

    //返回位置7处的字符
    System.out.println("位置7处的字符: " + greet.charAt(7));
    //使用了charAt()方法从指定位置访问字符

    //创建字符串 using the new keyword
    String example = new String("Hello! World");

    //返回子字符串World
    System.out.println("使用 subString(): " + example.substring(7));

    //将字符串转换为小写
    System.out.println("使用 toLowerCase(): " + example.toLowerCase());

    //将字符串转换为大写
    System.out.println("使用 toUpperCase(): " + example.toUpperCase());

    //替换字符'!”为“o”
    System.out.println("使用 replace(): " + example.replace('!', 'o'));

    //创建字符串使用new关键字
    // String name1 = new String("java string");

    // 在上面的示例中，我们使用了new关键字和构造函数String()来创建一个字符串。
    //  如果字符串已经存在， 不会创建新字符串。相反，新引用指向现有字符串。
    //  如果字符串不存在，则创建新字符串。
    //  但是，在使用new关键字创建字符串时，不会直接提供字符串的值。因此，新字符串总是被创建。
  }
}
