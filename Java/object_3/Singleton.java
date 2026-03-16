package object_3;

public class Singleton {
    // Singleton（单例）是一种设计模式，而不是Java特有的功能。它确保只创建一个类的实例。
    // 设计模式就像我们的代码库一样，其中包含世界各地程序员共享的各种编码技术。
}

// 下面是我们如何在Java中使用单例的方法。
//     创建一个private的构造函数，该构造函数限制在类之外创建对象
//     创建一个引用单例对象的private属性。
//     创建一个public static方法，该方法允许我们创建和访问我们创建的对象。 在方法内部，我们将创建一个条件来限制我们创建多个对象。
// 这是一个实例。

class SingletonExample {

    //引用对象的私有字段
   private static SingletonExample singleObject;

   private SingletonExample() {
       //SingletonExample类的构造函数
   }

   public static SingletonExample getInstance() {
        //编写仅允许我们创建一个对象的代码
        //根据需要访问对象
      return (singleObject == null) ? singleObject = new SingletonExample() : singleObject;
   }
}
// 在以上示例中，
    // private static SingletonExample singleObject - 对类对象的引用。
    // private SingletonExample() - 私有构造函数，用于限制在类外部创建对象。
    // public static SingletonExample getInstance() - 此方法返回对该类唯一对象的引用。 由于该方法是静态的，因此可以使用类名进行访问。



// 使用单例类类
// 使用数据库时可以使用单例。它们可用于创建连接池以访问数据库，同时为所有客户端重用相同的连接。例如，
class Database {
   private static Database dbObject;

   private Database() {      
   }

   public static Database getInstance() {

      //创建对象（如果尚未创建）
      if(dbObject == null) {
         dbObject = new Database();
      }

       //返回单例对象
       return dbObject;
   }

   public void getConnection() {
       System.out.println("现在已经连接到数据库。");
   }
}

// class Main {
//    public static void main(String[] args) {
//       Database db1;

//       //引用Database的唯一对象
//       db1= Database.getInstance();
      
//       db1.getConnection();
//    }
// }
// 在上面的示例中，
//     我们创建了一个单例类Database。
//     dbObject是一个类类型字段。 这将引用类Database的对象。
//     私有构造函数Database()，可防止在类外部创建对象。
//     静态类类型方法getInstance()将类的实例返回给外部。
//     在Main类中，我们具有类类型变量db1。 我们正在使用db1调用getInstance()来获取Database的唯一对象。
//     该方法getConnection()只能使用的对象进行访问Database。
//     由于Database只能有一个对象，因此所有客户端都可以通过单个连接访问数据库。

// 需要注意的是，只有少数情况（如日志）使单例有意义。甚至数据库连接通常也不应该是单例的。

// 如果您不确定是否使用单例，我们建议您避免完全使用单例。