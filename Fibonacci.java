
// 引入所需的模組
import java.util.Arrays;
import java.util.HashMap;

public class Fibonacci {
    // 創建一個 HashMap 來存儲已計算的費波那契數列值，以提高效率
    private static HashMap<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        // 設定要計算的費波那契數列的項數
        int n = 10;
        // 使用遞歸方法計算並輸出第 n 項的費波那契數列值
        System.out.println(fibonacciRecursion(n));
        // 使用迭代方法計算並輸出第 n 項的費波那契數列值
        System.out.println(fibonacciIteration(n));
        // 使用遞歸方法計算並輸出前 n 項的費波那契數列
        System.out.println(Arrays.toString(fibonacciRecursionArray(n)));
        // 使用迭代方法計算並輸出前 n 項的費波那契數列
        System.out.println(Arrays.toString(fibonacciIterationArray(n)));
    }

    // 使用遞歸方法計算第 n 項的費波那契數列值
    private static int fibonacciRecursion(int n) {
        if (n == 0 || n == 1) {
            // 費波那契數列的前兩項為 0 和 1
            return n;
        } else if (cache.containsKey(n)) {
            // 如果已經計算過這一項，則直接從 cache 中取出
            return cache.get(n);
        } else {
            // 否則，計算這一項並將其存入 cache
            cache.put(n, fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2));
            return cache.get(n);
        }
    }

    // 使用迭代方法計算第 n 項的費波那契數列值
    private static int fibonacciIteration(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            // 每一項的值都是前兩項的和
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    // 使用遞歸方法計算前 n 項的費波那契數列
    private static int[] fibonacciRecursionArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            // 對每一項進行遞歸計算
            array[i] = fibonacciRecursion(i);
        }
        return array;
    }

    // 使用迭代方法計算前 n 項的費波那契數列
    private static int[] fibonacciIterationArray(int n) {
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < n; i++) {
            // 每一項的值都是前兩項的和
            array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }
}
