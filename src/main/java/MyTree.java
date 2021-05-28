public class MyTree {
    private Node root;

    public void insert(Cat cat){
        Node node = new Node();
        node.cat = cat;
        if (root == null){
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if(cat.getId() < current.cat.getId()){
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }


    }

    public Node find(int key){
        Node current = root;
        while (current.cat.getId() != key){
            if(key < current.cat.getId()){
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if(current == null){
                return null;
            }
        }
        return current;
    }

    public void inOrder(Node rootNode){
        if(rootNode != null){
            inOrder(rootNode.leftChild);
            System.out.println(rootNode.toString());
            inOrder(rootNode.rightChild);
        }
    }

    public void preOrder(Node rootNode){
        if(rootNode != null){
            System.out.println(rootNode.toString());
            inOrder(rootNode.leftChild);
            inOrder(rootNode.rightChild);
        }
    }

    public void postOrder(Node rootNode){
        if(rootNode != null){
            inOrder(rootNode.leftChild);
            inOrder(rootNode.rightChild);
            System.out.println(rootNode.toString());
        }
    }

    public Node max(){
        Node current = root;
        Node last = null;
        while (current != null){
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public Node min(){
        Node current = root;
        Node last = null;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node getSuccessor(Node node){
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if(successor != node.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    public boolean delete(int id){
        Node current = root;
        Node parent = root;

        boolean isLeftChild = true;

        while (current.cat.getId() != id){
            parent = current;
            if(id < current.cat.getId()){
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null){
                return false;
            }
        }

        if(current.leftChild == null && current.rightChild == null){
            if(current == root){
                root = null;
            } if (isLeftChild){
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if(current.rightChild == null){
            if(current == null){
                root = current.leftChild;
            } else if(isLeftChild){
                parent.leftChild = current.leftChild;
            } else parent.rightChild = current.leftChild;

        } else if(current.leftChild == null){
            if(current == null){
                root = current.rightChild;
            } else if(isLeftChild){
                parent.leftChild = current.rightChild;
            } else parent.rightChild = current.rightChild;
        } else {
            Node successor = getSuccessor(current);
            if(current == root){
                root = successor;
            } else if(isLeftChild){
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public void display(){
        Node current = root;
        System.out.println("Симметричны:");
        inOrder(root);
        System.out.println("Прямой:");
        preOrder(root);
        System.out.println("Обратный:");
        postOrder(current);
    }
}
