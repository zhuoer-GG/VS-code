//#include<iostream>
//using namespace std;
//
//int num;
//int& test();
////test()函数的返回类型为int&。因此，此函数返回变量num的引用
//
//int main() {
//	test() = 10;
//	cout << num;
//	return 0;
//}
//
//int& test() {
//	return num;
//	//该语句不返回num的值，而是返回变量本身(地址)
//}
////与普通函数返回值不同，返回引用函数不能返回常量和局部变量