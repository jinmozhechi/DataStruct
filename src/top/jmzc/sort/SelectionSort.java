package top.jmzc.sort;

import java.util.Arrays;

/**
 * 简单选择排序：
 * 		第一次比较用序列的第一个元素依次和后面的每个元素进行比较，找到最小值放到序列的最前面
 * 		第二次比较用序列的第二个元素依次和后面的每个元素进行比较，找到次小值放到序列的第二个位置
 * 		以此类推
 * 		...
 * 		
 * @author sunyu
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 42, 2, 99, 54, 51, 5, 6, 5, 6512, 22 };
		System.out.println("排序前" + Arrays.toString(arr));
		selectSort(arr);
		System.out.println("排序后" + Arrays.toString(arr));
	}

	/**
	 * 选择排序
	 * @param arr
	 */
	private static void selectSort(int[] arr) {
		
		//所有的元素都会参与比较
		for (int i = 0; i < arr.length; i++) {
			//前面的每一个元素要和后面的所有元素进行比较
			for (int j = i+1; j < arr.length; j++) {
				//如果后面的比前面的小需要置换
				if(arr[j]<arr[i]) {
					arr[j] = arr[j]^arr[i];
					arr[i] = arr[j]^arr[i];
					arr[j] = arr[j]^arr[i];
				}
			}
		}
	}
}
