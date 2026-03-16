package Array;
import java.util.Arrays;

public class cyclecopy {
    public static void main(String[] args) {
      
        int [] source = {1, 2, 3, 4, 5, 6};
        int [] destination = new int[6];

        //迭代并将元素从源复制到目标
        for (int i = 0; i < source.length; ++i) {
            destination[i] = source[i];
        }
      
         //将数组转换为字符串
        System.out.println(Arrays.toString(destination));
    }
}
//在上面的示例中，我们使用了for循环来遍历源数组的每个元素。
//在每次迭代中，我们都将元素从source数组复制到destination数组。
//在这里，源和目标数组引用不同的对象（深度复制）
//如果一个数组的元素被更改，另一个数组的相应元素也将保持不变。 