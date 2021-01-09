import java.util.Comparator;
        import java.util.NoSuchElementException;

public class BinaryTree<Type1, Type2> {
    public class Node<Type1, Type2> {
        Type1 key;
        Type2 value;
        Node<Type1, Type2> left;
        Node<Type1, Type2> right;
        int height;

        Node(Type1 key, Type2 data) {
            this.value = data;
            this.key = key;
            this.right = null;
            this.left = null;
            this.height = 1;
        }

        public int getHeight() {
            return this.height;
        }

        public Type2 getVal() {
            return this.value;
        }

        public Type1 getKey() {
            return this.key;
        }

        public Node<Type1, Type2> getLeft() {
            return this.left;
        }

        public Node<Type1, Type2> getRight() {
            return this.right;
        }

        public int compareTo(Type1 val1) {
            Comparator<Type1> comp = new Comparator<Type1>() {
                @Override
                public int compare(Type1 o1, Type1 o2) {
                    try {
                        Comparable val1 = (Comparable) o1;
                        Comparable val2 = (Comparable) o2;
                        return val1.compareTo(val2);
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            return comp.compare(val1, this.key);
        }
    }

    public Node<Type1, Type2> root;

    public BinaryTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }


    //Balancing
    int getHeight(Node<Type1, Type2> root) {

        return root != null ? root.height : 0;
    }

    int getBalanceFactor(Node<Type1, Type2> root) {
        if (root == null) {
            return 0;
        }

        return getHeight(root.right) - getHeight(root.left);
    }

    void fixHeight(Node<Type1, Type2> root) {
        if (root == null) {
            return;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        root.height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
    }

    Node<Type1, Type2> rotateRight(Node<Type1, Type2> root) {
        Node<Type1, Type2> leftTree = root.left;
        root.left = leftTree.right;
        leftTree.right = root;
        fixHeight(root);
        fixHeight(leftTree);
        return leftTree;
    }

    Node<Type1, Type2> rotateLeft(Node<Type1, Type2> root) {
        Node<Type1, Type2> rightTree = root.right;
        root.right = rightTree.left;
        rightTree.left = root;
        fixHeight(root);
        fixHeight(rightTree);
        return rightTree;
    }

    Node<Type1, Type2> balance(Node<Type1, Type2> root) {
        fixHeight(root);
        if (getBalanceFactor(root) == 2) {
            if (getBalanceFactor(root.right) < 0) {
                root.right = rotateRight(root.right);
            }
            return rotateLeft(root);
        }
        if (getBalanceFactor(root) == (-2)) {
            if (getBalanceFactor(root.left) > 0) {
                root.left = rotateLeft(root.left);
            }
            return rotateRight(root);
        }
        return root;
    }

    private Node<Type1, Type2> addElement(Type1 key, Type2 value, Node<Type1, Type2> root) {
        Node<Type1, Type2> newNode = new Node<>(key, value);

        if (value == null) {
            throw new NullPointerException("Null values are not permitted!");
        } else if (root == null) {
            root = newNode;
        } else if (root.compareTo(key) < 0) {
            root.left = addElement(key, value, root.left);
        } else if (root.compareTo(key) > 0) {
            root.right = addElement(key, value, root.right);
        } else if (root.compareTo(key) == 0) {
            Node<Type1, Type2> old = root;
            root.value = value;
            return balance(old);
        }
        return balance(root);
    }


    public Type2 add(Type1 key, Type2 value) {
        this.root = addElement(key, value, this.root);
        return this.root.getVal();
    }

    public boolean isContains(Type1 key) {
        Node<Type1, Type2> current = this.root;
        while (current != null) {
            if (current.compareTo(key) < 0) {
                current = current.left;
            } else if (current.compareTo(key) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;

    }

    public Type2 getValue(Type1 key) {
        if (!this.isContains(key)) {
            throw new NoSuchElementException();
        }
        Node<Type1, Type2> current = this.root;
        while (current != null) {
            if (current.compareTo(key) < 0) {
                current = current.left;
            } else if (current.compareTo(key) > 0) {
                current = current.right;
            } else {
                return current.value;
            }
        }
        return null;

    }

    private Node<Type1, Type2> findSmallestValue(Node<Type1, Type2> root) {
        Node<Type1, Type2> current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }


    private Node<Type1, Type2> removeSmallestValue(Node<Type1, Type2> root) {
        if (root.left == null) {
            return root.right;
        } else {
            root.left = removeSmallestValue(root.left);
            return balance(root);
        }
    }

    public Node<Type1, Type2> findParent(Node<Type1, Type2> elem) {
        if (elem != this.root) {

            Node<Type1, Type2> current = this.root;
            while (current.left != elem && current.right != elem) {
                if (elem.compareTo(current.key) > 0) {
                    current = current.left;
                } else if (elem.compareTo(current.key) < 0) {
                    current = current.right;
                } else {
                    return current;
                }
            }
            return current;
        }
        return null;
    }

    private Node<Type1, Type2> removeElement(Type1 key, Node<Type1, Type2> root) {
        if (!this.isContains(key)) {
            throw new NoSuchElementException();
        }
        Node<Type1, Type2> current = root;

        if (current == null) {
            return null;
        }

        if (current.compareTo(key) > 0) {
            current.right = removeElement(key, current.right);
        } else if (current.compareTo(key) < 0) {
            current.left = removeElement(key, current.left);
        } else {
            //System.out.println("Height of: "+current.value + " IS " + current.height);
            Node<Type1, Type2> leftTree = current.left;
            Node<Type1, Type2> rightTree = current.right;
            if (rightTree == null) {
                return balance(leftTree);
            }
            Node<Type1, Type2> min = findSmallestValue(rightTree);
            min.right = removeSmallestValue(rightTree);
            min.left = leftTree;

            return balance(min);
        }
        return balance(current);
    }

    public void remove(Type1 key) {
        this.root = removeElement(key, this.root);
        return;
    }


}