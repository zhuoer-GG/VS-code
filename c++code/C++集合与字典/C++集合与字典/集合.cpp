#include <assert.h>
#include <iostream>
#include <string>
using namespace std;

//template <class T> class Set {
//public:
//    virtual Set() = 0;
//    virtual makeEmpty() = 0;
//    virtual bool addMember(const T x) = 0;
//    virtual bool delMember(const T x) = 0;
//    virtual Set<T> IntersectWith(const Set<T>& R) = 0;
//    virtual Set<T> unionWith(const Set<T>& R) = 0;
//    virtual Set<T> differenceFrom(const Set<T>& R) = 0;
//    virtual bool Contains(const T x) = 0;
//    virtual bool subSet(const Set<T>& R) = 0;
//    virtual bool operator == (const Set<T>& R) = 0;
//};

const int DefaultSize = 100;

class bitSet {
private:
    int* bitVector;
    int vectorSize;
    int setSize;
public:
    bitSet(int sz = DefaultSize);
    bitSet(const bitSet& R);
    ~bitSet() { delete[] bitVector; }
    void makeEmpty();
    int getMember(const int x);
    void putMember(const int x, int v);
    bool addMember(const int x);
    bool delMember(const int x);
    bitSet& operator = (const bitSet& R);
    bitSet operator + (const bitSet& R);
    bitSet operator * (const bitSet& R);
    bitSet operator - (const bitSet& R);
    bool Contains(const int x);
    bool subSet(bitSet& R);
    bool operator == (bitSet& R);
    friend istream& operator >> (istream& in, bitSet& R);
    friend ostream& operator << (ostream& out, bitSet& R);
};

bitSet::bitSet(int sz) : setSize(sz) {
    assert(setSize > 0);
    vectorSize = (setSize + 31) >> 5;
    bitVector = new int[vectorSize];
    assert(bitVector != nullptr);
    for (int i = 0; i < vectorSize; i++) bitVector[i] = 0;
}

bitSet::bitSet(const bitSet& R) {
    setSize = R.setSize;
    vectorSize = R.vectorSize;
    bitVector = new int[vectorSize];
    assert(bitVector != nullptr);
    for (int i = 0; i < vectorSize; i++) bitVector[i] = R.bitVector[i];
}

void bitSet::makeEmpty() {
    for (int i = 0; i < vectorSize; i++) bitVector[i] = 0;
}

int bitSet::getMember(const int x) {
    int ad = x / 32, id = x % 32;
    int elem = bitVector[ad];
    return int((elem >> (31 - id)) & 1);
}

void bitSet::putMember(const int x, int v) {
    int ad = x / 32, id = x % 32;
    if (v == 1) {
        bitVector[ad] |= (1 << (31 - id));
    }
    else {
        bitVector[ad] &= ~(1 << (31 - id));
    }
}

bool bitSet::addMember(const int x) {
    assert(x >= 0 && x < setSize);
    if (getMember(x) == 0) {
        putMember(x, 1); return true;
    }
    return false;
}

bool bitSet::delMember(const int x) {
    assert(x >= 0 && x < setSize);
    if (getMember(x) == 1) {
        putMember(x, 0); return true;
    }
    return false;
}

bool bitSet::Contains(const int x) {
    assert(x >= 0 && x < setSize);
    return getMember(x) == 1;
}

bitSet& bitSet::operator = (const bitSet& R) {
    if (this != &R) {
        delete[] bitVector;
        setSize = R.setSize;
        vectorSize = R.vectorSize;
        bitVector = new int[vectorSize];
        assert(bitVector != nullptr);
        for (int i = 0; i < vectorSize; i++) bitVector[i] = R.bitVector[i];
    }
    return *this;
}

bitSet bitSet::operator + (const bitSet& R) {
    assert(vectorSize == R.vectorSize);
    bitSet temp(setSize);
    for (int i = 0; i < vectorSize; i++) temp.bitVector[i] = bitVector[i] | R.bitVector[i];
    return temp;
}

bitSet bitSet::operator * (const bitSet& R) {
    assert(vectorSize == R.vectorSize);
    bitSet temp(setSize);
    for (int i = 0; i < vectorSize; i++) temp.bitVector[i] = bitVector[i] & R.bitVector[i];
    return temp;
}

bitSet bitSet::operator - (const bitSet& R) {
    assert(vectorSize == R.vectorSize);
    bitSet temp(setSize);
    for (int i = 0; i < vectorSize; i++) temp.bitVector[i] = bitVector[i] & ~R.bitVector[i];
    return temp;
}

bool bitSet::operator == (bitSet& R) {
    if (vectorSize != R.vectorSize) return false;
    for (int i = 0; i < vectorSize; i++)
        if (bitVector[i] != R.bitVector[i])
            return false;
    return true;
}

bool bitSet::subSet(bitSet& R) {
    assert(setSize == R.setSize);
    for (int i = 0; i < vectorSize; i++)
        if (bitVector[i] & ~R.bitVector[i])
            return false;
    return true;
}

istream& operator >> (istream& in, bitSet& R) {
    string input;
    cout << "请输入要添加到集合中的元素（输入 'd' 结束）: ";
    while (true) {
        in >> input;
        if (input == "d") break;  // 当用户输入 "done" 时结束输入
        int x = stoi(input);
        if (x >= R.setSize) {
            cout << "元素超出集合范围，忽略该元素。" << endl;
            continue;
        }
        R.addMember(x);  // 将元素加入集合
    }
    return in;
}

ostream& operator << (ostream& out, bitSet& R) {
    out << "{ ";
    for (int i = 0; i < R.setSize; i++) {
        if (R.Contains(i)) out << i << " ";
    }
    out << "}";
    return out;
}

//int main() {
//    bitSet set1, set2;
//
//    cout << "向集合1中添加成员：" << endl;
//    cin >> set1;
//    cout << "集合1: " << set1 << endl;
//
//    cout << "向集合2中添加成员：" << endl;
//    cin >> set2;
//    cout << "集合2: " << set2 << endl;
//
//    bitSet unionSet = set1 + set2;
//    cout << "集合1和集合2的并集: " << unionSet << endl;
//
//    bitSet intersectionSet = set1 * set2;
//    cout << "集合1和集合2的交集: " << intersectionSet << endl;
//
//    bitSet differenceSet = set1 - set2;
//    cout << "集合1和集合2的差集 (set1 - set2): " << differenceSet << endl;
//
//    if (set1.subSet(set2)) {
//        cout << "集合1是集合2的子集" << endl;
//    }
//    else {
//        cout << "集合1不是集合2的子集" << endl;
//    }
//
//    if (set1 == set2) {
//        cout << "集合1和集合2相等" << endl;
//    }
//    else {
//        cout << "集合1和集合2不相等" << endl;
//    }
//
//    cout << "向集合1中添加成员5" << endl;
//    set1.addMember(5);
//    cout << "集合1: " << set1 << endl;
//
//    cout << "从集合1中删除成员5" << endl;
//    set1.delMember(5);
//    cout << "集合1: " << set1 << endl;
//
//    bitSet set3 = set1;
//    cout << "赋值操作：将集合1赋值给集合3" << endl;
//    cout << "集合3: " << set3 << endl;
//
//    return 0;
//}
