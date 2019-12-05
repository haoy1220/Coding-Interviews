package 数据结构;

/**
 * @author Hao
 * @date 2019/12/5 21:10
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left = null;
    public TreeLinkNode right = null;
    public TreeLinkNode next = null;//指该结点的父节点

    public TreeLinkNode(int val) {
        this.val = val;
    }
}
