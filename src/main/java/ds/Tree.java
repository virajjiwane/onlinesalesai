package ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Tree {
    private Node root;

    public Tree() {
        root = new Node();
    }

    // path of the given N-ary Tree
    static void printPath(ArrayList<Node> vec) {

        // Print elements in the vector
        for (Node ele : vec) {
            System.out.print(ele.getCategories().getName() + " > ");
        }
        System.out.println(" = " + vec.get(vec.size() - 1).getFreq());
    }

    // Utility function to print all
    // root to leaf paths of an Nary Tree
    static void printAllRootToNodePaths(Node root, ArrayList<Node> vec) {

        // If root is null
        if (root == null)
            return;

        // Insert current node's
        // data into the vector
        vec.add(root);

        // Print the path
        printPath(vec);

        // Recur for all children of
        // the current node
        for (int i = 0; i < root.getSubCategories().size(); i++)
            // Recursive Function Call
            printAllRootToNodePaths(root.getSubCategories().get(i), vec);

        vec.remove(vec.size() - 1);
    }

    // Function to print root to leaf path
   public void printAllRootToNodePaths() {

        // If root is null, return
        if (root == null)
            return;

        // Stores the root to leaf path
        ArrayList<Node> vec = new ArrayList<>();

        // Utility function call
        printAllRootToNodePaths(root, vec);
    }
}
