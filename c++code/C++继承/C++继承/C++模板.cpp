//#include <iostream>
//using namespace std;
//
//// template function
////函数模板以关键字template开头，其后是<>内的模板参数
//template <class T>
//T Large(T n1, T n2)
//{
//	return (n1 > n2) ? n1 : n2;
//}
////T是一个模板参数，它接受不同的数据类型（如int，float等），而class是关键字
//
//int main()
//{
//	int i1, i2;
//	float f1, f2;
//	char c1, c2;
//
//	cout << "输入两个整数:\n";
//	cin >> i1 >> i2;
//	cout << Large(i1, i2) << " 更大。" << endl;
//	//在运行时，将整数传递给模板函数时，编译器知道必须生成一个Large()函数来接受int参数，并且也是这样做的。
//
//	cout << "\n输入两个浮点数:\n";
//	cin >> f1 >> f2;
//	cout << Large(f1, f2) << " 更大。" << endl;
//
//	cout << "\n输入两个字符:\n";
//	cin >> c1 >> c2;
//	cout << Large(c1, c2) << " 具有较大的ASCII值。";
//
//	return 0;
//}

//类模板
#include <iostream>
using namespace std;

template <class T>
class Calculator
{
private:
	T num1, num2;

public:
	Calculator(T n1, T n2)
	{
		num1 = n1;
		num2 = n2;
	}

	void displayResult()
	{
		cout << "Numbers are: " << num1 << " and " << num2 << "." << endl;
		cout << "Addition is: " << add() << endl;
		cout << "Subtraction is: " << subtract() << endl;
		cout << "Product is: " << multiply() << endl;
		cout << "Division is: " << divide() << endl;
	}

	T add() { return num1 + num2; }

	T subtract() { return num1 - num2; }

	T multiply() { return num1 * num2; }

	T divide() { return num1 / num2; }
};

int main()
{
	Calculator<int> intCalc(2, 1);
	Calculator<float> floatCalc(2.4, 1.2);
	//要创建类模板对象，需要在创建时在< >中定义数据类型

	cout << "Int results:" << endl;
	intCalc.displayResult();

	cout << endl << "Float results:" << endl;
	floatCalc.displayResult();

	return 0;
}