// 以下是一个模拟 "智能家居控制系统" 的复杂事件应用程序，包含多发布者、多订阅者、事件数据传递和动态订阅 / 取消订阅等场景
using System;
using System.Collections.Generic;

// 1. 定义事件数据类（继承EventArgs）
// 温度变化事件数据
public class TemperatureChangedEventArgs : EventArgs
{
    public float NewTemperature { get; } // 新温度
    public float OldTemperature { get; } // 旧温度
    public DateTime Time { get; } // 发生时间

    public TemperatureChangedEventArgs(float oldTemp, float newTemp)
    {
        OldTemperature = oldTemp;
        NewTemperature = newTemp;
        Time = DateTime.Now;
    }
}

// 门窗状态变化事件数据
public class DoorWindowStatusEventArgs : EventArgs
{
    public string DeviceName { get; } // 设备名称（如"前门"、"卧室窗"）
    public bool IsOpen { get; } // 是否打开
    public DateTime Time { get; } // 发生时间

    public DoorWindowStatusEventArgs(string name, bool isOpen)
    {
        DeviceName = name;
        IsOpen = isOpen;
        Time = DateTime.Now;
    }
}

// 2. 发布者类（各种智能设备）
// 温度传感器（发布温度变化事件）
public class TemperatureSensor
{
    private float _currentTemp = 25.0f; // 初始温度
    // 声明事件（使用泛型EventHandler）
    public event EventHandler<TemperatureChangedEventArgs> TemperatureChanged;

    // 模拟温度变化（每3秒随机变化一次）
    public void StartMonitoring()
    {
        var random = new Random();
        while (true)
        {
            System.Threading.Thread.Sleep(3000); // 每3秒检测一次
            float newTemp = _currentTemp + (float)(random.NextDouble() * 2 - 1); // -1到1之间的变化
            newTemp = (float)Math.Round(newTemp, 1); // 保留一位小数

            if (newTemp != _currentTemp) // 温度有变化时引发事件
            {
                OnTemperatureChanged(_currentTemp, newTemp);
                _currentTemp = newTemp;
            }
        }
    }

    // 触发事件的保护方法
    protected virtual void OnTemperatureChanged(float oldTemp, float newTemp)
    {
        // 安全触发事件（检查是否有订阅者）
        TemperatureChanged?.Invoke(this, new TemperatureChangedEventArgs(oldTemp, newTemp));
    }
}

// 门窗传感器（发布开关状态变化事件）
public class DoorWindowSensor
{
    public string DeviceName { get; }
    private bool _isOpen;
    // 声明事件
    public event EventHandler<DoorWindowStatusEventArgs> StatusChanged;

    public DoorWindowSensor(string name)
    {
        DeviceName = name;
        _isOpen = false; // 初始关闭状态
    }

    // 模拟状态变化（外部调用此方法触发事件）
    public void ToggleState()
    {
        _isOpen = !_isOpen;
        OnStatusChanged();
    }

    protected virtual void OnStatusChanged()
    {
        StatusChanged?.Invoke(this, new DoorWindowStatusEventArgs(DeviceName, _isOpen));
    }
}

// 3. 订阅者类（处理事件的设备/服务）
// 空调（根据温度变化调节工作状态）
public class AirConditioner
{
    private bool _isRunning = false;

    // 订阅温度事件
    public void SubscribeToTemperature(TemperatureSensor sensor)
    {
        sensor.TemperatureChanged += HandleTemperatureChange;
    }

    // 取消订阅温度事件
    public void UnsubscribeFromTemperature(TemperatureSensor sensor)
    {
        sensor.TemperatureChanged -= HandleTemperatureChange;
        Console.WriteLine("空调已取消温度订阅");
    }

    // 温度事件处理方法
    private void HandleTemperatureChange(object sender, TemperatureChangedEventArgs e)
    {
        Console.WriteLine($"\n=== 空调接收到温度变化 ===");
        Console.WriteLine($"时间：{e.Time:HH:mm:ss}");
        Console.WriteLine($"温度变化：{e.OldTemperature}°C → {e.NewTemperature}°C");

        // 根据温度自动调节
        if (e.NewTemperature > 26 && !_isRunning)
        {
            _isRunning = true;
            Console.WriteLine("空调启动：开始制冷");
        }
        else if (e.NewTemperature < 24 && _isRunning)
        {
            _isRunning = false;
            Console.WriteLine("空调关闭：温度已适宜");
        }
    }
}

// 智能家居中控（处理所有事件，发送通知）
public class SmartHomeHub
{
    private List<string> _notificationLog = new List<string>();

    // 订阅温度事件
    public void SubscribeToTemperature(TemperatureSensor sensor)
    {
        sensor.TemperatureChanged += LogTemperature;
    }

    // 订阅门窗事件
    public void SubscribeToDoorWindow(DoorWindowSensor sensor)
    {
        sensor.StatusChanged += HandleDoorWindowStatus;
    }

    // 处理温度事件（记录日志）
    private void LogTemperature(object sender, TemperatureChangedEventArgs e)
    {
        string log = $"[{e.Time:HH:mm:ss}] 温度日志：{e.NewTemperature}°C";
        _notificationLog.Add(log);
        Console.WriteLine($"\n=== 中控日志 ===");
        Console.WriteLine(log);
    }

    // 处理门窗事件（发送警报）
    private void HandleDoorWindowStatus(object sender, DoorWindowStatusEventArgs e)
    {
        string status = e.IsOpen ? "打开" : "关闭";
        string log = $"[{e.Time:HH:mm:ss}] {e.DeviceName}已{status}";
        _notificationLog.Add(log);
        
        Console.WriteLine($"\n=== 中控警报 ===");
        Console.WriteLine(log);
        if (e.IsOpen)
        {
            Console.WriteLine("警告：请确认门窗安全！");
        }
    }

    // 显示所有通知记录
    public void ShowNotificationLog()
    {
        Console.WriteLine("\n=== 历史通知记录 ===");
        foreach (var log in _notificationLog)
        {
            Console.WriteLine(log);
        }
    }
}

// 4. 主程序（模拟系统运行）
class SmartHomeSystem
{
    static void Main(string[] args)
    {
        // 创建设备（发布者）
        var tempSensor = new TemperatureSensor();
        var frontDoor = new DoorWindowSensor("前门");
        var bedroomWindow = new DoorWindowSensor("卧室窗");

        // 创建订阅者
        var ac = new AirConditioner();
        var hub = new SmartHomeHub();

        // 建立订阅关系
        ac.SubscribeToTemperature(tempSensor);
        hub.SubscribeToTemperature(tempSensor);
        hub.SubscribeToDoorWindow(frontDoor);
        hub.SubscribeToDoorWindow(bedroomWindow);

        // 启动温度监控线程（模拟持续运行）
        var tempThread = new System.Threading.Thread(tempSensor.StartMonitoring);
        tempThread.IsBackground = true;
        tempThread.Start();

        // 模拟用户操作门窗
        Console.WriteLine("系统启动，按任意键模拟门窗操作（输入q退出）...");
        while (Console.ReadKey().KeyChar != 'q')
        {
            Console.WriteLine("\n--- 模拟门窗操作 ---");
            frontDoor.ToggleState(); // 切换前门状态
            System.Threading.Thread.Sleep(1000);
            bedroomWindow.ToggleState(); // 切换卧室窗状态
        }

        // 清理操作
        ac.UnsubscribeFromTemperature(tempSensor);
        hub.ShowNotificationLog();
        Console.WriteLine("系统退出");
    }
}