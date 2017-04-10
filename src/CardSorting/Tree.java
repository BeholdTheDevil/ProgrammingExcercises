package CardSorting;

/**
 * Created by anton on 2017-04-03.
 */
public class Tree {

    Node root;
    int sortBy;

    Tree(int sortBy_) {
        sortBy = sortBy_;
    }

    void add(Card n) {
        if(root == null) root = new Node(n, sortBy);
        else {
            root.add(n);
        }
    }

    void list() {
        if(root != null) root.list(0);
        System.out.println("");
    }

    Node findNode(float n) {
        return root.find(n);
    }

    void removeNode(float n) {
        if(findNode(n) != null) root.remove(n);
    }



    class Node {

        Node left, right;
        Card card;
        int sortBy;

        Node(Card card_, int sortBy_) {
            card = card_;
            sortBy = sortBy_;
        }

        void add(Card n) {
            if((sortBy == -51 && (n.value < card.value || (n.value == card.value && n.color < card.color))) || (sortBy == -50 && (n.color < card.color || (n.color == card.color && n.value < card.value)))) {
                if(left == null) left = new Node(n, sortBy);
                else left.add(n);
            } else {
                if(right == null) right = new Node(n, sortBy);
                else right.add(n);
            }
        }

        boolean list(int n) {
            if(left == null || (left != null && left.list(n))) {
                System.out.print(card.name);
                if((n+1)%4 == 0) {
                    System.out.print("\n");
                } else {
                    System.out.print(" -> ");
                }
                if(right == null || (right != null && right.list(n+1))) {
                    return true;
                }
            }
            return false;
        }

        Node find(float n) {
            if(n == card.value) return this;
            else if(n < card.value) {
                if(left != null) {
                    return left.find(n);
                }
            } else if(n > card.value) {
                if(right != null) {
                    return right.find(n);
                }
            }
            System.out.println("Error: Node not found");
            return null;
        }

        void remove(float n) {
            if(left != null && left.card.value == n) {
                Node current = left.right;
                if(current != null) {
                    while(current.left != null) {
                        current = current.left;
                    }
                    current.left = left.left;
                }
                if(left.right != null) left = left.right;
                else left = left.left;
                return;
            } else if(right != null && right.card.value == n) {
                Node current = right.right;
                if(current != null) {
                    while (current.left != null) {
                        current = current.left;
                    }
                    current.left = right.left;
                }
                if(right.right != null) right = right.right;
                else right = right.left;
                return;
            }
            if(n < card.value) {
                left.remove(n);
            } else if(n > card.value) {
                right.remove(n);
            }
        }
   }
}
