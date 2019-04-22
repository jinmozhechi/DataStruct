package top.jmzc.array;

/**
 * 线性查找：从头到尾的查找，效率低
 * @author sunyu
 *
 */
public class SearchTest {

	public static void main(String[] args) {
		// 定义一个数组
		int[] arr = new int[] { 2, 24, 5, 6, 6, 77, 7, 86, 1 };
		// 定义要查找的元素
		int e = 6;
		// 线性查找
		System.out.println(search(arr, e));
	}

	/**
	 * 线性查找,返回第一次出现的位置
	 * @param arr
	 * @param i
	 */
	private static int search(int[] arr, int e) {
		
		int index = -1;
		
		if (arr != null) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == e) {
					index = j;
					break;
				}
			}
		}

		return index;
	}

}
