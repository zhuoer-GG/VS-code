//#include <iostream>
//using namespace std;
//
//class Area
//{
//private:
//    int length;
//    int breadth;
//
//public:
//    // 构造函数
//    Area() : length(5), breadth(2) { 
//    //构造函数体
//    }
//    //构造函数是成员函数的一种特殊类型，它在创建对象时会自动对其进行初始化
//    //处理多个对象时，手动初始化所有对象非常繁琐，这时可以使用构造函数
//
//    void GetLength()
//    {
//        cout << "分别输入长度和宽度: ";
//        cin >> length >> breadth;
//    }
//
//    int AreaCalculation() { return (length * breadth); }
//
//    void DisplayArea(int temp)
//    {
//        cout << "面积: " << temp;
//    }
//};
//
//int main()
//{
//    Area A1, A2;
//    int temp;
//
//    A1.GetLength();
//    temp = A1.AreaCalculation();
//    A1.DisplayArea(temp);
//
//    cout << endl << "不从用户那里获取值时的默认面积为:" << endl;
//
//    temp = A2.AreaCalculation();
//    A2.DisplayArea(temp);
//
//    return 0;
//}