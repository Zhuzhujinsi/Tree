public class Test {
    public static void main(String[] args) {
        BinTreeNode root = Traversal.createBinTree();
//        System.out.print("递归前序遍历：");
//        Traversal.preOrderRecursive(root);
//        System.out.println();
//        System.out.print("循环前序遍历：");
//        Traversal.preOrder(root);
//        System.out.println();
//        System.out.print("递归中序遍历：");
//        Traversal.midOrder(root);
//        System.out.println();
//        System.out.print("循环中序遍历：");
//        Traversal.midOrderRecursive(root);
//        System.out.println();
        System.out.print("递归后序遍历：");
        Traversal.postOrder(root);
        System.out.println();
        System.out.print("循环后序遍历：");
        Traversal.postOrderRecursive(root);
        System.out.println();
    }
}
