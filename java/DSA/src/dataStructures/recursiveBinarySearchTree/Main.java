package dataStructures.recursiveBinarySearchTree;

public class Main {
    public static void main(String[] args) {
        rBST bst = new rBST(10);
        bst.rInsert(15);
        bst.rInsert(15);
        bst.rInsert(25);
        bst.rInsert(30);
        bst.rInsert(9);
//        System.out.println(bst.rContains(8));
        System.out.println(bst.rContains(15));
    }
}
