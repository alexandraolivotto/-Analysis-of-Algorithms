import fileio.implementations.FileWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Main {
    public static int generateRandomInRange(int min, int max) {

        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;

    }
    static public void fileWrite (int size, Set<Integer> keys, int u, int v,
                                  InputLoader inputLoader) throws IOException, IOException {
        FileWriter fileWriter = new FileWriter(inputLoader.outputPath);
        fileWriter.writeInt(size);
        fileWriter.writeNewLine();
        Iterator value = keys.iterator();
        for(int i = 0; i < size; i++){
            fileWriter.writeInt((Integer) value.next());
            fileWriter.writeWord(" ");
        }
        fileWriter.writeNewLine();
        fileWriter.writeInt(u);
        fileWriter.writeWord(" ");
        fileWriter.writeInt(v);
        fileWriter.writeNewLine();
        fileWriter.close();
    }
    public static void main(String[] args) throws IOException {
        InputLoader inputLoader = new InputLoader(args[0], args[1]);
        Input input = inputLoader.load();
        int size = input.size;
        int addI = 0;
        int min = input.lowLimit;
        int max = input.upLimit;
        //System.out.println(min);
        //System.out.println(max);
        TestGenerator testGenerator = new TestGenerator();
        testGenerator.size = size;
        while(testGenerator.keys.size() < size){
            addI = generateRandomInRange(min,max);
            testGenerator.keys.add(addI);
        }
        //picking u and v

        int itemU = new Random().nextInt(size);
        int i = 0;
        for(Integer obj : testGenerator.keys) {
            if (i == itemU){
                testGenerator.u = obj;
            }
            i++;
        }
        int itemV = new Random().nextInt(size);
        while ( itemU == itemV){
            itemV = new Random().nextInt(size);
        }
        i = 0;
        for(Integer obj : testGenerator.keys) {
            if (i == itemV){
                testGenerator.v = obj;
            }
            i++;
        }


        fileWrite(size, testGenerator.keys, testGenerator.u, testGenerator.v ,
                inputLoader);
    }
}
