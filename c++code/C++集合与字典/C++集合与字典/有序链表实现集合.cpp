#include<iostream>
using namespace std;

//有序链表表示的集合中结点类的定义
template <class T>
struct SetNode {
    T data;
    SetNode<T>* link;
    SetNode() : link(NULL) { };
    SetNode(const T& x, SetNode<T>* next = NULL) : data(x), link(next) { };
};

//有序链表表示的集合的类的定义
template <class T> class LinkedSet {
private:
    SetNode<T>* first, * last;
public:
    LinkedSet() {
        first = last = new SetNode<T>;
    }  //构造函数
    LinkedSet(LinkedSet<T>& R);
    ~LinkedSet()
    {
        makeEmpty();  delete first;
    }
    void makeEmpty();     //置空集合
    bool addMember(const T& x);
    bool delMember(const T& x);
    LinkedSet<T>& operator = (LinkedSet<T>& R);         //置空集合将集合R赋给集合this 
    LinkedSet<T> operator + (LinkedSet<T>& R);              //求集合this与集合R的并
    LinkedSet<T> operator * (LinkedSet<T>& R);               //求集合this与集合R的交
    LinkedSet<T> operator - (LinkedSet<T>& R);	    //求集合this与集合R的差
    bool Contains(const T x);	//判x是否集合的成员
    bool operator == (LinkedSet<T>& R);	//判集合this与集合R相等
    bool Min(T& x);     //返回集合最小元素值
    bool Max(T& x);    //返回集合最大元素值
    bool subSet(LinkedSet< T >& R);    //this是否R的子集
};

//集合的复制构造函数
template <class T>
LinkedSet<T> ::LinkedSet(LinkedSet <T>& R) {
    SetNode<T>* srcptr = R.first->link;
    first = last = new SetNode<T>;
    while (srcptr != NULL) {
        last->link = new SetNode<T>(srcptr->data);
        last = last->link;
        srcptr = srcptr->link;
    }
    last->link = NULL;
}

//清空集合
template<class T>
void LinkedSet<T>::makeEmpty() {
    SetNode<T>* p = first->link;
    while (p != nullptr) {
        SetNode<T>* temp = p;
        p = p->link;
        delete temp;
    }
    first->link = nullptr;
    last = first;
}

template <class T>
bool LinkedSet<T> ::addMember(const T& x) {
    SetNode<T>* p = first->link, * pre = first;
    while (p != NULL && p->data < x)
    {
        pre = p;  p = p->link;
    }        //循链扫描
    if (p != NULL && p->data == x)
        return false;     //集合中已有此元素 
    SetNode<T>* s = new SetNode <T>(x);
    s->link = p;
    pre->link = s;    //链入
    if (p == NULL)
        last = s;  //链到链尾时改链尾指针
    return true;
}

template <class T>
bool LinkedSet<T> ::delMember(const T& x) {
    SetNode<T>* p = first->link, * pre = first;
    while (p != NULL && p->data < x)
    {
        pre = p;
        p = p->link;
    }	    //循链扫描
    if (p != NULL && p->data == x) {   //找到
        pre->link = p->link;	//重新链接
        if (p == last) {
            last = pre;
        }
        //删去链尾结点时改链尾指针
        delete p;  return true;	//删除含x结点
    }
    else return false; 		//集合中无此元素
}

//若x是集合成员, 则函数返回1, 否则返回0
template <class T>
bool LinkedSet<T> ::Contains(const T x) {
    SetNode<T>* temp = first->link;
    while (temp != NULL && temp->data < x)
        temp = temp->link;	 //循链搜索
    if (temp != NULL && temp->data == x)
        return true;			//找到, 返回1
    else return false;	         //未找到, 返回
}

