# Algorithm

这是一个用于学习与练习数据结构与算法的 Java 代码仓库，包含多个基础数据结构与典型算法的实现与测试示例。内容以教学与自学为导向，强调代码可读性、可运行性与逐步演进。

**目录概览**
- `Algorithm_Day1/`、`Algorithm_Day2/`、`Algorithm_Day3/`：按学习阶段划分的算法练习
- `DynamicArray/`、`SingleLinkedListNode/`、`DoublyLinkedList/`、`DoubleLinkedList/`：线性表与链表实现
- `Stack/`、`Queue/`、`DeQueue/`、`PriorityQueue/`：栈、队列、双端队列、优先队列
- `Recursion/`：递归相关练习

**项目特点**
- 纯 Java 源码，无需额外框架
- 每个主题独立目录，便于按需学习
- 提供基础测试类或示例入口，方便运行与验证

**如何运行**
本仓库未使用 Maven/Gradle，可直接使用 `javac` 和 `java` 运行。

示例（以某个类为例）：
```powershell
# 编译
javac .\Algorithm_Day1\Algorithm01.java

# 运行
java -cp . Algorithm_Day1.Algorithm01
```

说明：
- 若文件顶部包含 `package` 声明，请使用“包名.类名”的方式运行。
- 若无 `package` 声明，请确保运行命令在项目根目录执行，并直接使用类名。

**目录结构约定**
- 每个主题目录包含实现类与测试类（可能以 `*Test` 结尾）
- 文件名与类名保持一致（如 `Stack/Stack.java`）

**适用人群**
- 希望系统复习基础数据结构与算法的学习者
- 需要清晰、可运行代码示例的读者

**作者**
author: daiyinbao
