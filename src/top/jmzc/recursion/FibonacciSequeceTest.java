package top.jmzc.recursion;

/**
 * 递归测试
 * 斐波那契数列：1，1，2，3，5，8...
 * 		这个数列从第3项开始，每一项都等于前两项之和
 * @author sunyu
 *
 */
public class FibonacciSequeceTest {

	public static void main(String[] args) {

		int num =20;
		int res = fibonacci(num);
		System.out.println("第"+num+"项的值："+res);
	}

	/**
	 * 计算斐波那契数列第n项的值
	 * @param i 第几项
	 * @return
	 */
	private static int fibonacci(int i) {

		if (i == 1 || i == 2) {
			return 1;
		}

		return fibonacci(i - 1) + fibonacci(i - 2);

	}

}
