package AMR;

public class MsgTree {

    public char payloadChar;
    public MsgTree left;
    public MsgTree right;
    private static int staticCharIdx = 0;

    // Constructor building the tree from a string
    public MsgTree(String encodingString) {
        if (encodingString == null || encodingString.length() == 0) {
            return;
        }

        payloadChar = encodingString.charAt(staticCharIdx);
        staticCharIdx++;

        if (payloadChar == '^') {
            left = new MsgTree(encodingString);
            right = new MsgTree(encodingString);
        }
    }

    // Constructor for a single node with null children
    public MsgTree(char payloadChar) {
        this.payloadChar = payloadChar;
        left = null;
        right = null;
    }

    // Method to print characters and their binary codes
    public static void printCodes(MsgTree root, String code) {
        if (root == null) {
            return;
        }
        if (root.payloadChar != '^') {
            System.out.println(root.payloadChar + " " + code);
        }
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    // Method to decode the message
    public void decode(MsgTree codes, String msg) {
        if (codes == null || msg == null || msg.length() == 0) {
            return;
        }

        MsgTree current = codes;
        StringBuilder decodedMessage = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.payloadChar != '^') {
                decodedMessage.append(current.payloadChar);
                current = codes;
            }
        }

        System.out.println("MESSAGE:");
        System.out.println(decodedMessage.toString());
    }
}
