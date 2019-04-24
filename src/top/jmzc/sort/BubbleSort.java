package top.jmzc.sort;

import java.util.Arrays;

/**
 * 冒泡排序：
 * 		有n个数，需要执行n-1轮排序
 * 		在每一轮中，将相邻的2个数进行比较，较小的数排在前面，相邻的比较每一次都将有一个数不会参与比较
 * @author sunyu
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 99, 2, 3, 51, 51, 5, 5, 6, 6512, 22 };
		System.out.println("排序前" + Arrays.toString(arr));

		bubbleSort(arr);
		System.out.println("排序后" + Arrays.toString(arr));
	}

	/**
	 * 冒泡排序
	 * @param arr
	 */
	private static void bubbleSort(int[] arr) {

		// 外层循环表示进行的排序轮次
		for (int i = 0; i < arr.length - 1; i++) {
			// 内层循环表示每一轮中进行的两两比较的次数，arr.length-1-i说明相邻的比较都会有一个数不会参与，即已经有序的那个数
			for (int j = 0; (j < arr.length - 1 - i) && (arr[j] > arr[j + 1]); j++) {

				// 交换原理：一个数异或本身等于0（也可以说是一个数异或2次还是其本身）
				arr[j] = arr[j] ^ arr[j + 1];
				arr[j + 1] = arr[j] ^ arr[j + 1];
				arr[j] = arr[j] ^ arr[j + 1];
			}
		}

	}
}
