package session_12;

public class Test {
    public static void main(String[] args) {
        class TreeNode<E> {
            protected E element;
            protected
            TreeNode<E> left;
            protected TreeNode<E> right;
            public TreeNode(E e) {
                element = e;
            }
        }

        TreeNode<Integer> root = new TreeNode<>(60);
        root.left = new TreeNode<>(55);
        root.right = new TreeNode<>(100);
        System.out.println(root);

    }
}
