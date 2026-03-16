//#include <iostream>
//using namespace std;
//
//class Test
//{
//private:
//    int data1;
//    float data2;
////private关键字使数据和函数变为私有。只能从同一类内部访问私有数据和函数。
//
//public:
////public关键字将数据和函数公开。数据和函数可以在类之外访问
//    void insertIntegerData(int d)
//    {
//        data1 = d;
//        cout << "数字: " << data1;
//    }
//
//    float insertFloatData()
//    {
//        cout << "\n输入数据: ";
//        cin >> data2;
//        return data2;
//    }
//};
////可以使用o2.function1(); 上面示例中的任何函数或类。 但是代码o1.data2 = 5.5应该始终在类Test中
//
//int main()
//{
//    Test o1, o2;
//    float secondDataOfObject2;
//
//    o1.insertIntegerData(12);
//    secondDataOfObject2 = o2.insertFloatData();
//
//    cout << "您输入了 " << secondDataOfObject2;
//    return 0;
//}