# 引入所需的模組
from typing import List

# 引入 lru_cache 裝飾器
from functools import lru_cache


# 使用 lru_cache 裝飾器來優化遞歸函數
# maxsize 參數設為 None，表示快取的大小無上限
@lru_cache(maxsize=None)
def fibonacci_recursion(n: int) -> int:
    """使用遞歸方法計算第 n 項的費波那契數列值"""
    if n < 2:
        # 費波那契數列的前兩項為 0 和 1
        return n
    # 對於 n 大於或等於 2 的情況，每一項的值都是前兩項的和
    return fibonacci_recursion(n - 1) + fibonacci_recursion(n - 2)


def fibonacci_iteration(n: int) -> int:
    """使用迭代方法計算第 n 項的費波那契數列值"""
    if n == 0:
        return 0
    a, b = 0, 1
    for _ in range(2, n + 1):
        a, b = b, a + b
    return b


# 定義一個函數，該函數接受一個整數n作為輸入，並返回一個長度為n的費波那契數列
def fibonacci_recursion_array(n: int) -> List[int]:
    # 初始化一個長度為n的數組，所有元素都為0
    array = [0] * n

    # 定義一個輔助函數，該函數接受三個參數：n、a和b
    def helper(n: int, a: int, b: int) -> None:
        # 如果n大於等於1，則將a的值賦給數組的第-n個元素
        if n >= 1:
            array[-n] = a
        # 如果n大於等於2，則將b的值賦給數組的第-(n-1)個元素
        if n >= 2:
            array[-n + 1] = b
        # 如果n大於等於3，則遞歸調用輔助函數，並將n減1，a和b分別更新為b和a+b
        if n >= 3:
            helper(n - 1, b, a + b)

    # 調用輔助函數，初始時a和b的值分別為0和1
    helper(n, 0, 1)

    # 返回生成的費波那契數列
    return array


def fibonacci_iteration_array(n: int) -> List[int]:
    """使用迭代方法計算前 n 項的費波那契數列"""
    array = [0, 1] + [0] * (n - 2)
    for i in range(2, n):
        array[i] = array[i - 1] + array[i - 2]
    return array[:n]


if __name__ == "__main__":
    n = 10
    print(fibonacci_recursion(n))
    print(fibonacci_iteration(n))
    print(fibonacci_recursion_array(n))
    print(fibonacci_iteration_array(n))
