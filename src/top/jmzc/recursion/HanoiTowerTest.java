package top.jmzc.recursion;

import java.util.Enumeration;
import java.util.Stack;

/**
 * 汉诺塔问题：
 * 		三根柱子，64个盘子，小盘上不能放大盘，一次只能移动一个盘子，那么该如何把这些盘子移动到目标柱子上
 * @author sunyu
 *
 */
public class HanoiTowerTest {

	public static void main(String[] args) {
		int count = 4;
		Stack<Integer> stackA = new Stack<Integer>();
		Stack<Integer> stackB = new Stack<Integer>();
		Stack<Integer> stackC = new Stack<Integer>();

		// 准备盘子置于A柱子
		ready(count, stackA);
		// 查看A柱子盘子
		show(stackA);

		// 执行移动
		hanoi(count, stackA, stackB, stackC);
		// 查看C柱子盘子
		show(stackC);
		// 查看A柱子盘子
		show(stackA);

		System.out.println("======================================");
		// 看看步骤
		hanoiStep(2, 'A', 'B', 'C');
	}

	/**
	 * 汉诺塔移动步骤 
	 * 		只需关注source和target参数即可，他们代表了盘子的做怎样的移动
	 * 		之所以会有3个参数是因为需要存在三个变量来表示盘子的位置
	 * @param count 盘子数
	 * @param source 原始柱子
	 * @param aid 辅助柱子
	 * @param target 目标柱子
	 */
	private static void hanoiStep(int count, char source, char aid, char target) {
		if (count == 0) {
			return;
		}

		hanoiStep(count - 1, source, target, aid);
		System.out.println("将第" + count + "盘子从" + source + "移动到" + target);
		hanoiStep(count - 1, aid, source, target);

	}

	/**
	 * 显示柱子上的盘子
	 * @param stack
	 */
	private static void show(Stack<Integer> stack) {
		StringBuffer buff = new StringBuffer("[");
		Enumeration<Integer> elements = stack.elements();
		while (elements.hasMoreElements()) {
			buff.append(elements.nextElement()).append(",");
		}
		if (!stack.isEmpty()) {
			buff.delete(buff.length() - 1, buff.length()).append("]");
			System.out.println(buff.toString());
		}
		System.out.println("the end！");
	}

	/**
	 * 向A柱子准备数据
	 * @param count
	 * @param stackA
	 */
	private static void ready(int count, Stack<Integer> stackA) {
		for (int i = 1; i <= count; i++) {
			stackA.push(i);
		}
	}

	/**
	 * 汉诺塔的移动问题
	 * 		思路：
	 * 			1.将前面n-1个盘子移动到B柱子上
	 * ·		2.将第n个盘子移动到C柱子上
	 * 			3.在将n-1个盘子移动到第n个盘子上面
	 * 			
	 * @param count 要移动的盘子总数
	 * @param stackA 起始柱子
	 * @param stackB 辅助柱子
	 * @param stackC 目标柱子
	 */
	private static void hanoi(int n, Stack<Integer> A, Stack<Integer> B, Stack<Integer> C) {

		// 没有盘子就结束方法
		if (n == 0) {
			return;
		}
		// 移动n-1个盘子从起始位置A移动到辅助位置B
		hanoi(n - 1, A, C, B);
		// 将A柱子上的盘子移动到C柱子上
		C.push(A.pop());
		// 将n-1个盘子移动到第n个盘子上
		hanoi(n - 1, B, A, C);
	}
}
