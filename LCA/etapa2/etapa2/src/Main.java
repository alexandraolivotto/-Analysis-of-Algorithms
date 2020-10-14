import fileio.implementations.FileWriter;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        InputLoader inputLoader = new InputLoader(args[0], args[1]);
        Input input = inputLoader.load();

        int nodesNumber = input.nodesNumber;
        ArrayList<Integer> keys = input.keysList;
        int uNodeKey = input.uKey;
        int vNodeKey = input.vKey;
        BinaryTree tree = new BinaryTree();
        for(int key:keys) {
            tree.insertNode(tree.getRoot(), key);
        }
        tree.ifNodeExists(tree.getRoot(), uNodeKey);
        tree.ifNodeExists(tree.getRoot(), vNodeKey);

        Node lcaNode = tree.findLCA(tree.getU(), tree.getV());

        System.out.println(lcaNode.getKey());
    }
}
