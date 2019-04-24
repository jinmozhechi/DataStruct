package top.jmzc.link;

public class NodeTest {

	public static void main(String[] args) {
		
		Node node1 = new Node(99);
		Node node2 = new Node(29);
		Node node3 = new Node(78);
		
		//追加节点
		node1.append(node2).append(node3).append(new Node(272));
		
		//查看节点数据
		System.out.println(node1.getData());
		System.out.println(node1.getNext().getData());
		System.out.println(node2.getNext().getData());
		
		//是否为尾部节点
		System.out.println(node3.isLast());
		System.out.println(node2.isLast());
		
		//指定位置输出链表数据
		System.out.println(node1);
		
		//删除78这个节点
		System.out.println(node2.remove().getData());
		System.out.println(node1);
		
		//插入新节点
		Node newNode = new Node(87);
		node1.getNext().insert(newNode);
		System.out.println(node1);
		
		
	}
}
