import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;
    private int size;
    private ArrayList<Integer> E = new ArrayList<>();
    private ArrayList<Integer> L = new ArrayList<>();
    private ArrayList<Integer> H = new ArrayList<>();

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Integer> getE() {
        return E;
    }

    public void setE(ArrayList<Integer> e) {
        E = e;
    }

    public ArrayList<Integer> getL() {
        return L;
    }

    public void setL(ArrayList<Integer> l) {
        L = l;
    }

    public ArrayList<Integer> getH() {
        return H;
    }

    public void setH(ArrayList<Integer> h) {
        H = h;
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
               node.setLeft(left);
               break;
           } else
               q.add(node.getLeft());

           if (node.getRight() == null) {
               Node right = new Node(key);
               node.setRight(right);
               break;
           } else
               q.add(node.getRight());
       }
   }

    public void euler(Node root, int level) {
        if (root != null) {
            E.add(root.getValue());
            L.add(level);
            root.setVisited(1);
        }
        if (root.getLeft() != null) {
            root.setVisited(1);
            euler(root.getLeft(), level+1);
            E.add(root.getValue());
            L.add(level);
        }
        if (root.getRight() != null) {
            root.setVisited(1);
            euler(root.getRight(), level+1);
            E.add(root.getValue());
            L.add(level);
        }
    }

    public void printE() {
       System.out.println(E);
    }
    public void printL() {
        System.out.println(L);
    }
    public void settingH() {
        int hSize = 0;
        for (int i:E) {
            if (i > hSize) {
                hSize = i;
            }
        }
        hSize = hSize + 1;
        //int[] hContent = new int[hSize + 1];
        ArrayList<Integer> hContent = new ArrayList<>();
        for (int i = 0; i < hSize; i++) {
            hContent.add(-1);
        }
        for (int i = 0; i < E.size(); i++) {
                if (hContent.get(E.get(i)) == -1) {
                    hContent.set(E.get(i), i);
            }
        }
        H.addAll(hContent);
    }
    public int sizeH() {
        return H.size();
    }
    public void printH() {
        System.out.println(H);
    }
    public int findLCA(int start, int stop) {
        int minimum = H.size();
        int indexOfMinimum = 0;
        if(start > stop) {
            int aux = start;
            start = stop;
            stop = aux;
        }
        for (int i = start; i <= stop; i++) {
            if(L.get(i) < minimum) {
                minimum = L.get(i);
                indexOfMinimum = i;
            }
        }
        return E.get(indexOfMinimum);
    }
}
