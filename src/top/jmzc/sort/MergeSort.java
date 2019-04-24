package top.jmzc.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 		将2个已经有序的序列合并成一个新的有序序列（本身有序不代表合并后就有序）
 * 
 * @author sunyu
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 42, 2, 99, 54, 51, 5, 6, 5, 6512, 22 };
		System.out.println("排序前" + Arrays.toString(arr));
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("排序后" + Arrays.toString(arr));
	}

	/**
	 * 归并排序
	 * @param arr
	 * @param start 起始下标 
	 * @param end 结束下标
	 */
	private static void mergeSort(int[] arr, int start, int end) {
		//将一个序列和子序列不断的拆分成两部分，直到不可再拆分（序列中只有一个元素）
		//定义中间位置作为后半部分的起始位置
		int mid = (start+end)/2;
		if(start>=end) {
			return;
		}
		//递归拆分
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		
		//下面是归并的操作
		// 定义临时数组存放合并后的有序序列
		int[] temp = new int[end - start + 1];
		// 定义前后两部分的起始下标和临时数组的起始下标
		int l = start, r = mid+1, t = 0;
		//开始排序，在前后两部分分别取出一个数字进行比较，将较小的数字优先放到临时数组中
		while(l<=mid&&r<=end) {
			//前半部分的数字小于等于后半部分的数字，临时数组存放前面的数字
			if(arr[l]<=arr[r]) {
				temp[t++] = arr[l++];
			}else {
				//否则临时数字存放的是后半部分的数字
				temp[t++] = arr[r++];
			}
		}
		
		//前后两半部分的序列长度不一致的处理
		//前半部分序列比后半部分多，则需要单独这些多出的部分
		while(l<=mid) {
			//直接放到临时数组中即可
			temp[t++] = arr[l++];
		}
		//后半部分序列长的情况同样处理
		while(r<=end) {
			temp[t++] = arr[r++];
		}
		
		//上面处理结果就在临时数组中完成了一次排序，需要拷贝临时数组到原数组
		System.arraycopy(temp, 0, arr, start, temp.length);
	}
}
