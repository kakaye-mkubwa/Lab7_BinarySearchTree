import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;

public class BinarySearchTree_Bhattarai {
    TreeNode root;

    public BinarySearchTree_Bhattarai() {
        root = null;
    }

    public boolean insert(Student_Bhattarai student_bhattarai){
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();

        TreeNode n = new TreeNode();

        if (n == null){
            return false;
        }else{
            n.node = student_bhattarai.deepCopy();
            n.lc = null;
            n.rc = null;
            if (root == null){
                root = n;
            }else{
                findNode(student_bhattarai.getStudentID(),p,c);
                if (student_bhattarai.getStudentID().compareTo(p.get().node.getStudentID()) < 0){
                    p.get().lc = n;
                }else{
                    p.get().rc =n;
                }
            }
            return true;
        }
    }

    public Student_Bhattarai fetch(String targetKey){
        boolean found;
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();

        found = findNode(targetKey,p,c);
        if (found){
            return c.get().node.deepCopy();
        }else {
            return null;
        }
    }

    public boolean delete(String targetKey){
        boolean found;
        TreeNodeWrapper p = new TreeNodeWrapper();
        TreeNodeWrapper c = new TreeNodeWrapper();

        TreeNode largest;
        TreeNode nextLargest;
        found = findNode(targetKey,p,c);
        if (!found){
            return false;
        }else{
            if (c.get().lc == null && c.get().rc == null){
                if (p.get().lc == c.get()){
                    p.get().lc = null;
                }else{
                    p.get().rc = null;
                }
            }else if(c.get().lc == null || c.get().rc == null){
                if (p.get().lc == c.get()){
                    if (c.get().lc != null){
                        p.get().lc = c.get().lc;
                    }else {
                        p.get().lc = c.get().rc;
                    }
                }else{
                    if (c.get().lc != null){
                        p.get().rc = c.get().lc;
                    }else{
                        p.get().rc = c.get().rc;
                    }
                }
            }else{
                nextLargest = c.get().lc;
                largest = nextLargest.rc;

                if (largest != null){
                    while (largest.rc != null){
                        nextLargest = largest;
                        largest = largest.rc;
                    }
                    c.get().node = largest.node;
                    nextLargest.rc = largest.lc;
                }else{
                    nextLargest.rc = c.get().rc;
                    if (p.get().lc == c.get()){
                        p.get().lc = nextLargest;
                    }else{
                        p.get().rc = nextLargest;
                    }
                }
            }
            return true;
        }
    }

    public boolean update(String targetKey,Student_Bhattarai student_bhattarai){
        if (!delete(targetKey)){
            return false;
        }else if(!insert(student_bhattarai)){
            return false;
        }else {
            return true;
        }
    }

    public class TreeNode{
        private Student_Bhattarai node;
        private TreeNode lc;
        private TreeNode rc;

        public TreeNode(){

        }
    }

    private boolean findNode(String targetKey,TreeNodeWrapper parent,TreeNodeWrapper child){
        parent.set(root);
        child.set(root);

        if (root == null){
            return false;
        }
        while (child.get() != null){
            if (child.get().node.compareTo(targetKey) == 0){
                return true;
            }else{
                parent.set(child.get());
                if (targetKey.compareTo(child.get().node.getStudentID()) < 0){
                    child.set(child.get().lc);
                }else{
                    child.set(child.get().rc);
                }
            }
        }
        return false;
    }
    public class TreeNodeWrapper{
        TreeNode treeRef = null;

        public TreeNodeWrapper() {
        }

        public TreeNode get() {
            return treeRef;
        }

        public void set(TreeNode t) {
            this.treeRef = t;
        }
    }

    public void LNROutputTraversal(TreeNode mRoot){
        if (mRoot.lc != null){
            LNROutputTraversal(mRoot.lc);
        }
        System.out.println(mRoot.node);

        if (mRoot.rc != null){
            LNROutputTraversal(mRoot.rc);
        }
    }

    public void showAll(){
        if (root == null){
            System.out.println("The structure is empty");
        }else{
            LNROutputTraversal(root);
        }
    }
}
