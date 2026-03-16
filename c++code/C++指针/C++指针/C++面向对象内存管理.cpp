#include <iostream>
using namespace std;

class Test
{
private:
    int num;
    float* ptr;

public:
    Test()
    {
        cout << "输入学生总数: ";
        cin >> num;

        ptr = new float[num];

        cout << "输入学生的成绩。" << endl;
        for (int i = 0; i < num; ++i)
        {
            cout << "学生" << i + 1 << ": ";
            cin >> *(ptr + i);
        }
    }

    //当对象被销毁时，即，对象超出范围时，将自动调用析构函数
    ~Test() {
        delete[] ptr;
    }

    void Display() {
        cout << "\n显示学生的成绩。" << endl;
        for (int i = 0; i < num; ++i) {
            cout << "学生" << i + 1 << " :" << *(ptr + i) << endl;
        }
    }

};
int main() {
    Test s;
    s.Display();
    return 0;
}