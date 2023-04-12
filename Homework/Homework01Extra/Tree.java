
package Homework.Homework01Extra;

public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;
        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void fill (int levels) {
        root = new Node(1);
        fillTree(root, levels);
    }

    private void fillTree(Node current, int levels) {
//        if (current == null)
        if (levels == 0) {
            return;
        }

        if (current.leftChild == null && current.rightChild == null) {
            current.leftChild = new Node(current.value);
            current.rightChild = new Node(current.value +1);
            fillTree(current.leftChild, levels - 1);
            fillTree(current.rightChild, levels - 1);
        }


//        Node root = new Node();
//        root.value = 1;
//        current = root;
//        int count = 1;
//        while (count < levels) {
//            count++;
//            current.leftChild.value = current.value;
//            current.rightChild.value = current.value + 1;
//
//
//        }
//        return current;
    }

//        public List<Node> list(Node root) {
//        List<Node> currentLevel = new ArrayList<>();
//        currentLevel.add(root);
//        while (currentLevel.size() > 0) {
//            List<Node> nextLevel = new ArrayList<>();
//            for (Node node: currentLevel) {
//                if(node.value == value) {
//                    return node;
//                }
//            }
//            currentLevel = nextLevel;
//        }
//        return null;
//    }

}
