//c3315176 - Jeremy Anderson

public class Product
{
    private String name;
    private double price;
    private double weight;
    private int quantity;

    /**
     * creates initial values for a product
     * a product will only exist within a depot when the values are changed
     */
    public Product()
    {
        name = "null";
        price = 0;
        weight = 0;
        quantity = 0;
    }

    /**
     *
     */
    public Product(String newProductName, double newProductPrice, double newProductWeight, int newProductQuantity)
    {
        name = newProductName;
        price = newProductPrice;
        weight = newProductWeight;
        quantity = newProductQuantity;
    }

    public void setProductName(String newProductName)
    {
        name = newProductName;
    }

    public String getProductName()
    {
        return name;
    }

    public void setProductPrice(double newProductPrice)
    {
        price = newProductPrice;
    }

    public double getProductPrice()
    {
        return price;
    }

    public void setProductWeight(double newProductWeight)
    {
        weight = newProductWeight;
    }

    public double getProductWeight()
    {
        return weight;
    }

    public void setProductQuantity(int newProductQuantity)
    {
        quantity = newProductQuantity;
    }

    public int getProductQuantity()
    {
        return quantity;
    }
}


