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
        int lowLimit =0;
        int upLimit = 0;
        try {
            FileSystem fs = new FileSystem(inputPath, outputPath);
            arrSize = fs.nextInt();
            lowLimit = fs.nextInt();
            upLimit = fs.nextInt();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Input(arrSize,lowLimit,upLimit);
    }
}