package BinaryTree;

import java.util.Scanner;

public class DManager {

    public static DTree dummyTree()
    {
        DNode carmen = new DNode(
            4, "Johnson, Carmen", "8940 Small St", 
            "Seattle", "WA", "44953", 
            "cjjohnson@yahoo.com" , "(206) 565-7878", 
            null, null);

        DNode sam = new DNode(
            5, "James, Sam", "8940 Small St", 
            "Seattle", "WA", "44953", 
            "sjames0813@yahoo.com" , "(206) 888-9999", 
            null, null);

        DNode king = new DNode(
            0, "James, Kingston", "400 Seafront Drive", 
            "Bellingham", "WA", "76867", 
            "kjames@yahoo.com" , "(360) 222-3333", 
            carmen, sam);

        DTree mainTree = new DTree(king);

        return mainTree;
    }

    // menu method
    public static void menu(Scanner s, DTree tree)
    {
        boolean start = true;
        String selection = "";

        printASCII();

        System.out.println("Welcome to the MALL Corp Associate Lookup!");
        System.out.println();

        while (start == true)
        {
            System.out.println("Please choose an option: ");
            menuText();
            s = new Scanner(System.in);
            selection = s.next().toLowerCase();
            start = menuLogic(s, tree, selection);
        }

    }

    private static void printASCII()
    {
        for (int i = 0; i < 9; i++)
        {
            System.out.print("# ");
        }
        System.out.println();
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (j == 0 || j == 4 || j == 8)
                {
                    System.out.print("# ");
                }
                else 
                {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < 9; i++)
        {
            System.out.print("# ");
        }
        System.out.println();
        System.out.println();
    }

    // text for menu method
    private static void menuText()
    {
        System.out.printf("%s%n%s%n%s%n%s%n%s%n", 
                        "Add an entry (a)",
                                "Remove an entry (r)",
                                "Perform a lookup (l)",
                                "Modify an entry (m)",
                                "Exit (e)");
    }

    // main menu logic
    private static boolean menuLogic(Scanner s, DTree tree, String selection)
    {
        char input = selection.charAt(0);

        if (input == 'a')
        {
            addNode(tree, createNode(tree, s));
            return true;
        }
        else if (input == 'r')
        {
            return removeMenuLogic(s, tree);
        }
        else if (input == 'l')
        {
            return lookupMenuLogic(s, tree);
        }
        else if (input == 'm')
        {
            modifyNode(s, tree);
            return true;
        }
        else if (input == 'e')
        {
            return false;
        }
        else 
        {
            System.out.println("Please input a valid option.");
            return true;
        }
    }

    // logic for lookup menu
    private static boolean lookupMenuLogic(Scanner s, DTree tree)
    {
        boolean start = true;
        char lookupChar;

        System.out.println("What kind of lookup would you like to do?");
        System.out.printf("%s%n%s%n%s%n",
                        "Pre-order (p)",
                                "In-order (i)",
                                "Post-order (o)");

        lookupChar = s.next().toLowerCase().charAt(0);

        System.out.println();

        while (start == true)
        {
            if (lookupChar == 'p')
            {
                start = preOrderPrintLogic(tree);
            }
            else if (lookupChar == 'i')
            {
                start = inOrderPrintLogic(tree);
            }
            else if (lookupChar == 'o')
            {
                start = postOrderPrintLogic(tree);
            }
            else
            {
                System.out.println("Invalid selection. Try again.");
            }
        }
        System.out.println();

        return true;
    }

    // more logic for lookup
    private static boolean preOrderPrintLogic(DTree tree)
    {
        if (isTreeEmpty(tree))
        {
            System.out.println("This tree is empty.");
            return false;
        } 
        else
        {
            printDictionaryPreOrder(tree.getRoot());
            return false;
        }
    }

    // more logic for lookup
    private static boolean inOrderPrintLogic(DTree tree)
    {
        if (isTreeEmpty(tree))
        {
            System.out.println("This tree is empty.");
            return false;
        } 
        else
        {
            printDictionaryInOrder(tree.getRoot());
            return false;
        }
    }

    // more logic for lookup
    private static boolean postOrderPrintLogic(DTree tree)
    {
        if (isTreeEmpty(tree))
        {
            System.out.println("This tree is empty.");
            return false;
        } 
        else
        {
            printDictionaryPostOrder(tree.getRoot());
            return false;
        }
    }

