package top.jmzc.link;

/**
 * 模拟单项链表：
 * 		链式存储
 * 		以节点为单位，每个节点保存了自己的数据和下一个节点
 * @author sunyu
 *
 */
public class Node {

	/**
	 * 节点中数据
	 */
	private int data;
	/**
	 * 下一个节点
	 */
	private Node next;

	// getter、setter
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	// 构造器
	public Node() {
	}

	public Node(int data) {
		this.data = data;
	}

	/**
	 * 追加新节点
	 * 		从一个节点开始找，直到发现当前节点没有下一个节点时在追加
	 * @param node
	 * @return
	 */
	public Node append(Node node) {
		// 开始位置作为当前节点
		Node currentNode = this;
		// 不断查找整个链表，直到查到下一个节点为null
		while (currentNode.next != null) {
			// 不断切换当前节点
			currentNode = currentNode.next;
		}
		// 循环结束即找到最后一个节点，此时将节点追加到此节点之后
		currentNode.next = node;

		return this;
	}
	
	/**
	 * 删除节点：
	 * 		由于是单链表，删除只能通过当前节点删除下一个节点
	 */
	public  Node remove() {
		//保存当前节点下一个节点
		Node temp = this.next;
		
		//将当前节点和下下个节点关联起来
		this.next = this.next.next;
		//将原下一个节点的next指向置空
		temp.next = null;
		
		//返回被删除的节点
		return temp;
	}
	
	/**
	 * 任意位置插入节点:
	 * 		由于单链表的关系，只能插入当前节点的后面
	 * @param node
	 * @return
	 */
	public boolean insert(Node node) {
		//取出原下一个节点保存起来
		Node nextNode = this.next;
		//处理当前节点和新节点的关系
		this.next = node;
		//处理新节点和当前节点的下下节点的关系
		node.next = nextNode;
		
		return true;
	}

	/**
	 * 判断节点是不是最后一个
	 * @return
	 */
	public boolean isLast() {
		return this.next == null;
	}
	
	/**
	 * 查看从当前节点到链表尾部所有节点的数据
	 */
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer("[");
		
		Node current = this;
		while(current.next!=null) {
			buff.append(current.getData()).append(",");
			current= current.next;
		}
		buff.append(current.getData()).append("]");
		
		return buff.toString();
	}
}
