package top.jmzc.array;

import java.util.Arrays;

/**
 * 数组删除元素
 * @author sunyu
 *
 */
public class ArrayRemoveTest {

	public static void main(String[] args) {
		// 定义数组
		int[] arr = new int[] { 1, 23, 4, 5, 10 };

		// 定义一个要删除的元素
		int element = 4;
		// 定义新数组，长度为原数组长度-1
		int[] newArr = new int[arr.length - 1];
		for (int i = 0; i < newArr.length; i++) {
			// 获取要删除的元素的索引
			int index = getIndex(arr, element);
			// 元素不在数组中存在
			if (index == -1) {
				throw new RuntimeException("不能删除：数组中没有该元素");
			}
			// 复制前面的元素
			if (i < index) {
				newArr[i] = arr[i];
			} else
				// 复制后面的元素
				newArr[i] = arr[i + 1];
		}
		// 替换原数组
		arr = newArr;

		// 查看结果
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 查找指定元素在数组中的位置
	 * @param arr 给定数组
	 * @param e 指定元素
	 * @return 数组中有该元素是返回元素索引，否则返回-1
	 */
	private static int getIndex(int[] arr, int e) {
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == e) {
				index = i;
				break;
			}
		}
		return index;
	}

}
