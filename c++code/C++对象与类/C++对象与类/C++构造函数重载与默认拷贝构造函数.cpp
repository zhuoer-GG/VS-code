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
//    // 无参数构造函数
//    Area() : length(5), breadth(2) { }
//
//    // 有两个参数的构造函数
//    Area(int l, int b) : length(l), breadth(b) { }
//
//    /*重载的构造函数具有相同的名称（类的名称），但参数个数不同。
//    根据传递的参数的个数和类型，将调用特定的构造函数。
//    由于存在多个构造函数，因此在创建对象时也应传递构造函数的参数。*/
//
//    void GetLength()
//    {
//        cout << "分别输入长度和宽度： ";
//        cin >> length >> breadth;
//    }
//
//    int AreaCalculation() { return length * breadth; }
//
//    void DisplayArea(int temp)
//    {
//        cout << "面积: " << temp << endl;
//    }
//};
//
//int main()
//{
//    Area A1, A2(2, 1);
//    int temp;
//
//    cout << "没有传递参数时的默认面积。" << endl;
//    temp = A1.AreaCalculation();
//    A1.DisplayArea(temp);
//
//    cout << "（2,1）作为参数传递时的面积。" << endl;
//    temp = A2.AreaCalculation();
//    A2.DisplayArea(temp);
//
//    // 初始化一个对象A3，使它包含与A2相同的值
//    Area A3(A2);
//    // or
//    //Area A3 = A2;
//
//    //默认情况下，复制构造函数已经内置到所有类中
//
//    return 0;
//}