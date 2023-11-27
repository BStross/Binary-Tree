package BinaryTree;

import static BinaryTree.DManager.*;
import java.util.Scanner;

public class BSDictionary {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        DTree mainTree = dummyTree();

        menu(s, mainTree);
    }
}
