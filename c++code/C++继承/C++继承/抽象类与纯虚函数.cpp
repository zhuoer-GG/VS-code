/////在C ++中，可以创建一个无法实例化的抽象类（不可以创建该类的对象）
////但是，可以从中派生一个类并实例化派生类的对象。
////抽象类是无法实例化的基类。包含纯虚函数的类称为抽象类。
////声明以结尾的=0虚函数称为纯虚函数
//#include <iostream>
//using namespace std;
//
//// 抽象类（不允许实例化的类）
//class Shape
//{
//protected:
//    float l;
//public:
//    void getData()
//    {
//        cin >> l;
//    }
//
//    // 虚函数
//    virtual float calculateArea() = 0;
//};
//
////应该在派生类中重写基类的纯虚函数。 如果重写失败，则派生类也将成为抽象类
//class Square : public Shape
//{
//public:
//    float calculateArea()
//    {
//        return l * l;
//    }
//};
//
//class Circle : public Shape
//{
//public:
//    float calculateArea()
//    {
//        return 3.14 * l * l;
//    }
//};
//
//int main()
//{
//    Square s;
//    Circle c;
//
//    cout << "输入长度来计算正方形的面积: ";
//    s.getData();
//    cout << "正方形的面积: " << s.calculateArea();
//    cout << "\n输入半径以计算圆的面积: ";
//    c.getData();
//    cout << "圆的面积: " << c.calculateArea();
//
//    return 0;
//}
