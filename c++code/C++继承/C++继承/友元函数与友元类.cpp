////如果将函数定义为友元函数，则可以使用函数访问类的私有数据和受保护数据。
////要访问数据，应该在类的内部以关键字friend开始声明友元函数
//// (可以是类内部的任何地方，可以是private部分，也可以是public部分)
//#include <iostream>
//using namespace std;
//
////class Distance
////{
////private:
////    int meter;
////public:
////    Distance() : meter(0) { }
////    //友元函数
////    friend int addFive(Distance);
////};
////
////// 友元函数的定义
////int addFive(Distance d)
////{
////    //从非成员函数访问私有数据
////    d.meter += 5;
////    return d.meter;
////}
////
////int main()
////{
////    Distance D;
////    cout << "距离: " << addFive(D);
////    return 0;
////}
//
////使用友元函数添加两个不同类的成员
//// 前置声明,因为使用以下代码在class A中引用了class B的友元函数：friend int add（A，B）;
//class B;
//class A {
//private:
//    int numA;
//public:
//    A() : numA(12) { }
//    //友元函数声明
//    friend int add(A, B);
//};
//
//class B {
//private:
//    int numB;
//public:
//    B() : numB(1) { }
//    // 友元函数声明
//    friend int add(A, B);
//};
//
////函数add()是类A和B的友元函数
////访问成员变量numA和numB
//int add(A objectA, B objectB)
//{
//    return (objectA.numA + objectB.numB);
//}
//
//int main()
//{
//    A objectA;
//    B objectB;
//    cout << "Sum: " << add(objectA, objectB);
//    return 0;
//}
//
////类似地，像一个友元函数一样，一个类也可以使用关键字friend成为另一个类的友元类。
////class B;
////class A
////{
////    // class B 是 class A的友元类
////    friend class B;
////    ... .. ...
////}
////class B
////{
////    ... .. ...
////}
////B类的所有成员函数都是A类的朋友函数，
//// 因此B类的任何成员函数都可以访问A类的私有和受保护的数据，但是A类的成员函数不能访问B类的数据