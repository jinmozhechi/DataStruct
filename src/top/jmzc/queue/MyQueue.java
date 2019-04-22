package top.jmzc.queue;

import java.util.Arrays;

/**
 * 数组模拟队列：先进先出,顺序存储
 * @author sunyu
 *
 */
public class MyQueue {

	private int[] arr;

	public MyQueue() {
		arr = new int[0];
	}

	/**
	 * 入队：即数组末尾添加元素
	 * @param element
	 * @return
	 */
	public boolean add(int element) {

		int[] newArr = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		newArr[newArr.length - 1] = element;
		arr = newArr;

		return true;
	}

	/**
	 * 出队：即取出数组中第一个元素，其他数组元素前移
	 * @return
	 */
	public int poll() {
		if (arr.length == 0) {
			throw new RuntimeException("下标越界");
		}

		int temp = arr[0];

		int[] newArr = new int[arr.length - 1];
		for (int i = 0; i < arr.length - 1; i++) {
			newArr[i] = arr[i + 1];
		}
		arr = newArr;

		return temp;
	}

	/**
	 * 空值判断
	 * @return
	 */
	public boolean isEmpty() {
		return arr.length == 0;
	}

	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
}
