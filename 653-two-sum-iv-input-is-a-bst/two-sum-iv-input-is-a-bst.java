class Solution {

    Stack<TreeNode> asc = new Stack<>();
    Stack<TreeNode> desc = new Stack<>();

    int getSmall() {

        TreeNode small = asc.pop();

        TreeNode rightChild = small.right;

        while (rightChild != null) {
            asc.push(rightChild);
            rightChild = rightChild.left;
        }

        return small.val;
    }

    int getBig() {

        TreeNode big = desc.pop();

        TreeNode leftChild = big.left;

        while (leftChild != null) {
            desc.push(leftChild);
            leftChild = leftChild.right;
        }

        return big.val;
    }

    public boolean findTarget(TreeNode root, int k) {

        TreeNode t = root;

        // Stack for ascending order
        while (t != null) {
            asc.push(t);
            t = t.left;
        }

        // Stack for descending order
        t = root;

        while (t != null) {
            desc.push(t);
            t = t.right;
        }

        int s = getSmall();
        int e = getBig();

        while (s < e) {

            if (s + e == k) {
                return true;
            }

            else if (s + e < k) {
                s = getSmall();
            }

            else {
                e = getBig();
            }
        }

        return false;
    }
}