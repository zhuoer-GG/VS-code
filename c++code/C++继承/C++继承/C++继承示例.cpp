//#include <iostream>
//using namespace std;
//
//class Person
//{
//public:
//    string profession;
//    int age;
//
//    Person() : profession("unemployed"), age(16) { }
//    void display()
//    {
//        cout << "我的职业是: " << profession << endl;
//        cout << "我的年龄是: " << age << endl;
//        walk();
//        talk();
//    }
//    void walk() { cout << "我会走路。" << endl; }
//    void talk() { cout << "我会说话" << endl; }
//};
//
//// MathsTeacher类派生自基类Person。
//class MathsTeacher : public Person
//{
//public:
//    void teachMaths() { cout << "我会教数学。" << endl; }
//};
//
//// Footballer类派生自基类Person。
//class Footballer : public Person
//{
//public:
//    void playFootball() { cout << "我会踢足球。" << endl; }
//};
//
////MathsTeacher和Footballer可以访问Person的所有的数据成员和成员函数
//
//int main()
//{
//    MathsTeacher teacher;
//    teacher.profession = "老师";
//    teacher.age = 23;
//    teacher.display();
//    teacher.teachMaths();
//
//    Footballer footballer;
//    footballer.profession = "运动员";
//    footballer.age = 19;
//    footballer.display();
//    footballer.playFootball();
//
//    return 0;
//}