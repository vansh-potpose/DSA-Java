import java.util.*;
public class BinaryTreeM{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree {
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode= new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;

        }
        
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.data+" ");
    }
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        
        preOrder(root.left);
        System.out.print(root.data+" ");
        preOrder(root.right);
    }

    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode =q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }

    }

    public static int countOfNodes(Node root){
        if(root==null){
            return 0;
        }
        return 1+countOfNodes(root.left)+countOfNodes(root.right);
    }

    public static int sumOfNodes(Node root){
        if(root==null){
            return 0;
        }
        return root.data+sumOfNodes(root.left)+sumOfNodes(root.right);
    }

    public static int heightOfTree(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=heightOfTree(root.left);
        int rightHeight=heightOfTree(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

    public static int diameter(Node root){
        //O(n)
        if(root==null){
            return 0;
        }
        int diam1=diameter(root.left);
        int diam2=diameter(root.right);
        int diam3=heightOfTree(root.left)+heightOfTree(root.right)+1;
        return Math.max(diam1,Math.max(diam2,diam3));
    }

    static class TreeInfo{
        int ht;
        int diam;

        TreeInfo(int ht,int diam){
            this.ht=ht;
            this.diam=diam;
        }
    }

    public static TreeInfo diameter2(Node root){
        if(root==null){
            return new TreeInfo(0,0);
        }
        TreeInfo left =diameter2(root.left);
        TreeInfo right =diameter2(root.right);
        int myHeight=Math.max(left.ht,right.ht)+1;

        int diam1=left.diam;
        int diam2=right.diam;
        int diam3=left.ht+right.ht+1;

        int mydiam=Math.max(diam1, Math.max(diam2, diam3));

        TreeInfo myInfo =new TreeInfo(myHeight, mydiam);
        return myInfo;
    }

    public static boolean identical(Node root,Node subRoot){
        if(root==null && subRoot == null){
            return true;
        }
        if(root==null || subRoot == null){
            return false;
        }
        if(root.data==subRoot.data){
            return identical(root.left, subRoot.left) && identical(root.right, subRoot.right);
        }
        return false;
    }
    public static boolean isSubtree(Node root,Node subRoot){
        if(subRoot==null){
            return true;
        }
        if(root==null){
            return false;
        }
        if(root.data==subRoot.data){
            return identical(root, subRoot);
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int sub[]={2,4,-1,-1,5,-1,-1};
        /*     1
             /   \
            2      3
           /  \     \
          4   5      6
         */
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(nodes);
        System.out.println(root.data);
        // preOrder(root);
        levelOrder(root);
        System.err.println();
        System.err.println(countOfNodes(root));
        System.err.println(sumOfNodes(root));
        System.err.println(heightOfTree(root));

        BinaryTree stree=new BinaryTree();
        Node subroot=stree.buildTree(sub);
        System.out.println(isSubtree(root, subroot));
        
    }
}

