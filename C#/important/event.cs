// 事件是对象发送的通知，用于表示操作的发生。.NET中的事件遵循观察者设计模式。

// 引发事件的类称为 Publisher（发布者），接收通知的类称为 Subscriber（订阅者）。
// 一个事件可以有多个订阅者。通常，发布者在发生某个操作时引发事件。
// 订阅者希望在操作发生时获得通知，他们应该向事件注册并处理它。

// 在C＃中，事件是封装的委托。它取决于委托。委托为订阅者类的事件处理程序方法定义签名。

// 事件在类中声明且生成，且通过使用同一个类或其他类中的委托与事件处理程序关联。
// 包含事件的类用于发布事件。这被称为 发布者(publisher) 类。
// 其他接受该事件的类被称为 订阅者(subscriber) 类。
// 事件使用 发布-订阅(publisher-subscriber) 模型。

// 发布者(publisher)- 是一个包含事件和委托定义的对象。事件和委托之间的联系也定义在这个对象中。
// 发布者(publisher)类的对象调用这个事件，并通知其他的对象。

// 订阅者(subscriber)- 是一个接受事件并提供事件处理程序的对象。
// 在发布者(publisher)类中的委托调用订阅者(subscriber)类中的方法（事件处理程序）。


// 可以通过两个步骤声明一个事件：
    // 声明委托
    // 使用 event 关键字声明委托的变量
public delegate void Notify();  // 声明了一个委托 Notify

public class ProcessBusinessLogic
{
    public event Notify ProcessCompleted; // 声明了委托类型Notify的事件ProcessCompleted

    //引发事件
    public void StartProcess()
    {
        Console.WriteLine("Process Started!");
        // 处理某些业务逻辑代码
        OnProcessCompleted();
    }
    protected virtual void OnProcessCompleted() // 事件触发器(受保护的虚方法)
    {
        // 如果有订阅者（ProcessCompleted不为null），则调用该事件
        ProcessCompleted?.Invoke();
    }
}
// ProcessBusinessLogic类称为publisher（发布者）。
// Notify委托指定ProcessCompleted事件处理程序的签名。
// 它指定subscriber（订阅者）类中的事件处理程序方法必须具有 void 返回类型，并且没有参数。

// StartProcess()方法在末尾调用onProcessCompleted()方法，这将引发一个事件。
// 通常，要引发事件，应使用<EventName>上的名称定义protected和virtual方法。
// 受保护和虚拟使派生类重写引发事件的逻辑。但是，派生类应该始终调用基类的On<EventName>方法，以确保注册的委托接收事件。
// OnProcessCompleted() 方法使用 ProcessCompleted?. invoke() 调用委托。
// 这将调用所有注册到 ProcessCompleted 事件的事件处理程序方法。

// 订阅者类必须注册到ProcessCompleted事件，并使用签名匹配Notify委托的方法来处理它，如下所示。
class Program//Program 类是 ProcessCompleted 事件的订阅者。它使用 + = 运算符向事件注册
{
    public static void Main()
    {
        ProcessBusinessLogic bl = new ProcessBusinessLogic();
        bl.ProcessCompleted += bl_ProcessCompleted; // 注册事件
        bl.StartProcess();
    }

    // 事件处理程序
    public static void bl_ProcessCompleted()
    {
        Console.WriteLine("Process Completed!");
    }
}
// 请记住，这与我们在多播委托的调用列表中添加方法的方式是一样的。
// bl_processcompleted ()方法处理该事件，因为它与 Notify 委托的签名匹配。

// .NET Framework包含用于最常见事件的内置委托类型EventHandler和EventHandler <TEventArgs>。
// 通常，任何事件都应包括两个参数：事件源和事件数据
// 对不包含事件数据的所有事件使用EventHandler委托。对于包含要发送到处理程序的数据的事件，请使用 EventHandler<TEventArgs> 委托。
// 上面显示的示例可以使用EventHandler委托，而无需声明自定义Notify委托
class Program
{
    public static void Main()
    {
        ProcessBusinessLogic bl = new ProcessBusinessLogic();
        bl.ProcessCompleted += bl_ProcessCompleted; // 事件注册
        bl.StartProcess();
    }

    // 事件处理
    public static void bl_ProcessCompleted(object sender, EventArgs e)
    {
        Console.WriteLine("Process Completed!");
    }
}

public class ProcessBusinessLogic
{
    // 使用内置EventHandler声明事件
    public event EventHandler ProcessCompleted;

    public void StartProcess()
    {
        Console.WriteLine("Process Started!");
        // 一些代码在这里..
        OnProcessCompleted(EventArgs.Empty); //无事件数据
    }

