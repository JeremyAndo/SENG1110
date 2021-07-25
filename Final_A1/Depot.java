//c3315176 - Jeremy Anderson

public class Depot
{
    private String name;
    private Product product1, product2, product3;

    /**
     * Creates 3 initial products within a depot
     */
    public Depot()
    {
        name = null;
        product1 = null;
        product2 = null;
        product3 = null;
    }
    //add other methods
    public Depot(String newDepotName)
    {
        name = newDepotName;
    }

    public void setDepotName(String newDepotName)
    {
        name = newDepotName;
    }

    public String getDepotName()
    {
        return name;
    }

    public Product getProduct1()
    {
        return product1;
    }

    public Product getProduct2()
    {
        return product2;
    }

    public Product getProduct3()
    {
        return product3;
    }

    public void setProduct1(Product product)
    {
        this.product1 = product;
    }

    public void setProduct2(Product product)
    {
        this.product2 = product;
    }

    public void setProduct3(Product product)
    {
        this.product3 = product;
    }
}

