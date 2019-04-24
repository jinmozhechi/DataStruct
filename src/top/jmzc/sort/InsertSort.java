package top.jmzc.sort;

import java.util.Arrays;

/**
 * 插入排序：
 * 		将序列分成有序和无序的部分，以增量的方式向有序部分中添加无序部分的元素进行排序，直到全部序列有序
 * 			|- 将第一个数字作为有序部分，剩下的为无序部分
 * 			|- 拿出无序部分第一个数字与有序部分最后一个数字比较，如果小于就临时保存起来，然后去和有序部分的数字去比较
 * 				|- 如果临时数字一直小于有序部分的数字，就将有序部分的数字后移直到填充进这个临时数字完成新的有序部分
 * @author sunyu
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 42, 2, 99, 54, 51, 5, 6, 5, 6512, 22 };
		System.out.println("排序前" + Arrays.toString(arr));

		insertSort(arr);
		System.out.println("排序后" + Arrays.toString(arr));
	}

	/**
	 * 插入排序
	 * @param arr
	 */
	private static void insertSort(int[] arr) {
		// 将首元素作为有序部分
		// 只需从索引1的位置开始增量操作即可(遍历无序部分)
		for (int i = 1; i < arr.length; i++) {
			// 无序部分第一数字小于有序部分最后一个数字
			if (arr[i] < arr[i - 1]) {

				// 将无序部分第一个数字加入有序部分并重新排序
				// for (int j = i; (j >=1) && (arr[j] < arr[j - 1]); j--) {
				//
				// arr[j - 1] = arr[j - 1] ^ arr[j];
				// arr[j] = arr[j - 1] ^ arr[j];
				// arr[j - 1] = arr[j - 1] ^ arr[j];
				// }

				// 保存临时数字
				int temp = arr[i];
				int j = 0;
				// 拿临时数字去和有序部分作比较,如果有序部分的数字大于临时数字，就将有序部分的数字做后移处理
				for (j = i - 1; (j >= 0) && (arr[j] > temp); j--) {
					arr[j + 1] = arr[j];
				}
				// 所有大于临时数组的部分后移之后将临时数组插入到有序部分空出的位置
				// 这里是j+1，因为上面循环中做了j--，不能直接用j
				arr[j + 1] = temp;
			}
		}
	}
}