    private static boolean isTreeEmpty(DTree tree)
    {
        return tree.getRoot() == null;
    }

    // logic for remove menus
    private static boolean removeMenuLogic(Scanner s, DTree tree)
    {
        int removeIndex = getUserIndex(s, tree, "index ");
        boolean removeStatus = removePrompt(s, removeIndex);
        if (removeStatus)
        {
            removeNode(tree, removeIndex);
            return true;
        }
        else 
        {
            return true;
        }
    }

    // yes or no prompt for removing nodes
    private static boolean removePrompt(Scanner s, int nodeIndex)
    {
        boolean start = true;
        char inputChar = ' ';

        System.out.println("Are you sure you want to delete the node at " + nodeIndex + "?");
        System.out.println("(y) for Yes");
        System.out.println("(n) for No");

        while (start == true) {
            inputChar = s.next().toLowerCase().charAt(0);

            if (inputChar == 'y')
            {
                return true;
            }
            else if (inputChar == 'n')
            {
                return false;
            }
            else
            {
                System.out.println();
                System.out.println("Please enter a valid response.");
            }
        }

        return false;
    }

    // overhead for modifying node
    private static void modifyNode(Scanner s, DTree tree)
    {
        boolean start = true;
        String selection = "";
        int index;
        DNode node;

        System.out.println("Please indicate the index of the node you'd like to modify: ");
        index = s.nextInt();
        System.out.println();

        node = getIndexedNode(tree.getRoot(), index);
        System.out.println(node.toString());

        System.out.println("Please indicate the field you'd like to modify: ");
        while (start == true)
        {
            modifyText();
            s = new Scanner(System.in);
            selection = s.next().toLowerCase();
            start = modifyLogic(s, node, selection);
            System.out.println();
            // System.out.println(node.toString());
        }
    }

    // text for modify method
    private static void modifyText()
    {
        System.out.printf(
                         "%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n", 
                        "Name (n)",
                                "Address (a)",
                                "City (c)",
                                "State (s)",
                                "ZIP code (z)",
                                "Email (e)",
                                "Phone Number (p)",
                                "Back (b)");
    }

    // logic for modifying 
    private static boolean modifyLogic(Scanner s, DNode node, String selection)
    {
        if (selection.charAt(0) == 'n')
        {
            node.setName(getName(s));
            return true;
        }
        if (selection.charAt(0) == 'a')
        {
            node.setAddress(getUserAddress(s, "address "));
            return true;
        }
        if (selection.charAt(0) == 'c')
        {
            node.setCity(getUserString(s, "city "));
            return true;
        }
        if (selection.charAt(0) == 's')
        {
            node.setState(getUserString(s, "state "));
            return true;
        }
        if (selection.charAt(0) == 'z')
        {
            node.setZipcode(getUserString(s, "ZIP code "));
            return true;
        }
        if (selection.charAt(0) == 'e')
        {
            node.setEmailAddress(getUserString(s, "email address "));
            return true;
        }
        if (selection.charAt(0) == 'p')
        {
            node.setPhoneNumber(phoneNumberFromUser(s));
            return true;
        }
        if (selection.charAt(0) == 'b')
        {
            return false;
        }
        else
        {
            System.out.println("Invalid selection. Please try again.");
            return true;
        }
    }

    // creates a node using information fetched from user
    private static DNode createNode(DTree tree, Scanner s)
    {
        DNode newNode = new DNode();
        
        System.out.print("Used Keys (no duplicates allowed): ");
        inOrder(tree.getRoot());
        System.out.println();

        newNode.setIndex(getUserIndex(s, tree, "primary key "));
        newNode.setName(getName(s));
        System.out.println();
        newNode.setAddress(getUserString(s, "address "));
        System.out.println();
        newNode.setCity(getUserString(s, "city "));
        System.out.println();
        newNode.setState(getUserString(s, "state "));
        System.out.println();
        newNode.setZipcode(getUserString(s, "ZIP code "));
        System.out.println();
        newNode.setEmailAddress(getUserString(s, "email address "));
        System.out.println();
        newNode.setPhoneNumber(phoneNumberFromUser(s));
        System.out.println();

        return newNode;
    }

    private static String getUserAddress(Scanner s, String startText)
    {
        s = new Scanner(System.in);

        String string = "";

        System.out.println("Please enter the " + startText + "for this entry:");
        string = s.nextLine();

        return string;
    }

