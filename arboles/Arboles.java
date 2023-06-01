package arboles;
/**
 *
 * @author Mariana Zapata Covarrubias
 */
import java.util.Iterator;
import java.util.Random;

public class Arboles {
	
    public static void printTree(Iterator<Integer> it) {
	while(it.hasNext()) {
            System.out.println(it.next());
	}
    }

	
    public static void TestClase() {

        AVLTree<Integer> tree = new AVLTree();
               
        tree.add(100);
	tree.add(200);
	tree.add(300);
	tree.add(250);
	tree.add(375);
	tree.add(280);
        tree.add(290);
        
	printTree(tree.inOrder());
        
        System.out.println("\nImpresión por nivel\n");
	tree.printTree();
        
	//Borrar
        
	System.out.println("\nEliminamos la raíz:\n");
	tree.delete(tree.root.getElement());
        tree.printTree();
          
        System.out.println("\nNueva raíz: " + tree.root.getElement());
        
        System.out.println("\nEliminamos 100:\n");
	tree.delete(100);
        tree.printTree();
        
        System.out.println("\nEliminamos 200:\n");
	tree.delete(200);
        tree.printTree();
              
	System.out.println("\nNueva raíz: " + tree.root.getElement());
        System.out.println("\nBuscar 280 "+tree.find(tree.root.getElement()));
    }
    
    public static void TestnAVLs(int n, int m) {
        float suma = 0;
        for (int i = 0; i < n; i++){
            AVLTree<Integer> treeAVL = new AVLTree();
            Random random = new Random();
            for (int j = 0; j < m; j++) {
                int value = random.nextInt(100);
                while (((value!=0) && (treeAVL.find(value)==false))==false){
                    value = random.nextInt(100);
                }
                System.out.println("Insertando " + value);
                treeAVL.add(value);
                System.out.println("\n");
            }
            suma += treeAVL.root.maxDepth(treeAVL.root);
        }
        System.out.println("Altura promedio obtenida para m = "+m+": "+(suma/n));
    }
    
    public static void main(String[] args) {
        TestnAVLs(10,20);
    }
}