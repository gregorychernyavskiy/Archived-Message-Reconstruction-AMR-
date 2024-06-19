package AMR;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java -cp bin amr.Main <filename>");
            return;
        }

        String filename = args[0];
        String encodingString = null;
        String encodedMessage = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            encodingString = br.readLine();
            encodedMessage = br.readLine();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        if (encodingString != null && encodedMessage != null) {
            MsgTree tree = new MsgTree(encodingString);
            MsgTree.printCodes(tree, "");
            tree.decode(tree, encodedMessage);
        }
    }
}
