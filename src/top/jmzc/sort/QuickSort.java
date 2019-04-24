package top.jmzc.sort;

import java.util.Arrays;

/**
 * 快速排序：
 * 		|- 将一个序列分成两部分，有两个指针从各自的部分取值去和基准数去比较
 * 			|- 在后面部分中，如果取到的数比基准数大，则继续移动后部分指针；反之，则不再移动指针，用这个数替换掉前部分指针处的数字
 * 			|- 在前面部分中，如果取到的数比基准数小，则继续移动前部分指针；反之，则不再移动指针，用这个数替换掉后部分指针处的数字
 * 			|- 如此不断往复，直到2个指针重合，将这个基准数移动到该位置，此时就完成了一次排序，其结果就是基准数前面的都比基准数小，后面的都比基准数大
 * 		|- 将无序的两部分继续上面的操作，直到全部有序
 * 		
 * @author sunyu
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 42, 2, 99, 54, 51, 5, 6, 5, 6512, 22 };
		System.out.println("排序前" + Arrays.toString(arr));

		quickSort(arr, 0, arr.length - 1);
		System.out.println("排序后" + Arrays.toString(arr));
	}

	/**
	 * 快速排序
	 * @param arr
	 * @param end  
	 * @param start 
	 */
	private static void quickSort(int[] arr, int start, int end) {

		//确保排序范围有效
		if (start >= end) {
			return;
		}

		// 定义一个基准,通常取序列的开始位置元素作为基准
		int base = arr[start];
		// 定义两部分的指针
		int low = start;
		int high = end;

		// 进行第一轮的排序,以两指针的重合作为一轮的结束
		while (low < high) {
			// 开始后部分操作
			// 如果后部分指针处的数字比基准数大就移动指针
			while (low < high && arr[high] >= base) {
				high--;
			}
			// 直到找到比基准数小的数字才停止,并使用该数字替换前部分指针处的数字
			arr[low] = arr[high];

			// 开始前部分操作
			// 如果前部分指针处的数字比基准数小就移动指针
			while (low < high && arr[low] <= base) {
				low++;
			}
			// 直到找到比基准数大的数字才停止,并使用该数字替换后部分指针处的数字
			arr[high] = arr[low];
		}
		// 当两部分指针重合时将基准数放到该位置
		arr[low] = base;

		// 递归处理无序部分
		quickSort(arr, start, low);
		quickSort(arr, low + 1, end);

	}
}
