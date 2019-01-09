

# 安徽建筑大学《Android项目开发实训》

<middle>授课教师:北大青鸟课工场 赵靖老师260768400@qq.com</middle>

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
```bash
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

- 项目网址：https://github.com/webturing/Point24d

  

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

#### 版本1 ：耦合了System.out, 冗余括号较多

```java
public void midVisit() {
    System.out.print("(");
    if(left!=null)left.midVisit();
    System.out.print(root);
    if(right!=null)right.midVisit();	
    System.out.print(")");
}
```

#### 版本2:  解决移植性

```java
public void midVisit(StringBuffer buffer) {
    if (braced)
        buffer.append("(");
    if (left != null)
        left.midVisit(buffer);
    buffer.append(root);
    if (right != null)
        right.midVisit(buffer);
    if (braced)
        buffer.append(")");
}
```

### 版本3：括号优化技术

#### 括号优化

```java
public void setLeft(BinaryTree left) {
    this.left = left;
    left.braced = Evaluator.less(left.root, root);
}
public void setRight(BinaryTree right) {
    this.right = right;
    right.braced = Evaluator.lessOrEqual(root, right.root);
}
```

#### 算符判定

```java
public static boolean lessOrEqual(String a, String b) {
    return Arrays.asList("-- -+ *+ *- */ /+ /- /* //".split(" ")).contains(
        a + b);
}

public static boolean less(String a, String b) {
    return Arrays.asList("+* +/ -* -/".split(" ")).contains(a + b);
}
```
# 第四讲：24游戏的改进III------确定性搜索器和数据库存储技术

## 康拓展开和全排列

###  康拓展开： 全排列 映射为 0~n！

###康拓逆展开:   0~n！映射为 全排列 

```java
/**
	 * 逆康拓展开，根据数值直接生成排列
	 * @param x
	 * @param m
	 * @return
	 */
	static final int FAC[] = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };
	public static int[] codel(int x, int m) {
		int[] label = new int[m];
		int[] n = new int[m];
		int cnt;
		for (int i = 0; i < m; i++)
			label[i] = 1;
		for (int i = 0; i < m; i++) {
			cnt = x / FAC[m - 1 - i];
			x = x % FAC[m - 1 - i];
			for (int j = 0; j < m; j++) {
				if (label[j] == 0)
					continue;
				if (cnt == 0) {
					label[j] = 0;
					n[i] = j;
					break;
				}
				cnt--;
			}
		}
		return n;
	}
```



## 改进的后缀式枚举：

### （4个运算数 三个算符XYZ组成的二叉树只有5种）

- { a, b, X, c, Y, d, Z },
- { a, b, c, X, Y, d, Z },
- { a, b, X, c, d, Y, Z },
- { a, b, c, X, d, Y, Z },
- { a, b, c, d, X, Y, Z }

###算法实现
```java
public static List<String> bruteSearch(int[] arr) {
		 List<String> exp=new ArrayList<String>();
		for (int cc = 0; cc < Permutation.FAC[4]; cc++) {
			int[] idx = Permutation.codel(cc, 4);
			String a = String.valueOf(arr[idx[0]]);
			String b = String.valueOf(arr[idx[1]]);
			String c = String.valueOf(arr[idx[2]]);
			String d = String.valueOf(arr[idx[3]]);
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++)
					for (int k = 0; k < 4; k++) {
						String X = Point24.OPS[i];
						String Y = Point24.OPS[j];
						String Z = Point24.OPS[k];
						for (String[] ee : new String[][] {
								{ a, b, X, c, Y, d, Z },
								{ a, b, c, X, Y, d, Z },
								{ a, b, X, c, d, Y, Z },
								{ a, b, c, X, d, Y, Z },
								{ a, b, c, d, X, Y, Z }, }) {
							if (Evaluator.eval(ee) == Point24.GOAL) {
								exp.addAll(Arrays.asList(ee));
								return exp;
							}
						}
					}
		}
		exp.clear();
		return exp;
	}
```

## 记忆化搜索和数据库技术:

### 动态规划入门：记忆化搜索

### sqlite 技术

#### 创建数据库CREATE

#### 数据库的增删改查



# 第五讲：24游戏的持续改进

## 存储所有结果

## 排序结果散列

## 网络数据库和本地数据库的同步

### 对战模式？







# 总结：本案例所设计的知识要点：

1. Java 核心编程技术
2. 数据结构（二叉树、栈）
3. 算法和编译原理： 表达式计算、算符优先关系计算
4. 数据库技术
5. Android开发基础  
6. 软件工程GIT/GITHUB和文档Markdown

感谢所有听课的小伙伴，预祝课题答辩顺利，早日成为技术达人谢谢！