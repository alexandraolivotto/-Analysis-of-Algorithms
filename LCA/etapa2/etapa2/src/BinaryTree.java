import java.util.*;

public class BinaryTree {

    private Node root;
    private Node u;
    private Node v;
    private Node LCA;
    public int nr = 0;
    public Set<Node> ancestors = new HashSet<>();
    ArrayList<Integer> keyList = new ArrayList<>();

    public BinaryTree() {
        u = new Node(-1);
        v = new Node(-1);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getU() {
        return u;
    }

    public void setU(Node u) {
        this.u = u;
    }

    public Node getV() {
        return v;
    }

    public void setV(Node v) {
        this.v = v;
    }

    public Node getLCA() {
        return LCA;
    }

    public void setLCA(Node LCA) {
        this.LCA = LCA;
    }

/*    public Node getNodeByKey(int key) {
        Node keep_root = root;
        while(root != null){
            if(root.getKey() < key) {
                root = root.getRight();
            }
            if(root.getKey() > key) {
                root = root.getLeft();
            }
            if (root.getKey() == key ) {
                Node toRet = root;
                root = keep_root;
                return toRet;
            }
        }
        return null;
    }*/

/*    public Node getNodeByKey( Node node, int key) {
        if (node.getKey() == key) {
            return node;
        }
        if(node.getKey() != key) {
            Node aux = node;
            if (node.getLeft() != null) {
                return getNodeByKey(node.getLeft(), key);
            }
            if (node.getRight() != null) {
                return getNodeByKey(node.getRight(), key);
            }
        }
        return null;
    }*/
    public boolean ifNodeExists( Node node, int key)
    {
        if (node == null)
            return false;

        if (node.getKey() == key){
            if(u.getKey() == -1) {
                u = node;
            } else {
                if(v.getKey() == -1) {
                    v = node;
                }
            }
            return true;
        }
        boolean res1 = ifNodeExists(node.getLeft(), key);
        boolean res2 = ifNodeExists(node.getRight(), key);

        return res1 || res2;
    }

    public void insertNode(Node node, int key) {
        if(node == null) {
            Node root = new Node(key);
            setRoot(root);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);

        while (!q.isEmpty()) {
            node = q.peek();
            q.remove();

            if (node.getLeft() == null) {
                Node left = new Node(key);
                left.setParent(node);
                node.setLeft(left);
                break;
            } else
                q.add(node.getLeft());

            if (node.getRight() == null) {
                Node right = new Node(key);
                right.setParent(node);
                node.setRight(right);
                break;
            } else
                q.add(node.getRight());
        }
    }
    boolean existsArray (ArrayList<Integer> arr, int elem) {
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) == elem){
                return true;
            }
        }
        return false;
    }
    Node findLCA(Node u, Node v) {

        while (u != null) {
            ancestors.add(u);
            keyList.add(u.getKey());
            u = u.getParent();
        }
        keyList.add(root.getKey());
        while (v != null) {
            nr = nr+1;
            /*
            if (ancestors.contains(v) != ancestors.isEmpty()) {
                return v;
            }*/
            if(existsArray(keyList, v.getKey())){
                return v;
            }
            v = v.getParent();
        }
        return null;
    }
}