    // gets phone number from user
    private static String phoneNumberFromUser(Scanner s)
    {
        long selection = 0;

        boolean validInput = false;

        while (validInput == false)
        {
            try
            {
                s = new Scanner(System.in);
                System.out.println("Please enter a phone number: ");
                selection = s.nextLong();
                validInput = true;
            }
            catch (Exception NumberformatException)
            {
                System.out.printf("%n%s%n%s", 
                "Please enter a valid ten digit phone number ", 
                "without spaces or special characters.");
                System.out.println("");
            }
        }

        return numberFormatter(selection);
    }

    // turns phone number into proper format
    private static String numberFormatter(Long num)
    {
        String number = Long.toString(num);

        number = "(" + number.substring(0, 3) + ") " 
                + number.substring(3, 6) 
                + "-" + number.substring(6, 10);

        return number;
    }

    // gets multiple strings from user for the name field
    private static String getName(Scanner s)
    {
        String firstName = getUserString(s, "first name ");
        String lastName = getUserString(s, "last name ");
        String name = lastName + ", " + firstName;
        
        return name;
    }

    // gets string from user
    private static String getUserString(Scanner s, String startText)
    {
        s = new Scanner(System.in);

        String string = "";

        System.out.println("Please enter the " + startText + "for this entry:");
        string = s.next();

        return string;
    }

    // gets index for entry from user
    private static int getUserIndex(Scanner s, DTree tree, String startText)
    {
        int index = 0;

        if (tree.getRoot() == null)
        {
            return 0;
        }
        else
        {
            index = getUserIndexLoop(s, startText);
        }

        if (index < 0)
        {
            return -index;
        }

        return index;
    }

    // try-catch for getting user index
    private static int getUserIndexLoop(Scanner s, String startText)
    {
        boolean validInput = false;
        int index = 0;

        System.out.println("Please indicate the " + startText + "for this entry");
        // System.out.println("(no duplicate keys allowed): ");

        while (validInput == false)
        {
            try 
            {
                s = new Scanner(System.in);
                index = s.nextInt();
                validInput = true;
            }
            catch (Exception NumberformatException)
            {
                System.out.println("Please input an integer greater than zero.");
            }
        }

        System.out.println();

        return index;
    }

    // remove node method
    private static void removeNode(DTree tree, int index)
    {
        DNode parent;
        DNode leaf;
        DNode target = getIndexedNode(tree.getRoot(), index);

        if (target != tree.getRoot())
        {
            parent = getIndexedNode(
                    tree.getRoot(), getParentIndex(tree.getRoot(), target.getIndex()));

            if (parent.getLeft() == target)
            {
                parent.setLeft(removeNodeLogic(tree, index));
            }
            if (parent.getRight() == target)
            {
                parent.setRight(removeNodeLogic(tree, index));
            }
        }
        else if (target == tree.getRoot() 
            && (target.getLeft() != null 
            || target.getRight() != null))
        {
            leaf = getLeaf(target);
            // sever leaf from tree
            leafRemoval(tree, leaf);
            // copy main branches of root to leaf
            leaf.setLeft(target.getLeft());
            leaf.setRight(target.getRight());
            // set root branches to null
            target.setLeft(null);
            target.setRight(null);
            // set tree root to leaf
            tree.setRoot(leaf);
        }
        else 
        {
            tree.setRoot(null);
        }
    }

    // logic for node removal
    private static DNode removeNodeLogic(DTree tree, int index)
    {
        DNode target = getIndexedNode(tree.getRoot(), index);
        DNode leaf;

        if (target.getLeft() == null 
            && target.getRight() == null)
        {
            return null;
        }
        else if (target.getLeft() == null 
            && target.getRight() != null)
        {
            return target.getRight();
        }
        else if (target.getLeft() != null 
            && target.getRight() == null)
        {
            return target.getLeft();
        }
        else if (target.getLeft() != null 
            && target.getRight() != null)
        {
            leaf = getLeaf(tree.getRoot());
            leafRemoval(tree, leaf);
            leaf.setLeft(target.getLeft());
            leaf.setRight(target.getRight());
            return leaf;
        }
        else
        {
            return null;
        }
    }

