//#include <iostream>
//using namespace std;
//int main() {
//    int* pc, c;
//
//    c = 5;
//    cout << "Address of c (&c): " << &c << endl;
//    cout << "Value of c (c): " << c << endl << endl;
//
//    pc = &c;    // 指针pc保存变量c的内存地址
//    cout << "pc持有的指针地址(pc): " << pc << endl;
//    cout << "地址指针pc持有的值(*pc): " << *pc << endl << endl;
//
//    c = 11;    // 内存地址＆c中的值从5更改为11。
//    cout << "地址指针pc持有(pc): " << pc << endl;
//    cout << "地址指针pc持有的内容(*pc): " << *pc << endl << endl;
//
//    *pc = 2;
//    cout << "Address of c (&c): " << &c << endl;
//    cout << "Value of c (c): " << c << endl << endl;
//
//    return 0;
//}