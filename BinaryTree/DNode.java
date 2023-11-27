package BinaryTree;

public class DNode {
    private int index;

    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String emailAddress;
    private String phoneNumber; 

    private DNode left;
    private DNode right;

    public DNode()
    {

    }

    public DNode(
        int index, DNode left, DNode right)
    {
        this.index = index;
        this.left = left;
        this.right = right;
    }

    public DNode(
        int index, String name, String address, 
        String city, String state, String zipCode, 
        String emailAddress, String phoneNumber, 
        DNode left, DNode right)
    {
        this.index = index;

        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;

        this.left = left;
        this.right = right;
    }

    public int getIndex()
    {
        return this.index;
    }

    public DNode getLeft()
    {
        return this.left;
    }

    public DNode getRight()
    {
        return this.right;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public void setZipcode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setLeft(DNode left)
    {
        this.left = left;
    }

    public void setRight(DNode right)
    {
        this.right = right;
    }

    public String toString()
    {
        return "Contact ID " + this.index + "\n" +
                "Name: " + this.name + "\n" +
                "Address: " + this.address + "\n" +
                "City: " + this.city + "\n" +
                "State: " + this.state + "\n" +
                "ZIP Code: " + this.zipCode + "\n" +
                "Email Address: " + this.emailAddress + "\n" +
                "Phone Number: " + this.phoneNumber + "\n";
    }
}