//求集合this与集合R的并, 结果通过临时集合temp返回，this集合与R集合不变
template <class T> LinkedSet<T> LinkedSet<T> ::
operator + (LinkedSet<T>& R) {   //加法操作符重载函数
    SetNode<T>* pb = R.first->link;            
    SetNode<T>* pa = first->link;
    LinkedSet <T> temp;                            
    SetNode<T>* p, * pc = temp.first;
    while (pa != NULL && pb != NULL) {
        if (pa->data == pb->data) {    //共有元素
            pc->link = new SetNode<T>(pa->data);    
            pa = pa->link;  
            pb = pb->link;
        }
        else if (pa->data < pb->data) {
            pc->link = new SetNode<T>(pa->data);          
            pa = pa->link;
        }
        else {           //pa->data > pb->data 
            pc->link = new SetNode<T>(pb->data);          
            pb = pb->link;
        }
        pc = pc->link;
    }
    if (pa != NULL) 
        p = pa;
    else 
        p = pb;           //p指未扫完集合
    while (p != NULL) {    //向结果链逐个复制
        pc->link = new SetNode<T>(p->data);       
        pc = pc->link; 
        p = p->link;
    }
    pc->link = NULL;  
    temp.last = pc;	/*链表收尾*/    
    return temp;
}

//集合赋值
template <class T>
LinkedSet<T>& LinkedSet<T>::operator=(LinkedSet<T>& R) {
    if (this == &R) // 检查自我赋值
        return *this;

    // 清空当前集合
    makeEmpty();

    // 逐个复制 R 集合中的节点
    SetNode<T>* srcptr = R.first->link;
    SetNode<T>* destptr = first;  // 指向当前集合的头节点
    while (srcptr != NULL) {
        destptr->link = new SetNode<T>(srcptr->data);
        destptr = destptr->link;
        srcptr = srcptr->link;
    }

    // 设置最后一个节点的链接为空，并更新 last 指针
    destptr->link = NULL;
    last = destptr;

    return *this;
}

//求交集
template<class T>
LinkedSet<T> LinkedSet<T>::operator*(LinkedSet<T>& R) {
    SetNode<T>* pa = first->link;
    SetNode<T>* pb = R.first->link;
    LinkedSet<T> temp;
    SetNode<T>* pc = temp.first;

    while (pa != nullptr && pb != nullptr) {
        if (pa->data == pb->data) {
            pc->link = new SetNode<T>(pa->data);
            pc = pc->link;
            pa = pa->link;
            pb = pb->link;
        }
        else if (pa->data < pb->data) {
            pa = pa->link;
        }
        else {
            pb = pb->link;
        }
    }
    pc->link = nullptr;
    temp.last = pc;
    return temp;
}

//求差集
template <class T>
LinkedSet<T> LinkedSet<T>::operator - (LinkedSet<T>& R) {
    SetNode<T>* pa = first->link;
    SetNode<T>* pb = R.first->link;
    LinkedSet<T> temp;
    SetNode<T>* pc = temp.first;
    while (pa != NULL) {
        if (pb == NULL || pa->data < pb->data) {
            pc->link = new SetNode<T>(pa->data);
            pc = pc->link;
            pa = pa->link;
        }
        else if (pa->data == pb->data) {
            pa = pa->link;
            pb = pb->link;
        }
        else pb = pb->link;
    }
    pc->link = NULL;
    temp.last = pc;
    return temp;
}

//判断相等
template <class T>
bool LinkedSet<T> :: operator == (LinkedSet<T>& R) {
    SetNode<T>* pb = R.first->link;
    SetNode<T>* pa = first->link;
    while (pa != NULL && pb != NULL)
        if (pa->data == pb->data)	 //相等, 继续
        {
            pa = pa->link;  
            pb = pb->link;
        }
        else return false;    //不等时中途退出, 返回0
    if (pa != NULL || pb != NULL)
        return false;       //链不等长时, 返回0
    return true;
}

//最小值
template <class T>
bool LinkedSet<T>::Min(T& x) {
    if (first->link == NULL) return false;
    x = first->link->data;
    return true;
}
//最大值
template <class T>
bool LinkedSet<T>::Max(T& x) {
    if (first->link == NULL) return false;
    x = last->data;
    return true;
}

//判断是否是子集
template <class T>
bool LinkedSet<T>::subSet(LinkedSet<T>& R) {
    SetNode<T>* pa = first->link;
    SetNode<T>* pb = R.first->link;
    while (pa != NULL) {
        if (pb == NULL || pa->data < pb->data) return false;
        if (pa->data == pb->data) pa = pa->link;
        pb = pb->link;
    }
    return true;
}