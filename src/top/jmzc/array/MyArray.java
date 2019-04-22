package top.jmzc.array;

import java.util.Arrays;

/**
 * 自定义一个可变的对象数组
 * @author sunyu
 *
 */
public class MyArray {

	/**
	 * 定义一个任意类型的数组
	 */
	private int[] arr;

	/**
	 * 无参构造器
	 * 		内部定义了一个长度为0的int数组
	 */
	public MyArray() {
		arr = new int[0];
	}

	/**
	 * 获取数组的长度
	 * @return
	 */
	public int size() {
		return arr.length;
	}

	/**
	 * 向数组的末尾添加一个元素
	 * @param element 
	 * @return 
	 */
	public boolean add(int element) {
		// 定义一个新数组
		int[] newArr = new int[arr.length + 1];
		// 拷贝原数组元素
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		// 为新数组添加末尾元素
		newArr[newArr.length - 1] = element;
		// 替换原数组
		arr = newArr;

		// 返回结果
		return true;
	}

	/**
	 * 删除指定索引处的元素
	 * @param index 
	 * @return
	 */
	public int remove(int index) {

		this.indexValidate(index);

		// 取得要删除的元素
		int temp = arr[index];

		// 定义新数组
		int[] newArr = new int[arr.length - 1];
		// 添加原数组元素
		for (int i = 0; i < arr.length - 1; i++) {
			// 比删除元素的索引小，直接拷贝
			if (i < index) {
				newArr[i] = arr[i];
			} else {
				// 否则将原数组的元素向前移动一个位置
				newArr[i] = arr[i + 1];
			}
		}
		// 替换原数组
		arr = newArr;

		// 返回被删除的元素
		return temp;
	}

	/**
	 * 向指定位置添加指定的元素
	 * @param ele
	 * @param index
	 * @return 
	 */
	public boolean add(int ele, int index) {

		this.indexValidate(index);

		// 定义新数组
		int[] newArr = new int[arr.length + 1];
		// 使用原数组元素填充
		for (int i = 0; i < arr.length; i++) {
			if (i < index) {
				newArr[i] = arr[i];
			} else {
				newArr[i + 1] = arr[i];
			}
		}
		// 填充新元素
		newArr[index] = ele;
		// 替换原数组
		arr = newArr;

		return true;
	}

	/**
	 * 使用给定元素替换指定索引处的元素
	 * @param ele
	 * @param index
	 * @return
	 */
	public int set(int ele, int index) {

		this.indexValidate(index);

		// 取出索引处的元素
		int temp = arr[index];
		// 进行替换
		arr[index] = ele;

		// 返回被替换掉的元素
		return temp;
	}

	/**
	 * 数组下标验证
	 * @param index
	 */
	private void indexValidate(int index) {
		if (index < 0 | index > arr.length - 1) {
			throw new RuntimeException("索引越界");
		}
	}

	/**
	 * 线性查找元素第一次出现的位置
	 * @param e
	 * @return 找到返回下标，找不到返回-1
	 */
	public int search(int e) {
		int index = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == e) {
				index = i;
				break;
			}
		}

		return index;
	}

	/**
	 * 二分查找元素第一次出现的位置
	 * @param e
	 * @return 找到返回下标，找不到返回-1
	 */
	public int binarySearch(int e) {
		int index = -1;

		// 定义起始位置和结束位置
		int begin = 0;
		int end = arr.length - 1;
		// 定义可比较的元素的位置
		int mid = (begin + end) / 2;

		// 开始查找
		while (begin < end) {
			// 恰好找到，修改返回值并结束循环
			if (e == arr[mid]) {
				index = mid;
				break;
			}

			// 查找元素小于要比较的元素，修改结束位置
			if (e < arr[mid]) {
				end = mid - 1;
			}
			// 查找元素大于要比较的元素，修改开始位置
			if (e < arr[mid]) {
				begin = mid + 1;
			}
			// 重新定义比较元素的下标
			mid = (begin + end) / 2;
		}

		return index;
	}

	/**
	 * 重写toString()
	 */
	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
}
