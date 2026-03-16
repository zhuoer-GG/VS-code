//#include <iostream>
//
//// 函数声明 
//void func(void);
//
//static int count = 25; /* 全局变量 */
////当 static 修饰全局变量时，会使变量的作用域限制在声明它的文件内
//
//int main()
//{
//    while (count--)
//    {
//        func();
//    }
//    return 0;
//}
//// 函数定义
//void func(void)
//{
//    static int i = 8; // 局部静态变量
//    //static 修饰局部变量可以在函数调用之间保持局部变量的值
//    i++;
//    std::cout << "变量 i 为 " << i;
//    std::cout << " , 变量 count 为 " << count << std::endl;
//}