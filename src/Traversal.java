import java.util.Stack;

public class Traversal {
    /**
     * 创建一颗二叉树
     * @return
     */
    public static BinTreeNode createBinTree() {
        BinTreeNode R3 = new BinTreeNode(6, null, null);
        BinTreeNode R2 = new BinTreeNode(5, null, R3);
        BinTreeNode L2 = new BinTreeNode(4, null, null);
        BinTreeNode L1 = new BinTreeNode(2, L2, R2);
        BinTreeNode R1 = new BinTreeNode(3, null, null);
        BinTreeNode T = new BinTreeNode(1, L1, R1);
        return T;
    }

    //递归前序遍历
    public static void preOrderRecursive(BinTreeNode root){
        System.out.print(root.val);

        if(root.left != null)
            preOrderRecursive(root.left);
        if(root.right != null)
            preOrderRecursive(root.right);
    }

    //循环前序遍历
    public static void preOrder(BinTreeNode root){
        Stack<BinTreeNode> stack = new Stack<>();
        BinTreeNode temp = root;
        while (temp != null || !stack.isEmpty()){
            if(temp != null){
                System.out.print(temp.val);
                stack.push(temp);
                temp = temp.left;
            }else{
                temp = stack.pop();
                temp = temp.right;
            }
        }
    }

    //递归中序遍历
    public static void midOrder(BinTreeNode root){
        if(root.left != null)
            midOrder(root.left);
        System.out.print(root.val);
        if(root.right != null)
            midOrder(root.right);
    }

    //循环中序遍历
    public static void midOrderRecursive(BinTreeNode root){
        if(root == null)
            return;
        Stack<BinTreeNode> stack = new Stack<>();
        BinTreeNode temp = root;
        while (temp!= null || !stack.isEmpty()){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else {
                temp = stack.pop();
                System.out.print(temp.val);
                temp = temp.right;
            }
        }
    }

    //递归后序遍历
    public static void postOrder(BinTreeNode root){
        if(root.left != null)
            postOrder(root.left);
        if(root.right != null)
            postOrder(root.right);
        System.out.print(root.val);
    }

    //循环后序遍历(***难点***)
    public static void postOrderRecursive(BinTreeNode root){
        BinTreeNode temp = root;
        Stack<BinTreeNode> stack1 = new Stack<>();//用来存储树的节点
        Stack<Integer> stack2 = new Stack<>();//用来表示stack1中对应的节点接下来要遍历的是左子树还是右子树！
        int left = 1;
        int right = 2;
        while (temp != null || !stack1.isEmpty()) {
            while (temp != null) {
                stack1.push(temp);//将当前节点插入stack1中
                stack2.push(left);//接下来处理stack1中对应的当前节点的左子树，所以下一行是.left!
                temp = temp.left;
            }

            while (!stack1.isEmpty() && stack2.peek() == 2){//如果是从右子树返回的父节点，则从两个栈中分别弹栈！
                System.out.print(stack1.pop().val);
                stack2.pop();
            }
            if (!stack1.isEmpty() && stack2.peek() == 1) {//如果是从左子树返回的父节点，则将标记改为右子树
                stack2.pop();
                stack2.push(right);//接下来处理stack1种对应的当前节点的右子树，所以下一行是.right!
                temp = stack1.peek().right;
            }
        }
    }
}
