//#include <iostream>
//
//using namespace std;
//
//// 基类 Shape
//class Shape
//{
////派生类可以访问基类中所有的非私有成员。
////因此基类成员如果不想被派生类的成员函数访问，则应在基类中声明为 private。
//public:
//    void setWidth(int w)
//    {
//        width = w;
//    }
//    void setHeight(int h)
//    {
//        height = h;
//    }
//protected:
//    int width;
//    int height;
//};
//
//// 基类 PaintCost
//class PaintCost
//{
//public:
//    int getCost(int area)
//    {
//        return area * 70;
//    }
//};
//
//// 派生类
//class Rectangle : public Shape, public PaintCost//此处的public表示公有继承：
//    //当一个类派生自公有基类时，基类的公有成员也是派生类的公有成员，基类的保护成员也是派生类的保护成员，
//    //基类的私有成员不能直接被派生类访问，但是可以通过调用基类的公有和保护成员来访问。
//{
//public:
//    int getArea()
//    {
//        return (width * height);
//    }
//};
////一个派生类继承了所有的基类方法，除了：
////基类的构造函数、析构函数和拷贝构造函数。
////基类的重载运算符。
////基类的友元函数。
//
//int main(void)
//{
//    Rectangle Rect;
//    int area;
//
//    Rect.setWidth(5);
//    Rect.setHeight(7);
//
//    area = Rect.getArea();
//
//    // 输出对象的面积
//    cout << "总面积: " << Rect.getArea() << endl;
//
//    // 输出总花费
//    cout << "总花费: $" << Rect.getCost(area) << endl;
//
//    return 0;
//}