package Easy;

public class test{

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        System.out.println(sumRootToLeaf.sumRootToLeaf(root));
    }




    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

