package top.jmzc.link;

/**
 * 模拟循环双链表测试
 * @author sunyu
 *
 */
public class DbLoopNodeTest {

	public static void main(String[] args) {
		DbLoopNode node1 = new DbLoopNode(1);
		DbLoopNode node2 = new DbLoopNode(2);
		DbLoopNode node3 = new DbLoopNode(3);
		
		System.out.println(node1.getNext().getData());
		System.out.println(node1.getPre().getData());
		System.out.println(node1.getData());
		
		node1.insert(node2);
		System.out.println(node1.getNext().getData());
		System.out.println(node1.getPre().getData());
		System.out.println(node1.getData());
		
		node2.insert(node3);
		System.out.println(node1.getNext().getData());
		System.out.println(node1.getPre().getData());
		System.out.println(node1.getData());
		
		
	}
}
