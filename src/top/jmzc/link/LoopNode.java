package top.jmzc.link;

/**
 * 模拟循环链表
 * 		：与单链表不同的是：没有末尾节点
 * @author sunyu
 *
 */
public class LoopNode {

	/**
	 * 节点数据
	 */
	private int data;
	/**
	 * 下一个节点：极限情况，链表中只有一个节点，那么作为循环链表，它的下一个节点就是它本身
	 */
	private LoopNode next = this;

	public LoopNode() {
	}

	public LoopNode(int data) {
		this.data = data;
	}

	/**
	 * 添加节点
	 * @param node
	 * @return
	 */
	public boolean insert(LoopNode node) {
		LoopNode nextNode = this.next;
		this.next = node;
		node.next = nextNode;

		return true;
	}

	/**
	 * 删除节点
	 * @return
	 */
	public LoopNode remove() {
		LoopNode temp = this.next;

		this.next = this.next.next;
		temp.next = null;

		return temp;
	}

	public int getData() {
		return data;
	}

	//getter
	public LoopNode getNext() {
		return next;
	}
}
