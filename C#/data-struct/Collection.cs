// 在 C# 中，Collection（集合）是用于存储和管理一组相关对象的数据结构，它提供了比普通数组更丰富的功能和灵活性。

// 特性	        普通数组（Array）	                集合（Collection）
// 长度特性	     长度固定，一旦创建无法改变	        长度动态可变，可自动扩容
// 类型安全性	 类型安全，但不支持泛型（早期）	    泛型集合（List<T>等）提供强类型安全
// 功能丰富度	 仅提供基础访问功能（索引器）	    提供添加、删除、查找等丰富方法
// 性能	        简单访问场景下性能略优	            复杂操作（增删）更高效
// 内存占用	     连续内存分配，内存利用率高	        动态分配，可能有额外内存开销
// 兼容性	     与低级代码（如 C/C++）交互友好	    更适合.NET 框架内的高级操作

// # 集合主要分为非泛型集合（位于System.Collections命名空间）和泛型集合（位于System.Collections.Generic命名空间）
// 推荐优先使用泛型集合，因为它们提供类型安全和更好的性能

// 泛型集合（常用）
//     List<T>：动态数组，最常用的集合类型
//     Dictionary<TKey, TValue>：键值对集合
//     HashSet<T>：无重复元素的集合
//     Queue<T>：先进先出（FIFO）队列
//     Stack<T>：后进先出（LIFO）栈
// 非泛型集合（不推荐，仅兼容旧代码）
//     ArrayList：可存储任意类型的动态数组
//     Hashtable：非泛型键值对集合
//     Queue、Stack：非泛型的队列和栈
using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        // 创建字符串类型的List
        List<string> fruits = new List<string>();
        
        // 添加元素
        fruits.Add("苹果");
        fruits.Add("香蕉");
        fruits.Add("橙子");
        
        // 插入元素（在索引1位置插入）
        fruits.Insert(1, "草莓");
        
        // 访问元素（支持索引器）
        Console.WriteLine("第二个元素：" + fruits[1]);
        
        // 遍历元素
        Console.WriteLine("所有水果：");
        foreach (string fruit in fruits)
        {
            Console.WriteLine(fruit);
        }
        
        // 查找元素
        if (fruits.Contains("香蕉"))
        {
            Console.WriteLine("包含香蕉，索引为：" + fruits.IndexOf("香蕉"));
        }
        
        // 删除元素
        fruits.Remove("橙子"); // 按值删除
        fruits.RemoveAt(0);    // 按索引删除
        
        // 清空集合
        // fruits.Clear();
        
        Console.WriteLine("修改后的数量：" + fruits.Count);
    }
}

class Program
{
    static void Main()
    {
        // 创建键为int、值为string的字典（存储学号和姓名）
        Dictionary<int, string> students = new Dictionary<int, string>();

        // 添加键值对
        students.Add(101, "张三");
        students.Add(102, "李四");
        students.Add(103, "王五");

        // 访问值（通过键）
        Console.WriteLine("学号102的学生：" + students[102]);

        // 遍历字典
        Console.WriteLine("所有学生：");
        foreach (var pair in students)
        {
            Console.WriteLine($"学号：{pair.Key}，姓名：{pair.Value}");
        }

        // 检查键是否存在
        if (students.ContainsKey(103))
        {
            Console.WriteLine("存在学号103");
        }

        // 删除元素
        students.Remove(101);

        // 尝试获取值（避免键不存在时抛出异常）
        if (students.TryGetValue(104, out string name))
        {
            Console.WriteLine("学号104的学生：" + name);
        }
        else
        {
            Console.WriteLine("学号104不存在");
        }
        
        // 队列示例
        Queue<string> queue = new Queue<string>();
        queue.Enqueue("任务1"); // 入队
        queue.Enqueue("任务2");
        string task = queue.Dequeue(); // 出队（返回"任务1"）

        // 栈示例
        Stack<string> stack = new Stack<string>();
        stack.Push("步骤1"); // 入栈
        stack.Push("步骤2");
        string step = stack.Pop(); // 出栈（返回"步骤2"）
    }
}

