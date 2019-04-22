package top.jmzc.array;
/**
 * 测试自定义数组
 * @author sunyu
 *
 */
public class MyArrayTest {

	public static void main(String[] args) {
		//创建一个数组对象
		MyArray arr = new MyArray();
		//查看长度
		System.out.println("数组长度："+arr.size());

		//添加新元素
		arr.add(30);
		arr.add(90);
		arr.add(44);
		System.out.println(arr+"-----------数组长度："+arr.size());
		
		//删除下标为1的元素
		System.out.println("被删除的元素："+arr.remove(1));
		System.out.println(arr+"-----------数组长度："+arr.size());
		
		//新增一个元素到下标为1的位置
		arr.add(88, 1);
		System.out.println(arr+"-----------数组长度："+arr.size());
		
		//用99替换下标为0的元素
		System.out.println("被替换的元素"+arr.set(99, 0));
		System.out.println(arr+"-----------数组长度："+arr.size());
		
		//线性查找
		System.out.println(arr.search(88));
		System.out.println(arr.search(9));
		
		System.out.println("============================");
		
		//二分查找
		System.out.println(arr.binarySearch(88));
		System.out.println(arr.binarySearch(9));

	}
}
