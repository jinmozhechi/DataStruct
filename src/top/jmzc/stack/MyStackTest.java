package top.jmzc.stack;

/**
 * 模拟栈测试
 * @author sunyu
 *
 */
public class MyStackTest {

	public static void main(String[] args) {
		MyStack stack  = new MyStack();
		
		//压栈
		stack.push(88);
		stack.push(28);
		stack.push(32);
		stack.push(55);
		System.out.println(stack);
		
		//弹栈
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		
		//取栈顶元素
		System.out.println(stack.peek());
		
		//空判断
		System.out.println(stack.isEmpty());
		
		System.out.println(stack.pop());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		
		System.out.println(stack.isEmpty());
	}
}
