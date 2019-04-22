package top.jmzc.array;

import java.util.Arrays;

/**
 * 数组基本使用：
 * 		数组就是一组相同数据类型的元素的集合，元素可以是基本类型也可以是引用类型
 * 		数组长度不可变
 * 		查找快、增删慢
 * 		顺序存储
 * @author sunyu
 *
 */
public class ArrayTest {

	public static void main(String[] args) {
		
		//动态初始化一个int数组
		int[] arr = new int[3];
		//获取数组的长度
		System.out.println("数组长度为："+arr.length);
		//获取数组中的第一个元素
		System.out.println("首元素是："+arr[0]);
		//为数组元素赋值
		arr[0] = 99;
		arr[1] = 99;
		arr[2] = 99;
		//遍历数组
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println("===============================");
		//静态初始化一个数组
		int[] arr2 = new int[] {1,23,2,45,88};
		//使用Arrays工具类打印数组元素
		System.out.println(Arrays.toString(arr2));
	}
}