    // special method to sever leaf from tree
    private static void leafRemoval(DTree tree, DNode leaf)
    {
        DNode parent = getIndexedNode(
            tree.getRoot(), getParentIndex(tree.getRoot(), leaf.getIndex()));

        if (parent.getLeft() == leaf)
        {
            parent.setLeft(null);
        }
        else if (parent.getRight() == leaf)
        {
            parent.setRight(null);
        }
    }

    // gets the index of a parent node
    private static int getParentIndex(DNode current, int index)
    {
        int returnIndex;
        if (current == null 
            || (current.getLeft() == null 
            && current.getRight() == null))
        {
            return -1;
        }

        if (current.getLeft() != null 
            && current.getLeft().getIndex() == index)
        {
            return current.getIndex();
        }

        if (current.getRight() != null 
            && current.getRight().getIndex() == index)
        {
            return current.getIndex();
        }

        returnIndex = getParentIndex(current.getLeft(), index);
        if (returnIndex != -1)
        {
            return returnIndex;
        }
        returnIndex = getParentIndex(current.getRight(), index);

        return returnIndex;
    }

    // recursively adds node wherever there is space
    private static void addNode(DTree tree, DNode newNode)
    {
        DNode parent;

        if (tree.getRoot() != null)
        {
            parent = getFreeNode(tree.getRoot());

            if (parent.getLeft() == null)
            {
                parent.setLeft(newNode);
            }
            else if (parent.getRight() == null)
            {
                parent.setRight(newNode);
            }
        }
        else
        {
            tree.setRoot(newNode);
        }
    }

    // gets the inorder node that has a free space 
    private static DNode getFreeNode(DNode node)
    {
        DNode returnNode;
        if (node == null)
        {
            return null;
        }
        else if (node.getLeft() == null)
        {
            return node;
        }
        else if (node.getRight() == null)
        {
            return node;
        }

        returnNode = getFreeNode(node.getLeft());
        if (returnNode != null)
        {
            return returnNode;
        }
        returnNode = getFreeNode(node.getRight());
        return returnNode;
    }

    // uses in-order search to get node @ index
    private static DNode getIndexedNode(DNode node, int index)
    {
        DNode returnNode;
        if (node == null)
        {
            return null;
        }
        if (node.getIndex() == index)
        {
            return node;
        }

        returnNode = getIndexedNode(node.getLeft(), index);
        if (returnNode != null)
        {
            return returnNode;
        }
        returnNode = getIndexedNode(node.getRight(), index);
        return returnNode;
    }

    // traverses tree and gets the leftmost leaf 
    private static DNode getLeaf(DNode node)
    {
        DNode returnNode;
        if (node == null)
        {
            return null;
        }
        if (node.getRight() == null 
            && node.getLeft() == null)
        {
            return node;
        }

        returnNode = getLeaf(node.getLeft());
        if (returnNode != null)
        {
            return returnNode;
        }
        returnNode = getLeaf(node.getRight());
        return returnNode;
    }

    // prints dictionary in pre-order
    private static void printDictionaryPreOrder(DNode node)
    {
        if (node == null)
        {
            return;
        }

        System.out.println(node.toString() + " ");
        printDictionaryPreOrder(node.getLeft());
        printDictionaryPreOrder(node.getRight());
    }

    // prints dictionary in in-order
    private static void printDictionaryInOrder(DNode node)
    {
        if (node == null)
        {
            return;
        }

        printDictionaryInOrder(node.getLeft());
        System.out.println(node.toString() + " ");
        printDictionaryInOrder(node.getRight());
    }

    // prints dictionary in post-order
    private static void printDictionaryPostOrder(DNode node)
    {
        if (node == null)
        {
            return;
        }

        printDictionaryPostOrder(node.getLeft());
        printDictionaryPostOrder(node.getRight());
        System.out.println(node.toString() + " ");
    }

    // recursive in-order search (base)
    private static void inOrder(DNode node)
    {
        if (node == null)
        {
            return;
        }

        inOrder(node.getLeft());
        System.out.print(node.getIndex() + " ");
        inOrder(node.getRight());
    }

    // recursive pre-order search
    private static void preOrder(DNode node)
    {
        if (node == null)
        {
            return;
        }

        System.out.print(node.getIndex() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }
    // recursive post-order search
    private static void postOrder(DNode node)
    {
        if (node == null)
        {
            return;
        }

        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getIndex() + " ");
    }    
}
