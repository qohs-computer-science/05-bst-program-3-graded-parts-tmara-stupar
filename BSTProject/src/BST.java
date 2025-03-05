import java.lang.Comparable;
import java.util.Stack;


public class BST implements BSTInterface
{
    private TreeNode root;

    public BST()
    {

        root = null;

    }//constructor

    public void add(Comparable newVal) 
    {

        if (root == null)
            root = new TreeNode(newVal);
        else if (newVal.compareTo(root.getValue()) > 0 )
            //right
            if (root.getRight() == null)
                root.setRight(new TreeNode(newVal));
            else
                //helper
                addHelper(newVal, root.getRight());

        else if (newVal.compareTo(root.getValue()) <= 0 )
            //left
            if (root.getLeft() == null)
                root.setLeft(new TreeNode(newVal));

            else
                //helper
                addHelper(newVal, root.getLeft());

    }//add

    private void addHelper(Comparable newVal, TreeNode parent) 
    {

        //right
        if(newVal.compareTo(parent.getValue())> 0 && parent.getRight() == null)
            parent.setRight(new TreeNode(newVal));

        else if (newVal.compareTo(parent.getValue())> 0)
            addHelper(newVal, parent.getRight());

        //left
        else if(newVal.compareTo(parent.getValue()) <= 0 && parent.getLeft() == null)
            parent.setLeft(new TreeNode(newVal));

        else if (newVal.compareTo(parent.getValue()) <= 0)
            addHelper(newVal, parent.getLeft());

    }//addHelper


    public void printInOrder()
    {
        if (root.getLeft().getValue()== null)
        {
            System.out.println(root.getValue());
            if (root.getRight().getValue() != null)
                helperPIO(root.getRight());
        }
        else
            helperPIO(root.getLeft());
            if (root.getRight().getValue() != null)
                helperPIO(root.getRight());

    }//PrintInOrder Traversal
    
    private void helperPIO(TreeNode node)
    {
        Stack <Comparable> print = new Stack <Comparable> ();
        print.add(node.getValue()); //add to stack
        if (node.getLeft() != null)
        {
            helperPIO(node.getLeft());
        }
        if (node.getRight()!= null)
            helperPIO(node.getRight());

        while (!print.isEmpty())
            System.out.println(print.pop());
    }//helperPOI





}//end class