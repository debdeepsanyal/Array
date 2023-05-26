import java.util.Arrays;

public class InOrderandPreOrder {
        public static TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[0]);
            int mid = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == preorder[0]) {
                    mid = i;
                    break;
                }
            }
            System.out.println(mid);
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
            root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, inorder.length));
            return root;
        }

    public static void main(String[] args) {
        buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
}
