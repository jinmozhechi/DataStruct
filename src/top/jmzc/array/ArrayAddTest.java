package top.jmzc.array;

import java.util.Arrays;

/**
 * 数组添加元素
 * @author sunyu
 *
 */
public class ArrayAddTest {

	public static void main(String[] args) {
		// 先定义一个数组
		int[] arr = new int[] { 9, 8, 7 };

		// 要添加的元素
		int element = 20;
		// 创建一个新数组，长度是原数组的长度+1
		int[] newArr = new int[arr.length + 1];
		// 复制原数组元素
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		// 添加最后一个元素
		newArr[newArr.length - 1] = element;
		// 替换原数组
		arr = newArr;

		// 查看结果
		System.out.println(Arrays.toString(arr));
	}
}
