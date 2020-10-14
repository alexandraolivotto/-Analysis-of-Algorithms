import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;

public class InputLoader {
    public final String inputPath;
    public final String outputPath;

    public InputLoader(final String inputPath, final String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    public Input load() {
        int arrSize = 0;
        ArrayList<Integer> keys = new ArrayList<>();
        int uk = 0;
        int vk = 0;
        try {
            FileSystem fs = new FileSystem(inputPath, outputPath);
            arrSize = fs.nextInt();
            for(int i = 0; i < arrSize; i++) {
                keys.add(fs.nextInt());
            }
            uk = fs.nextInt();
            vk = fs.nextInt();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Input(arrSize, keys, uk, vk);
    }
}
