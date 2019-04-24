package top.jmzc.sort;

import java.util.Arrays;

/**
 * 希尔排序：
 * 		|- 取一个小于序列长度的正整数作为增量，将整个序列分成若干个组，然后在每个分组中进行插入排序；之后不断缩小增量，重复之前的操作，直至值存在一组进行最后的插入排序
 * 			|- 一般的初次取序列的一半为增量，以后每次减半，直到增量为1
 * 			|- 分组数计算：从数组下标分析，[0,增量）区间的元素数量就是分组数
 * 		
 * @author sunyu
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 42, 2, 99, 54, 51, 5, 6, 5, 6512, 22 };
		System.out.println("排序前" + Arrays.toString(arr));
		shellSort(arr);
		System.out.println("排序后" + Arrays.toString(arr));
	}

	/**
	 * 希尔排序
	 * @param arr
	 */
	private static void shellSort(int[] arr) {
		// 增量的每一次变化就是进行一轮排序
		for (int i = arr.length / 2; i > 0; i /= 2) {
			// 根据增量可以进行如下分组
			for (int j = 0; j < i; j++) {
				// 每组中的元素进行插入排序
				insertSort(arr, j, i);
			}
		}

	}

	/**
	 * 直接插入排序
	 * @param arr 排序数组
	 * @param start 起始下标
	 * @param incr  元素之间的距离（增量）
	 */
	private static void insertSort(int[] arr, int start, int incr) {
		// 将整个序列的首元素作为有序部分
		// 无序部分参与排序
		for (int i = start + incr; i < arr.length; i += incr) {
			// 当无序部分的首元素小于有序部分的末尾元素时才进行插入操作
			if (arr[i] < arr[i - incr]) {
				// 将无序部分的每一个元素填充到有序部分中去重新排序
				for (int j = i; j >= incr && arr[j] < arr[j - incr]; j -= incr) {
					// 置换
					arr[j] = arr[j] ^ arr[j - incr];
					arr[j - incr] = arr[j] ^ arr[j - incr];
					arr[j] = arr[j] ^ arr[j - incr];
				}
			}

		}
	}

}
