//#include <iostream>
//using namespace std;
//
////重载的运算符是带有特殊名称的函数，函数名是由关键字 operator 和其后
//// 要重载的运算符符号构成的。与其他函数一样，重载运算符有一个返回类型和一个参数列表
//
//class Box
//{
//public:
//
//    double getVolume(void)
//    {
//        return length * breadth * height;
//    }
//    void setLength(double len)
//    {
//        length = len;
//    }
//
//    void setBreadth(double bre)
//    {
//        breadth = bre;
//    }
//
//    void setHeight(double hei)
//    {
//        height = hei;
//    }
//
//    //大多数的重载运算符可被定义为普通的非成员函数或者被定义为类成员函数
//    //重载 + 运算符，用于把两个 Box 对象相加
//    //对象作为参数进行传递，对象的属性使用 this 运算符进行访问
//    Box operator+(const Box& b)
//    {
//        Box box;
//        box.length = this->length + b.length;
//        box.breadth = this->breadth + b.breadth;
//        box.height = this->height + b.height;
//        return box;
//    }
//private:
//    double length;      // 长度
//    double breadth;     // 宽度
//    double height;      // 高度
//};
//// 程序的主函数
//int main()
//{
//    Box Box1;                // 声明 Box1，类型为 Box
//    Box Box2;                // 声明 Box2，类型为 Box
//    Box Box3;                // 声明 Box3，类型为 Box
//    double volume = 0.0;     // 把体积存储在该变量中
//
//    // Box1 详述
//    Box1.setLength(6.0);
//    Box1.setBreadth(7.0);
//    Box1.setHeight(5.0);
//
//    // Box2 详述
//    Box2.setLength(12.0);
//    Box2.setBreadth(13.0);
//    Box2.setHeight(10.0);
//
//    // Box1 的体积
//    volume = Box1.getVolume();
//    cout << "Box1的体积 : " << volume << endl;
//
//    // Box2 的体积
//    volume = Box2.getVolume();
//    cout << "Box2的体积 : " << volume << endl;
//
//    // 把两个对象相加，得到 Box3
//    Box3 = Box1 + Box2;
//
//    // Box3 的体积
//    volume = Box3.getVolume();
//    cout << "Box3的体积 : " << volume << endl;
//
//    return 0;
//}