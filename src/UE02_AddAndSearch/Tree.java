package UE02_AddAndSearch;

public class Tree {
    private Node root;

    public void add(int number) {
        Node newNode = new Node(number);

        // Baum ist noch leer
        if (root == null)
            root = newNode;
        // Sonst richtige Stelle suchen und dort einfügen
        else {
            // Variante 1: Rekursiv
            addRecursive(root, newNode);
            // Variante 2: Schleife
            addLoop(root, newNode);
        }
    }

    // Add - Variante Rekursion
    private void addRecursive(Node currentNode, Node newNode) {
        if (currentNode.getNumber() > newNode.getNumber())
        {
            // Ist die linke Position von CurrentNode frei?
            if (currentNode.getLeft() == null)
            {
                currentNode.setLeft(newNode);
            }
            // Linke Position ist schon belegt
            else
            {
                addRecursive(currentNode.getLeft(), newNode);
            }
        }
        else if (currentNode.getNumber() < newNode.getNumber())
        {
            // Ist die rechte Position von currentNode frei?
            if (currentNode.getRight() == null)
            {
                currentNode.setRight(newNode);
            }
            // Rechte Position ist schon belegt
            else
            {
                addRecursive(currentNode.getRight(), newNode);
            }
        }
    }

    // Add - Variante Loop
    private void addLoop(Node startNode, Node newNode) {

          Node currentNode = startNode;
          boolean nodeAdded = false;

          while(nodeAdded = false)
        {
            if(newNode.getNumber() < currentNode.getNumber()){

                if(currentNode.getLeft() == null){

                    currentNode.setLeft(newNode);
                    nodeAdded = true;
                }
                else{
                    currentNode = currentNode.getLeft();
                }

            }
            else
            {
                if(currentNode.getRight() == null){

                    currentNode.setRight(newNode);
                    nodeAdded = true;
                }
                else{
                    currentNode = currentNode.getRight();

                }
            }

        }

    }

    public Node searchNumber(int number) {
        System.out.print("SearchNumber - ");

        Node currentNode = root;
        while (currentNode != null) {
            if (number == currentNode.getNumber())
                return currentNode;
            else if (number < currentNode.getNumber())
                currentNode = currentNode.getLeft();
            else
                currentNode = currentNode.getRight();
        }
            return null;


    }   // Variante 2: Aufruf Schleife
        //return searchNumberLoop(number);


    // Suche - Variante Rekursion
    private Node searchNumberRecursive(Node currentNode, int number) {
            // Base Case: root is null or not
            if (currentNode == null) {
                // Insert the new data, if root is null
                // return the current root to his sub tree
                return null;
            }
            // Here checking for root data is greater or equal to newData or not
            else if (currentNode.getNumber() == number) {
                // if current root data is greater than the new data then now process the left sub-tree
              return currentNode;
            } else if(currentNode.getNumber() > number){
                 return searchNumberRecursive(currentNode.getLeft(), number);
            }
            else

            return searchNumberRecursive(currentNode.getRight(), number);

    }

    // Suche - Variante Schleife
    private Node searchNumberLoop(int number) {
        Node newNode = new Node(number);
        if(root == null){
            root = newNode;
            return root;
        }
        else if(root.getNumber() >= number){

        }

        return null;
    }

    /**
     * Funktion zur Ausgabe des gesamten Baums.
     */
    public void printTree() {
        printTree(root, "");
    }

    /**
     * Funktion zur Ausgabe des Baums unterhalb eines Knotens
     *
     * @param currentNode Knoten, dessen Teilbaum ausgegeben werden soll
     * @param prefix      Zur Einr�ckung
     */
    public void printTree(Node currentNode, String prefix) {
        if (currentNode == null) {
            return;
        }
        System.out.println(prefix + currentNode.getNumber());
        printTree(currentNode.getLeft(), prefix + "L ");
        printTree(currentNode.getRight(), prefix + "R ");
    }


}
