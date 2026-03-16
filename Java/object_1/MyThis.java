package object_1;

public class MyThis {
    //在Java中，this关键字用于引用方法或构造函数中的当前对象
    int instVar;

    MyThis(int instVar){
        this.instVar = instVar;
        System.out.println("this引用= " + this);
    }

    public static void main(String[] args) {
        MyThis obj = new MyThis(8);
        System.out.println("对象引用= " + obj);
    }

    //在处理构造函数重载时，我们可能必须从另一个构造函数调用一个构造函数。
    //在这种情况下，我们不能显式调用构造函数。相反，我们必须使用this关键字。
    class Complex {

        private int a, b;

        //带两个参数的构造函数
        private Complex( int i, int j ){
            this.a = i;
            this.b = j;
        }

        //具有单个参数的构造函数
        private Complex(int i){
            //用两个参数调用构造函数
            this(i, i); 
        }

        //没有参数的构造函数
        private Complex(){
            //用单个参数调用构造函数
            this(0);
        }
        // 在上面的示例中，我们使用了this关键字，
        // 从构造函数Complex(inti)调用构造函数Complex(inti，intj)
        // 从构造函数Complex()调用构造函数Complex(int i)

        @Override
        public String toString(){
            return this.a + " + " + this.b + "i";
        }

        public static void main( String[] args ) {
    
                    //创建Complex类的对象
                    //使用2个参数调用构造函数 
            // Complex c1 = new Complex(2, 3); 
        
            //使用单个参数调用构造函数
            // Complex c2 = new Complex(3);

            //不带参数调用构造函数
            // Complex c3 = new Complex();

            //打印对象
            // System.out.println(c1);
            // System.out.println(c2);
            // System.out.println(c3);
        }
    }

    // 我们可以使用this关键字将当前对象作为参数传递给方法
    class ThisExample {
        // declare variables
        int x;
        int y;

        ThisExample(int x, int y) {
            //为构造函数内的变量赋值
            this.x = x;
            this.y = y;

            //调用add()前x和y的值
            System.out.println("在将this其传递给addTwo()方法之前:");
            System.out.println("x = " + this.x + ", y = " + this.y);

            //调用add()方法，将this其作为参数传递
            add(this);
            // 因为this关键字包含对类的对象obj的引用，所以我们可以在add()方法中更改x和y的值。

            //调用add()后x和y的值
            System.out.println("在将this其传递给addTwo()方法之后:");
            System.out.println("x = " + this.x + ", y = " + this.y);
        }

        void add(ThisExample o){
            o.x += 2;
            o.y += 2;
        }
    }

    class Main {
        public static void main( String[] args ) {
            // ThisExample obj = new ThisExample(1, -2);
        }
    }
}
