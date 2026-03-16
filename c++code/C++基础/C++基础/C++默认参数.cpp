//#include<iostream>
//using namespace std;
//
//void display(char = '*', int = 1);
////常见错误：
////不能跳过两个参数之间的默认参数，ep：void add(int a, int b = 3, int c, int d = 4);
////只使用一个默认参数，需确保是最后一个参数,ep：void add(int a, int b, int c, int d = 4);
//
//int main() {
//    cout << "没有参数传递:\n";
//    display();
//
//    cout << "\n第一个参数被传递:\n";
//    display('#');
//
//    cout << "\n两个参数被传递:\n";
//    display('$', 5);
//	return 0;
//}
//
//void display(char a,int n) {
//	for (int i = 0; i < n; i++) {
//		cout << a;
//	}
//	cout << endl;
//}