import java.util.ArrayList;

public class Input {
    int nodesNumber;
    public ArrayList<Integer> keysList = new ArrayList<>();
    public int uKey;
    public int vKey;

    public Input(int nodesNumber, ArrayList<Integer> keysList, int uKey,
                 int vKey) {
        this.nodesNumber = nodesNumber;
        this.keysList = keysList;
        this.uKey = uKey;
        this.vKey = vKey;
    }
}
