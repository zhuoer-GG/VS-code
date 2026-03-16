package branch_cycle;

public class LabeledContinue {
    public static void main(String[] args) {

        //外部for循环标记为label     
        first:
        for (int i = 1; i < 6; ++i) {
            for (int j = 1; j < 5; ++j) {
                if (i == 3 || j == 2)

                    //跳过标签的迭代(外部for循环)
                    continue first;
                System.out.println("i = " + i + "; j = " + j); 
            }
        } 
        //在上面的示例中，使用带标签的continue语句跳过标记为first的循环的当前迭代。
        //通常不建议使用带标签的continue，因为这会使代码难以理解
    }
}
