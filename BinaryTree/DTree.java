package BinaryTree;

public class DTree {
    private DNode root;
    // private int size;

    public DTree()
    {

    }

    public DTree(DNode root)
    {
        this.root = root;
    }

    public DNode getRoot()
    {
        return this.root;
    }

    public void setRoot(DNode root)
    {
        this.root = root;
    }
}
