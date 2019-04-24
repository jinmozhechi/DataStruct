package top.jmzc.link;

/**
 * 模拟循环链表测试
 * @author sunyu
 *
 */
public class LoopNodeTest {

	public static void main(String[] args) {
		
		LoopNode node1 = new LoopNode(12);
		LoopNode node2 = new LoopNode(1121);
		LoopNode node3 = new LoopNode(112);
		LoopNode node4 = new LoopNode(221);
		
		node1.insert(node2);
		node1.insert(node3);
		node2.insert(node4);
		
		System.out.println(node1.getData());
		System.out.println(node1.getNext().getData());
		System.out.println(node1.getNext().getNext().getData());
		System.out.println(node1.getNext().getNext().getNext().getData());
		// node1,node3,node2,221
		System.out.println("========================");
		
		LoopNode remove = node4.remove();
		System.out.println("----"+remove.getData());
		System.out.println(node3.getData());
		System.out.println(node3.getNext().getData());
		System.out.println(node3.getNext().getNext().getData());
		System.out.println(node3.getNext().getNext().getNext().getData());
		
	}
}
