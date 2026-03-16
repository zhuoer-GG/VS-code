//#include<iostream>
//using namespace std;
//
//int test();
//int test(int a);
//float test(double a);
//int test(int a, int b);
////所有4个函数都是重载函数，因为传递给这些函数的参数不同
////这4个函数的返回类型并不相同。重载函数可能有也可能没有不同的返回类型，但是应该有不同的参数
//
//int main() {
//	int result1, result2, result3, result4;
//	result1=test();
//	cout << endl;
//	result2 = test(10);
//	result3 = test(1.0);
//	result4 = test(10, 20);
//	cout << result2 << endl << result3 << endl << result4;
//	return 0;
//}
//
//int test() {
//	cout << "没有传参";
//	return 1;
//}
//int test(int a) {
//	return a;
//}
//float test(double a) {
//	return a;
//}
//int test(int a, int b) {
//	return a + b;
//}