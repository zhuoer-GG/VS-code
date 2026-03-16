package Array;

//在Java中，这是我们如何声明数组的方法
// dataType[] arrayName;
// data = new Double[10];
// 这里，数组的大小是10。这意味着它可以容纳10个元素

public class ArrayExample {
    public static void main(String[] args) {

        //创建一个数组
        int[] age = {12, 4, 5, 2, 5};

        // 通过数组索引值访问数组元素
        for (int i = 0; i < 5; ++i) {
            System.out.println("元素索引 " + i +": " + age[i]);
        }
    }
}
