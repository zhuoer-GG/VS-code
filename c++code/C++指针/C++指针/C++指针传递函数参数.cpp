//#include<iostream>	
//using namespace std;
//
//void swap1(int&, int&);
//void swap2(int*, int*);
//
//int main() {
//    int a = 11, b = 22;
//    cout << "交换之前" << endl;
//    cout << "a = " << a << endl;
//    cout << "b = " << b << endl;
//
//    swap1(a, b);
//
//    cout << "\n交换之后" << endl;
//    cout << "a = " << a << endl;
//    cout << "b = " << b << endl;
//
//    swap2(&a, &b);
//
//    cout << "\n交换之后" << endl;
//    cout << "a = " << a << endl;
//    cout << "b = " << b << endl;
//	return 0;
//}
//
//void swap1(int& n1, int& n2) {
//    //函数中仅接收变量a和b的引用（地址），并且交换发生在变量的原始地址中
//    int temp;
//    temp = n1;
//    n1 = n2;
//    n2 = temp;
//}
//void swap2(int* n1, int* n2) {
//    //变量的地址是在函数调用期间传递的，而不是变量本身
//    // 由于传递的是地址而不是值，因此必须使用解引用运算符来访问存储在该地址中的值
//    int temp;
//    temp = *n1;
//    *n1 = *n2;
//    *n2 = temp;
//}