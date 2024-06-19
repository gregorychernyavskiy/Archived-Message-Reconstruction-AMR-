### Archived Message Reconstruction (AMR)

**Project Overview:**
The Archived Message Reconstruction (AMR) project focuses on reconstructing or unzipping messages that have been archived using a binary-tree-based algorithm. This project is implemented in Java and involves reading encoded files, decoding messages using a binary tree structure, and printing the decoded messages along with their corresponding character codes.

**Features:**
1. **Binary Tree Construction:** 
   - Constructs a binary tree from a given encoding scheme using a preorder traversal.
   - Supports both recursive and iterative methods for tree construction.

2. **Message Decoding:**
   - Decodes archived messages encoded in a bit string format using the constructed binary tree.
   - Outputs the decoded message to the console.

3. **Character Encoding Display:**
   - Prints the characters and their corresponding binary codes.

4. **Statistics (Optional):**
   - Calculates and displays message-specific statistics, including average bits per character, total characters, and space savings.

**Usage:**
- The program prompts the user to enter the filename of the archived message (with a `.arch` extension).
- It reads the encoding scheme and the compressed message from the file.
- Constructs the binary tree and decodes the message, displaying the output on the console.

**Classes and Methods:**
1. **MsgTree Class:**
   - Represents the nodes of the binary tree.
   - **Fields:**
     - `char payloadChar`: Holds the character stored at the node.
     - `MsgTree left`: Reference to the left child node.
     - `MsgTree right`: Reference to the right child node.
     - `static int staticCharIdx`: A static index used for recursive tree construction.
   - **Constructors:**
     - `MsgTree(String encodingString)`: Constructs the tree from the encoding string using preorder traversal.
     - `MsgTree(char payloadChar)`: Constructs a single node with null children.
   - **Methods:**
     - `static void printCodes(MsgTree root, String code)`: Performs a recursive preorder traversal of the tree and prints all characters with their corresponding binary codes.
     - `void decode(MsgTree codes, String msg)`: Decodes the given message using the binary tree and prints the decoded message.

2. **Main Class:**
   - **Methods:**
     - `public static void main(String[] args)`: The main method that initiates the program.
     - Prompts the user for the filename, reads the file, constructs the binary tree, and calls methods to print the character codes and decode the message.

**Code Explanation:**
1. **Tree Construction:**
   - The encoding scheme is read from the file and passed to the `MsgTree` constructor.
   - The tree is built using a preorder traversal approach, where each character in the encoding string is processed to create nodes and establish parent-child relationships.

2. **Printing Character Codes:**
   - The `printCodes` method performs a recursive traversal of the tree.
   - For each leaf node, it prints the character and its corresponding binary code, accumulated during the traversal.

3. **Decoding the Message:**
   - The `decode` method reads the compressed message bit by bit.
   - Starting from the root of the tree, it traverses left or right based on each bit (0 or 1).
   - When a leaf node is reached, it prints the character stored at that node and restarts from the root for the next sequence of bits.

**Step-by-Step Guide:**
1. **Clone the Repository:**
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. **Compile the Java Files:**
   ```bash
   javac -d bin amr/*.java
   ```

3. **Run the Program:**
   ```bash
   java -cp bin amr.Main
   ```

4. **Enter the Filename:**
   - When prompted, enter the filename of the archived message (e.g., `monalisa.arch`).

5. **View the Output:**
   - The program will display the character codes and the decoded message on the console.

6. **Optional Statistics:**
   - If implemented, the program will also display message-specific statistics.

**Example:**
Given an encoding tree string `^a^^!^dc^rb` and a bit string `10110101011101101010100`, the program constructs the tree and decodes the message to `cadbard!`.

**Conclusion:**
The AMR project provides a robust solution for reconstructing archived messages using a binary-tree-based algorithm. It demonstrates the practical application of data structures in encoding and decoding processes. The project is a valuable tool for understanding tree traversal and binary encoding schemes, with potential for further enhancements such as handling larger datasets and optimizing performance.

---
