package branch_cycle;

public class LabeledBreak {
    // public static void main(String[] args) {
   
    //     //for循环标记为first 
    //     first:
    //     for( int i = 1; i < 5; i++) {

    //         //for循环标记为second
    //         second:
    //         for(int j = 1; j < 3; j ++ ) {
    //             System.out.println("i = " + i + "; j = " +j);
             
    //             //break语句终止第一个for循环
    //             if ( i == 2)
    //                 break first;
    //         }
    //     }
    // }
    //如果我们更改break first；为 break second；程序的行为将不同。
    //在这种情况下，标记为second的for循环将被终止。
    public static void main(String[] args) {
      
        //for循环标记为first
        //first:
        for( int i = 1; i < 5; i++) {

            //for循环标记为second
            second:
            for(int j = 1; j < 3; j ++ ) {

                System.out.println("i = " + i + "; j = " +j);
       
                //break语句终止标记为second的循环  
                if ( i == 2)
                    break second;
            }
        }
    }
}
