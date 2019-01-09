

# 北大青鸟课工场《Android项目开发实训》

<middle>授课教师:赵靖老师260768400@qq.com</middle>

# 第一讲：环境搭建和项目准备：

## 环境搭建：

###  网络资源

- 菜鸟网[www.runoob.com](http://www.runoob.com) 
- CSDN [www.csdn.net](http://www.csdn.net) 
- GITHUB[www.github.com](http://www.github.com)

### 安卓开发环境

- JDK:>=1.8
- Eclipse+ADT: 
- Android Studio安装:
  - AS
  - Gradle 离线版
  - ADT安装

## GIT/GITHUB

-  GIT:
  -  Linux :  ``` apt intall git```
  - Windows： GIT .exe
-  GITHUB注册：
  -   注册一个github账号（邮箱激活）
  -  创建项目，组织团队
-  GIT命令快速入门：
  -  在github创建一个项目 <https://github.com/webturing/Point24c.git>
  - GIT Shell/bash:
```
  克隆仓库Git clone
  增加待提交的文件Git add
  提交修改到本地Git commit
  推送到远程服务器Git push
  从远程服务器拉取更新本地库Git pull
```
- Linux Shell: ```ls cd cat rm pwd rm vi```
- 用IDE(eclipse/AS)创建一个同名的项目，测试框架、覆盖原来的git目录，提交第一次修改
- 增量开发

###  项目文档技术Markdown

##《越算越聪明的趣味24点》项目分析：
- 核心算法：表达式计算和处理

- 计算结果缓存：数据库存储

- 项目网址：

  - 计算机1班:  https://github.com/webturing/Point24c
  - 计算机2班:  https://github.com/webturing/Point24d

  

# 第二讲：24游戏的分析设计：

## 程序UI界面：

-   输入 4 EditText

-   输出 计算结果 TexView
-   Button:
    -   随机产生 
    -   搜索结果
    -   退出

## 表达式及计算：

### 表达式三种形式

-  中缀式 a+b 直观 需要复杂的括号

- 前缀式 + a b// f(a,b) 波兰式
- 后缀式 a b +  逆波兰式     无需括号

###   后缀式求值：栈

- 运算符处理

  ```java
  if (isOperator(s)) {
  				if(stack.isEmpty())return -1;
  				double b = stack.pop();
  				if(stack.isEmpty())return -1;
  				double a = stack.pop();
  				double c = 0;
  				switch (s) {
  				case "+":
  					c = a + b;
  					break;
  				case "-":
  					c = a - b;
  					break;
  				case "*":
  					c = a * b;
  					break;
  				case "/":
  					if (b != 0)
  						c = a / b;
  					else
  						c = Double.MAX_VALUE;
  					break;
  
  				}
  				stack.push(c);
  }
  ```

  

- 运算数判断

  ```java
  public static boolean isNumber(String s) {//巧妙利用异常机制来处理 也可以使用正则表达式来判断
  		try{
  			Double.parseDouble(s);
  			return true;
  		}catch(NumberFormatException e){
  			return false;
  		}
  }
  ```

  

## Core Java核心技术基础           

-  字符串String/StringBuffer/StringBuilder/char[]

-   输入输出 File/Scanner/….

- **异常处理 Exception Handling**
- 集合框架 java.uitl.  Stack<Double>

- 日期/高精度

-  随机数: //**游戏开发必备技能**

   -  Math.random()

   -  java.util.Random()

   -  Collections.shuffle(List s)

      ```java
      public class RandDemo {
      	static Random rand = new Random();
      	public static void main(String[] args) {
      		System.out.println(Math.random());//产生0-1之间的随机小数
      		System.out.println(rand.nextInt(10));//产生[0,10)之间的随机整数
      		List<Integer> balls = new ArrayList<Integer>();
      		for (int i = 1; i <= 15; i++)
      			balls.add(i);
      		System.out.println(balls);
      		Collections.shuffle(balls);
      		System.out.println(balls);
      		List<Integer> firstPrize = balls.subList(0, 6);
      		System.out.println("First Prize:" + firstPrize);
      	}
      }
      ```

      

## 利用集合洗牌算法产生随机排列：
### 算法:
- 四个数+3个随机的运算符

- 产生随机排列

- 判断当前值是否是24

  ```java
  public static List<String> search(int[] a) { //随机搜索器的实现，以较大的概率搜索到答案
  		List<String> exp = new ArrayList<String>();
  		for (int e : a)
  			exp.add(Integer.toString(e));
  		int cnt = 0;		
  		while (++cnt < MAX_CNT) {
  			List<String> ops=new ArrayList<String>();
  			ops.add(OPERATORS[random.nextInt(4)]);
  			ops.add(OPERATORS[random.nextInt(4)]);
  			ops.add(OPERATORS[random.nextInt(4)]);
  			exp.addAll(ops);
  			Collections.shuffle(exp);
  			if (Evaluator.eval(exp) == 24.0) {
  				return exp;
  			}
  			exp.removeAll(ops);
  		}
  		return new ArrayList<>();
  	}
  ```

  

### 通用类型函数的实现

- 重载所有基础类型
- 重载对象类型Object或者对应的接口

# 第三讲：24游戏的设计2-后缀转中缀（二叉树）
## 二叉树及性质
- 递归定义

- java实现链式结构非常方便
 ## 二叉树的实现

  ```java
public void midVisit() {
		System.out.print("(");
		if(left!=null)left.midVisit();
		System.out.print(root);
		if(right!=null)right.midVisit();	
		System.out.print(")");
	}
public BinaryTree(String root) {    this(root,null,null);//构造方法的重载}
public BinaryTree(String root, BinaryTree left, BinaryTree right) {
    this.root = root;
    this.left = left;
    this.right = right;
}
public String getRoot() {    return root;}
public void setRoot(String root) {    this.root = root;}
public BinaryTree getLeft() {    return left;}
public void setLeft(BinaryTree left) {    this.left = left;}
public BinaryTree getRight() {  return right;}
public void setRight(BinaryTree right) {    this.right = right;}

String root;
BinaryTree left;
BinaryTree right;
  ```

## 根据后缀转中缀核心算法：

### 建立二叉树算法

```java
/**
	 * 根据后缀式还原二叉树
	 * @param 后缀表达式exp
	 * @return 一个二叉树tree 其后序遍历为exp
	 */
public static BinaryTree createTree(String[] exp) {
    Stack<BinaryTree> stack=new Stack<BinaryTree>();
    for(String s:exp){
        if(Evaluator.isNumber(s)){
            BinaryTree t=new BinaryTree(s);
            stack.push(t);				
        }else if (Evaluator.isOperator(s)){
            BinaryTree t=new BinaryTree(s);// operator
            BinaryTree right=stack.pop();
            BinaryTree left=stack.pop();
            t.setLeft(left);
            t.setRight(right);
            stack.push(t);

        }
    }
    return stack.peek();
}

```

### 中序遍历（括号和移植)

#### 版本1 ：冗余括号较多

```java
public void midVisit() {
		System.out.print("(");
		if(left!=null)left.midVisit();
		System.out.print(root);
		if(right!=null)right.midVisit();	
		System.out.print(")");
}
```

