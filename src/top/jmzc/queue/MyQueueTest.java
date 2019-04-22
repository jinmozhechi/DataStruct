package top.jmzc.queue;

/**
 * 模拟队列测试
 * @author sunyu
 *
 */
public class MyQueueTest {

	public static void main(String[] args) {
		
		MyQueue queue = new MyQueue();
		
		//入队
		queue.add(28);
		queue.add(22);
		queue.add(43);
		
		System.out.println(queue);
		
		
		//出队
		System.out.println("出队元素："+queue.poll());
		System.out.println(queue);
	}
}
