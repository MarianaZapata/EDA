package arboles;
/**
 *
 * @author Mariana Zapata Covarrubias
 */
public class ExperimentoABB {
    
    private Node root;

    public ExperimentoABB() {
        root = null;
    }

    private class Node {
        int value;
        int weight;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.weight = 1;
            this.left = null;
            this.right = null;
        }
    }

    private void updateWeight(Node node) {
        if (node != null) {
            node.weight = (node.left != null ? node.left.weight + 1 : 1) +
                    (node.right != null ? node.right.weight + 1 : 1);
        }
    }

    private void rebalance(Node node) {
        if (node == null) {
            return;
        }

        if (node.left != null && node.right != null) {
            int leftWeight = node.left.weight;
            int rightWeight = node.right.weight;
            int weight = node.weight;
            if (leftWeight * 2 < weight) {
                int subWeight = node.right.left != null ? node.right.left.weight + 1 : 1;
                node.right.weight -= subWeight;
                node.weight -= subWeight;
                node.left = rotateRight(node.left);
                node = rotateLeft(node);
            } else if (rightWeight * 2 < weight) {
                int subWeight = node.left.right != null ? node.left.right.weight + 1 : 1;
                node.left.weight -= subWeight;
                node.weight -= subWeight;
                node.right = rotateLeft(node.right);
                node = rotateRight(node);
            }
        }

        updateWeight(node.left);
        updateWeight(node.right);
        updateWeight(node);
    }

    private Node rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        updateWeight(node);
        updateWeight(temp);
        return temp;
    }

    private Node rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        updateWeight(node);
        updateWeight(temp);
        return temp;
    }

    public void insert(int value) {
        root = insert(root, value);
        rebalance(root);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }

        updateWeight(node);
        return node;
    }
    
    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
      
    private static void printInOrder(ABBlogn.Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.value + " ");
            printInOrder(node.right);
        }
    }
    
    public static float log2(int N)
    {
        //Calcular log2(n)
        float result = (float)(Math.log(N) / Math.log(2));
        return result;
    }
    
    public static void main(String[] args) {
        ABBlogn tree = new ABBlogn();
        int n = 9;
        
        
        tree.insert(91);
        printInOrder(tree.root);
            System.out.println("\n");
            
        tree.insert(56);
        printInOrder(tree.root);
        System.out.println("\n");
            
        tree.insert(64);
        printInOrder(tree.root);
        System.out.println("\n");
            
        tree.insert(23);
        printInOrder(tree.root);
        System.out.println("\n");
            
        tree.insert(83);
        printInOrder(tree.root);
        System.out.println("\n");
        
        tree.insert(19);
        printInOrder(tree.root);
        System.out.println("\n");
        
        tree.insert(9);
        printInOrder(tree.root);
        System.out.println("\n");
        
        tree.insert(15);
        printInOrder(tree.root);
        System.out.println("\n");
        
        tree.insert(89);
        printInOrder(tree.root);
        System.out.println("\n");

        // Imprimir árbol en orden
        
        System.out.print("Valores del árbol en orden: ");
        printInOrder(tree.root);
        
        // Imprimir altura del árbol
        
        System.out.println("\n"+tree.height(tree.root));
        System.out.println("\nDebería acercarse a: "+log2(n+1));
    }
}