////虚函数是基类中的成员函数，可以在派生类中重新定义这些函数
//#include <iostream>
//using namespace std;
//
//class Weapon {
//public:
//    virtual void features() { cout << "装载武器特性。\n"; }
//};
//
//class Bomb : public Weapon {
//public:
//    void features() {
//        this->Weapon::features();
//        cout << "装载刀的特性。\n";
//    }
//};
//
//class Gun : public Weapon {
//public:
//    void features() {
//        this->Weapon::features();
//        cout << "加载枪的特性。\n";
//    }
//};
//
//class Bow : public Weapon {
//public:
//    void features() {
//        this -> Weapon::features();
//        cout << "加载弓的特性。\n";
//    }
//};
//
//class Loader {
//public:
//    void loadFeatures(Weapon* weapon) {
//        weapon->features();
//    }
//};
//
//int main() {
//    Loader* l = new Loader;
//    Weapon* w;
//    Bomb b;
//    Gun g;
//
//    //l->loadFeatures(w)函数会根据l对象所指向的对象调用不同类的函数
//    w = &b;
//    l->loadFeatures(w);
//
//    w = &g;
//    l->loadFeatures(w);
//
//    Bow bo;
//    w = &bo;
//    l->loadFeatures(w);
//    return 0;
//}