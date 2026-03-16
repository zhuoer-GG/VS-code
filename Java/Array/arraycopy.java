package Array;

public class arraycopy {
    public static void main(String[] args) {
      
        int [] numbers = {1, 2, 3, 4, 5, 6};
        int [] positiveNumbers = numbers;    //复制数组
      
        //更改第一个数组的值
        numbers[0] = -1;

        //打印第二个数组
        for (int number: positiveNumbers) {
            System.out.print(number + ", ");
        }
    }
}
//在上面的示例中，我们使用赋值运算符（=）将一个名为numbers的数组复制到另一个名为positiveEnumbers的数组中。 
//这种技术是最简单的一种，它同样有效。然而，这种技术有一个问题。如果我们改变一个数组的元素，其他数组的相应元素也会改变。
//这是因为两个数组都引用相同的数组对象。这是因为浅拷贝。