package top.jmzc.link;

/**
 * 模拟循环双链表
 * @author sunyu
 *
 */
public class DbLoopNode {

	private DbLoopNode pre = this;
	private int data;
	private DbLoopNode next = this;

	public DbLoopNode() {
	}

	public DbLoopNode(int data) {
		this.data = data;
	}

	/**
	 * 添加节点
	 * @param node
	 * @return
	 */
	public boolean insert(DbLoopNode node) {
		//取出原下一个节点保存
		DbLoopNode nextNode = this.next; 

		//新节点和当前节点的关系
		this.next= node;
		node.pre = this;
		//新节点和原下一个节点的关系
		node.next = nextNode;
		nextNode.pre = node;

		return true;
	}

	public DbLoopNode getPre() {
		return pre;
	}

	public int getData() {
		return data;
	}

	public DbLoopNode getNext() {
		return next;
	}

}
