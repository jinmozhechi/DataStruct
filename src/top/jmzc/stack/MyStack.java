package top.jmzc.stack;

import java.util.Arrays;

/**
 * 使用数组模拟栈：先进后出(后进先出)的特点
 * @author sunyu
 *
 */
public class MyStack {

	private int[] arr;

	public MyStack() {
		arr = new int[0];
	}

	/**
	 * 压栈：即向数组末尾添加一个元素
	 * @param e
	 * @return
	 */
	public boolean push(int e) {

		// 数组中添加元素
		int[] newArr = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		newArr[newArr.length - 1] = e;
		arr = newArr;

		return true;
	}

	/**
	 * 弹栈:即删除数组末尾元素并返回
	 * @return
	 */
	public int pop() {

		// 保证栈中有元素
		if (arr.length == 0) {
			throw new RuntimeException("栈中没有元素");
		}

		// 取出要弹出的元素
		int temp = arr[arr.length - 1];

		// 数组中删除元素
		int[] newArr = new int[arr.length - 1];
		for (int i = 0; i < arr.length - 1; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;

		return temp;
	}

	/**
	 * 查看栈顶元素
	 * @return
	 */
	public int peek() {
		// 保证栈中有元素
		if (arr.length == 0) {
			throw new RuntimeException("栈中没有元素");
		}
		
		return arr[arr.length - 1];
	}
	
	/**
	 * 判断是否是空栈
	 * @return
	 */
	public boolean isEmpty() {
		return arr.length==0;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
}
