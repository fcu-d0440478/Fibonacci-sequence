# Fibonacci Sequence Generator in Python and Java

這個 Java 和 Python 程式碼是用來生成費波那契數列的。它提供了兩種方法：遞歸和迭代。

## 費波那契數列介紹

費波那契數列是一種數學序列，其中每個數字是前兩個數字的和。這個序列通常從 0 和 1 開始，接下來的每個數字都是前兩個數字的和。例如，前十個數字是：

0, 1, 1, 2, 3, 5, 8, 13, 21, 34

## 程式碼功能

這個程式碼提供了以下四種功能：

1. `fibonacci_recursion(int n)`、`fibonacciRecursion(int n)`：使用遞歸方法計算第 n 項的費波那契數列值。
2. `fibonacci_iteration(int n)`、`fibonacciIteration(int n)`：使用迭代方法計算第 n 項的費波那契數列值。
3. `fibonacci_recursion_array(int n)`、`fibonacciRecursionArray(int n)`：使用遞歸方法計算前 n 項的費波那契數列。
4. `fibonacci_iteration_array(int n)`、`fibonacciIterationArray(int n)`：使用迭代方法計算前 n 項的費波那契數列。

## 使用方法

只需在 `main` 函數中設定要計算的費波那契數列的項數，然後調用相應的函數即可。

Python

```python
if __name__ == "__main__":
    n = 10
    print(fibonacci_recursion(n))
    print(fibonacci_iteration(n))
    print(fibonacci_recursion_array(n))
    print(fibonacci_iteration_array(n))
```

Java

```java
public static void main(String[] args) {
    int n = 10;
    System.out.println(fibonacciRecursion(n));
    System.out.println(fibonacciIteration(n));
    System.out.println(Arrays.toString(fibonacciRecursionArray(n)));
    System.out.println(Arrays.toString(fibonacciIterationArray(n)));
}
```
