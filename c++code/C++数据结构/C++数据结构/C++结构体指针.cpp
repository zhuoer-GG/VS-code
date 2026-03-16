//#include <iostream>
//using namespace std;
//
//struct Distance
//{
//    int feet;
//    float inch;
//};
//
//int main()
//{
//    Distance* ptr, d;
//
//    ptr = &d;
//    //变量d的地址存储在指针变量中，即ptr指向变量d，然后使用指针访问变量d的成员函数
//    //（* ptr）.inch和d.inch是完全相同的单元
//    //使用指针访问成员函数:  ptr->feet 等同于  (*ptr).feet
//
//    cout << "输入英尺: ";
//    cin >> (*ptr).feet;
//    cout << "输入英寸: ";
//    cin >> (*ptr).inch;
//
//    cout << "显示信息" << endl;
//    cout << "距离 = " << (*ptr).feet << " 英尺 " << (*ptr).inch << " 英寸";
//
//    return 0;
//}