    protected virtual void OnProcessCompleted(EventArgs e)
    {
        ProcessCompleted?.Invoke(this, e);
    }
}
// 在上面的示例中，事件处理程序bl_ProcessCompleted()方法包含两个与 EventHandler 委托匹配的参数。
// 同时，传递 this 作为发送者和EventArgs。当我们在OnProcessCompleted()方法中使用Invoke()引发事件时为空。
// 因为我们的事件不需要任何数据，它只是通知订阅者流程已经完成，所以我们传递了 EventArgs.Empty。


// 传递事件数据

// 大多数事件向订阅者发送一些数据。EventArgs类是所有事件数据类的基类。
// NET包含许多内置事件数据类，如 SerialDataReceivedEventArgs。
// 它遵循以EventArgs结束所有事件数据类的命名模式。您可以通过派生 EventArgs 类为事件数据创建自定义类。
class Program
{
    public static void Main()
    {
        ProcessBusinessLogic bl = new ProcessBusinessLogic();
        bl.ProcessCompleted += bl_ProcessCompleted; // 事件注册
        bl.StartProcess();
    }

    // 事件处理
    public static void bl_ProcessCompleted(object sender, bool IsSuccessful)//我们将单个布尔值传递给处理程序，以指示该过程是否成功完成。
    {
        Console.WriteLine("Process " + (IsSuccessful? "Completed Successfully": "failed"));
    }
}

public class ProcessBusinessLogic
{
    // 使用内置EventHandler声明事件
    public event EventHandler<bool> ProcessCompleted;

    public void StartProcess()
    {
        try
        {
            Console.WriteLine("Process Started!");

            // 一些代码在这里..

            OnProcessCompleted(true);
        }
        catch (Exception ex)
        {
            OnProcessCompleted(false);
        }
    }

    protected virtual void OnProcessCompleted(bool IsSuccessful)
    {
        ProcessCompleted?.Invoke(this, IsSuccessful);
    }
}

// 如果希望将多个值作为事件数据传递，那么可以创建一个从 EventArgs 基类派生的类
class ProcessEventArgs : EventArgs
{
    public bool IsSuccessful { get; set; }
    public DateTime CompletionTime { get; set; }
}
//下面的示例演示如何将自定义 ProcessEventArgs 类传递给处理程序
class Program
{
    public static void Main()
    {
        ProcessBusinessLogic bl = new ProcessBusinessLogic();
        bl.ProcessCompleted += bl_ProcessCompleted; // 事件注册
        bl.StartProcess();
    }

    // 事件处理
    public static void bl_ProcessCompleted(object sender, ProcessEventArgs e)
    {
        Console.WriteLine("Process " + (e.IsSuccessful? "Completed Successfully": "failed"));
        Console.WriteLine("Completion Time: " + e.CompletionTime.ToLongDateString());
    }
}

public class ProcessBusinessLogic
{
    // 使用内置EventHandler声明事件
    public event EventHandler<ProcessEventArgs> ProcessCompleted;

    public void StartProcess()
    {
        var data = new ProcessEventArgs();

        try
        {
            Console.WriteLine("Process Started!");

            // 一些代码在这里..

            data.IsSuccessful = true;
            data.CompletionTime = DateTime.Now;
            OnProcessCompleted(data);
        }
        catch (Exception ex)
        {
            data.IsSuccessful = false;
            data.CompletionTime = DateTime.Now;
            OnProcessCompleted(data);
        }
    }

    protected virtual void OnProcessCompleted(ProcessEventArgs e)
    {
        ProcessCompleted?.Invoke(this, e);
    }
}

// 要记住的要点

//     事件是对委托的包装。这取决于委托。
//     将“event”关键字与委托类型变量一起使用来声明事件。
//     将内置委托EventHandler或EventHandler <TEventArgs>用于常见事件。
//     发布者类引发一个事件，而订阅者类注册一个事件并提供事件处理程序方法。
//     用事件名称命名引发事件的方法，该方法以“ On”为前缀。
//     处理程序方法的签名必须与委托签名匹配。
//     使用+ =运算符注册事件。使用 -= 运算符取消订阅，不能使用=运算符。
//     使用EventHandler <TEventArgs>传递事件数据。
//     派生EventArgs基类以创建自定义事件数据类。
//     可以将事件声明为静态，虚拟，密封和抽象（static, virtual, sealed, abstract）。
//     接口可以将事件作为成员包含。
//     如果有多个订阅者，则将同步调用事件处理程序。