#include <iostream>
using namespace std;

enum designFlags {
    BOLD = 1,
    ITALICS = 2,
    UNDERLINE = 4
};
//积分常数是2的幂，所以可以同时组合两个或多个标志，而不用使用按位或|操作符进行重叠

int main()
{
    int myDesign = BOLD | UNDERLINE;

    //    00000001
    //  | 00000100
    //  ___________
    //    00000101

    cout << myDesign;

    //可以检查一个标志是否包含BOLD样式，通过检查myDesign & BOLD是否非零

    if (myDesign & ITALICS) {
        // 斜体代码
    }
    //在设计中添加了斜体。注意，只有斜体代码写在if语句中


    //如果将来需要添加或修改设计标志，你只需要在枚举定义中进行更改，而不需要在代码的多个地方进行修改。
    
    return 0;
}