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
    a, b = 0, 1
    for _ in range(n):
        a, b = b, a + b
    return a


# 定義一個函數，該函數接受一個整數n作為輸入，並返回一個長度為n的費波那契數列
def fibonacci_recursion_array(n: int) -> List[int]:
    return [fibonacci_recursion(i) for i in range(n)]


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
