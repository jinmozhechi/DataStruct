package top.jmzc.array;

/**
 * 二分查找：效率比线性查找高，但要求数组有序
 * @author sunyu
 *
 */
public class BinarySearchTest {

	public static void main(String[] args) {
		// 定义一个数组
		int[] arr = new int[] { 1, 5, 6, 9, 23, 33,33, 55 };
		// 定义要查找的元素
		int e = 311;
		// 二分查找
		System.out.println(binarySearch(arr, e));

	}

	/**
	 * 二分查找返回第一次出现的位置
	 * @param arr
	 * @param e
	 * @return
	 */
	private static int binarySearch(int[] arr, int e) {
		// 定义开始位置和结束位置
		int begin = 0;
		int end = arr.length - 1;
		// 指定一个中间位置作为分界
		int mid = (begin + end) / 2;

		// 当起始位置大于或者等于结束位置时需要结束循环
		while (begin < end) {
			// 如果给定元素等于中间位置的元素,结束方法返回下标
			if (e == arr[mid]) {
				return mid;
			}

			// 如果给定元素小于中间位置的元素,就将中间位置前一个位置作为结束位置
			if (e < arr[mid]) {
				end = mid-1;
			}
			// 如果给定元素大于中间位置的元素,就将中间位置后一个位置作为起始位置
			if (e > arr[mid]) {
				begin = mid+1;
			}
			// 修正中间位置，准备下一次循环
			mid = (begin + end) / 2;
		}
		// 没有则返回-1
		return -1;
	}
}
