// Darrell Criss
// Class: CS145
// 11/21/2023
// References: https://www.java67.com/2016/08/binary-tree-inorder-traversal-in-java.html 
// Bradford Stross
// Assignment: Lab 6 - Binary Search Tree
// Unsorted Binary Tree + basic operations

// There are a few bugs, mostly in user input. 
// Duplicate keys may also cause unintended behavior - you have been warned!

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
