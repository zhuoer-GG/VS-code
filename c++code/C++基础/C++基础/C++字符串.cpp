#include<iostream>
#include<string>
using namespace std;

int main() {
	//C ++字符串以读取一行文本
	char str[100];
	cout << "输入一个字符串：";
	cin.get(str, 100);
	//要读取包含空格的文本，可以使用cin.get函数
	//第一个参数是字符串的名称,第二个参数是数组的最大容量
	cout << "您输入了：" << str << endl;

	// 忽略掉 cin.get() 留在输入缓冲区中的换行符
	cin.ignore(numeric_limits<streamsize>::max(), '\n');

	//创建字符串对象以保存字符串
	//声明一个字符串对象
	string str1;
	cout << "输入一个字符串：";
	getline(cin, str1);
	//getline()函数将输入流作为第一个参数，cin和str作为要存储的行的位置
	cout << "您输入了：" << str1 << endl;
	return 0;
}