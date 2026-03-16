//#include<iostream>
//using namespace std;
//
//class Base {
//public:
//	void print() {
//		cout << "这是基类的函数" << endl;
//	}
//};
//
//class derive :public Base
//{
//public:
//	void print() {
//		cout << "这是派生类的函数" << endl;
////如果创建派生类的对象并调用在两个类（基类和派生类）中都存在的成员函数，
////则将调用派生类的成员函数，而忽略基类的函数。
//
////要从派生类访问基类的重写函数，可以使用范围解析运算符::
//		Base::print();
//	}
//
//};
//int main() {
//	derive obj;
//	obj.print();
//	return 0;
//}