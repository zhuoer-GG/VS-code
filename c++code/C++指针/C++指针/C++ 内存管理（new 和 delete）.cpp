//#include <iostream>
//#include <cstring>
//using namespace std;
//
//int main()
//{
//    int num;
//    cout << "输入学生总数: ";
//    cin >> num;
//    float* ptr;
//
//    // 内存分配的浮点数
//    ptr = new float[num];
//    //new表达式返回一个指向内存部分的指针，该内存恰好足以容纳num个浮点数据
//
//    cout << "输入学生的成绩。" << endl;
//    for (int i = 0; i < num; ++i)
//    {
//        cout << "学生" << i + 1 << ": ";
//        cin >> *(ptr + i);
//    }
//
//    cout << "\n显示学生的成绩。" << endl;
//    for (int i = 0; i < num; ++i) {
//        cout << "学生" << i + 1 << " :" << *(ptr + i) << endl;
//    }
//
//    // ptr内存被释放
//    delete[] ptr;
//    //方括号[]表示数组已被删除。如果需要删除单个对象，则不需要使用方括号
//
//    return 0;
//}