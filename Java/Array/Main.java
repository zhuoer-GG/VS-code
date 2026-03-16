package Array;
import java.util.Arrays;
//在Java中，System类包包含一个名为arraycopy()的方法来复制数组。
// arraycopy(Object src, int srcPos,Object dest, int destPos, int length)
// src -您要复制的源数组
// srcPos -源数组中的起始位置（索引）
// dest -目标数组，将从源中复制元素
// destPos -目标数组中的起始位置（索引）
// length -要复制的元素数
public class Main {
     public static void main(String[] args) {
        int[] n1 = {2, 3, 12, 4, 12, -2};
      
        int[] n3 = new int[5];

        //创建长度为n1的n2数组
        int[] n2 = new int[n1.length];
      
        //将整个n1数组复制到n2
        System.arraycopy(n1, 0, n2, 0, n1.length);
        System.out.println("n2 = " + Arrays.toString(n2));  
      
         //从n1数组的索引2复制元素
         //将元素复制到n3数组的索引1
        //将复制2个元素
        System.arraycopy(n1, 2, n3, 1, 2);
        System.out.println("n3 = " + Arrays.toString(n3));  
        //int类型数组元素的默认初始值为0

        //类似于一维数组，我们还可以使用for循环来复制二维数组
        int[][] source = {
              {1, 2, 3, 4}, 
              {5, 6},
              {0, 2, 42, -4, 5}
              };

        int[][] destination = new int[source.length][];

        // for (int i = 0; i<destination.length; ++i) {

        //     //为目标数组的每一行分配空间
        //     destination[i] = new int[source[i].length];

        //     for (int j = 0; j<destination[i].length; ++j) {
        //         destination[i][j] = source[i][j];
        //     }
        // }
     
        //显示目标数组
        System.out.println(Arrays.deepToString(destination));
        //在这里，使用deepToString()方法提供二维数组的更好表示

        //为了使上面的代码更简单，我们可以使用System.arraycopy()替换内部循环，就像处理一维数组一样
        for (int i = 0; i<source.length; ++i) {

             //为目标数组的每一行分配空间
             destination[i] = new int[source[i].length];
             System.arraycopy(source[i], 0, destination[i], 0, destination[i].length);
        }
     
        //显示目标数组
        System.out.println(Arrays.deepToString(destination));  
    }
}
