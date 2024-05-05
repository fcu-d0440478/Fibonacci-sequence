
// 引入所需的模組
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Fibonacci {
    // 創建一個 HashMap 來存儲已計算的費波那契數列值，以提高效率
    private static HashMap<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        // 創建 Scanner 物件來讀取使用者輸入
        Scanner scanner = new Scanner(System.in);

        // 提示使用者輸入要計算的費波那契數列的項數
        System.out.print("請輸入要輸出的費波那契數列項數（從0開始）: ");
        int n = scanner.nextInt();

        // 計算並輸出第 n 項的費波那契數列值（遞歸方法）
        System.out.printf("第 %d 項費波那契數列的值（遞歸方法）為: %d%n", n, fibonacciRecursion(n));

        // 計算並輸出第 n 項的費波那契數列值（迭代方法）
        System.out.printf("第 %d 項費波那契數列的值（迭代方法）為: %d%n", n, fibonacciIteration(n));

        // 提示使用者輸入要輸出的費波那契數列的前幾項
        System.out.print("請輸入要輸出的費波那契數列前幾項: ");
        n = scanner.nextInt();

        // 計算並輸出前 n 項的費波那契數列（遞歸方法）
        System.out.printf("費波那契數列的前 %d 項（遞歸方法）為: %s%n", n, Arrays.toString(fibonacciRecursionArray(n)));

        // 計算並輸出前 n 項的費波那契數列（迭代方法）
        System.out.printf("費波那契數列的前 %d 項（迭代方法）為: %s%n", n, Arrays.toString(fibonacciIterationArray(n)));

        // 關閉 scanner 物件
        scanner.close();
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
        for (int i = 0; i < n; i++) {
            // 每一項的值都是前兩項的和
            c = a + b;
            a = b;
            b = c;
        }
        return a;
    }

    // 使用遞歸方法計算前 n 項的費波那契數列
    private static int[] fibonacciRecursionArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = fibonacciRecursion(i);
        }
        return array;
    }

    // 使用迭代方法計算前 n 項的費波那契數列
    private static int[] fibonacciIterationArray(int n) {
        int[] array = new int[Math.max(n, 2)];
        array[1] = 1;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return Arrays.copyOf(array, n);
    }
}
