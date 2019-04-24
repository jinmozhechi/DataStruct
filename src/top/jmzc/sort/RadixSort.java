package top.jmzc.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 基数排序：
 * 		存在一组0-9的桶容器，这个容器是按照0-9这个顺序摆放的
 * 		首先取数序列中的个位上数字，按照取出的数字将这个序列元素都放到对应的桶容器中，然后从0-9的桶中按照放入的顺序取出所有序列元素，完成一轮排序
 * 		然后取十位上的数字
 * 		...
 * 		直到取到最高位上的数字，完成最后一轮排序
 * 		
 * @author sunyu
 *
 */
public class RadixSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 42, 2, 99, 54, 51, 555, 231, 5, 6512, 22 };
		System.out.println("排序前" + Arrays.toString(arr));
		radixSort(arr); // 数组版
		System.out.println("排序后" + Arrays.toString(arr));
		radixSort_Queue(arr); // 队列版
		System.out.println("队列版排序后" + Arrays.toString(arr));
	}

	/**
	 * 使用队列作为桶容器的基数排序
	 * @param arr
	 */
	@SuppressWarnings("unchecked")
	private static void radixSort_Queue(int[] arr) {
		// 初始化桶容器
		Queue<Integer>[] temp = new LinkedList[10];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = new LinkedList<Integer>();
		}

		// 向桶容器中存取的轮次,b是计算余数使用的一个增量
		for (int i = 0, b = 1; i < maxLength(arr); i++, b *= 10) {
			// 每轮存数据
			for (int j = 0; j < arr.length; j++) {
				// 依次取得各个数位上的余数
				int ys = arr[j] / b % 10;
				// 元素入队
				temp[ys].offer(arr[j]);
			}
			// 每轮取数据
			// 定义arr数组起始下标
			int index = 0;
			// 元素出队
			for (int j = 0; j < temp.length; j++) {
				while (!temp[j].isEmpty()) {
					arr[index++] = temp[j].poll();
				}
			}
		}
	}

	/**
	 * 基数排序数组版
	 * @param arr
	 */
	private static void radixSort(int[] arr) {
		// 定义一个二维数组作为0-9的桶容器
		int[][] container = new int[10][arr.length];
		// 定义一个数组来统计每一个桶容器中的元素数目，长度10，刚好能和0-9的桶数量一致
		int[] count = new int[10];

		// 先找出数组中的最大数的长度，以便决定要就行多少轮排序
		// 在每一轮中都要计算余数，通过变量b来控制（从个位到最高位）
		for (int i = 0, b = 1; i < maxLength(arr); i++, b *= 10) {
			// 计算每一个元素的余数并按照余数把元素放到对应的桶容器中
			for (int j = 0; j < arr.length; j++) {
				// 计算余数
				int ys = arr[j] / b % 10;
				// 按照余数把元素放到对应的桶容器中
				// 说明count[ys]++: 该数组是int数组，元素默认值是0，即count[ys]初始值是0，++来确定下一个相同余数的数字要放置的下标
				// 例如，余数是1，该句的意思就是把数字放到1号桶中下标为0的位置，之后再有余数是1的数，则放到1号桶的下标为1的位置...
				container[ys][count[ys]++] = arr[j];
			}

			int index = 0;

			// 依据桶的编号按照存入桶中的顺序取出元素
			// 去每个桶中取
			for (int j = 0; j < count.length; j++) {
				if (count[j] != 0) {
					// 桶中有元素,就按照存入的数量取出,放入arr中
					for (int k = 0; k < count[j]; k++) {
						arr[index++] = container[j][k];
					}
					// 清空计数的数组
					count[j] = 0;
				}
			}
		}
	}

	/**
	 * 取到数组中最大的元素的长度
	 * @param arr
	 * @return
	 */
	private static int maxLength(int[] arr) {

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return String.valueOf(max).length();
	}
}
