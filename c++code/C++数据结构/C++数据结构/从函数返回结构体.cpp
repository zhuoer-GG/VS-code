//#include <iostream>
//using namespace std;
//
//struct Person {
//    char name[50];
//    int age;
//    float salary;
//};
//
//Person getData(Person);
//void displayData(Person);
//
//int main()
//{
//
//    Person p;
//
//    p = getData(p);
//    displayData(p);
//
//    return 0;
//}
//
//Person getData(Person p) {
//
//    cout << "输入姓名: ";
//    cin.get(p.name, 50);
//    cout << "输入年龄: ";
//    cin >> p.age;
//    cout << "输入工资: ";
//    cin >> p.salary;
//
//    return p;
//}
//
//void displayData(Person p)
//{
//    cout << "\n显示信息" << endl;
//    cout << "姓名: " << p.name << endl;
//    cout << "年龄: " << p.age << endl;
//    cout << "工资: " << p.salary;
//}