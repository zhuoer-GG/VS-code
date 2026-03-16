#include <iostream>
using namespace std;

const int DefaultSize = 100;
enum KindOfStatus { Active, Empty, Deleted };

template <class E, class K>
class HashTable {
public:
    HashTable(int d, int sz = DefaultSize);
    ~HashTable();
    HashTable(const HashTable<E, K>& ht2); // 复制构造函数
    HashTable<E, K>& operator=(const HashTable<E, K>& ht2); // 赋值操作符
    bool Search(const K k1, E& e1) const; // 搜索
    bool Insert(const E& e1); // 插入
    bool Remove(const K k1, E& e1); // 删除
    void makeEmpty(); // 清空表
    void printTable() const; // 打印表内容（调试用）

private:
    int divisor; // 散列函数的除数
    int CurrentSize, TableSize; // 当前和最大桶数
    E* ht; // 散列表数组
    KindOfStatus* info; // 元素状态
    int FindPos(const K k1) const; // 查找位置
    void rehash(); // 扩展散列表
    float loadFactor() const; // 装填因子
};

// 构造函数
template <class E, class K>
HashTable<E, K>::HashTable(int d, int sz) : divisor(d), TableSize(sz), CurrentSize(0) {
    ht = new E[TableSize];
    info = new KindOfStatus[TableSize];
    for (int i = 0; i < TableSize; i++) info[i] = Empty;
}

// 析构函数
template <class E, class K>
HashTable<E, K>::~HashTable() {
    delete[] ht;
    delete[] info;
}

// 复制构造函数
template <class E, class K>
HashTable<E, K>::HashTable(const HashTable<E, K>& ht2) {
    TableSize = ht2.TableSize;
    divisor = ht2.divisor;
    CurrentSize = ht2.CurrentSize;
    ht = new E[TableSize];
    info = new KindOfStatus[TableSize];
    for (int i = 0; i < TableSize; i++) {
        ht[i] = ht2.ht[i];
        info[i] = ht2.info[i];
    }
}

// 赋值操作符
template <class E, class K>
HashTable<E, K>& HashTable<E, K>::operator=(const HashTable<E, K>& ht2) {
    if (this != &ht2) {
        delete[] ht;
        delete[] info;
        TableSize = ht2.TableSize;
        divisor = ht2.divisor;
        CurrentSize = ht2.CurrentSize;
        ht = new E[TableSize];
        info = new KindOfStatus[TableSize];
        for (int i = 0; i < TableSize; i++) {
            ht[i] = ht2.ht[i];
            info[i] = ht2.info[i];
        }
    }
    return *this;
}

// 查找位置
template <class E, class K>
int HashTable<E, K>::FindPos(const K k1) const {
    int i = k1 % divisor; // 初始桶号
    int j = i;
    do {
        if (info[j] == Empty || (info[j] == Active && ht[j] == k1)) return j;
        j = (j + 1) % TableSize; // 线性探查下一个桶
    } while (j != i);
    return j;
}

// 插入元素
template <class E, class K>
bool HashTable<E, K>::Insert(const E& e1) {
    if (loadFactor() > 0.7) rehash(); // 若装填因子超过阈值，进行再散列
    K k1 = e1;
    int i = FindPos(k1);
    if (info[i] != Active) {
        ht[i] = e1;
        info[i] = Active;
        CurrentSize++;
        return true;
    }
    cout << "表中已有此元素或表已满，插入失败！" << endl;
    return false;
}

// 删除元素
template <class E, class K>
bool HashTable<E, K>::Remove(const K k1, E& e1) {
    int i = FindPos(k1);
    if (info[i] == Active && ht[i] == k1) {
        info[i] = Deleted; // 标记为已删除
        CurrentSize--;
        e1 = ht[i];
        return true;
    }
    return false;
}

// 搜索元素
template <class E, class K>
bool HashTable<E, K>::Search(const K k1, E& e1) const {
    int i = FindPos(k1);
    if (info[i] == Active && ht[i] == k1) {
        e1 = ht[i];
        return true;
    }
    return false;
}

// 清空表
template <class E, class K>
void HashTable<E, K>::makeEmpty() {
    for (int i = 0; i < TableSize; i++) info[i] = Empty;
    CurrentSize = 0;
}

// 计算装填因子
template <class E, class K>
float HashTable<E, K>::loadFactor() const {
    return (float)CurrentSize / TableSize;
}

// 扩展散列表
template <class E, class K>
void HashTable<E, K>::rehash() {
    int oldTableSize = TableSize;
    TableSize *= 2; // 表大小扩展为两倍
    E* oldHt = ht;
    KindOfStatus* oldInfo = info;

    ht = new E[TableSize];
    info = new KindOfStatus[TableSize];
    for (int i = 0; i < TableSize; i++) info[i] = Empty;

    CurrentSize = 0;
    for (int i = 0; i < oldTableSize; i++) {
        if (oldInfo[i] == Active) Insert(oldHt[i]); // 重新插入有效元素
    }
    delete[] oldHt;
    delete[] oldInfo;
}

// 打印表内容（调试用）
template <class E, class K>
void HashTable<E, K>::printTable() const {
    for (int i = 0; i < TableSize; i++) {
        cout << i << ": ";
        if (info[i] == Active) cout << ht[i] << " (Active)";
        else if (info[i] == Deleted) cout << "Deleted";
        else cout << "Empty";
        cout << endl;
    }
}

// 测试代码
int main() {
    HashTable<int, int> table(7, 10); // 创建散列表，除数7，初始大小10

    // 插入一些元素
    table.Insert(10);
    table.Insert(20);
    table.Insert(30);
    table.Insert(40);
    table.Insert(50);

    cout << "初始散列表：" << endl;
    table.printTable();

    // 搜索元素
    int value;
    if (table.Search(20, value)) cout << "找到元素: " << value << endl;
    else cout << "未找到元素 20" << endl;

    // 删除元素
    if (table.Remove(20, value)) cout << "删除元素: " << value << endl;
    else cout << "未找到元素 20，无法删除" << endl;

    cout << "删除后的散列表：" << endl;
    table.printTable();

    // 插入更多元素，测试再散列
    table.Insert(60);
    table.Insert(70);
    table.Insert(80);
    table.Insert(90);
    table.Insert(100);

    cout << "再散列后的散列表：" << endl;
    table.printTable();

    return 0;
}
